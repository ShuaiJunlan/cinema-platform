package cn.shuaijunlan.platform.user.manager.modular.auth.controller;

import cn.shuaijunlan.platform.user.manager.modular.auth.util.JwtTokenUtil;
import cn.shuaijunlan.platform.user.manager.modular.auth.validator.IReqValidator;
import com.stylefeng.guns.core.exception.GunsException;
import cn.shuaijunlan.platform.user.manager.common.exception.BizExceptionEnum;
import cn.shuaijunlan.platform.user.manager.modular.auth.controller.dto.AuthRequest;
import cn.shuaijunlan.platform.user.manager.modular.auth.controller.dto.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @Resource(name = "simpleValidator")
    private IReqValidator reqValidator;

    @RequestMapping(value = "${jwt.auth-path}")
    public ResponseEntity<?> createAuthenticationToken(AuthRequest authRequest) {

        boolean validate = reqValidator.validate(authRequest);

        if (validate) {
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(authRequest.getUserName(), randomKey);
            return ResponseEntity.ok(new AuthResponse(token, randomKey));
        } else {
            throw new GunsException(BizExceptionEnum.AUTH_REQUEST_ERROR);
        }
    }
}
