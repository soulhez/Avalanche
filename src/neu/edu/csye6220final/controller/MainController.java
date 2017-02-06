package neu.edu.csye6220final.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import neu.edu.csye6220final.beans.Games;
import neu.edu.csye6220final.beans.User;
import neu.edu.csye6220final.dao.GamesDaoInterface;
import neu.edu.csye6220final.dao.UserDaoInterface;

@Controller
@RequestMapping("/")
public class MainController {

	@Resource
	private UserDaoInterface udi;

	@Resource
	private GamesDaoInterface gdi;

	@Resource
	private SessionFactory sessionFactory;

	private Session session;

	private int id = 0;

	private String filePath = "e:\\CSE6220\\CSYE6220FinalProject\\WebContent\\img\\";

	@RequestMapping("/login")
	public void CheckLogin(String Username, String Password, HttpServletResponse rep) {
		try {
			rep.setContentType("text/html;charset=UTF-8");
			OutputStream printWriter = null;
			printWriter = rep.getOutputStream();
			session = sessionFactory.getCurrentSession();
			@SuppressWarnings("unused")
			User user = new User(URLDecoder.decode(Username, "utf-8"), URLDecoder.decode(Password, "utf-8"));
			if (udi.GetUserByName(Username, Password, session)[0].equals("NoUser")) {
				printWriter.write("nouser".getBytes());
			} else if (udi.GetUserByName(Username, Password, session)[0].equals("PassError")) {
				printWriter.write("passerror".getBytes());
			} else if (udi.GetUserByName(Username, Password, session)[0].equals("Success")) {
				id = Integer.valueOf(udi.GetUserByName(Username, Password, session)[1]);
				if (udi.GetUserByName(Username, Password, session)[2].equals("ROLE_ADMIN")) {
					printWriter.write("admin".getBytes());
				} else {
					printWriter.write("user".getBytes());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/signup")
	public void SignUp(String Username, String Password, String Email, String PasswordConfirm,
			HttpServletResponse rep) {
		try {
			rep.setContentType("text/html;charset=UTF-8");
			OutputStream printWriter = null;
			printWriter = rep.getOutputStream();
			session = sessionFactory.getCurrentSession();
			String pass = URLDecoder.decode(Password, "utf-8");
			String passconfirm = URLDecoder.decode(PasswordConfirm, "utf-8");
			if (pass.endsWith(passconfirm)) {
				User user = new User(null, URLDecoder.decode(Username, "utf-8"), URLDecoder.decode(Password, "utf-8"),
						URLDecoder.decode(Email, "utf-8"), "User", "0");
				if (udi.AddUser(user, session).equals("success")) {
					printWriter.write("success".getBytes());
				} else {
					printWriter.write("hasuser".getBytes());
				}
			} else {
				printWriter.write("passdiff".getBytes());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/getuser")
	public void GetUser(HttpServletResponse rep) {
		try {
			rep.setContentType("text/html;charset=UTF-8");
			OutputStream printWriter = null;
			printWriter = rep.getOutputStream();
			session = sessionFactory.getCurrentSession();
			printWriter.write(udi.GetUser(session, id).getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/signout")
	public void SignOut(HttpServletResponse rep) {
		try {
			rep.setContentType("text/html;charset=UTF-8");
			id = 0;
			OutputStream printWriter = null;
			printWriter = rep.getOutputStream();
			printWriter.write("success".getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/UserHome")
	public String toUserHome(HttpServletRequest req, HttpServletResponse rep) {
		if (id == 0) {
			return "index";
		} else {
			List<Games> games = new ArrayList<Games>();
			for (int counter = 1; counter <= 6; counter++) {
				session = sessionFactory.getCurrentSession();
				// gdi.getAllGames(session);
				games.add(gdi.getAllGames(session).get(counter));
			}
			req.setAttribute("Gamelist", games);
			return "UserHome";
		}
	}

	@RequestMapping("/UserGames")
	public String toUserGames(HttpServletRequest req, HttpServletResponse rep) {
		if (id == 0) {
			return "index";
		} else {
			session = sessionFactory.getCurrentSession();
			List<Games> allgames = gdi.getAllGames(session);
			req.setAttribute("AllGameList", allgames);
			return "UserGames";
		}
	}

	@RequestMapping("/UserAccount")
	public String toUserAccount(HttpServletRequest req, HttpServletResponse rep) {
		if (id == 0) {
			return "index";
		} else {
			session = sessionFactory.getCurrentSession();
			req.setAttribute("username", udi.GetUser(session, this.id));
			String favoritegames = udi.GetUserObj(session, this.id).getFavorites();
			List<Games> games = new ArrayList<Games>();
			List<Games> allgames = new ArrayList<Games>();
			allgames = gdi.getAllGames(session);

			if (favoritegames.equals("0")) {
				req.setAttribute("nofav", "You do not have any favorite games, let's add some!");
			} else {
				String str[] = favoritegames.split(",");
				for (int counter = 0; counter < str.length; counter++) {
					session = sessionFactory.getCurrentSession();
					for (int counter_1 = 0; counter_1 < allgames.size(); counter_1++) {
						if (allgames.get(counter_1).getId() == Integer.parseInt(str[counter])) {
							games.add(allgames.get(counter_1));
						}
					}
				}
			}
			req.setAttribute("Gamelist", games);
			return "UserAccount";
		}
	}

	@RequestMapping("/addFavorite")
	public void AddFavorites(String ID, HttpServletResponse rep) {
		try {
			// System.out.println("AddFavorites Called!");
			String favid = URLDecoder.decode(ID, "utf-8");
			rep.setContentType("text/html;charset=UTF-8");
			OutputStream printWriter = null;
			printWriter = rep.getOutputStream();
			int flag = 0;
			session = sessionFactory.getCurrentSession();
			String favorites = udi.GetUserObj(session, this.id).getFavorites();
			// System.out.println(favorites);
			if (favorites.length() == 0) {
				udi.GetUserObj(session, this.id).AddFavorites(favid);
				udi.UpdateUser(udi.GetUserObj(session, this.id), session);
				printWriter.write("success".getBytes());
			} else {
				String str[] = favorites.split(",");
				for (int counter = 0; counter < str.length; counter++) {
					if (str[counter].equals(favid)) {
						flag = 1;
						printWriter.write("alreadyhasgame".getBytes());
					}
				}
				if (flag == 0) {
					udi.GetUserObj(session, this.id).AddFavorites(favid);
					udi.UpdateUser(udi.GetUserObj(session, this.id), session);
					printWriter.write("success".getBytes());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/removeFavorite")
	public void RemoveFavorites(String ID, HttpServletResponse rep) {
		try {
			// System.out.println("AddFavorites Called!");
			String favid = URLDecoder.decode(ID, "utf-8");
			rep.setContentType("text/html;charset=UTF-8");
			OutputStream printWriter = null;
			printWriter = rep.getOutputStream();
			session = sessionFactory.getCurrentSession();
			// String favorites = udi.GetUserObj(session,
			// this.id).getFavorites();
			// System.out.println(favorites);
			User user = udi.GetUserObj(session, this.id);
			user.RemoveFavorites(favid);
			udi.UpdateUser(user, session);
			printWriter.write("success".getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/addGames")
	public void AddGames(String path, String name, String site, String info, HttpServletResponse rep) {
		try {
			filePath = "e:\\CSE6220\\CSYE6220FinalProject\\WebContent\\img\\";
			String picpath = URLDecoder.decode(path, "utf-8");
			String gamename = URLDecoder.decode(name, "utf-8");
			String gameinfo = URLDecoder.decode(info, "utf-8");
			String gamesite = URLDecoder.decode(site, "utf-8");
			URL url = new URL(picpath);
			InputStream fStream = url.openConnection().getInputStream();
			int b = 0;
			filePath += gamename + ".jpg";
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			while ((b = fStream.read()) != -1) {
				fos.write(b);
			}
			fStream.close();
			fos.close();

			// picpath = "img/" + gamename + ".jpg";

			rep.setContentType("text/html;charset=UTF-8");
			OutputStream printWriter = null;
			printWriter = rep.getOutputStream();

			session = sessionFactory.getCurrentSession();
			Games newgame = new Games(null, gamename, gamesite, gameinfo, picpath);
			String result = gdi.AddGames(newgame, session);
			if (result.equals("success")) {
				printWriter.write("success".getBytes());
			} else if (result.equals("hasgame")) {
				printWriter.write("hasgame".getBytes());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/toList")
	public String toGameList(HttpServletRequest req, HttpServletResponse rep) {
		if (id == 0) {
			return "index";
		} else {
			session = sessionFactory.getCurrentSession();
			List<Games> allgames = gdi.getAllGames(session);
			req.setAttribute("AllGameList", allgames);
			return "GameList";
		}
	}

	@RequestMapping("/toEdit")
	public String toEditGame(String ID, HttpServletRequest req) {
		if (id == 0) {
			return "index";
		} else {
			session = sessionFactory.getCurrentSession();
			String gameid = "";
			try {
				gameid = URLDecoder.decode(ID, "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("gametoedit", gdi.GetGames(session, Integer.parseInt(gameid)));
			return "EditGame";
		}
	}

	@RequestMapping("/toRemove")
	public void toRemoveGame(String ID, HttpServletResponse rep) throws IOException {
		session = sessionFactory.getCurrentSession();
		String gameid = "";
		try {
			gameid = URLDecoder.decode(ID, "utf-8");
			gdi.DeleteGame(Integer.parseInt(gameid), session);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// req.setAttribute("gametoedit", gdi.GetGames(session,
		// Integer.parseInt(gameid)));
		// return "GameList";
	}

	@RequestMapping("/updateGames")
	public void UpdateGames(String path, String name, String site, String info, String id, HttpServletResponse rep)
			throws IOException {
		rep.setContentType("text/html;charset=UTF-8");
		OutputStream printWriter = null;

		try {
			filePath = "e:\\CSE6220\\CSYE6220FinalProject\\WebContent\\img\\";
			String picpath = URLDecoder.decode(path, "utf-8");
			String gamename = URLDecoder.decode(name, "utf-8");
			String gameinfo = URLDecoder.decode(info, "utf-8");
			String gamesite = URLDecoder.decode(site, "utf-8");
			int gameid = Integer.parseInt(URLDecoder.decode(id, "utf-8"));
			printWriter = rep.getOutputStream();
			session = sessionFactory.getCurrentSession();
			Games game = gdi.GetGames(session, gameid);
			game.setGameimg(picpath);
			game.setGamename(gamename);
			game.setGamelink(gamesite);
			game.setGameinfo(gameinfo);
			String result = gdi.UpdateGames(game, session);
			if (result.equals("success")) {
				printWriter.write("success".getBytes());
			} else {
				printWriter.write("error".getBytes());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			printWriter.write("error".getBytes());
			e.printStackTrace();
		}
	}

	@RequestMapping("/logout")
	public String toLogout() {
		id = 0;
		return "index";
	}

	@RequestMapping("/AdminHome")
	public String toAdminHome() {
		if (id == 0) {
			return "index";
		} else {
			return "AdminHome";
		}
	}

	@RequestMapping("/SignUp")
	public String toSignUp() {
		return "SignUp";
	}

	@RequestMapping("/Login")
	public String toIndex() {
		return "index";
	}

	@RequestMapping("/index")
	public String toIndex_2() {
		if (id == 0) {
			return "index";
		} else {
			return "index";
		}
	}

	@RequestMapping("/Contact")
	public String toContact() {
		if (id == 0) {
			return "index";
		} else {
			return "Contact";
		}
	}

}
