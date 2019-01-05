package cn.shuaijunlan.userservicesapi.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shuaijunlan
 */
@Data
public class UserModel implements Serializable {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
}
