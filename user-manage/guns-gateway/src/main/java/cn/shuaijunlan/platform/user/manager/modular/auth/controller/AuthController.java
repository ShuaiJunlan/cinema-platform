package cn.shuaijunlan.platform.user.manager.modular.auth.controller;

import cn.shuaijunlan.platform.user.manager.modular.auth.util.JwtTokenUtil;
import cn.shuaijunlan.platform.user.manager.modular.vo.ResponseVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.user.IUserService;
import cn.shuaijunlan.platform.user.manager.modular.auth.controller.dto.AuthRequest;
import cn.shuaijunlan.platform.user.manager.modular.auth.controller.dto.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请求验证的
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:22
 */
@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Reference(interfaceClass = IUserService.class, check = false)
    private IUserService IUserService;

    @RequestMapping(value = "${jwt.auth-path}")
    public ResponseVO createAuthenticationToken(AuthRequest authRequest) {

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