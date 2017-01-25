package neu.edu.csye6220.dao;

import org.hibernate.Session;

import neu.edu.csye6220.beans.User;

public interface UserDaoInterface {
	
	public String AddUser(User user,Session session);
	public String[] GetUserByName(String Username,String Password,Session session);
	public void UpdateUser(User user,Session session);
	public String GetUser(Session session,int id);

}
