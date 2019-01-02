package cn.shuaijunlan.platform.user.manager.persistence.dao.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 4:38 PM 1/2/19.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void getUserByUsernameTest(){
        System.out.println(userRepository.findById(2).get());
    }

}