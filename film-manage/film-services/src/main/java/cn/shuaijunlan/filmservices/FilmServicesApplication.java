package cn.shuaijunlan.filmservices;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shuaijunlan
 */
@SpringBootApplication
@EnableDubbo
public class FilmServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmServicesApplication.class, args);
    }

}

