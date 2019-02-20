package cn.shuaijunlan.accountservices;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:07 AM 2/20/19.
 */
@SpringBootApplication
@EnableDubbo
public class AccountServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountServicesApplication.class, args);
    }
}
