package edu.harvard.i2b2.fhir.smart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

public class SClientRowMapper implements RowMapper<SClient>{
		
		public SClient mapRow(ResultSet rs, int arg1) throws SQLException {
			SClient sc=new SClient();
			sc.setId(rs.getString("id"));
			sc.setSecret(rs.getString("secret"));
			sc.setRedirectUrl(rs.getString("redirecturl"));
			sc.setUserId(rs.getString("userid"));
			sc.setCreateDT(rs.getTimestamp("createdt"));
			return sc;
		}

}
