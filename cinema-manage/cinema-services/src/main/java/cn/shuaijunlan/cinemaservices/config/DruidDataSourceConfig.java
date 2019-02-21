package cn.shuaijunlan.cinemaservices.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 10:28 AM 2/21/19.
 */
// @Configuration
// @EnableTransactionManagement
// @EnableJpaRepositories(
//         entityManagerFactoryRef = "billSystemEntityManagerFactoryBean",
//         transactionManagerRef = "billSystemTransactionManager",
//         //设置Repository所在位置
//         basePackages = {"cn.shuaijunlan"})
public class DruidDataSourceConfig {
    // @Autowired
    // private JpaProperties jpaProperties;
    //
    // @Autowired
    // @Qualifier("datasource")
    // private DataSource billSystemDataSource;
    //
    // @Bean(name = "billSystemEntityManagerFactoryBean")
    // @Primary
    // public LocalContainerEntityManagerFactoryBean billSystemEntityManagerFactoryBean(EntityManagerFactoryBuilder builder){
    //     return builder.dataSource(billSystemDataSource)
    //             .properties(getVendorProperties(billSystemDataSource))
    //             //设置实体类所在位置
    //             .packages("com.ligowave.bill.domain.billsystem.entity")
    //             .persistenceUnit("billSystemPersistenceUnit")
    //             .build();
    // }
    //
    // private Map<String,String> getVendorProperties(DataSource dataSource){
    //     // return jpaProperties.getHibernateProperties(dataSource);
    //     return new HashMap<>();
    // }
    //
    // /**
    //  * EntityManagerFactory类似于Hibernate的SessionFactory,mybatis的SqlSessionFactory
    //  * 总之,在执行操作之前,我们总要获取一个EntityManager,这就类似于Hibernate的Session,
    //  * mybatis的sqlSession.
    //  * @param builder
    //  * @return
    //  */
    // @Bean(name = "billSystemEntityManagerFactory")
    // public EntityManagerFactory billSystemEntityManagerFactory(EntityManagerFactoryBuilder builder){
    //     return this.billSystemEntityManagerFactoryBean(builder).getObject();
    // }
    //
    // /**
    //  * 配置事物管理器
    //  */
    // @Bean(name = "billSystemTransactionManager")
    // public PlatformTransactionManager billSystemTransactionManager(EntityManagerFactoryBuilder builder){
    //     return new JpaTransactionManager(billSystemEntityManagerFactory(builder));
    // }
}
