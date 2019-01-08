package cn.shuaijunlan.cinemaservicesapi.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CinemaVO implements Serializable {

    private String uuid;
    private String cinemaName;
    private String address;
    private String minimumPrice;

}
