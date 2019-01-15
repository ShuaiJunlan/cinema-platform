package cn.shuaijunlan.cinemaservices.dao.repository;

import cn.shuaijunlan.cinemaservices.dao.model.CinemaInfoTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:27 AM 1/15/19.
 */
@Repository
public interface CinemaInfoRepository extends JpaRepository<CinemaInfoTable, Integer> {
}
