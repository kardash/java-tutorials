package com.addressbook.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages="com.addressbook.repositories")
@EnableTransactionManagement
public class DataConfig {
	@Value("${db.username}")
	private String dbUser;
	
	@Value("${db.password}")
	private String dbPass;
	
	@Value("${db.url}")
	private String dbUrl;
	
	@Value("${db.driverClassName}")
	private String dbDriver;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
	  return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
    public DriverManagerDataSource dataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName(dbDriver);
    	dataSource.setUrl(dbUrl);
    	dataSource.setUsername(dbUser);
    	dataSource.setPassword(dbPass);
    	
        return dataSource;
    }
	    
    @Bean 
    public EntityManagerFactory entityManagerFactory() throws SQLException {

    	HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    	vendorAdapter.setGenerateDdl(true);

    	LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    	
    	factory.setJpaVendorAdapter(vendorAdapter);
    	factory.setPackagesToScan("com.addressbook.entities");
    	factory.setDataSource(dataSource());
    	factory.setJpaProperties(jpaProperties());
    	factory.afterPropertiesSet();

    	return factory.getObject();
    }
        
    @Bean
    public JpaTransactionManager transactionManager() throws SQLException{
    	JpaTransactionManager tm = new JpaTransactionManager();
    	
    	tm.setEntityManagerFactory(entityManagerFactory());
    	
    	return tm;
    }
    
    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.globally_quoted_identifiers", "true");
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        
        return properties;
    }
}
