package cn.shuaijunlan.orderservices.dao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 1:38 PM 1/15/19.
 */
@Entity
@Data
public class OrderInfoTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uuid;
    /**
     * 影院编号
     */
    private Integer cinemaId;
    /**
     * 放映场次编号
     */
    private Integer fieldId;
    /**
     * 电影编号
     */
    private Integer filmId;
    /**
     * 已售座位编号
     */
    private String seatsIds;
    /**
     * 已售座位名称
     */
    private String seatsName;
    /**
     * 订单总金额
     */
    private Double orderPrice;
    /**
     * 下单时间
     */
    private Date orderTime;
    /**
     * 下单人
     */
    private Integer orderUser;
    /**
     * 0-待支付,1-已支付,2-已关闭
     */
    private Integer orderStatus;
}

