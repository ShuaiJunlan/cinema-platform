package cn.shuaijunlan.platform.user.manager.persistence.dao.repository;

import cn.shuaijunlan.platform.user.manager.persistence.model.UserTModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 3:35 PM 1/2/19.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTRepositoryTest {
    @Autowired
    private UserTRepository userTRepository;

    @Test
    public void findUserTModelByUserName(){
        UserTModel userTModel = userTRepository.findUserTModelByUserName("admin");
        System.out.println(userTModel.toString());
    }

}