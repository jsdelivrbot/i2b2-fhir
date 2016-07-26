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
public class SClientJdbcRepository {

	static Logger logger = LoggerFactory.getLogger(SClientJdbcRepository.class);
	private static final String SELECT_BY_ID = "select id,secret,redirecturl,userid,createdt from sclient where id=?";
	private static final String SELECT_BY_USER_ID = "select id,secret,redirecturl,userid,createdt from sclient where userid=?";

	private static final String UPDATE_SCLIENT = "UPDATE sclient SET secret=?,redirecturl=?,userid=?,createdt=? where id=?";
	private static final String INSERT_SCLIENT = "INSERT INTO sclient(id,secret,redirecturl,userid,createdt) values (?,?,?,?,?)";
	private JdbcOperations jdbcOperations;

	@Inject
	public SClientJdbcRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	public List<SClient> find(String id) {
		List<SClient> c = jdbcOperations.query(SELECT_BY_ID, new SClientRowMapper(), id);
		return c;

	}

	public List<SClient> findByUserId(String userid) {
		List<SClient> c = jdbcOperations.query(SELECT_BY_USER_ID, new SClientRowMapper(), userid);
		return c;

	}

	public void save(SClient c) {
		if (find(c.getId()).size() == 0) {
			insert(c);
		} else {
			update(c);
		}

	}

	private void update(SClient c) {
		jdbcOperations.update(UPDATE_SCLIENT, c.getSecret(), c.getRedirectUrl(),  c.getUserId(),c.getCreateDT(),
				c.getId());

	}

	private void insert(SClient c) {
		jdbcOperations.update(INSERT_SCLIENT, c.getId(), c.getSecret(),  c.getRedirectUrl(),c.getUserId(),
				c.getCreateDT());

	}

	public void remove(String id) {
		// TODO Auto-generated method stub

	}

	public SClient findOne(String id) {
		List<SClient> l = find(id);
		return (l.size() > 0) ? l.get(0) : null;
	}

}
