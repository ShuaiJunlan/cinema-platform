package cn.shuaijunlan.cinemaservices.service;

import cn.shuaijunlan.cinemaservicesapi.CinemaServiceAPI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 10:38 AM 2/20/19.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CinemaServiceImplTest {
    @Autowired
    private CinemaServiceAPI cinemaServiceAPI;

    @Test
    public void getCinemas() {
    }

    @Test
    public void getBrands() {
    }

    @Test
    public void getAreas() {
    }

    @Test
    public void getHallTypes() {
    }

    @Test
    public void getCinemaInfoById() {
    }

    @Test
    public void getFilmInfoByCinemaId() {
    }

    @Test
    public void getFilmFieldInfo() {
    }

    @Test
    public void getFilmInfoByFieldId() {
    }

    @Test
    public void getOrderNeeds() {
    }

    @Test
    public void addSells() {
        assertTrue(cinemaServiceAPI.addSells(1, "1,2,3"));
    }
}