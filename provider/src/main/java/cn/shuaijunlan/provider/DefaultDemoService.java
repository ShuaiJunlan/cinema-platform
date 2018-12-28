package cn.shuaijunlan.provider;

import cn.shuaijunlan.api.DemoService;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 7:44 PM 12/28/18.
 */
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class DefaultDemoService implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }
}
