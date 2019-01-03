package cn.shuaijunlan.services.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 3:29 PM 1/2/19.
 */
@Entity(name = "user_info")
@Data
public class UserTableModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @Id
    private int uuid;
    /**
     * 用户账号
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPwd;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户性别 0-男，1-女
     */
    private Integer userSex;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户手机号
     */
    private String userPhone;
    /**
     * 用户住址
     */
    private String address;
    /**
     * 头像URL
     */
    private String headUrl;
    /**
     * 生活状态
     */
    private Integer lifeState;
    /**
     * 生活状态
     */
    private String biography;
    /**
     * 创建时间
     */
    private Date beginTime;
    /**
     * 修改时间
     */
    private Date updateTime;

}

