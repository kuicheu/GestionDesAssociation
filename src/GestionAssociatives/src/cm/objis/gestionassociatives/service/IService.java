package cm.objis.gestionassociatives.service;

import java.util.List;

import cm.objis.gestionassociatives.domaine.Adherent;
import cm.objis.gestionassociatives.domaine.Aide;
import cm.objis.gestionassociatives.domaine.Authentification;
import cm.objis.gestionassociatives.domaine.Participation;
import cm.objis.gestionassociatives.domaine.Pret;
import cm.objis.gestionassociatives.domaine.PretOrdinaire;

public interface IService {

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalités d'enregistrement d'un adherent en base de donnée.
	 */
	public int enregistrerAdherentService(Adherent adherent);

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalités d'enregistrement d'une aide en base de donnée.
	 */
	public int enregistrerAideService(Aide aide);

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalités d'enregistrement d'un utilisateur en base de donnée.
	 */
	public int enregistrerauthentificationService(Authentification authentification);

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalités d'enregistrement d'un pret en base de donnée.
	 */
	public int enregistrerPretService(Pret pret);

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalités d'enregistrement d'un pretOrdinaire en base de donnée.
	 */
	public int enregistrerPretOrdinaireService(PretOrdinaire pretordinaire);

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalités d'enregistrement d'une particiaption en base de donnée.
	 */
	public int enregistrerparticipationService(Participation participation);

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalités de lecture d'un Adherent en base de donnée.
	 */
	public List<Adherent> getAllAdherentService();

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalités de lecture d'une Aide en base de donnée.
	 */
	public List<Aide> getAllAideService();

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalités qui permettent de listés les utilisateurs enrégistrer en
	 * base de donnée.
	 */
	public List<Authentification> getAllAuthentificationService();

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalités de lecture des differents prets en base de donnée.
	 */
	public List<Pret> getAllPretService();

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalités de lecture des prets ordinaires en base de donnée.
	 */
	public List<PretOrdinaire> getAllPretOrdinaireService();

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalités de lecture des participations en base de donnée.
	 */
	public List<Participation> getAllParticipationService();

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalités de verification des utilisateurs au niveau du login.
	 */

	public int authentificationService(String login, String password);

}
