package jdbctemplate;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringJdbcSqlConfig.class})
public class UserJdbcTemplateTest {

	
	//create table user(id int not null auto_increment, name varchar(10) , primary key(id));
	@Autowired
	private JdbcUserRepository repository;
	
	
	@Test
	public void createUser() {
		repository.create(new User());
		
	
		
		
	}
	
	@Test
	public void findUser() {
		
		System.out.println(repository.findById(1));
	}
	
	@Test
	public void selectUser() {
		
		
		/*jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        ).forEach(customer -> log.info(customer.toString()));
		*/
	}

}
