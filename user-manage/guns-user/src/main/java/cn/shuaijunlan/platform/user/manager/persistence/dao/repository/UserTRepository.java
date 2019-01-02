package cn.shuaijunlan.platform.user.manager.persistence.dao.repository;

import cn.shuaijunlan.platform.user.manager.persistence.model.UserTModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 3:15 PM 1/2/19.
 */
@Repository
public interface UserTRepository extends JpaRepository<UserTModel, Integer> {

    /**
     * @param username username
     * @return
     */
    UserTModel findUserTModelByUserName(String username);
}
