package cn.shuaijunlan.orderservices.config;

import com.alibaba.fescar.spring.annotation.GlobalTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 5:08 PM 2/20/19.
 */
@Configuration
public class FescarConfig {
    /**
     * init global transaction scanner
     *
     * @return GlobalTransactionScanner
     */
    @Bean
    public GlobalTransactionScanner globalTransactionScanner(){
        return new GlobalTransactionScanner("dubbo-gts-fescar-example", "my_test_tx_group");
    }
}
