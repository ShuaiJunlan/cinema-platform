package cn.shuaijunlan.userservices.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 5:18 PM 1/4/19.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void register() {
    }

    @Test
    public void login() {
    }

    @Test
    public void checkUsername() {
    }

    @Test
    public void getUserInfo() {
        System.out.println(userService.getUserInfo(10));
    }

    @Test
    public void updateUserInfo() {
    }
}