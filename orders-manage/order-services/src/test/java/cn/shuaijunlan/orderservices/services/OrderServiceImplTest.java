package cn.shuaijunlan.orderservices.services;

import cn.shuaijunlan.orderservicesapi.OrderServiceAPI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 3:28 PM 2/20/19.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceAPI orderServiceAPI;

    @Test
    public void isTrueSeats() {
    }

    @Test
    public void isNotSoldSeats() {
    }

    @Test
    public void saveOrderInfo() {
        System.out.println(orderServiceAPI.saveOrderInfo(1,1, 1, "1", "第一排1座", 1, 123.11));
    }

    @Test
    public void createOrder(){
        System.out.println(orderServiceAPI.createOrder(1,1, 1, "1", "第一排1座", 1, 123.11));
    }

    @Test
    public void getSoldSeatsByFieldId() {
    }

    @Test
    public void getOrderInfoById() {
    }

    @Test
    public void paySuccess() {
    }

    @Test
    public void payFail() {
    }
}