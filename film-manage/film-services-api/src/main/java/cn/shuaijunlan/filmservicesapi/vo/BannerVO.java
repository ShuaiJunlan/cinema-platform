package cn.shuaijunlan.filmservicesapi.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BannerVO implements Serializable {
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
