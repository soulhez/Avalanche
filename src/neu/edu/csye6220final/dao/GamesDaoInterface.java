package neu.edu.csye6220final.dao;

import java.util.List;

import org.hibernate.Session;

import neu.edu.csye6220final.beans.Games;

public interface GamesDaoInterface {

	public String AddGames(Games Games, Session session);

	public String[] GetGamesByName(String Gamesname, Session session);

	public String UpdateGames(Games Games, Session session);

	public Games GetGames(Session session, int id);

	public List<Games> getAllGames(Session session);

}
