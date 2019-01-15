package cn.shuaijunlan.cinemaservices.dao.model;

/**
 * 影厅电影信息表
 *
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:59 AM 1/15/19.
 */
public class CinemaHallFilmInfoTable {

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
