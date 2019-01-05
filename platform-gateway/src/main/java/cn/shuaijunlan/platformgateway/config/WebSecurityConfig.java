package cn.shuaijunlan.platformgateway.config;

import cn.shuaijunlan.platformgateway.config.properties.RestProperties;
import cn.shuaijunlan.platformgateway.modular.auth.filter.AuthFilter;
import cn.shuaijunlan.platformgateway.modular.auth.security.DataSecurityAction;
import cn.shuaijunlan.platformgateway.modular.auth.security.impl.Base64SecurityAction;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * web配置
 *
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 4:51 PM 1/5/19.
 */
@Configuration
public class WebSecurityConfig {

    @Bean
    @ConditionalOnProperty(prefix = RestProperties.REST_PREFIX, name = "auth-open", havingValue = "true")
    public AuthFilter jwtAuthenticationTokenFilter() {
        return new AuthFilter();
    }

    @Bean
    public DataSecurityAction dataSecurityAction() {
        return new Base64SecurityAction();
    }
}
