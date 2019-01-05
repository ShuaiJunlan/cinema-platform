package cn.shuaijunlan.filmservices.dao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * <p>
 * 区域信息表
 * </p>
 *
*
 */
@Entity
@Data
public class FilmAreaDictTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @Id
    private Integer uuid;
    /**
     * 显示名称
     */
    private String showName;
}
