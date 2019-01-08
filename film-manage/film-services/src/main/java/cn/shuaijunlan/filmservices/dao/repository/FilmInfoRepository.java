package cn.shuaijunlan.filmservices.dao.repository;

import cn.shuaijunlan.filmservices.dao.model.FilmInfoTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 8:14 PM 1/5/19.
 */
@Repository
public interface FilmInfoRepository extends JpaRepository<FilmInfoTable, Integer> {
    FilmInfoTable findFilmInfoTableByFilmId(String filmId);
}
