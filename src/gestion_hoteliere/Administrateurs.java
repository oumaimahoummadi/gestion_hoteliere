package gestion_hoteliere;


public class Administrateurs {
	private int id_admin;
	private String login,password;
	
	public Administrateurs(int id_admin, String password, String login) {
		super();
		this.id_admin = id_admin;
		this.password = password;
		this.login = login;
	}

	public int getId_admin() {
		return id_admin;
	}

	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
