package edu.harvard.i2b2.fhir.smart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SUserJdbcRepository {

	static Logger logger = LoggerFactory.getLogger(SUserJdbcRepository.class);
	private static final String SELECT_BY_ID = "select id, password,firstname, lastname, email, createdt from suser where id=?";
	
	private static final String UPDATE_SUSER = "UPDATE suser SET password=?,firstname=?, lastname=?, email=?,createdt=? where id=?";
	private static final String INSERT_SUSER = "INSERT INTO suser(id,password,firstname,lastname,email,createdt) values (?,?,?,?,?,?)";
	private JdbcOperations jdbcOperations;

	@Inject
	public SUserJdbcRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	public List<SUser> find(String id) {
		List<SUser> u = jdbcOperations.query(SELECT_BY_ID, new SUserRowMapper(), id);
		return u;

	}

	public void save(SUser u) {
		if (find(u.getId()).size() == 0) {
			insert(u);
		} else {
			update(u);
		}

	}

	private void update(SUser u) {
		jdbcOperations.update(UPDATE_SUSER, u.getPassword(),u.getFirstName(),u.getLastName(),u.getEmail(),u.getCreateDT(),u.getId());

	}

	private void insert(SUser u) {
		jdbcOperations.update(INSERT_SUSER, u.getId(), u.getPassword(),u.getFirstName(),u.getLastName(),u.getEmail(),u.getCreateDT());

	}

	public void remove(String id) {
		// TODO Auto-generated method stub

	}

	public SUser findOne(String id) {
		List<SUser> l = find(id);
		return (l.size() > 0) ? l.get(0) : null;
	}

}
