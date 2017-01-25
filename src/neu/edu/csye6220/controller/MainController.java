package neu.edu.csye6220.controller;

import java.io.OutputStream;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import neu.edu.csye6220.beans.User;
import neu.edu.csye6220.dao.UserDaoInterface;

@Controller
@RequestMapping("/")
public class MainController {

	@Resource
	private UserDaoInterface udi;

	@Resource
	private SessionFactory sessionFactory;

	private Session session;

	private int id;

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
				if (udi.GetUserByName(Username, Password, session)[2].equals("Admin")) {
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
						URLDecoder.decode(Email, "utf-8"), "User");
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
	public String toUserHome() {
		return "UserHome";
	}
	
	@RequestMapping("/logout")
	public String toLogout() {
		id = 0;
		return "index";
	}

	@RequestMapping("/AdminHome")
	public String toAdminHome() {
		return "AdminHome";
	}

	@RequestMapping("/SignUp")
	public String toSignUp() {
		return "SignUp";
	}

	@RequestMapping("Login")
	public String toIndex() {
		return "index";
	}
	
	@RequestMapping("UserAccount")
	public String toUserAccount() {
		return "UserAccount";
	}

	@RequestMapping("index")
	public String toIndex_2() {
		return "index";
	}

}
