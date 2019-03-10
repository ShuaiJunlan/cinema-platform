package cn.shuaijunlan.accountservices.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:34 AM 2/20/19.
 */
@Entity
@Data
public class UserAccountSpendingTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Integer uuid;
    private Integer userAccountId;
    private Integer type;
    private Date spendingTime;
    private Double amount;
}
