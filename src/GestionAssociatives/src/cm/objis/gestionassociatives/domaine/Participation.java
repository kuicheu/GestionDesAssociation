package cm.objis.gestionassociatives.domaine;

/**
 * cette Class offre les fonctionalités permettant de prendre les parametres
 * d'une participation
 *
 */
public class Participation {
	/**
	 * les attributs de la classe Participation
	 */

	private int idParticipation;
	private int idAdherent;
	private String NomAdherent;
	private String dateParticipation;
	private int montantParticipation;
	private String motifParticipation;

	/**
	 * les contructeurs de la classe Participation
	 */

	public Participation(int idAdherent, String nomAdherent, String dateParticipation, int montantParticipation,
			String motifParticipation) {
		super();
		this.idAdherent = idAdherent;
		NomAdherent = nomAdherent;
		this.dateParticipation = dateParticipation;
		this.montantParticipation = montantParticipation;
		this.motifParticipation = motifParticipation;
	}

	public Participation() {
		super();
	}

	/**
	 * les getters et les setters de la classe Participation
	 */

	public int getIdParticipation() {
		return idParticipation;
	}

	public void setIdParticipation(int idParticipation) {
		this.idParticipation = idParticipation;
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

	public String getDateParticipation() {
		return dateParticipation;
	}

	public void setDateParticipation(String dateParticipation) {
		this.dateParticipation = dateParticipation;
	}

	public int getMontantParticipation() {
		return montantParticipation;
	}

	public void setMontantParticipation(int montantParticipation) {
		this.montantParticipation = montantParticipation;
	}

	public String getMotifParticipation() {
		return motifParticipation;
	}

	public void setMotifParticipation(String motifParticipation) {
		this.motifParticipation = motifParticipation;
	}

}
