package neu.edu.csye6220final.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "game")
public class Games {

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "native")
	@GeneratedValue(generator = "idGenerator")
	@Column(length = 11)
	private Integer id;

	@Column(name = "Gamename")
	private String Gamename;

	@Column(name = "Gamelink")
	private String Gamelink;

	@Column(name = "Gameinfo")
	private String Gameinfo;

	@Column(name = "Gameimg")
	private String Gameimg;

	public Games() {

	}

	public Games(String Gamename, String Gameimg) {
		this.Gamename = Gamename;
		this.Gameimg = Gameimg;
	}

	public Games(String Gamename, String Gameinfo, String Gameimg, String Gamelink) {
		this.Gamename = Gamename;
		this.Gameinfo = Gameinfo;
		this.Gameimg = Gameimg;
		this.Gamelink = Gamelink;
	}

	public Games(Integer id, String Gamename, String Gamelink, String Gameinfo, String Gameimg) {
		this.id = id;
		this.Gamename = Gamename;
		this.Gameinfo = Gameinfo;
		this.Gameimg = Gameimg;
		this.Gamelink = Gamelink;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGamename() {
		return Gamename;
	}

	public void setGamename(String gamename) {
		Gamename = gamename;
	}

	public String getGamelink() {
		return Gamelink;
	}

	public void setGamelink(String gamelink) {
		Gamelink = gamelink;
	}

	public String getGameinfo() {
		return Gameinfo;
	}

	public void setGameinfo(String gameinfo) {
		Gameinfo = gameinfo;
	}

	public String getGameimg() {
		return Gameimg;
	}

	public void setGameimg(String gameimg) {
		Gameimg = gameimg;
	}

}