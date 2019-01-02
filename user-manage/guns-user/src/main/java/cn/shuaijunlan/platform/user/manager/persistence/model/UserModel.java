package cn.shuaijunlan.platform.user.manager.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 3:29 PM 1/2/19.
 */
@Entity
@Data
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String userName;
}
