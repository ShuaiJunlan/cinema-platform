package cn.shuaijunlan.filmservicesapi.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class YearVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer uuid;

    /**
     * 显示名称
     */
    private String showName;
}
