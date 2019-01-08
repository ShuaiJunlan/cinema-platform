package cn.shuaijunlan.filmservicesapi.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class ImgVO implements Serializable {

    private String mainImg;
    private ArrayList<String> subImgs;
    private String img01;
    private String img02;
    private String img03;
    private String img04;
}
