package com.mavenproject.Config;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mavenproject.model.Category;
import com.mavenproject.model.Product;
import com.mavenproject.model.Supplier;
import com.mavenproject.model.User;
@Configuration
@EnableTransactionManagement
@ComponentScan("com.mavenproject")
public class DBconfig {
	
	@Bean(name="datasource")
	public DataSource getH2DataSource() 
	{
		DriverManagerDataSource datasource= new DriverManagerDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl(" jdbc:h2:tcp://localhost/~/test");
		datasource.setUsername("sa");
		datasource.setPassword("sa");
		return datasource;
		
	}
	@Bean(name="sessionfactory")
	public SessionFactory getSessionFactory() {
		Properties hproperties=new Properties();
		hproperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hproperties.setProperty("hibernate.hbm2ddl.auto","update");
		//hproperties.setProperty("hibernate.show_sql","true");
		
		
		LocalSessionFactoryBuilder localsession=new LocalSessionFactoryBuilder(getH2DataSource());
		localsession.addProperties(hproperties);
		localsession.addAnnotatedClass(Category.class);
		localsession.addAnnotatedClass(Supplier.class);
		localsession.addAnnotatedClass(Product.class);
		localsession.addAnnotatedClass(User.class);
		
		
		SessionFactory sessionfactory=localsession.buildSessionFactory();
		
		System.out.println("sessionfactory");
		return sessionfactory;
	}
	@Bean(name="transactionmanager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionfactory) {
		System.out.println("transactionmanager");
		return new HibernateTransactionManager(sessionfactory);
	} 

}

