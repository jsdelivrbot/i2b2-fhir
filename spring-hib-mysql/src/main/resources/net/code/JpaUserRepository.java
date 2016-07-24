package net.code;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class JpaUserRepository implements UserRepository {

	@PersistenceUnit
	private EntityManagerFactory emf;

	//@Override
	//public void addUser(Useracc user) {
		//System.out.println(">>>>>>Creating user:"+user.toString());
		//emf.createEntityManager().persist(user);
		//System.out.println(">>>>>>Created user:"+user.toString());
		
	//}

	@Override
	public Useracc getUserById(int id) {
		return emf.createEntityManager().find(Useracc.class, id);
	}

	public Useracc save(Useracc user) {
		System.out.println(">>>>>>saving user:"+user.toString());
		//if (user.getId()==0) {
			emf.createEntityManager().persist(user);
			//emf.createEntityManager().
			System.out.println(">>>>>>saved user:"+user.toString());
			return user;
		//} else {
			//System.out.println(">>>>>>saved user:"+user.toString());
			//return emf.createEntityManager().merge(user);
		//}
		
	}

	
	
	@Override
	public int getSize() {
		return emf.createEntityManager().createQuery("select email from Useracc").getResultList().size();
	
	}

	@PostConstruct
	public void init(){
		Useracc user=new Useracc();
		user.setEmail("email4");
		user=save(user);
		user=getUserById(0);
	}

	

}