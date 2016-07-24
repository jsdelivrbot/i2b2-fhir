package net.code;

public interface UserRepository {



	Useracc getUserById(int id);

	Useracc save(Useracc user);
	
	int getSize();
	


}
