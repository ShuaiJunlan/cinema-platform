package cn.shuaijunlan.cinemaservices.config;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:15 AM 2/21/19.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryPrimary",
        transactionManagerRef="transactionManagerPrimary",
        basePackages= { "cn.shuaijunlan"}) //设置Repository所在位置
public class PrimaryConfig {

    @Autowired
    @Qualifier("druidDataSource")
    private DataSource primaryDataSource;


    @Primary
    @Bean(name = "entityManagerPrimary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }

    // @Autowired
    // private JpaProperties jpaProperties;

    @Bean(name = "entityManagerFactoryPrimary")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary (EntityManagerFactoryBuilder builder) {
        return builder.dataSource(primaryDataSource)
                .packages("cn.shuaijunlan")
                .persistenceUnit("primary")
                .properties(buildProperties())
                .build();
    }
    @Bean(name="transactionManagerPrimary")
    @Autowired
    public PlatformTransactionManager primaryTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }

    // 公共jpa设置
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String dll;
    // @Value("${spring.jpa.properties.hibernate.dialect}")
    // String dialect;
    @Value("${spring.jpa.show-sql}")
    private String showSql;

    private Map<String, Object> buildProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.ejb.naming_strategy", ImprovedNamingStrategy.class.getName());
        properties.put("hibernate.hbm2ddl.auto", dll);
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", showSql);
        return properties;
    }
}
