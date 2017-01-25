package neu.edu.csye6220final.dao;

import org.hibernate.Session;

import neu.edu.csye6220final.beans.User;

public interface UserDaoInterface {

	public String AddUser(User user, Session session);

	public String[] GetUserByName(String Username, String Password, Session session);

	public void UpdateUser(User user, Session session);

	public String GetUser(Session session, int id);

	public User GetUserObj(Session session, int id);

}
