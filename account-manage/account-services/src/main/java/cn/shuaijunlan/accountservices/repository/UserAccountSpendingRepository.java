package cn.shuaijunlan.accountservices.repository;

import cn.shuaijunlan.accountservices.model.UserAccountSpendingTable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:40 AM 2/20/19.
 */
public interface UserAccountSpendingRepository extends JpaRepository<UserAccountSpendingTable, Integer> {
}
