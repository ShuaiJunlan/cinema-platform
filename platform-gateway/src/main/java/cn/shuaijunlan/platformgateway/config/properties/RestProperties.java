package cn.shuaijunlan.platformgateway.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 项目相关配置
 *
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 9:55 PM 1/3/19.
 */
@Component
@ConfigurationProperties(prefix = RestProperties.REST_PREFIX)
@Data
public class RestProperties {

    public static final String REST_PREFIX = "rest";

    private boolean authOpen = true;

    private boolean signOpen = true;

}
