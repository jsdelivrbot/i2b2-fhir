package net.code;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//@SpringBootApplication
//@EnableWebMvc // mvc:annotation-driven
@Configuration
// @EnableJpaRepositories({ "net.code.*" })
@ComponentScan({ "net.code*" })
// @EntityScan({ "net.code.*"})
@PropertySource(value = { "classpath:application.properties" })
public class SpringSqlConfig {

	@Autowired
	private Environment environment;

	@Bean
	public String myBean() {
		System.out.println(">>>>>>>>>created my bean");
		return "mybean1";

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
			JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		emfb.setJpaVendorAdapter(jpaVendorAdapter);
		emfb.setPackagesToScan("net.code");
		return emfb;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		return adapter;
	}

	

	@Bean
	public DataSource dataSource() {
		// return new
		// EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
		// .addScript("classpath:schema.sql")
		// .addScript("classpath:test-data.sql").build();
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/i2b2fhir");
		ds.setUsername("ifcu");
		ds.setPassword("ifcp");
		return ds;
	}

	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "net.code*" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		 properties.put("hibernate.hbm2ddl.auto", "create-drop");
		return properties;
	}

}