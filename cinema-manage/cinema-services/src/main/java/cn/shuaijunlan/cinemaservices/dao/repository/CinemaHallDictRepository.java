package cn.shuaijunlan.cinemaservices.dao.repository;

import cn.shuaijunlan.cinemaservices.dao.model.CinemaHallDictTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:26 AM 1/15/19.
 */
@Repository
public interface CinemaHallDictRepository extends JpaRepository<CinemaHallDictTable, Integer> {
}
