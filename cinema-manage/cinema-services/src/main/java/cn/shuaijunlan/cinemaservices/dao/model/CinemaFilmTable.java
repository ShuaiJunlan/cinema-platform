package cn.shuaijunlan.cinemaservices.dao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 放映场次表
 *
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:09 AM 1/15/19.
 */
@Data
@Entity
public class CinemaFilmTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @Id
    @GeneratedValue
    private Integer uuid;
    /**
     * 影院编号
     */
    private Integer cinemaId;
    /**
     * 电影编号
     */
    private Integer filmId;
    /**
     * 开始时间
     */
    private String beginTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 放映厅类型编号
     */
    private Integer hallId;
    /**
     * 放映厅名称
     */
    private String hallName;
    /**
     * 票价
     */
    private Integer price;
}
