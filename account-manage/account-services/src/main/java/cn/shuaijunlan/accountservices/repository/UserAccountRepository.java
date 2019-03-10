package cn.shuaijunlan.accountservices.repository;

import cn.shuaijunlan.accountservices.model.UserAccountTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:39 AM 2/20/19.
 */
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountTable, Integer> {
    /**
     * @param uuid
     * @param amount
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query("update UserAccountTable ua set ua.amount=:amount where ua.uuid=:uuid")
    int updateAmount(@Param("uuid") int uuid, @Param("amount") double amount);
}
