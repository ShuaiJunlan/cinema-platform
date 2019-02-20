package cn.shuaijunlan.accountservices.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:33 AM 2/20/19.
 */
@Entity
@Data
public class UserAccountTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer uuid;
    private Integer userId;
    private Double amount;
}
