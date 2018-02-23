package cm.objis.gestionassociatives.service;

import java.util.List;

import cm.objis.gestionassociatives.dao.IDao;
import cm.objis.gestionassociatives.domaine.Adherent;
import cm.objis.gestionassociatives.domaine.Aide;
import cm.objis.gestionassociatives.domaine.Authentification;
import cm.objis.gestionassociatives.domaine.Participation;
import cm.objis.gestionassociatives.domaine.Pret;
import cm.objis.gestionassociatives.domaine.PretOrdinaire;

public class Service implements IService {
	
	private IDao dao;
	
	public Service(){
		
	}
	
	

	public Service(IDao dao) {
		super();
		this.dao = dao;
	}



	@Override
	public int enregistrerAdherentService(Adherent adherent) {
		// TODO Auto-generated method stub
		return dao.enregistrerAdherentDao(adherent);
	}

	@Override
	public List<Adherent> getAllAdherentService() {
		// TODO Auto-generated method stub
		return dao.getAllAdherent();
	}



	@Override
	public int enregistrerAideService(Aide aide) {
		// TODO Auto-generated method stub
		return dao.enregistrerAideDao(aide);
	}



	@Override
	public List<Aide> getAllAideService() {
		// TODO Auto-generated method stub
		return dao.getAllAide();
	}



	@Override
	public int enregistrerauthentificationService(Authentification authentification) {
		// TODO Auto-generated method stub
		return dao.enregistrerAuthentificationDao(authentification);
	}



	@Override
	public List<Authentification> getAllAuthentificationService() {
		// TODO Auto-generated method stub
		return dao.getAllAuthentification();
	}



	@Override
	public int enregistrerPretService(Pret pret) {
		// TODO Auto-generated method stub
		return dao.enregistrerPretDao(pret);
	}



	@Override
	public int enregistrerPretOrdinaireService(PretOrdinaire pretordinaire) {
		// TODO Auto-generated method stub
		return dao.enregistrerPretOrdinaireDao(pretordinaire);
	}



	@Override
	public int enregistrerparticipationService(Participation participation) {
		// TODO Auto-generated method stub
		return dao.enregistrerParticipationDao(participation);
	}



	@Override
	public List<Pret> getAllPretService() {
		// TODO Auto-generated method stub
		return dao.getAllPret();
	}



	@Override
	public List<PretOrdinaire> getAllPretOrdinaireService() {
		// TODO Auto-generated method stub
		return dao.getAllPretOrdinaire();
	}



	@Override
	public List<Participation> getAllParticipationService() {
		// TODO Auto-generated method stub
		return dao.getAllParticipation();
	}



	@Override
	public int authentificationService(String login, String password) {
		
		return dao.authentificationDao(login, password);
	}

}
