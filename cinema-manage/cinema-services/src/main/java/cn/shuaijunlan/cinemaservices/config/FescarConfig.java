package cn.shuaijunlan.cinemaservices.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fescar.rm.datasource.DataSourceProxy;
import com.alibaba.fescar.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 9:45 PM 2/20/19.
 */
@Configuration
public class FescarConfig {

    // @Autowired
    // private ApplicationContext applicationContext;

    // @Bean(name = "druidDataSource")
    // @Primary
    // public DataSource getDataSource() {
    //     return applicationContext.getBean(DataSource.class);
    // }

    // @Bean(name = "druidDataSource")
    // @Primary
    // @ConfigurationProperties(prefix="spring.datasource")
    // public DataSource getMyDataSource(){
    //     return DataSourceBuilder.create().build();
    // }



    // /**
    //  * hibernate 适配器,定制方言为mysql,并打印sql
    //  *
    //  * @return
    //  */
    // @Bean(name = "hibernateJpaVendorAdapter")
    // @Primary
    // public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
    //     HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
    //     hibernateJpaVendorAdapter.setShowSql(true);
    //     hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
    //     return hibernateJpaVendorAdapter;
    // }
    //
    // @Bean(name = "localContainerEntityManagerFactoryBean")
    // @Primary
    // public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(@Qualifier("druidDataSource") DataSource dataSource
    //         , @Qualifier("hibernateJpaVendorAdapter") HibernateJpaVendorAdapter hibernateJpaVendorAdapter) {
    //     LocalContainerEntityManagerFactoryBean local = new LocalContainerEntityManagerFactoryBean();
    //     local.setDataSource(dataSource);
    //     local.setJpaVendorAdapter(hibernateJpaVendorAdapter);
    //     local.setPackagesToScan("com.inn.developer.model.domain");
    //     Properties properties = new Properties();
    //     properties.put("hibernate.format_sql", true);
    //     properties.put("hibernate.hbm2ddl.auto", "update");
    //     local.setJpaProperties(properties);
    //     return local;
    // }
    //
    // @Bean(name = "jpaTransactionManager")
    // @Primary
    // public JpaTransactionManager jpaTransactionManager(@Qualifier("localContainerEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
    //     JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
    //     EntityManagerFactory object = entityManagerFactoryBean.getObject();
    //     jpaTransactionManager.setEntityManagerFactory(object);
    //     return jpaTransactionManager;
    // }


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
        return new GlobalTransactionScanner("storage-gts-fescar-example", "my_test_tx_group");
    }
}
