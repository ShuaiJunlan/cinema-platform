package cn.shuaijunlan.cinemaservices.dao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 10:15 AM 2/20/19.
 */
@Entity
@Data
public class CinemaFilmSellTable implements Serializable {
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
    private Integer cinemaFilmId;

    /**
     * 已售座位
     */
    private String sells;
}
