package cn.shuaijunlan.userservicesapi.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shuaijunlan
 */
@Data
public class UserInfoModel implements Serializable{
    private int uuid;
    private String username;
    private String nickname;
    private String email;
    private String phone;
    private int userSex;
    private String birthday;
    private int lifeState;
    private String biography;
    private String address;
    private String headAddress;
    private long beginTime;
    private long updateTime;
}
