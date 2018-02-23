package cm.objis.gestionassociatives.domaine;

/**
 * cette class offre les fonctionalités permettant de prendre les parametres
 * d'un pret
 *
 */
public class Pret {
	/**
	 * les attributs de la classe Pret
	 */

	private int idPret;
	private int idAdherent;
	private String NomAdherent;
	private int MontantPret;
	private String DelaiPret;

	/**
	 * les constructeurs de la classe Pret
	 */

	public Pret(int idAdherent, String nomAdherent, int montantPret, String delaiPret) {
		super();
		this.idAdherent = idAdherent;
		NomAdherent = nomAdherent;
		MontantPret = montantPret;
		DelaiPret = delaiPret;
	}

	public Pret() {
		super();
	}

	/**
	 * les getters et les setters de la classe Pret
	 */

	public int getIdPret() {
		return idPret;
	}

	public void setIdPret(int idPret) {
		this.idPret = idPret;
	}

	public int getIdAdherent() {
		return idAdherent;
	}

	public void setIdAdherent(int idAdherent) {
		this.idAdherent = idAdherent;
	}

	public String getNomAdherent() {
		return NomAdherent;
	}

	public void setNomAdherent(String nomAdherent) {
		NomAdherent = nomAdherent;
	}

	public int getMontantPret() {
		return MontantPret;
	}

	public void setMontantPret(int montantPret) {
		MontantPret = montantPret;
	}

	public String getDelaiPret() {
		return DelaiPret;
	}

	public void setDelaiPret(String delaiPret) {
		DelaiPret = delaiPret;
	}

}
