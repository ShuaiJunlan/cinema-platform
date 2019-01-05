package cn.shuaijunlan.filmservices.dao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * <p>
 * banner信息表
 * </p>
 *
*
 */
@Entity
@Data
public class FilmBannerTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @Id
    private Integer uuid;
    /**
     * banner图存放路径
     */
    private String bannerAddress;
    /**
     * banner点击跳转url
     */
    private String bannerUrl;
    /**
     * 是否弃用 0-失效,1-失效
     */
    private Integer isValid;


}
