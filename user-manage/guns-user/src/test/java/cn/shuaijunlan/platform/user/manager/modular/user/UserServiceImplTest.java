package cn.shuaijunlan.platform.user.manager.modular.user;

import com.stylefeng.guns.api.user.vo.UserInfoModel;
import com.stylefeng.guns.api.user.vo.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 3:57 PM 1/2/19.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;
    @Test
    public void register() {
        UserModel userModel = new UserModel();
        userModel.setAddress("湖北省武汉市洪山区");
        userModel.setEmail("shuaijunlan@gmail.com");
        userModel.setPassword("root");
        userModel.setPhone("15927175619");
        userModel.setUsername("root");
        userService.register(userModel);
    }

    @Test
    public void login() {
    }

    @Test
    public void checkUsername() {
    }

    @Test
    public void getUserInfo() {
    }

    @Test
    public void updateUserInfo() {
        UserInfoModel userInfoModel = new UserInfoModel();
        userInfoModel.setAddress("湖北省武汉市洪山区");
        userInfoModel.setEmail("test@gmail.com");
        userInfoModel.setPhone("15927170000");
        userInfoModel.setUsername("hello");
        userInfoModel.setLifeState("1");
        userInfoModel.setUuid(3);

        userService.updateUserInfo(userInfoModel);
    }
}