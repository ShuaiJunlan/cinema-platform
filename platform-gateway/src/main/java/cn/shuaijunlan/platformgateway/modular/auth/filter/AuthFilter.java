package cn.shuaijunlan.platformgateway.modular.auth.filter;

import cn.shuaijunlan.platform.core.base.tips.ErrorTip;
import cn.shuaijunlan.platform.core.util.RenderUtil;
import cn.shuaijunlan.platformgateway.common.CurrentUser;
import cn.shuaijunlan.platformgateway.common.exception.BizExceptionEnum;
import cn.shuaijunlan.platformgateway.config.properties.AuthProperties;
import cn.shuaijunlan.platformgateway.config.properties.JwtProperties;
import cn.shuaijunlan.platformgateway.modular.auth.util.JwtTokenUtil;
import io.jsonwebtoken.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 对客户端请求的jwt token验证过滤器
 *
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 10:13 PM 1/3/19.
 */
public class AuthFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthFilter.class);

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private AuthProperties authProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 认证url
        if (request.getServletPath().equals("/" + jwtProperties.getAuthPath())) {
            chain.doFilter(request, response);
            return;
        }

        // 忽略列表
        String ignoreUrl = jwtProperties.getIgnoreUrl();
        String[] ignoreUrls = ignoreUrl.split(",");
        for (String ignoreUrl1 : ignoreUrls) {
            if (request.getServletPath().equals(ignoreUrl1)) {
                chain.doFilter(request, response);
                return;
            }
        }

        String randomKey = request.getHeader(authProperties.getKeyName());
        String token = request.getHeader(authProperties.getTokenName());

        if (randomKey == null || token == null){
            RenderUtil.renderJson(response, new ErrorTip(BizExceptionEnum.TOKEN_ERROR.getCode(), BizExceptionEnum.TOKEN_ERROR.getMessage()));
            return;
        }

        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute(randomKey);
        if (userId != null) {
            //验证token是否过期,包含了验证jwt是否正确
            try {
                boolean flag = jwtTokenUtil.isTokenExpired(token);
                if (flag) {
                    RenderUtil.renderJson(response, new ErrorTip(BizExceptionEnum.TOKEN_EXPIRED.getCode(), BizExceptionEnum.TOKEN_EXPIRED.getMessage()));
                    return;
                }
            } catch (JwtException e) {
                //有异常就是token解析失败
                RenderUtil.renderJson(response, new ErrorTip(BizExceptionEnum.TOKEN_ERROR.getCode(), BizExceptionEnum.TOKEN_ERROR.getMessage()));
                return;
            }
            //根据token获取用户信息
            String temp = jwtTokenUtil.getUsernameFromToken(token);
            if (temp != null && temp.equals(String.valueOf(userId))) {
                CurrentUser.saveUserId(temp);
                LOGGER.info("Store userId into ThreadLocal!");
                chain.doFilter(request, response);
            }
        } else {
            RenderUtil.renderJson(response, new ErrorTip(BizExceptionEnum.TOKEN_ERROR.getCode(), BizExceptionEnum.TOKEN_ERROR.getMessage()));
        }
    }
}