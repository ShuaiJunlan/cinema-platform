package cn.shuaijunlan.services.services;

import cn.shuaijunlan.platform.core.util.MD5Util;
import cn.shuaijunlan.services.dao.repository.UserRepository;
import cn.shuaijunlan.services.model.UserInfoTable;
import cn.shuaijunlan.userservicesapi.IUserService;
import cn.shuaijunlan.userservicesapi.vo.UserInfoModel;
import cn.shuaijunlan.userservicesapi.vo.UserModel;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;


/**
 * @author shuaijunlan
 */
@Component
@Service(interfaceClass = IUserService.class, loadbalance = "roundrobin")
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userTRepository) {
        this.userRepository = userTRepository;
    }

    @Override
    public boolean register(UserModel userModel) {
        // 将注册信息实体转换为数据实体[user_info]
        UserInfoTable userTModel = new UserInfoTable();
        userTModel.setUserName(userModel.getUsername());
        userTModel.setEmail(userModel.getEmail());
        userTModel.setAddress(userModel.getAddress());
        userTModel.setUserPhone(userModel.getPhone());
        // 创建时间和修改时间 -> current_timestamp

        // 数据加密 【MD5混淆加密 + 盐值 -> Shiro加密】
        String md5Password = MD5Util.encrypt(userModel.getPassword());
        userTModel.setUserPwd(md5Password);

        // 将数据实体存入数据库
        UserInfoTable insert = userRepository.save(userTModel);
        return insert != null;
    }


    @Override
    public int login(String username, String password) {
        // 根据登陆账号从数据库获取信息
        UserInfoTable result = userRepository.findUserTableModelByUserName(username);

        // 获取到的结果，然后与加密以后的密码做匹配
        if (result != null && result.getUuid() > 0) {
            String md5Password = MD5Util.encrypt(password);
            if (result.getUserPwd().equals(md5Password)) {
                return result.getUuid();
            }
        }
        return 0;
    }

    @Override
    public boolean checkUsername(String username) {
        UserInfoTable result = userRepository.findUserTableModelByUserName(username);
        return result == null;
    }



    @Override
    public UserInfoModel getUserInfo(int uuid) {
        // 根据主键查询用户信息
        Optional<UserInfoTable> optionalUserTableModel = userRepository.findById(uuid);
        UserInfoTable userInfoTable = optionalUserTableModel.orElse(null);
        if (userInfoTable == null){
            return null;
        }
        // 将UserTableModel转换UserInfoModel
        // 返回UserInfoModel
        System.out.println(userInfoTable.toString());
        return do2UserInfo(userInfoTable);
    }

    private UserInfoModel do2UserInfo(UserInfoTable userInfoTable) {
        UserInfoModel userInfoModel = new UserInfoModel();

        userInfoModel.setUuid(userInfoTable.getUuid());
        userInfoModel.setHeadAddress(userInfoTable.getHeadUrl());
        userInfoModel.setPhone(userInfoTable.getUserPhone());
        userInfoModel.setUpdateTime(userInfoTable.getUpdateTime().getTime());
        userInfoModel.setEmail(userInfoTable.getEmail());
        userInfoModel.setUsername(userInfoTable.getUserName());
        userInfoModel.setNickname(userInfoTable.getNickName());
        userInfoModel.setLifeState("" + userInfoTable.getLifeState());
        userInfoModel.setBirthday(userInfoTable.getBirthday());
        userInfoModel.setAddress(userInfoTable.getAddress());
        userInfoModel.setSex(userInfoTable.getUserSex());
        userInfoModel.setBeginTime(userInfoTable.getBeginTime().getTime());
        userInfoModel.setBiography(userInfoTable.getBiography());

        return userInfoModel;
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel newObj) {

        // 将传入的参数转换为UserTableModel
        UserInfoTable userTModel = new UserInfoTable();
        userTModel.setUuid(newObj.getUuid());
        userTModel.setNickName(newObj.getNickname());
        userTModel.setLifeState(Integer.parseInt(newObj.getLifeState()));
        userTModel.setBirthday(newObj.getBirthday());
        userTModel.setBiography(newObj.getBiography());
        userTModel.setBeginTime(null);
        userTModel.setHeadUrl(newObj.getHeadAddress());
        userTModel.setEmail(newObj.getEmail());
        userTModel.setAddress(newObj.getAddress());
        userTModel.setUserPhone(newObj.getPhone());
        userTModel.setUserSex(newObj.getSex());
        userTModel.setUpdateTime(new Date());

        // DO存入数据库
        UserInfoTable userInfoTable = userRepository.save(userTModel);
        // System.out.println(userRepository.updateUserInfo(userInfoModel.getUuid(), userInfoModel.getUsername(), userInfoModel.getNickname(), userInfoModel.getSex()));

        return newObj;
    }
}
