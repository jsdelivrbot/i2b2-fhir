package jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u=new User();
		u.setId(rs.getString("id"));
		u.setName(rs.getString("name"));
		return u; 
		
	}

}
