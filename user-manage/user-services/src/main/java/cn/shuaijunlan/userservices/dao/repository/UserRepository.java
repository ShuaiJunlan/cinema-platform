package cn.shuaijunlan.userservices.dao.repository;

import cn.shuaijunlan.userservices.dao.model.UserInfoTable;
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
 *  Spring Data Jpa事务管理：
 *  http://blog.didispace.com/springboottransactional/
 *  rollbackFor: https://blog.csdn.net/Cary_1029/article/details/84945166
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfoTable, Integer> {

    /**
     * @param username the user name
     * @return get user information
     */
    UserInfoTable findUserTableModelByUserName(String username);

    /**
     * @param uuid      用户id
     * @param userName  用户名
     * @param nickName  用户昵称
     * @param email     电子邮箱
     * @param phone     手机号
     * @param userSex   性别
     * @param birthday  生日
     * @param lifeState 婚姻状态
     * @param biography 座右铭
     * @param address   联系地址
     * @param headAddress   头像链接
     * @return 更新结果
     * @throws Exception 抛出异常
     */
    @Transactional(rollbackFor = Exception.class)
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


    /**
     * @param uuid      用户id
     * @param userName  用户名
     * @return  修改结果
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query("update UserInfoTable u set u.userName=:username where u.uuid=:uuid")
    int updateUserName(
            @Param("uuid") Integer uuid,
            @Param("username") String userName) throws Exception;

    /**
     * @param uuid      用户id
     * @param password  用户名
     * @return  修改结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query("update UserInfoTable u set u.userPwd=:password where u.uuid=:uuid")
    int updatePassword(
            @Param("uuid") int uuid,
            @Param("password") String password);
}
