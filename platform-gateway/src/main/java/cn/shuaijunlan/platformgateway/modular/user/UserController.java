package cn.shuaijunlan.platformgateway.modular.user;

import cn.shuaijunlan.platform.core.util.MD5Util;
import cn.shuaijunlan.platformgateway.common.CurrentUser;
import cn.shuaijunlan.platformgateway.config.properties.AuthProperties;
import cn.shuaijunlan.platformgateway.modular.vo.ResponseVO;
import cn.shuaijunlan.userservicesapi.IUserService;
import cn.shuaijunlan.userservicesapi.vo.UserInfoModel;
import cn.shuaijunlan.userservicesapi.vo.UserModel;
import com.alibaba.dubbo.common.utils.ConcurrentHashSet;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author shuaijunlan
 */
@RequestMapping("/user/")
@RestController
public class UserController {

    @Reference(interfaceClass = IUserService.class, check = false)
    private IUserService userService;

    @Autowired
    private AuthProperties authProperties;

    private static ConcurrentHashSet<Thread> concurrentHashSet = new ConcurrentHashSet<>();


    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseVO register(UserModel userModel) {
        if (userModel.getUsername() == null || userModel.getUsername().trim().length() == 0) {
            return ResponseVO.serviceFail("用户名不能为空");
        }
        if (userModel.getPassword() == null || userModel.getPassword().trim().length() == 0) {
            return ResponseVO.serviceFail("密码不能为空");
        }
        //密码加密
        userModel.setPassword(MD5Util.encrypt(userModel.getPassword()));

        boolean isSuccess = userService.register(userModel);
        if (isSuccess) {
            return ResponseVO.success("注册成功");
        } else {
            return ResponseVO.serviceFail("注册失败");
        }
    }

    @RequestMapping(value = "check", method = RequestMethod.GET)
    public ResponseVO check(String username) {
        concurrentHashSet.add(Thread.currentThread());
        System.out.println(concurrentHashSet.size());
        if (username != null && username.trim().length() > 0) {
            // 当返回true的时候，表示用户名可用
            boolean notExists = userService.checkUsername(username);
            if (notExists) {
                return ResponseVO.success("用户名不存在");
            } else {
                return ResponseVO.serviceFail("用户名已存在");
            }

        } else {
            return ResponseVO.serviceFail("用户名不能为空");
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public ResponseVO logout(HttpServletRequest request) {
        /*
            应用：
                1、前端存储JWT 【七天】 ： JWT的刷新
                2、服务器端会存储活动用户信息【30分钟】
                3、JWT里的userId为key，查找活跃用户
            退出：
                1、前端删除掉JWT
                2、后端服务器删除活跃用户缓存
            现状：
                1、前端删除掉JWT
         */
        HttpSession session = request.getSession();
        if (request.getHeader(authProperties.getKeyName()) != null){
            session.removeAttribute(request.getHeader(authProperties.getKeyName()));
        }


        return ResponseVO.success("用户退出成功");
    }


    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
    public ResponseVO getUserInfo() {
        System.out.println(Thread.currentThread().getName());
        // 获取当前登陆用户
        String userId = CurrentUser.getCurrentUser();
        if (userId != null && userId.trim().length() > 0) {
            // 将用户ID传入后端进行查询
            int uuid = Integer.parseInt(userId);
            UserInfoModel userInfo = userService.getUserInfo(uuid);
            if (userInfo != null) {
                return ResponseVO.success(userInfo);
            } else {
                return ResponseVO.appFail("用户信息查询失败");
            }
        } else {
            return ResponseVO.serviceFail("用户未登陆");
        }
    }

    @RequestMapping(value = "updateUserInfo", method = RequestMethod.POST)
    public ResponseVO updateUserInfo(UserInfoModel userInfoModel) {
        // 获取当前登陆用户
        String userId = CurrentUser.getCurrentUser();
        if (userId != null && userId.trim().length() > 0) {
            // 将用户ID传入后端进行查询
            int uuid = Integer.parseInt(userId);
            // 判断当前登陆人员的ID与修改的结果ID是否一致
            if (uuid != userInfoModel.getUuid()) {
                return ResponseVO.serviceFail("请修改您个人的信息");
            }

            UserInfoModel userInfo = userService.updateUserInfo(userInfoModel);
            if (userInfo != null) {
                return ResponseVO.success(userInfo);
            } else {
                return ResponseVO.appFail("用户信息修改失败");
            }
        } else {
            return ResponseVO.serviceFail("用户未登陆");
        }
    }

    @RequestMapping(value = "updatePassword")
    public ResponseVO updatePassword(String password, HttpServletRequest request){
        if (StringUtils.isEmpty(password)){
            return ResponseVO.serviceFail("修改失败");
        }
        int re = userService.updateUserPassword(Integer.valueOf(CurrentUser.getCurrentUser()), MD5Util.encrypt(password));
        if (re != 1){
            return ResponseVO.serviceFail("修改失败");
        }
        HttpSession session = request.getSession();
        session.removeAttribute(session.getId());
        return ResponseVO.success("修改成功");
    }
}
