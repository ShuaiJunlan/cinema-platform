package cn.shuaijunlan.platformgateway.modular.film;

import cn.shuaijunlan.filmservicesapi.FilmServiceApi;
import cn.shuaijunlan.filmservicesapi.vo.BannerVO;
import cn.shuaijunlan.filmservicesapi.vo.YearVO;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 3:03 PM 1/8/19.
 */
@RestController
@RequestMapping(value = "/film/")
public class FilmController {
    @Reference(interfaceClass = FilmServiceApi.class, check = false)
    private FilmServiceApi filmService;
    @RequestMapping(value = "banners")
    public List<BannerVO> getAllBanners(){
        return filmService.getBanners();
    }

    @RequestMapping(value = "years")
    public List<YearVO> getAllYears(){
        return filmService.getYears();
    }
}
