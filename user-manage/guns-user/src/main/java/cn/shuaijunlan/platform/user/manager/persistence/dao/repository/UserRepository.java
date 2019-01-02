package cn.shuaijunlan.platform.user.manager.persistence.dao.repository;

import com.stylefeng.guns.api.user.vo.UserModel;

import java.util.List;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 3:10 PM 1/2/19.
 */
// @Repository
public interface UserRepository  {
    /**
     * @param username
     * @return
     */
    List<UserModel> findAllByUserName(String username);
}
