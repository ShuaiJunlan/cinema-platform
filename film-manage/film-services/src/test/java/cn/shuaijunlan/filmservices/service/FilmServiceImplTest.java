package cn.shuaijunlan.filmservices.service;

import cn.shuaijunlan.filmservices.dao.repository.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 2:53 PM 1/8/19.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class FilmServiceImplTest {
    @Autowired
    private FilmServiceImpl filmService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getBanners() {
    }

    @Test
    public void getHotFilms() {
    }

    @Test
    public void getSoonFilms() {
    }

    @Test
    public void getClassicFilms() {
    }

    @Test
    public void getBoxRanking() {
    }

    @Test
    public void getExpectRanking() {
    }

    @Test
    public void getTop() {
    }

    @Test
    public void getCats() {
    }

    @Test
    public void getSources() {
    }

    @Test
    public void getYears() {
        System.out.println(filmService.getYears());
    }

    @Test
    public void getFilmDetail() {
    }

    @Test
    public void getFilmDesc() {
    }

    @Test
    public void getImgs() {
    }

    @Test
    public void getDectInfo() {
    }

    @Test
    public void getActors() {
    }
}