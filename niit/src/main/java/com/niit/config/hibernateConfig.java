package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.niit"})
public class hibernateConfig {
	
	private final static String URL = "jdbc:h2:tcp://localhost/~/j2ee";
	private final static String DRIVER_CLASS = "org.h2.Driver";		
	private final static String USERNAME = "sa";
	private final static String PASSWORD = "";
	
	@Bean
	public SessionFactory sessionFactory(DataSource datasource)
	{
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(datasource);
		builder.addProperties(hibernateProperties());
		builder.scanPackages("com.niit.Model");
		
		return builder.buildSessionFactory();
			
	}
	

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);	        
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
	@Bean
	public Properties hibernateProperties()
	{
		Properties properties =new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect"); 
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties; 
		
		
	}
	

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(sessionFactory);
       return txManager;
    }


}
