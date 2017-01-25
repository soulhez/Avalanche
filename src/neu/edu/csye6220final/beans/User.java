package neu.edu.csye6220final.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "native")
	@GeneratedValue(generator = "idGenerator")
	@Column(length = 11)
	private Integer id;

	@Column(name = "Username")
	private String Username;

	@Column(name = "Password")
	private String Password;

	@Column(name = "Email")
	private String Email;

	@Column(name = "UserCharacter")
	private String Character;

	@Column(name = "Favorites")
	private String Favorite;

	public User() {

	}

	public User(String Username, String Password) {
		this.Username = Username;
		this.Password = Password;
	}

	public User(String Username, String Password, String Email) {
		this.Username = Username;
		this.Password = Password;
		this.Email = Email;
	}

	public User(Integer id, String Username, String Password, String Email, String Character, String fav) {
		this.id = id;
		this.Username = Username;
		this.Password = Password;
		this.Email = Email;
		this.Character = Character;
		this.Favorite = fav;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCharacter() {
		return Character;
	}

	public void setCharacter(String character) {
		Character = character;
	}

	public String getFavorites() {
		return this.Favorite;
	}

	public void AddFavorites(String favorite) {
		if (this.Favorite.equals("0")) {
			this.Favorite = favorite + ",";
		} else {
			this.Favorite += favorite;
			this.Favorite += ",";
		}
	}

	public void RemoveFavorites(String favorite) {
		String tmp = favorite + ",";
		this.Favorite = this.Favorite.replace(tmp, "");
		// System.out.println(this.Favorite);
	}

}
