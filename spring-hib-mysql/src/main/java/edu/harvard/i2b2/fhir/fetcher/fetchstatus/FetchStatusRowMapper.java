package edu.harvard.i2b2.fhir.fetcher.fetchstatus;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class FetchStatusRowMapper implements RowMapper<FetchStatus>{

	@Override
	public FetchStatus mapRow(ResultSet rs, int i) throws SQLException {
		FetchStatus fs=new FetchStatus();
		fs.setId(rs.getString("id"));
		fs.setCount(rs.getInt("count"));
		return fs;
	}

}
