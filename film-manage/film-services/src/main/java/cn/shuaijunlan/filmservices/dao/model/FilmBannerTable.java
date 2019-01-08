package cn.shuaijunlan.filmservices.dao.model;

import cn.shuaijunlan.filmservicesapi.vo.BannerVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * <p>
 * banner信息表
 * </p>
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 8:08 PM 1/8/19.
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class FilmBannerTable extends BannerVO implements Serializable {

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
