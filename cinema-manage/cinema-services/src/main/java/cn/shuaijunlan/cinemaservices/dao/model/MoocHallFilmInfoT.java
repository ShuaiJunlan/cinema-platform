package cn.shuaijunlan.cinemaservices.dao.model;

/**
 * <p>
 * 影厅电影信息表
 * </p>
 *
 */
public class MoocHallFilmInfoT {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    private Integer uuid;
    /**
     * 电影编号
     */
    private Integer filmId;
    /**
     * 电影名称
     */
    private String filmName;
    /**
     * 电影时长
     */
    private String filmLength;
    /**
     * 电影类型
     */
    private String filmCats;
    /**
     * 电影语言
     */
    private String filmLanguage;
    /**
     * 演员列表
     */
    private String actors;
    /**
     * 图片地址
     */
    private String imgAddress;
}
