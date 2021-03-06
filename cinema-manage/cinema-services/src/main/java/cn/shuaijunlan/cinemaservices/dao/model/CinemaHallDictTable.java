package cn.shuaijunlan.cinemaservices.dao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 影厅信息表
 *
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:09 AM 1/15/19.
 */
@Data
@Entity
public class CinemaHallDictTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @Id
    @GeneratedValue
    private Integer uuid;
    /**
     * 显示名称
     */
    private String showName;
    /**
     * 座位文件存放地址
     */
    private String seatAddress;

}
