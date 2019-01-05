package cn.shuaijunlan.filmservices.dao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * <p>
 * 影片与演员映射表
 * </p>
 *
 */
@Entity
@Data
public class FilmActorTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @Id
    private Integer uuid;
    /**
     * 影片编号,对应mooc_film_t
     */
    private Integer filmId;
    /**
     * 演员编号,对应mooc_actor_t
     */
    private Integer actorId;
    /**
     * 角色名称
     */
    private String roleName;

}
