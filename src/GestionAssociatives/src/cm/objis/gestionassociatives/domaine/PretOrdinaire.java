package cm.objis.gestionassociatives.domaine;

/**
 * cette Class offre les fonctionalités permettant de prendre en parametre 
 * un pret ordinaire
 *
 */
public class PretOrdinaire extends Pret {
	
	/**
	 * les constructeurs de la classe PretOrdinaire
	 */

	public PretOrdinaire(int pidAdherent, String pNomAdherent, int pMontantPret, String pdelaiPret) {
		super(pidAdherent, pNomAdherent, pMontantPret, pdelaiPret);
	}

}
