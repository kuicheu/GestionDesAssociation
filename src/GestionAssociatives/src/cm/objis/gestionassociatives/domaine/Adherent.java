package cm.objis.gestionassociatives.domaine;

/**
 * cette Class offre les fonctionalités permettant de recuperer 
 * les parametres d'un adherents
 *
 */
public class Adherent {

	/**
	 * proprietés de la classe Adherent
	 */

	private int idAdherent;
	private String NomsPrenoms;
	private String DateLieuNaissance;
	private String NumeroCniLieuDelivrance;
	private String ResidenceTelephone;
	private String SituationMatrimonialeNomEpouse;
	private String NomPereMere;
	private String ProcheAContacter;

	/**
	 * les contructeurs de la classe Adherent
	 */

	public Adherent() {
		super();
	}

	public Adherent(String nomsPrenoms, String dateLieuNaissance, String numeroCniLieuDelivrance,
			String residenceTelephone, String situationMatrimonialeNomEpouse, String nomPereMere,
			String procheAContacter) {
		super();
		NomsPrenoms = nomsPrenoms;
		DateLieuNaissance = dateLieuNaissance;
		NumeroCniLieuDelivrance = numeroCniLieuDelivrance;
		ResidenceTelephone = residenceTelephone;
		SituationMatrimonialeNomEpouse = situationMatrimonialeNomEpouse;
		NomPereMere = nomPereMere;
		ProcheAContacter = procheAContacter;
	}

	/**
	 * les getters et les setters de la classe Adherent
	 */

	public int getIdAdherent() {
		return idAdherent;
	}

	public void setIdAdherent(int idAdherent) {
		this.idAdherent = idAdherent;
	}

	public String getNomsPrenoms() {
		return NomsPrenoms;
	}

	public void setNomsPrenoms(String nomsPrenoms) {
		NomsPrenoms = nomsPrenoms;
	}

	public String getDateLieuNaissance() {
		return DateLieuNaissance;
	}

	public void setDateLieuNaissance(String dateLieuNaissance) {
		DateLieuNaissance = dateLieuNaissance;
	}

	public String getNumeroCniLieuDelivrance() {
		return NumeroCniLieuDelivrance;
	}

	public void setNumeroCniLieuDelivrance(String numeroCniLieuDelivrance) {
		NumeroCniLieuDelivrance = numeroCniLieuDelivrance;
	}

	public String getResidenceTelephone() {
		return ResidenceTelephone;
	}

	public void setResidenceTelephone(String residenceTelephone) {
		ResidenceTelephone = residenceTelephone;
	}

	public String getSituationMatrimonialeNomEpouse() {
		return SituationMatrimonialeNomEpouse;
	}

	public void setSituationMatrimonialeNomEpouse(String situationMatrimonialeNomEpouse) {
		SituationMatrimonialeNomEpouse = situationMatrimonialeNomEpouse;
	}

	public String getNomPereMere() {
		return NomPereMere;
	}

	public void setNomPereMere(String nomPereMere) {
		NomPereMere = nomPereMere;
	}

	public String getProcheAContacter() {
		return ProcheAContacter;
	}

	public void setProcheAContacter(String procheAContacter) {
		ProcheAContacter = procheAContacter;
	}

}
