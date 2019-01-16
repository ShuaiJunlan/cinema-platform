package cn.shuaijunlan.platformgateway.config.properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 4:28 PM 1/15/19.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthPropertiesTest {
    @Autowired
    private AuthProperties authProperties;
    @Test
    public void test1(){
        System.out.println(authProperties.getKeyName());
        System.out.println(authProperties.getTokenName());
    }
}