package cn.shuaijunlan.platformgateway.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * jwt相关配置
 *
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 9:54 PM 1/3/19.
 * TODO: https://tuhrig.de/using-configurationproperties-to-separate-service-and-configuration/
 */
@Component
@ConfigurationProperties(prefix = JwtProperties.JWT_PREFIX)
@Data
public class JwtProperties {

    static final String JWT_PREFIX = "jwt";

    private String header = "Authorization";

    private String secret = "defaultSecret";

    private Long expiration = 604800L;

    private String authPath = "auth";

    private String md5Key = "randomKey";

    private String ignoreUrl = "";
}
