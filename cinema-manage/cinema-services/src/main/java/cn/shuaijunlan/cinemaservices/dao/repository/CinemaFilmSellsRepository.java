package cn.shuaijunlan.cinemaservices.dao.repository;

import cn.shuaijunlan.cinemaservices.dao.model.CinemaFilmSellTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 10:25 AM 2/20/19.
 */
@Repository
public interface CinemaFilmSellsRepository extends JpaRepository<CinemaFilmSellTable, Integer> {
}
