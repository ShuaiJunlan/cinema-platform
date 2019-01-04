package cn.shuaijunlan.services.dao.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 4:18 PM 1/4/19.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void update(){
        System.out.println(userRepository.updateUserName(5, "shuaijun"));
    }
    @Test
    public void updateUserInfo(){
        userRepository.updateUserInfo(5, "shuaijunlan", "hello junlan", 1, "hubei");
    }
}