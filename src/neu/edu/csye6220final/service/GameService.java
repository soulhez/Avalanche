package neu.edu.csye6220final.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.csye6220final.beans.Games;
import neu.edu.csye6220final.beans.User;
import neu.edu.csye6220final.dao.GamesDaoInterface;

@Service
@Transactional
public class GameService implements GamesDaoInterface {

	@Resource
	private SessionFactory sessionFactory_create;

	@Override
	public String AddGames(Games Games, Session session) {
		// TODO Auto-generated method stub
		String hql_checkName = "FROM Games WHERE gamename = ?";
		@SuppressWarnings("unchecked")
		List<User> list = session.createQuery(hql_checkName).setString(0, Games.getGamename()).list();
		if (list.isEmpty()) {
			sessionFactory_create.getCurrentSession().persist(Games);
			System.out.println("Add Game called!");
			return "success";
		} else {
			System.out.println("Add Game called with user already exists Error!");
			return "hasgame";
		}
	}

	@Override
	public String[] GetGamesByName(String Gamesname, Session session) {
		// TODO Auto-generated method stub
		String hql_checkName = "FROM Games WHERE gamename = ?";
		String result[] = null;
		@SuppressWarnings("unchecked")
		List<Games> list = session.createQuery(hql_checkName).setString(0, Gamesname).list();
		if (list.isEmpty()) {
			System.out.println("Check Game called with No Game Error!");
			result = new String[1];
			result[0] = "NoGame";
			return result;
		} else {
			System.out.println("Check Game called!");
			result = new String[3];
			result[0] = "Success";
			result[1] = String.valueOf(list.get(0).getId());
			result[2] = list.get(0).getGameinfo();
			return result;
		}
	}

	@Override
	public String UpdateGames(Games Games, Session session) {
		// TODO Auto-generated method stub
		session.update(Games);
		System.out.println("Update Game called!");
		return "success";
	}

	@Override
	public Games GetGames(Session session, int id) {
		// TODO Auto-generated method stub
		String hql_checkName = "FROM Games WHERE Gamename = ?";
		Games games = (Games) session.get(Games.class, id);
		@SuppressWarnings("unchecked")
		List<Games> list = session.createQuery(hql_checkName).setString(0, games.getGamename()).list();
		System.out.println(list.get(0).getGamename());
		return list.get(0);
	}

	@Override
	public List<Games> getAllGames(Session session) {
		// TODO Auto-generated method stub
		String hql_checkName = "FROM Games";
		@SuppressWarnings("unchecked")
		List<Games> list = session.createQuery(hql_checkName).list();
		return list;
	}

}
