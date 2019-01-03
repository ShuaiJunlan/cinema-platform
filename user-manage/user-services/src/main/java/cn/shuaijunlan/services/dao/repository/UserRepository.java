package cn.shuaijunlan.services.dao.repository;

import cn.shuaijunlan.services.model.UserTableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 3:15 PM 1/2/19.
 */
@Repository
public interface UserRepository extends JpaRepository<UserTableModel, Integer> {

    /**
     * @param username username
     * @return userTModel
     */
    UserTableModel findUserTableModelByUserName(String username);
}
