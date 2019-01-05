package cn.shuaijunlan.platformgateway.config;

import cn.shuaijunlan.platform.core.config.DefaultFastjsonConfig;
import cn.shuaijunlan.platformgateway.config.properties.RestProperties;
import cn.shuaijunlan.platformgateway.modular.auth.converter.WithSignMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 签名校验messageConverter
 *
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 4:51 PM 1/5/19.
 */
@Configuration
public class MessageConverterConfig {

    @Bean
    @ConditionalOnProperty(prefix = RestProperties.REST_PREFIX, name = "sign-open", havingValue = "true", matchIfMissing = true)
    public WithSignMessageConverter withSignMessageConverter() {
        WithSignMessageConverter withSignMessageConverter = new WithSignMessageConverter();
        DefaultFastjsonConfig defaultFastjsonConfig = new DefaultFastjsonConfig();
        withSignMessageConverter.setFastJsonConfig(defaultFastjsonConfig.fastjsonConfig());
        withSignMessageConverter.setSupportedMediaTypes(defaultFastjsonConfig.getSupportedMediaType());
        return withSignMessageConverter;
    }
}
