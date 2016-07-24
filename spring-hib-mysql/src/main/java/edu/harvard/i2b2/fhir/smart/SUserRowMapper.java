package edu.harvard.i2b2.fhir.smart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

public class SUserRowMapper implements RowMapper<SUser>{
		
		public SUser mapRow(ResultSet rs, int arg1) throws SQLException {
			SUser su=new SUser();
			su.setId(rs.getString("id"));
			su.setPassword(rs.getString("password"));
			su.setFirstName(rs.getString("firstname"));
			su.setLastName(rs.getString("lastname"));
			su.setEmail(rs.getString("email"));
			su.setCreateDT(rs.getTimestamp("createdt"));
			return su;
		}

}
