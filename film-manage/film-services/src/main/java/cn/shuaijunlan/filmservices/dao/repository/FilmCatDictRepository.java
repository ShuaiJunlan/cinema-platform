package cn.shuaijunlan.filmservices.dao.repository;

import cn.shuaijunlan.filmservices.dao.model.FilmCatDictTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 8:13 PM 1/5/19.
 */
@Repository
public interface FilmCatDictRepository extends JpaRepository<FilmCatDictTable, Integer> {
}
