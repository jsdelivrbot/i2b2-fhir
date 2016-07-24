package net.code;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringSqlConfig.class})
public class TestSql {
	@Autowired
	DataSource ds;
	
	@Autowired 
	UserRepository jparep;
	
	@Test
	public void test1() {
		return ;
	}
	
	//@Test
	public void test() {
		//fail("Not yet implemented");
		
		Useracc user=new Useracc();
		user.setEmail("email4");
		jparep.save(user);
		 user=new Useracc();
		user.setEmail("email5");
		jparep.save(user);
		//user.setUsername("username3");
		//jparep.saveUser(user);
		
		System.out.println(">>>size:"+jparep.getUserById(0));
		/*try {
			Connection conn = ds.getConnection();
			//PreparedStatement st = conn.prepareStatement("create table if not exists tb1(id int  );");
			PreparedStatement st = conn.prepareStatement("select * from Useracc;");
			
			 ResultSet rs = st.executeQuery();
			 ResultSetMetaData rsmd = rs.getMetaData();
			 int columnsNumber = rsmd.getColumnCount();
			 while (rs.next()) {
			        for (int i = 1; i <= columnsNumber; i++) {
			            if (i > 1) System.out.print(",  ");
			            String columnValue = rs.getString(i);
			            System.out.print(columnValue + " " + rsmd.getColumnName(i));
			        }
			        System.out.println("");
			    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		assertEquals("1", "1");
	}

}
