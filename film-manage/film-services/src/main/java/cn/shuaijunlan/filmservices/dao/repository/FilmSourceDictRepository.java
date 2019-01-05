package cn.shuaijunlan.filmservices.dao.repository;

import cn.shuaijunlan.filmservices.dao.model.FilmSourceDictTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 8:15 PM 1/5/19.
 */
@Repository
public interface FilmSourceDictRepository extends JpaRepository<FilmSourceDictTable, Integer> {
}
