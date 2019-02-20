package cn.shuaijunlan.orderservicesapi;


import cn.shuaijunlan.orderservicesapi.vo.OrderVO;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 3:11 PM 2/20/19.
 */
public interface OrderServiceAPI {

    // 验证售出的票是否为真
    boolean isTrueSeats(String fieldId, String seats);

    // 已经销售的座位里，有没有这些座位
    boolean isNotSoldSeats(String fieldId, String seats);

    /**
     * 创建订单信息
     * @param cinemaId 影院id
     * @param fieldId 场次id
     * @param filmId 电影id
     * @param soldSeats 座位编号
     * @param seatsName 最为名称
     * @param userId 用户ID
     * @param orderPrice 订单价格
     * @return 返回订单信息
     */
    OrderVO saveOrderInfo(Integer cinemaId, Integer fieldId, Integer filmId,  String soldSeats, String seatsName, Integer userId, Double orderPrice);

    /**
     * @param cinemaId
     * @param fieldId
     * @param filmId
     * @param soldSeats
     * @param seatsName
     * @param userId
     * @param totalPrice
     * @return
     */
    OrderVO createOrder(Integer cinemaId, Integer fieldId, Integer filmId,  String soldSeats, String seatsName, Integer userId, Double totalPrice);

    // 使用当前登陆人获取已经购买的订单
    // Page<OrderVO> getOrderByUserId(Integer userId, Page<OrderVO> page);

    // 根据FieldId 获取所有已经销售的座位编号
    String getSoldSeatsByFieldId(Integer fieldId);

    // 根据订单编号获取订单信息
    OrderVO getOrderInfoById(String orderId);

    boolean paySuccess(String orderId);

    boolean payFail(String orderId);

}
