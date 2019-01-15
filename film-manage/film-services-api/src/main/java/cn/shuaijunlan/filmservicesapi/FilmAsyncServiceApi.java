package cn.shuaijunlan.filmservicesapi;


import cn.shuaijunlan.filmservicesapi.vo.ActorVO;
import cn.shuaijunlan.filmservicesapi.vo.FilmDescVO;
import cn.shuaijunlan.filmservicesapi.vo.ImgVO;

import java.util.List;

public interface FilmAsyncServiceApi {

    // 获取影片描述信息
    FilmDescVO getFilmDesc(Integer filmId);

    // 获取图片信息
    ImgVO getImgs(Integer filmId);

    // 获取导演信息
    ActorVO getDectInfo(Integer filmId);

    // 获取演员信息
    List<ActorVO> getActors(Integer filmId);

}
