package cn.shuaijunlan.filmservicesapi.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SourceVO implements Serializable {

    private String sourceId;
    private String sourceName;
    private Boolean active;

}
