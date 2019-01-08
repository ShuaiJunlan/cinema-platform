package cn.shuaijunlan.filmservices.service;

import cn.shuaijunlan.filmservices.dao.model.FilmBannerTable;
import cn.shuaijunlan.filmservices.dao.repository.*;
import cn.shuaijunlan.filmservicesapi.FilmServiceApi;
import cn.shuaijunlan.filmservicesapi.vo.*;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:07 AM 1/8/19.
 */
@Component
@Service(interfaceClass = FilmServiceApi.class)
public class FilmServiceImpl implements FilmServiceApi {

    private final FilmBannerRepository filmBannerRepository;
    private final FilmRepository filmRepository;
    private final FilmCatDictRepository filmCatDictRepository;
    private final FilmInfoRepository filmInfoRepository;
    private final FilmYearDictRepository filmYearDictRepository;
    private final FilmSourceDictRepository filmSourceDictRepository;
    private final ActorRepository actorRepository;

    @Autowired
    public FilmServiceImpl(FilmBannerRepository filmBannerRepository, FilmRepository filmRepository, FilmCatDictRepository filmCatDictRepository, FilmInfoRepository filmInfoRepository, FilmYearDictRepository filmYearDictRepository, FilmSourceDictRepository filmSourceDictRepository, ActorRepository actorRepository) {
        this.filmBannerRepository = filmBannerRepository;
        this.filmRepository = filmRepository;
        this.filmCatDictRepository = filmCatDictRepository;
        this.filmInfoRepository = filmInfoRepository;
        this.filmYearDictRepository = filmYearDictRepository;
        this.filmSourceDictRepository = filmSourceDictRepository;
        this.actorRepository = actorRepository;
    }

    @Override
    public List<BannerVO> getBanners() {

        List<FilmBannerTable> filmBannerTableList = filmBannerRepository.findAll();
        return new ArrayList<>(filmBannerTableList);
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
        return new ArrayList<>(filmYearDictRepository.findAll());
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
