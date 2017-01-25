package neu.edu.csye6220.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.csye6220.beans.User;
import neu.edu.csye6220.dao.UserDaoInterface;

@Service
@Transactional
public class UserService implements UserDaoInterface {

	@Resource
	private SessionFactory sessionFactory_create;

	@Override
	public String AddUser(User user, Session session) {
		// TODO Auto-generated method stub
		String hql_checkName = "FROM User WHERE username = ?";
		@SuppressWarnings("unchecked")
		List<User> list = session.createQuery(hql_checkName).setString(0, user.getUsername()).list();
		if (list.isEmpty()) {
			sessionFactory_create.getCurrentSession().persist(user);
			System.out.println("Add User called!");
			return "success";
		} else {
			System.out.println("Add User called with user already exists Error!");
			return "hasuser";
		}
	}

	@Override
	public String[] GetUserByName(String Username, String Password, Session session) {
		// TODO Auto-generated method stub
		String hql_checkName = "FROM User WHERE username = ?";
		String hql_checkPass = "FROM User WHERE username = ? AND password = ?";
		String result[] = null;
		@SuppressWarnings("unchecked")
		List<User> list = session.createQuery(hql_checkName).setString(0, Username).list();
		if (list.isEmpty()) {
			System.out.println("Check User called with No User Error!");
			result = new String[1];
			result[0] = "NoUser";
			return result;
		} else {
			@SuppressWarnings("unchecked")
			List<User> list_final = session.createQuery(hql_checkPass).setString(0, Username).setString(1, Password)
					.list();
			if (list_final.isEmpty()) {
				System.out.println("Check User called with Password Error");
				result = new String[1];
				result[0] = "PassError";
				return result;
			} else {
				System.out.println("Check User called!");
				result = new String[3];
				result[0] = "Success";
				result[1] = String.valueOf(list_final.get(0).getId());
				result[2] = list_final.get(0).getCharacter();
				return result;
			}
		}
	}

	@Override
	public void UpdateUser(User user, Session session) {
		// TODO Auto-generated method stub
		session.update(user);
		System.out.println("Update User called!");
	}

	@Override
	public String GetUser(Session session, int id) {
		// TODO Auto-generated method stubSession session =
		// sessionFactory.getCurrentSession();
		String hql_checkName = "FROM User WHERE username = ?";
		User user = (User) session.get(User.class, id);
		@SuppressWarnings("unchecked")
		List<User> list = session.createQuery(hql_checkName).setString(0, user.getUsername()).list();
		return list.get(0).getUsername().toString();
	}

}
