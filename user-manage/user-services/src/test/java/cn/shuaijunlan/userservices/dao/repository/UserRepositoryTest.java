package cn.shuaijunlan.userservices.dao.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        try {
            System.out.println(userRepository.updateUserName(4, "admin"));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(1);
        }
    }
    @Test
    public void updateUserInfo(){
        // userRepository.updateUserInfo(5, "shuaijunlan", "hello junlan", 1, "hubei");
    }
}