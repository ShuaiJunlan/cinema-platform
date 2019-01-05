package cn.shuaijunlan.filmservices.dao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * <p>
 * 演员表
 * </p>
 *
*
 */
@Entity
@Data
public class ActorTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @Id
    private Integer uuid;
    /**
     * 演员名称
     */
    private String actorName;
    /**
     * 演员图片位置
     */
    private String actorImg;

}
