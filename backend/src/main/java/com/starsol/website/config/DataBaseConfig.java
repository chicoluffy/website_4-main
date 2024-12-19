package com.starsol.website.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan(basePackages = "com.starsol.website.jpa.entity.*")
@EnableJpaRepositories(
        basePackages = "com.starsol.website.jpa.repository",
        entityManagerFactoryRef = "starEntityManager",
        transactionManagerRef = "starTransactionManager")
@EnableTransactionManagement
public class DataBaseConfig {
    @Value("${spring.datasource.hibernate.ddl-auto}")
    private String hbm2ddlAuto;

    @Bean(name = "starDatasource")
    @Qualifier("starDatasource")
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource starDatasource() {
        return DataSourceBuilder.create().build();
    }
    // @PersistenceContext(unitName = "starUnit")
    // @Primary
    // @Bean(name = "starEntityManager")
    // public LocalContainerEntityManagerFactoryBean starEntityManager(LocalContainerEntityManagerFactoryBean builder) {
    //     return builder
    //             .dataSource(starDatasource())
    //             .persistenceUnit("starUnit")
    //             .properties(jpaProperties())
    //             .packages("com.starsol.star.game.orch.*")
    //             .build();
    // }

    // @Bean(name = "starTransactionManager")
    // public PlatformTransactionManager transactionManager(EntityManagerFactory builder) {
    //     JpaTransactionManager tm = new JpaTransactionManager();
    //     tm.setEntityManagerFactory(builder);
    //     tm.setDataSource(starDatasource());
    //     return tm;
    // }

     private Properties jpaProperties() {
        Properties props = new Properties();
        props.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
        return props;
     }

    @PersistenceContext(unitName = "starUnit")
    @Primary
    @Bean(name = "starEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(starDatasource());
        em.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class);
        em.setPersistenceUnitName("starUnit");
        em.setJpaProperties(jpaProperties());
        em.setPackagesToScan("com.starsol.website.jpa.entity");

        return em;
    }

    @Bean(name = "starTransactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}