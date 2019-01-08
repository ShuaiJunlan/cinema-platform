package cn.shuaijunlan.filmservices.service;

import cn.shuaijunlan.filmservices.dao.model.ActorTable;
import cn.shuaijunlan.filmservices.dao.model.FilmInfoTable;
import cn.shuaijunlan.filmservices.dao.repository.ActorRepository;
import cn.shuaijunlan.filmservices.dao.repository.FilmInfoRepository;
import cn.shuaijunlan.filmservicesapi.FilmAsyncServiceApi;
import cn.shuaijunlan.filmservicesapi.vo.ActorVO;
import cn.shuaijunlan.filmservicesapi.vo.FilmDescVO;
import cn.shuaijunlan.filmservicesapi.vo.ImgVO;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:08 AM 1/8/19.
 */
@Component
@Service(interfaceClass = FilmAsyncServiceApi.class)
public class FilmAsyncServiceImpl implements FilmAsyncServiceApi {
    private final FilmInfoRepository filmInfoRepository;

    private final ActorRepository actorRepository;

    @Autowired
    public FilmAsyncServiceImpl(FilmInfoRepository filmInfoRepository, ActorRepository actorRepository) {
        this.filmInfoRepository = filmInfoRepository;
        this.actorRepository = actorRepository;
    }

    private FilmInfoTable getFilmInfoById(String filmId){
        return filmInfoRepository.findFilmInfoTableByFilmId(filmId);
    }

    @Override
    public FilmDescVO getFilmDesc(String filmId) {
        return null;
    }

    @Override
    public ImgVO getImgs(String filmId) {
        FilmInfoTable filmInfoTable = getFilmInfoById(filmId);
        if (filmInfoTable == null){
            return new ImgVO();
        }
        String filmImgStr = filmInfoTable.getFilmImgs();
        if (filmImgStr == null){
            return new ImgVO();
        }
        String[] filmImgs = filmImgStr.split(",");
        ImgVO imgVO = new ImgVO();

        if (filmImgs.length > 0){
            imgVO.setMainImg(filmImgs[0]);
        }
        ArrayList<String> otherImg = new ArrayList<>(Arrays.asList(filmImgs).subList(1, filmImgs.length));
        imgVO.setSubImgs(otherImg);
        return imgVO;
    }

    @Override
    public ActorVO getDectInfo(String filmId) {
        FilmInfoTable filmInfoTable = getFilmInfoById(filmId);

        // 获取导演编号
        Integer directId = filmInfoTable.getDirectorId();

        ActorTable actorTable = actorRepository.getOne(directId);

        ActorVO actorVO = new ActorVO();
        actorVO.setImgAddress(actorTable.getActorImg());
        actorVO.setDirectorName(actorTable.getActorName());

        return actorVO;
    }

    @Override
    public List<ActorVO> getActors(String filmId) {
        return null;
    }
}
