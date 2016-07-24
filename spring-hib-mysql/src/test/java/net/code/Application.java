
package net.code;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//@SpringBootApplication
//@ComponentScan({ "net.code.*" })
//@EntityScan({ "net.code.*"})

public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
    
    /*@Bean
	public DataSource dataSource() {
		//return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
		//.addScript("classpath:schema.sql")
			//	.addScript("classpath:test-data.sql").build();
		DriverManagerDataSource ds=new DriverManagerDataSource();
		 ds.setDriverClassName("com.mysql.jdbc.Driver");
		 ds.setUrl("jdbc:mysql://localhost:3306/i2b2fhir");
		 ds.setUsername("ifcu");
		 ds.setPassword("ifcp");
		 return ds;
	}*/

}