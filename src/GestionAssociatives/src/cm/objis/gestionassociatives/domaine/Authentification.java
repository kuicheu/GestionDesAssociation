package cm.objis.gestionassociatives.domaine;

/**
 * cette Class offre les fonctionalités permettant de prendre les parametres
 * d'un utilisateurs
 *
 */
public class Authentification {

	/**
	 * les attributs de la classe Authentification
	 */

	private int idAuthentification;
	private String login;
	private String password;

	/**
	 * les constructeurs de la classe Authentification
	 */

	public Authentification(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public Authentification() {
		super();
	}

	/**
	 * les getters et les setters de la classe Authentification
	 */

	public int getIdAuthentification() {
		return idAuthentification;
	}

	public void setIdAuthentification(int idAuthentification) {
		this.idAuthentification = idAuthentification;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPassword(char[] password2) {
		// TODO Auto-generated method stub

	}

}
