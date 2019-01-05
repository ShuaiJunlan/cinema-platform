package cn.shuaijunlan.services.dao.repository;

import cn.shuaijunlan.services.model.UserInfoTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 3:15 PM 1/2/19.
 *
 * TODO: Spring Data Jpa实现多表查询:
 *  https://blog.csdn.net/johnf_nash/article/details/80587204
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfoTable, Integer> {

    /**
     * @param username the user name
     * @return get user information
     */
    UserInfoTable findUserTableModelByUserName(String username);

    @Transactional()
    @Modifying
    @Query("update UserInfoTable ui set " +
            "ui.userName=:userName, ui.nickName=:nickName, ui.email=:email, ui.userPhone=:phone, " +
            "ui.userSex=:userSex, ui.birthday=:birthday, ui.lifeState=:lifeState, ui.biography=:biography, ui.address=:address, ui.headUrl=:headAddress " +
            "where ui.uuid = :uuid")
    int updateUserInfo(
            @Param("uuid") int uuid,
            @Param("userName") String userName,
            @Param("nickName") String nickName,
            @Param("email") String email,
            @Param("phone") String phone,
            @Param("userSex") int userSex,
            @Param("birthday") String birthday,
            @Param("lifeState") int lifeState,
            @Param("biography") String biography,
            @Param("address") String address,
            @Param("headAddress") String headAddress) throws Exception;


    @Transactional
    @Modifying
    @Query("update UserInfoTable u set u.userName=:username where u.uuid=:uuid")
    int updateUserName(
            @Param("uuid") Integer uuid,
            @Param("username") String userName) throws Exception;

    @Transactional
    @Modifying
    @Query("update UserInfoTable u set u.userPwd=:password where u.uuid=:uuid")
    int updatePassword(
            @Param("uuid") int uuid,
            @Param("password") String password);
}
