package cn.shuaijunlan.filmservices.dao.repository;

import cn.shuaijunlan.filmservices.dao.model.FilmAreaDictTable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 8:12 PM 1/5/19.
 */
public interface FilmAreaDictRepository extends JpaRepository<FilmAreaDictTable, Integer> {
}
