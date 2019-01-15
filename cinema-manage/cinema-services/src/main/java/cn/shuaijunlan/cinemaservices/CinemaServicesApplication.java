package cn.shuaijunlan.cinemaservices;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shuaijunlan
 */
@SpringBootApplication
@EnableDubbo
public class CinemaServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaServicesApplication.class, args);
    }

}

