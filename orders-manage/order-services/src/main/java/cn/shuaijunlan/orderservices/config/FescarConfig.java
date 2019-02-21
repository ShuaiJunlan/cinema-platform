package cn.shuaijunlan.orderservices.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fescar.rm.datasource.DataSourceProxy;
import com.alibaba.fescar.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 5:08 PM 2/20/19.
 */
@Configuration
public class FescarConfig {
    /**
     * init datasource proxy
     * @param source  datasource bean instance
     * @return DataSourceProxy  datasource proxy
     */
    @Bean(name = "datasourceProxy")
    public DataSourceProxy dataSourceProxy(DataSource source){
        return new DataSourceProxy((DruidDataSource) source);
    }
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
