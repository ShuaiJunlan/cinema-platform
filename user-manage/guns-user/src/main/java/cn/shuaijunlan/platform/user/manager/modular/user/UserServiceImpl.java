package cn.shuaijunlan.platform.user.manager.modular.user;

import cn.shuaijunlan.platform.user.manager.persistence.dao.repository.UserTRepository;
import cn.shuaijunlan.platform.user.manager.persistence.model.UserTModel;
import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.user.IUserService;
import com.stylefeng.guns.api.user.vo.UserInfoModel;
import com.stylefeng.guns.api.user.vo.UserModel;
import com.stylefeng.guns.core.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * @author shuaijunlan
 */
@Component
@Service(interfaceClass = IUserService.class, loadbalance = "roundrobin")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserTRepository userTRepository;

    @Override
    public boolean register(UserModel userModel) {
        // 将注册信息实体转换为数据实体[mooc_user_t]
        UserTModel userTModel = new UserTModel();
        userTModel.setUserName(userModel.getUsername());
        userTModel.setEmail(userModel.getEmail());
        userTModel.setAddress(userModel.getAddress());
        userTModel.setUserPhone(userModel.getPhone());
        // 创建时间和修改时间 -> current_timestamp

        // 数据加密 【MD5混淆加密 + 盐值 -> Shiro加密】
        String md5Password = MD5Util.encrypt(userModel.getPassword());
        userTModel.setUserPwd(md5Password); // 注意

        // 将数据实体存入数据库
        UserTModel insert = userTRepository.save(userTModel);
        return insert != null;
    }


    @Override
    public int login(String username, String password) {
        // 根据登陆账号获取数据库信息
        UserTModel result = userTRepository.findUserTModelByUserName(username);

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
        UserTModel result = userTRepository.findUserTModelByUserName(username);
        return result == null;
    }

    private UserInfoModel do2UserInfo(UserTModel moocUserT) {
        UserInfoModel userInfoModel = new UserInfoModel();

        userInfoModel.setUuid(moocUserT.getUuid());
        userInfoModel.setHeadAddress(moocUserT.getHeadUrl());
        userInfoModel.setPhone(moocUserT.getUserPhone());
        userInfoModel.setUpdateTime(moocUserT.getUpdateTime().getTime());
        userInfoModel.setEmail(moocUserT.getEmail());
        userInfoModel.setUsername(moocUserT.getUserName());
        userInfoModel.setNickname(moocUserT.getNickName());
        userInfoModel.setLifeState("" + moocUserT.getLifeState());
        userInfoModel.setBirthday(moocUserT.getBirthday());
        userInfoModel.setAddress(moocUserT.getAddress());
        userInfoModel.setSex(moocUserT.getUserSex());
        userInfoModel.setBeginTime(moocUserT.getBeginTime().getTime());
        userInfoModel.setBiography(moocUserT.getBiography());

        return userInfoModel;
    }

    @Override
    public UserInfoModel getUserInfo(int uuid) {
        // 根据主键查询用户信息 [MoocUserT]
        Optional<UserTModel> optionalUserTModel = userTRepository.findById(uuid);
        UserTModel moocUserT = optionalUserTModel.orElse(null);
        // 将MoocUserT转换UserInfoModel
        // 返回UserInfoModel
        return do2UserInfo(moocUserT);
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel) {
        // 将传入的参数转换为DO 【MoocUserT】
        UserTModel userTModel = new UserTModel();
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
        UserTModel integer = userTRepository.save(userTModel);
        // if(integer>0){
        //     // 将数据从数据库中读取出来
            UserInfoModel userInfo = getUserInfo(userTModel.getUuid());
        //     // 将结果返回给前端
        //     return userInfo;
        // }else{
        //     return null;
        // }
        return userInfo;
    }


}
