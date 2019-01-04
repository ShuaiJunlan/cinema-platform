package cn.shuaijunlan.services.dao.repository;

import cn.shuaijunlan.services.model.UserInfoTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 3:15 PM 1/2/19.
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfoTable, Integer> {

    /**
     * @param username the user name
     * @return get user information
     */
    UserInfoTable findUserTableModelByUserName(String username);

    @Transactional
    @Modifying
    @Query("update UserInfoTable ui set ui.userName=:userName, ui.nickName=:nickName, ui.userSex = :userSex, ui.address=:address where ui.uuid = :uuid")
    int updateUserInfo(
            @Param("uuid") int uuid,
            @Param("userName") String userName,
            @Param("nickName") String nickName,
            @Param("userSex") int userSex,
            @Param("address") String address);


    @Transactional
    @Modifying
    @Query("update UserInfoTable u set u.userName=:username where u.uuid=:uuid")
    int updateUserName(
            @Param("uuid") Integer uuid,
            @Param("username") String userName);

    @Transactional
    @Modifying
    @Query("update UserInfoTable u set u.userPwd=:password where u.uuid=:uuid")
    int updatePassword(
            @Param("uuid") Integer uuid,
            @Param("password") String password);
}
