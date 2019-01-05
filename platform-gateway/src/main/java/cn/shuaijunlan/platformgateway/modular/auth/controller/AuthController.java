package cn.shuaijunlan.platformgateway.modular.auth.controller;

import cn.shuaijunlan.platformgateway.modular.auth.controller.dto.AuthRequest;
import cn.shuaijunlan.platformgateway.modular.auth.controller.dto.AuthResponse;
import cn.shuaijunlan.platformgateway.modular.auth.util.JwtTokenUtil;
import cn.shuaijunlan.platformgateway.modular.vo.ResponseVO;
import cn.shuaijunlan.userservicesapi.IUserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请求验证的
 *
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 10:06 PM 1/3/19.
 */
@RestController
public class AuthController {

    private final JwtTokenUtil jwtTokenUtil;

    @Reference(interfaceClass = IUserService.class, check = false)
    private IUserService IUserService;

    @Autowired
    public AuthController(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @RequestMapping(value = "${jwt.auth-path}", method = RequestMethod.POST)
    public ResponseVO createAuthenticationToken(AuthRequest authRequest) {
        System.out.println(Thread.currentThread().getName());

        boolean validate = true;
        // 去掉guns自身携带的用户名密码验证机制，使用我们自己的
        int userId = IUserService.login(authRequest.getUserName(), authRequest.getPassword());
        if (userId == 0) {
            validate = false;
        }

        if (validate) {
            // randomKey和token已经生成完毕
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken("" + userId, randomKey);
            // 返回值
            return ResponseVO.success(new AuthResponse(token, randomKey));
        } else {
            return ResponseVO.serviceFail("用户名或密码错误");
        }
    }
}
