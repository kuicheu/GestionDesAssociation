package cm.objis.gestionassociatives.dao;

import java.util.List;

import cm.objis.gestionassociatives.domaine.Adherent;
import cm.objis.gestionassociatives.domaine.Aide;
import cm.objis.gestionassociatives.domaine.Authentification;
import cm.objis.gestionassociatives.domaine.Participation;
import cm.objis.gestionassociatives.domaine.Pret;
import cm.objis.gestionassociatives.domaine.PretOrdinaire;

public interface IDao {

	/**
	 * cette methode permet d'enregistrer un adherent
	 */

	public int enregistrerAdherentDao(Adherent adherent);

	/**
	 * cette methode permet d'enregistrer une aide
	 */

	public int enregistrerAideDao(Aide aide);

	/**
	 * cette methode permet d'enregistrer un utilisateur
	 */

	public int enregistrerAuthentificationDao(Authentification authentification);

	/**
	 * cette methode permet d'enregistrer un pret
	 */

	public int enregistrerPretDao(Pret pret);

	/**
	 * cette methode permet d'enregistrer un pret ordinaire
	 */

	public int enregistrerPretOrdinaireDao(PretOrdinaire pretOrdinaire);

	/**
	 * cette methode permet d'enregistrer une participation
	 */

	public int enregistrerParticipationDao(Participation participation);

	/**
	 * cette méthode affiche la liste des adherents
	 */

	public List<Adherent> getAllAdherent();

	/**
	 * cette méthode affiche la liste des aides
	 */

	public List<Aide> getAllAide();

	/**
	 * cette méthode affiche la liste des utilisateurs
	 */

	public List<Authentification> getAllAuthentification();

	/**
	 * cette méthode affiche la liste des prets
	 */

	public List<Pret> getAllPret();

	/**
	 * cette méthode affiche la liste des prets ordinaires
	 */

	public List<PretOrdinaire> getAllPretOrdinaire();

	/**
	 * cette méthode affiche la liste des participations
	 */

	public List<Participation> getAllParticipation();

	/**
	 * cette méthode prend en parametre l'utilisateurs saisie au niveau du login
	 * et reourne un message ok si l'utilisateur existe
	 */

	public int authentificationDao(String login, String password);

}
