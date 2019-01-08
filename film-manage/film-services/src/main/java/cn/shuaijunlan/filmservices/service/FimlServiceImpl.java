package cn.shuaijunlan.filmservices.service;

import cn.shuaijunlan.filmservicesapi.FilmServiceApi;
import cn.shuaijunlan.filmservicesapi.vo.*;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:07 AM 1/8/19.
 */
@Component
@Service(interfaceClass = FilmServiceApi.class)
public class FimlServiceImpl implements FilmServiceApi {
    @Override
    public List<BannerVO> getBanners() {
        return null;
    }

    @Override
    public FilmVO getHotFilms(boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId) {
        return null;
    }

    @Override
    public FilmVO getSoonFilms(boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId) {
        return null;
    }

    @Override
    public FilmVO getClassicFilms(int nums, int nowPage, int sortId, int sourceId, int yearId, int catId) {
        return null;
    }

    @Override
    public List<FilmInfo> getBoxRanking() {
        return null;
    }

    @Override
    public List<FilmInfo> getExpectRanking() {
        return null;
    }

    @Override
    public List<FilmInfo> getTop() {
        return null;
    }

    @Override
    public List<CatVO> getCats() {
        return null;
    }

    @Override
    public List<SourceVO> getSources() {
        return null;
    }

    @Override
    public List<YearVO> getYears() {
        return null;
    }

    @Override
    public FilmDetailVO getFilmDetail(int searchType, String searchParam) {
        return null;
    }

    @Override
    public FilmDescVO getFilmDesc(String filmId) {
        return null;
    }

    @Override
    public ImgVO getImgs(String filmId) {
        return null;
    }

    @Override
    public ActorVO getDectInfo(String filmId) {
        return null;
    }

    @Override
    public List<ActorVO> getActors(String filmId) {
        return null;
    }
}
