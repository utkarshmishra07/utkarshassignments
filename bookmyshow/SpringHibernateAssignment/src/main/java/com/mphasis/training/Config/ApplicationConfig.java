package com.mphasis.training.Config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.mphasis.training")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class ApplicationConfig {
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("nano");
		ds.setPassword("nano");
		return ds;
	}
	
@Bean
public LocalSessionFactoryBean getSessionFactory() {
	LocalSessionFactoryBean sessionFactory= new LocalSessionFactoryBean();
	sessionFactory.setDataSource(getDataSource());
	
	Properties props=new Properties();
	props.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
	props.put("hibernate.hbm2ddl.auto", "create");
	props.put("hibernate.show_sql", "true");
	props.put("hibernate.format_sql","true");
	sessionFactory.setHibernateProperties(props);
	//sessionFactory.setAnnotatedClasses(Employee.class);
	sessionFactory.setPackagesToScan("com.mphasis.training.entities");
	return sessionFactory;
}
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;

		}	
		
		
	}
