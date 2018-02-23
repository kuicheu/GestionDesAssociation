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
	 * fonctionalit�s d'enregistrement d'un adherent en base de donn�e.
	 */
	public int enregistrerAdherentService(Adherent adherent);

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalit�s d'enregistrement d'une aide en base de donn�e.
	 */
	public int enregistrerAideService(Aide aide);

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalit�s d'enregistrement d'un utilisateur en base de donn�e.
	 */
	public int enregistrerauthentificationService(Authentification authentification);

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalit�s d'enregistrement d'un pret en base de donn�e.
	 */
	public int enregistrerPretService(Pret pret);

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalit�s d'enregistrement d'un pretOrdinaire en base de donn�e.
	 */
	public int enregistrerPretOrdinaireService(PretOrdinaire pretordinaire);

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalit�s d'enregistrement d'une particiaption en base de donn�e.
	 */
	public int enregistrerparticipationService(Participation participation);

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalit�s de lecture d'un Adherent en base de donn�e.
	 */
	public List<Adherent> getAllAdherentService();

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalit�s de lecture d'une Aide en base de donn�e.
	 */
	public List<Aide> getAllAideService();

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalit�s qui permettent de list�s les utilisateurs enr�gistrer en
	 * base de donn�e.
	 */
	public List<Authentification> getAllAuthentificationService();

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalit�s de lecture des differents prets en base de donn�e.
	 */
	public List<Pret> getAllPretService();

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalit�s de lecture des prets ordinaires en base de donn�e.
	 */
	public List<PretOrdinaire> getAllPretOrdinaireService();

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalit�s de lecture des participations en base de donn�e.
	 */
	public List<Participation> getAllParticipationService();

	/**
	 * Cette methode permet d'appeler la methode de dao qui offre les
	 * fonctionalit�s de verification des utilisateurs au niveau du login.
	 */

	public int authentificationService(String login, String password);

}
