package jdbctemplate;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserRepository {
	private JdbcOperations jdbcOperations;

	private static final String SELECT_USER_BY_ID = "select id,name from user where id = ?";
	private static final String INSERT_USER = "INSERT INTO user(name) VALUES ('name1')";

	@Inject
	public JdbcUserRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	public User create(User user) {
		String id = "1";
		jdbcOperations.execute(INSERT_USER);
		return user;
	}
	
	User findById(int id){
		
		User u = jdbcOperations.queryForObject(
				SELECT_USER_BY_ID,
				new UserRowMapper(),
				id);
		System.out.println(u.toString());
		return u;
	}
}