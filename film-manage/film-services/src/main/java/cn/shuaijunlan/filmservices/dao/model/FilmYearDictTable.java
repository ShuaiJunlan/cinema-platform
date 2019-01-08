package cn.shuaijunlan.filmservices.dao.model;

import cn.shuaijunlan.filmservicesapi.vo.YearVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * <p>
 * 年代信息表
 * </p>
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 8:08 PM 1/8/19.
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Data
public class FilmYearDictTable extends YearVO {
    private static final long serialVersionUID = 1L;
    /**
     * 主键编号
     */
    @Id
    @GeneratedValue
    private Integer uuid;

    /**
     * 显示名称
     */
    private String showName;
}
