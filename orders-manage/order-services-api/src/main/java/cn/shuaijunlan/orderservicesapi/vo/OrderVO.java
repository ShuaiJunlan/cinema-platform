package cn.shuaijunlan.orderservicesapi.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 3:11 PM 2/20/19.
 */
@Data
public class OrderVO implements Serializable {

    private String orderId;
    private String filmName;
    private String fieldTime;
    private String cinemaName;
    private String seatsName;
    private String orderPrice;
    private String orderTimestamp;
    private String orderStatus;

}
