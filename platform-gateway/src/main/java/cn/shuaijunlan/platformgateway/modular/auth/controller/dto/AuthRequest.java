package cn.shuaijunlan.platformgateway.modular.auth.controller.dto;


import cn.shuaijunlan.platformgateway.modular.auth.validator.dto.Credence;

/**
 * 认证的请求dto
 *
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 10:06 PM 1/3/19.
 */
public class AuthRequest implements Credence {

    private String userName;
    private String password;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String getCredenceName() {
        return this.userName;
    }

    @Override
    public String getCredenceCode() {
        return this.password;
    }
}
