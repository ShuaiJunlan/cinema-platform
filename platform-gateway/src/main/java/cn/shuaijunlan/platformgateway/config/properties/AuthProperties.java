package cn.shuaijunlan.platformgateway.config.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 4:21 PM 1/15/19.
 */
@Configuration
@Data
public class AuthProperties {

    @Value("${auth.token.name}")
    private String tokenName = "X-Token";

    @Value("${auth.key.name}")
    private String keyName = "RandomKey";
}
