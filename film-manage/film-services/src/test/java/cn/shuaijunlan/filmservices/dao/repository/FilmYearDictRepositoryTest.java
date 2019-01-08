package cn.shuaijunlan.filmservices.dao.repository;

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
 * @since Created in 2:41 PM 1/8/19.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class FilmYearDictRepositoryTest {
    @Autowired
    private FilmYearDictRepository filmYearDictRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllYears(){
        System.out.println(filmYearDictRepository.findAll());
    }
}