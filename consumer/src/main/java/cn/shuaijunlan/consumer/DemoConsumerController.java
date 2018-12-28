package cn.shuaijunlan.consumer;

import cn.shuaijunlan.api.DemoService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 7:48 PM 12/28/18.
 */
@RestController
public class DemoConsumerController {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            interfaceClass = DemoService.class)
    private DemoService demoService;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        return demoService.sayHello(name);
    }

}
