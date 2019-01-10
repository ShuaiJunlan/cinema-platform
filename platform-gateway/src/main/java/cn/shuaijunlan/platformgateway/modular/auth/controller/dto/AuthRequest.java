package cn.shuaijunlan.platformgateway.modular.auth.controller.dto;


import lombok.Data;

/**
 * 认证的请求dto
 *
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 10:06 PM 1/3/19.
 */
@Data
public class AuthRequest {

    private String username;
    private String password;

}
