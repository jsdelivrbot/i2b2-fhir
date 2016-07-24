package edu.harvard.i2b2.fhir.fetcher.fetchstatus;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import edu.harvard.i2b2.fhir.web.WebControllerFS;


@Repository
public class FetchStatusJdbcRepository {
	static Logger logger = LoggerFactory.getLogger(FetchStatusJdbcRepository.class);
	private JdbcOperations jdbcOperations;

	private static final String SELECT_FS_BY_ID = "select id,count from fetchstatus where id = ?";
	private static final String INSERT_FS = "INSERT INTO fetchstatus(id,count) VALUES (?,?)";
	private static final String UPDATE_FS =" UPDATE fetchstatus SET count=? WHERE  id=?";

	
	//create table fetchstatus(id varchar(10) not null, count int, primary key(id));
	@Inject
	public FetchStatusJdbcRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}
	
	public FetchStatus findOne(String id) {
		FetchStatus fs = jdbcOperations.queryForObject(
				SELECT_FS_BY_ID,
				new FetchStatusRowMapper(),id);
		//System.out.println(fs.toString());
		return fs;
	}

	

	public void save(FetchStatus fs) {
		logger.info("saving:"+fs.toString());
		//System.out.println("saving:"+fs.toString());
		if(findOne(fs.getId())==null){
		jdbcOperations.update(
				INSERT_FS,
				fs.getId(),fs.getCount());
		}else{
			update(fs);
		}
	}
	
	private void update(FetchStatus fs) {
		jdbcOperations.update(
				UPDATE_FS,
				fs.getCount(),fs.getId());

	}

}
