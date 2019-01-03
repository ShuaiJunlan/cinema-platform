package cn.shuaijunlan.services.services;

import cn.shuaijunlan.platform.core.util.MD5Util;
import cn.shuaijunlan.services.dao.repository.UserRepository;
import cn.shuaijunlan.services.model.UserTableModel;
import cn.shuaijunlan.userservicesapi.IUserService;
import cn.shuaijunlan.userservicesapi.vo.UserInfoModel;
import cn.shuaijunlan.userservicesapi.vo.UserModel;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * @author shuaijunlan
 */
@Component
@Service(interfaceClass = IUserService.class, loadbalance = "roundrobin")
public class UserServiceImpl implements IUserService {

    private final UserRepository userTRepository;

    public UserServiceImpl(UserRepository userTRepository) {
        this.userTRepository = userTRepository;
    }

    @Override
    public boolean register(UserModel userModel) {
        // 将注册信息实体转换为数据实体[user_info]
        UserTableModel userTModel = new UserTableModel();
        userTModel.setUserName(userModel.getUsername());
        userTModel.setEmail(userModel.getEmail());
        userTModel.setAddress(userModel.getAddress());
        userTModel.setUserPhone(userModel.getPhone());
        // 创建时间和修改时间 -> current_timestamp

        // 数据加密 【MD5混淆加密 + 盐值 -> Shiro加密】
        String md5Password = MD5Util.encrypt(userModel.getPassword());
        userTModel.setUserPwd(md5Password);

        // 将数据实体存入数据库
        UserTableModel insert = userTRepository.save(userTModel);
        return insert != null;
    }


    @Override
    public int login(String username, String password) {
        // 根据登陆账号从数据库获取信息
        UserTableModel result = userTRepository.findUserTableModelByUserName(username);

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
        UserTableModel result = userTRepository.findUserTableModelByUserName(username);
        return result == null;
    }



    @Override
    public UserInfoModel getUserInfo(int uuid) {
        // 根据主键查询用户信息
        Optional<UserTableModel> optionalUserTableModel = userTRepository.findById(uuid);
        UserTableModel userTableModel = optionalUserTableModel.orElse(null);
        if (userTableModel == null){
            return null;
        }
        // 将UserTableModel转换UserInfoModel
        // 返回UserInfoModel
        return do2UserInfo(userTableModel);
    }

    private UserInfoModel do2UserInfo(UserTableModel userTableModel) {
        UserInfoModel userInfoModel = new UserInfoModel();

        userInfoModel.setUuid(userTableModel.getUuid());
        userInfoModel.setHeadAddress(userTableModel.getHeadUrl());
        userInfoModel.setPhone(userTableModel.getUserPhone());
        userInfoModel.setUpdateTime(userTableModel.getUpdateTime().getTime());
        userInfoModel.setEmail(userTableModel.getEmail());
        userInfoModel.setUsername(userTableModel.getUserName());
        userInfoModel.setNickname(userTableModel.getNickName());
        userInfoModel.setLifeState("" + userTableModel.getLifeState());
        userInfoModel.setBirthday(userTableModel.getBirthday());
        userInfoModel.setAddress(userTableModel.getAddress());
        userInfoModel.setSex(userTableModel.getUserSex());
        userInfoModel.setBeginTime(userTableModel.getBeginTime().getTime());
        userInfoModel.setBiography(userTableModel.getBiography());

        return userInfoModel;
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel) {
        // 将传入的参数转换为UserTableModel
        UserTableModel userTModel = new UserTableModel();
        userTModel.setUuid(userInfoModel.getUuid());
        userTModel.setNickName(userInfoModel.getNickname());
        userTModel.setLifeState(Integer.parseInt(userInfoModel.getLifeState()));
        userTModel.setBirthday(userInfoModel.getBirthday());
        userTModel.setBiography(userInfoModel.getBiography());
        userTModel.setBeginTime(null);
        userTModel.setHeadUrl(userInfoModel.getHeadAddress());
        userTModel.setEmail(userInfoModel.getEmail());
        userTModel.setAddress(userInfoModel.getAddress());
        userTModel.setUserPhone(userInfoModel.getPhone());
        userTModel.setUserSex(userInfoModel.getSex());
        userTModel.setUpdateTime(null);

        // DO存入数据库
        UserTableModel userTableModel = userTRepository.save(userTModel);

        return getUserInfo(userTModel.getUuid());
    }
}
