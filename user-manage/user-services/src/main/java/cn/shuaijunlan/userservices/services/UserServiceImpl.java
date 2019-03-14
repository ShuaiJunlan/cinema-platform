package cn.shuaijunlan.userservices.services;

import cn.shuaijunlan.platform.core.util.MD5Util;
import cn.shuaijunlan.userservices.dao.repository.UserRepository;
import cn.shuaijunlan.userservices.dao.model.UserInfoTable;
import cn.shuaijunlan.userservicesapi.IUserService;
import cn.shuaijunlan.userservicesapi.vo.UserInfoModel;
import cn.shuaijunlan.userservicesapi.vo.UserModel;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        if (userRepository.findUserTableModelByUserName(userModel.getUsername()) != null){
            return false;
        }
        // 将注册信息实体转换为数据实体[user_info_table]
        UserInfoTable userTModel = new UserInfoTable();
        userTModel.setUserName(userModel.getUsername());
        userTModel.setEmail(userModel.getEmail());
        userTModel.setAddress(userModel.getAddress());
        userTModel.setUserPhone(userModel.getPhone());
        userTModel.setUserPwd(userModel.getPassword());

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
        return -1;
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
        userInfoModel.setLifeState(userInfoTable.getLifeState());
        userInfoModel.setBirthday(userInfoTable.getBirthday());
        userInfoModel.setAddress(userInfoTable.getAddress());
        userInfoModel.setUserSex(userInfoTable.getUserSex());
        userInfoModel.setBeginTime(userInfoTable.getBeginTime().getTime());
        userInfoModel.setBiography(userInfoTable.getBiography());

        return userInfoModel;
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel obj) {

        try {
            int re = userRepository.updateUserInfo(obj.getUuid(), obj.getUsername(), obj.getNickname(), obj.getEmail(), obj.getPhone(), obj.getUserSex(), obj.getBirthday(), obj.getLifeState(), obj.getBiography(), obj.getAddress(), obj.getHeadAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public int updateUserPassword(int uuid, String password) {
        return userRepository.updatePassword(uuid, password);
    }
}