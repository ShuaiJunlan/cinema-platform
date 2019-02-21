package cn.shuaijunlan.cinemaservices.service;

import cn.shuaijunlan.cinemaservices.dao.model.CinemaFilmSellTable;
import cn.shuaijunlan.cinemaservices.dao.repository.CinemaFilmRepository;
import cn.shuaijunlan.cinemaservices.dao.repository.CinemaFilmSellsRepository;
import cn.shuaijunlan.cinemaservicesapi.CinemaServiceAPI;
import cn.shuaijunlan.cinemaservicesapi.vo.*;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 10:24 AM 2/20/19.
 */
@Component
@Service(interfaceClass = CinemaServiceAPI.class, loadbalance = "roundrobin")
public class CinemaServiceImpl implements CinemaServiceAPI {

    private CinemaFilmRepository cinemaFilmRepository;
    private CinemaFilmSellsRepository cinemaFilmSellsRepository;

    public CinemaServiceImpl(CinemaFilmRepository cinemaFilmRepository, CinemaFilmSellsRepository cinemaFilmSellsRepository) {
        this.cinemaFilmRepository = cinemaFilmRepository;
        this.cinemaFilmSellsRepository = cinemaFilmSellsRepository;
    }

    @Override
    public List<CinemaVO> getCinemas(CinemaQueryVO cinemaQueryVO) {
        return null;
    }

    @Override
    public List<BrandVO> getBrands(int brandId) {
        return null;
    }

    @Override
    public List<AreaVO> getAreas(int areaId) {
        return null;
    }

    @Override
    public List<HallTypeVO> getHallTypes(int hallType) {
        return null;
    }

    @Override
    public CinemaInfoVO getCinemaInfoById(int cinemaId) {
        return null;
    }

    @Override
    public List<FilmInfoVO> getFilmInfoByCinemaId(int cinemaId) {
        return null;
    }

    @Override
    public HallInfoVO getFilmFieldInfo(int fieldId) {
        return null;
    }

    @Override
    public FilmInfoVO getFilmInfoByFieldId(int fieldId) {
        return null;
    }

    @Override
    public OrderQueryVO getOrderNeeds(int fieldId) {
        return null;
    }

    @Override
    public boolean addSells(int cinemaFilmId, String sells) {
        if (cinemaFilmRepository.findById(cinemaFilmId).isPresent()){
            CinemaFilmSellTable cinemaFilmSellTable = new CinemaFilmSellTable();
            cinemaFilmSellTable.setCinemaFilmId(cinemaFilmId);
            cinemaFilmSellTable.setSells(sells);
            return cinemaFilmSellsRepository.save(cinemaFilmSellTable) != null;
        }
        return false;
    }
}
