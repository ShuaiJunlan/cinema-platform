package cn.shuaijunlan.filmservicesapi.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FilmVO  implements Serializable {

    private int filmNum;
    private int nowPage;
    private int totalPage;
    private List<FilmInfo> filmInfo;

}
