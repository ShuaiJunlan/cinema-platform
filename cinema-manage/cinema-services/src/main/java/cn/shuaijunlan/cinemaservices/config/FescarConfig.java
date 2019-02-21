package cn.shuaijunlan.cinemaservices.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fescar.rm.datasource.DataSourceProxy;
import com.alibaba.fescar.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 9:45 PM 2/20/19.
 */
@Configuration
public class FescarConfig {

    @Bean(name = "druidDataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DruidDataSource getDataSource(){
        return new DruidDataSource();
    }

    /**
     * init datasource proxy
     * @param source  datasource bean instance
     * @return DataSourceProxy  datasource proxy
     */
    @Bean(name = "datasourceProxy")
    @Primary
    public DataSourceProxy dataSourceProxy(@Qualifier("druidDataSource") DataSource source){
        return new DataSourceProxy((DruidDataSource) source);
    }

    /**
     * init global transaction scanner
     *
     * @return GlobalTransactionScanner
     */
    @Bean
    public GlobalTransactionScanner globalTransactionScanner(){
        return new GlobalTransactionScanner("storage-gts-fescar-example", "my_test_tx_group");
    }
}
