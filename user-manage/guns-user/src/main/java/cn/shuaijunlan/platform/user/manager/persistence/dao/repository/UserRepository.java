package cn.shuaijunlan.platform.user.manager.persistence.dao.repository;

import cn.shuaijunlan.platform.user.manager.persistence.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 3:10 PM 1/2/19.
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
