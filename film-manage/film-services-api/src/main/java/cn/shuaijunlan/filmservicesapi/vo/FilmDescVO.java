package cn.shuaijunlan.filmservicesapi.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shuaijunlan
 */
@Data
public class FilmDescVO implements Serializable {

    private String biography;
    private Integer filmId;

}
