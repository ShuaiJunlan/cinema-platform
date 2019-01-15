package cn.shuaijunlan.cinemaservices.dao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 影院信息表
 *
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:29 AM 1/15/19.
 */
@Entity
@Data
public class CinemaInfoTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @Id
    @GeneratedValue
    private Integer uuid;
    /**
     * 影院名称
     */
    private String cinemaName;
    /**
     * 影院电话
     */
    private String cinemaPhone;
    /**
     * 品牌编号
     */
    private Integer brandId;
    /**
     * 地域编号
     */
    private Integer areaId;
    /**
     * 包含的影厅类型,以#作为分割
     */
    private String hallIds;
    /**
     * 影院图片地址
     */
    private String imgAddress;
    /**
     * 影院地址
     */
    private String cinemaAddress;
    /**
     * 最低票价
     */
    private Integer minimumPrice;
}
