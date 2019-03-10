package cn.shuaijunlan.platformgateway.modular.auth.controller;

import cn.shuaijunlan.platformgateway.modular.auth.controller.dto.AuthRequest;
import cn.shuaijunlan.platformgateway.modular.auth.controller.dto.AuthResponse;
import cn.shuaijunlan.platformgateway.modular.auth.util.JwtTokenUtil;
import cn.shuaijunlan.platformgateway.modular.vo.ResponseVO;
import cn.shuaijunlan.userservicesapi.IUserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * 登录验证
 *
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 10:06 PM 1/3/19.
 */
@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    private final JwtTokenUtil jwtTokenUtil;

    @Reference(interfaceClass = IUserService.class, check = false)
    private IUserService IUserService;

    @Autowired
    public AuthController(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @RequestMapping(value = "${jwt.auth-path}", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseVO createAuthenticationToken(@RequestBody AuthRequest authRequest, HttpServletRequest request) {

        int userId = IUserService.login(authRequest.getUsername(), authRequest.getPassword());

        HttpSession session = request.getSession();
        boolean validate = (userId > 0);
        final String randomKey = jwtTokenUtil.getRandomKey();


        if (validate) {

            // randomKey和token已经生成完毕
            final String token = jwtTokenUtil.generateToken("" + userId, randomKey);

            LOGGER.info("Login successfully and randomKey id is: {}.", randomKey);
            session.setAttribute(randomKey, userId);

            // 返回值
            return ResponseVO.success(new AuthResponse(token, randomKey));
        } else {
            session.removeAttribute(randomKey);
            return ResponseVO.serviceFail("用户名或密码错误");
        }
    }
}
