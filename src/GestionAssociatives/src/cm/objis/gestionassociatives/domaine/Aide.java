package cm.objis.gestionassociatives.domaine;

import javax.swing.JComboBox;

/**
 * cette class offre les fonctionalités permettant de 
 * de prendre les paramettres d'une aide pour un enrégistrement
 *
 */
public class Aide {

	/**
	 * les propriétes de la classe Aide
	 */

	private int idAide;// propriétés
	private int idAdherent;// propriétés
	private String NomAdherent;// propriétés
	private String MontantAide;// propriétés
	private String TitreAide;// propriétés
	private String DelaiAide;// propriétés

	/**
	 * les constructeurs de la classe Aide
	 */

	public Aide(String nomAdherent, String montantAide, String titreAide, String delaiAide) {
		super();
		NomAdherent = nomAdherent;
		MontantAide = montantAide;
		TitreAide = titreAide;
		DelaiAide = delaiAide;
	}

	public Aide() {
		super();
	}

	/**
	 * les getters et les setters de la classe Aide
	 */

	public int getIdAide() {
		return idAide;
	}

	public void setIdAide(int idAide) {
		this.idAide = idAide;
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

	public String getMontantAide() {
		return MontantAide;
	}

	public void setMontantAide(String montantAide) {
		MontantAide = montantAide;
	}

	public String getTitreAide() {
		return TitreAide;
	}

	public void setTitreAide(String titreAide) {
		TitreAide = titreAide;
	}

	public String getDelaiAide() {
		return DelaiAide;
	}

	public void setDelaiAide(String delaiAide) {
		DelaiAide = delaiAide;
	}

	public void setIdAdherent(String string) {
		// TODO Auto-generated method stub

	}

}
