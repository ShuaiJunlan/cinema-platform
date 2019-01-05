package cn.shuaijunlan.filmservicesapi.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CatVO implements Serializable {

    private String catId;
    private String catName;
    /**
     * TODO: Why not using isActive?
     */
    private Boolean active;

}
