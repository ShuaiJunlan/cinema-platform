package cn.shuaijunlan.filmservices.dao.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * <p>
 * 影片主表
 * </p>
 * TODO: about jpa properties: https://zjhdreams.iteye.com/blog/2112354
 */
@Entity
@Data
public class FilmInfoTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @Id
    private Integer uuid;
    /**
     */
    private String filmId;
    /**
     * 影片英文名称
     */
    private String filmEnName;
    /**
     * 影片评分
     */
    private String filmScore;
    /**
     * 评分人数,以万为单位
     */
    private Integer filmScoreNum;
    /**
     * 播放时长，以分钟为单位，不足取整
     */
    private Integer filmLength;
    /**
     * 影片介绍
     */
    @Column(columnDefinition = "TEXT")
    private String biography;
    /**
     * 导演编号
     */
    private Integer directorId;
    /**
     * 影片图片集地址,多个图片以逗号分隔
     */
    @Column(columnDefinition = "TEXT")
    private String filmImgs;
}
