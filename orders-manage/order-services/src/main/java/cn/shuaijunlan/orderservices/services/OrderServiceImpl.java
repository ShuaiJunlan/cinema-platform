package cn.shuaijunlan.orderservices.services;

import cn.shuaijunlan.accountservicesapi.AccountServicesAPI;
import cn.shuaijunlan.cinemaservicesapi.CinemaServiceAPI;
import cn.shuaijunlan.orderservices.dao.model.OrderInfoTable;
import cn.shuaijunlan.orderservices.dao.repository.OrderRepository;
import cn.shuaijunlan.orderservicesapi.OrderServiceAPI;
import cn.shuaijunlan.orderservicesapi.vo.OrderVO;
import cn.shuaijunlan.userservicesapi.IUserService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 3:18 PM 2/20/19.
 */
@Component
// @Service(interfaceClass = OrderServiceAPI.class, loadbalance = "roundrobin")
public class OrderServiceImpl implements OrderServiceAPI {

    @Reference(interfaceClass = IUserService.class, check = false)
    private IUserService userService;

    @Reference(interfaceClass = CinemaServiceAPI.class, check = false)
    private CinemaServiceAPI cinemaServiceAPI;

    @Reference(interfaceClass = AccountServicesAPI.class, check = false)
    private AccountServicesAPI accountServicesAPI;

    private final OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public boolean isTrueSeats(String fieldId, String seats) {
        return false;
    }

    @Override
    public boolean isNotSoldSeats(String fieldId, String seats) {
        return false;
    }

    @Override
    public OrderVO saveOrderInfo(Integer cinemaId, Integer fieldId, Integer filmId, String soldSeats, String seatsName, Integer userId, Double orderPrice) {

        OrderInfoTable orderInfoTable = new OrderInfoTable();
        orderInfoTable.setCinemaId(cinemaId);
        orderInfoTable.setFieldId(fieldId);
        orderInfoTable.setFilmId(filmId);
        orderInfoTable.setSeatsIds(soldSeats);
        orderInfoTable.setSeatsName(seatsName);
        orderInfoTable.setOrderUser(userId);

        Date current = new Date();
        orderInfoTable.setOrderTime(current);

        orderInfoTable.setOrderPrice(orderPrice);

        orderInfoTable.setOrderStatus(0);
        orderRepository.save(orderInfoTable);

        OrderVO orderVO = new OrderVO();
        orderVO.setOrderTimestamp(current.toString());
        return orderVO;
    }

    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-gts-fescar-example")
    public OrderVO createOrder(Integer cinemaId, Integer fieldId, Integer filmId, String soldSeats, String seatsName, Integer userId, Double totalPrice) {
        //减库存
        cinemaServiceAPI.addSells(fieldId, soldSeats);

        // if (true){
        //     throw new RuntimeException();
        // }

        //创建订单
        return saveOrderInfo(cinemaId, fieldId, filmId, soldSeats, seatsName, userId, totalPrice);
    }

    @Override
    public String getSoldSeatsByFieldId(Integer fieldId) {
        return null;
    }

    @Override
    public OrderVO getOrderInfoById(String orderId) {
        return null;
    }

    @Override
    public boolean paySuccess(String orderId) {
        return false;
    }

    @Override
    public boolean payFail(String orderId) {
        return false;
    }
}
