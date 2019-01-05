package cn.shuaijunlan.userservicesapi;


import cn.shuaijunlan.userservicesapi.vo.UserInfoModel;
import cn.shuaijunlan.userservicesapi.vo.UserModel;

/**
 * @author shuaijunlan
 */
public interface IUserService {

    int login(String username, String password);

    boolean register(UserModel userModel);

    boolean checkUsername(String username);

    UserInfoModel getUserInfo(int uuid);

    UserInfoModel updateUserInfo(UserInfoModel userInfoModel);

    int updateUserPassword(int uuid, String password);

}
