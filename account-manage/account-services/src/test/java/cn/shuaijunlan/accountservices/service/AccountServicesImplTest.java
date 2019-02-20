package cn.shuaijunlan.accountservices.service;

import cn.shuaijunlan.accountservicesapi.AccountServicesAPI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 12:03 PM 2/20/19.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountServicesImplTest {
    @Autowired
    private AccountServicesAPI accountServicesAPI;

    @Test
    public void deduct() {
        assertTrue(accountServicesAPI.deduct(2, 10.1));
        assertFalse(accountServicesAPI.deduct(2, 100000.1));
    }

    @Test
    public void add() {
    }
}