package cm.objis.gestionassociatives.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cm.objis.gestionassociatives.domaine.Adherent;
import cm.objis.gestionassociatives.domaine.Aide;
import cm.objis.gestionassociatives.domaine.Authentification;
import cm.objis.gestionassociatives.domaine.Participation;
import cm.objis.gestionassociatives.domaine.Pret;
import cm.objis.gestionassociatives.domaine.PretOrdinaire;
import cm.objis.gestionassociatives.presentation.lanceur.AccueilGestionAssociativesLanceur;
import cm.objis.gestionassociatives.utils.ConnectionMYSQL;

public class Dao implements IDao {

	public Dao() {
		// super();
	}

	@Override
	public int enregistrerAdherentDao(Adherent adherent) {

		try {

			/**
			 * Etape de connection à la base de données
			 */
			Connection cn = ConnectionMYSQL.getInstance();

			/**
			 * Requête préparée d'insertion des données dans la table adherent
			 */

			String sql = "INSERT INTO `adherent` (`nomsprenoms`,`datelieunaissance`,`numerocnilieudelivrance`,`residencetelephone`,`situationmatrimonialenomepouse`,`nomperemere`,`procheacontacter`) "
					+ "VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, adherent.getNomsPrenoms());
			ps.setString(2, adherent.getDateLieuNaissance());
			ps.setString(3, adherent.getNumeroCniLieuDelivrance());
			ps.setString(4, adherent.getResidenceTelephone());
			ps.setString(5, adherent.getSituationMatrimonialeNomEpouse());
			ps.setString(6, adherent.getNomPereMere());
			ps.setString(7, adherent.getProcheAContacter());

			/**
			 * Exécution de la requête
			 */
			ps.executeUpdate();

			return 1;

			/**
			 * Etape 4 : gestion des exceptions et libération 'automatique' des
			 * ressources
			 */

		} catch (SQLException e) {
			e.printStackTrace();

			return 0;
		}

	}

	@Override
	public List<Adherent> getAllAdherent() {

		List<Adherent> maListeAdherent = new ArrayList<Adherent>();

		try {

			/**
			 * récupération de la connexion
			 */
			Connection cn = ConnectionMYSQL.getInstance();

			/**
			 * préparation requête
			 */
			Statement st = cn.createStatement();

			String sql = "SELECT * FROM `adherent` ";
			

			ResultSet rs = st.executeQuery(sql);
			/**
			 * parcours du resultset
			 */

			while (rs.next()) {
				/**
				 * instanciation d'un objet adherent
				 */
				Adherent adherent = new Adherent();
				adherent.setIdAdherent(rs.getInt("idAdherent"));
				adherent.setNomsPrenoms(rs.getString("nomsprenoms"));
				adherent.setDateLieuNaissance(rs.getString("datelieunaissance"));
				adherent.setNumeroCniLieuDelivrance(rs.getString("numerocnilieudelivrance"));
				adherent.setResidenceTelephone(rs.getString("residencetelephone"));
				adherent.setSituationMatrimonialeNomEpouse(rs.getString("situationmatrimonialenomepouse"));
				adherent.setNomPereMere(rs.getString("nomperemere"));
				adherent.setProcheAContacter(rs.getString("procheacontacter"));

				maListeAdherent.add(adherent);

			}

			/**
			 * gestion des exceptions et libération 'automatique' des ressources
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return maListeAdherent;

	}

	@Override
	public int enregistrerAideDao(Aide aide) {

		try {

			/**
			 * Etape de connection à la base de données
			 */
			Connection cn = ConnectionMYSQL.getInstance();

			/**
			 * Requête préparée d'insertion des données dans la table aide
			 */

			String sql = "INSERT INTO `aide` (`idAdherent`,`nomAdherent`,`montantaide`,`titreaide`,`delaiaide`) "
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, aide.getIdAdherent());
			ps.setString(2, aide.getNomAdherent());
			ps.setString(3, aide.getMontantAide());
			ps.setString(4, aide.getTitreAide());
			ps.setString(5, aide.getDelaiAide());

			/**
			 * Exécution de la requête
			 */
			ps.executeUpdate();

			return 1;

			/**
			 * Etape 4 : gestion des exceptions et libération 'automatique' des
			 * ressources
			 */

		} catch (SQLException e) {
			e.printStackTrace();

			return 0;
		}

	}

	@Override
	public List<Aide> getAllAide() {

		List<Aide> maListeAides = new ArrayList<Aide>();

		try {

			/**
			 * récupération de la connexion
			 */
			Connection cn = ConnectionMYSQL.getInstance();

			/**
			 * préparation requête
			 */
			Statement st = cn.createStatement();

			String sql = "SELECT * FROM `aide` ";
			

			ResultSet rs = st.executeQuery(sql);
			/**
			 * parcours du resultset
			 */

			while (rs.next()) {
				/**
				 * instanciation d'un objet aide
				 */
				Aide aide = new Aide();
				aide.setIdAide(rs.getInt("idAide"));
				aide.setIdAdherent(rs.getString("idAdherent"));
				aide.setNomAdherent(rs.getString("nomAdherent"));
				aide.setMontantAide(rs.getString("montantaide"));
				aide.setTitreAide(rs.getString("titreaide"));
				aide.setDelaiAide(rs.getString("delaiaide"));

				maListeAides.add(aide);

			}

			/**
			 * gestion des exceptions et libération 'automatique' des ressources
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return maListeAides;

	}

	@Override
	public int enregistrerAuthentificationDao(Authentification authentification) {
		try {

			/**
			 * Etape de connection à la base de données
			 */
			Connection cn = ConnectionMYSQL.getInstance();

			/**
			 * Requête préparée d'insertion des données dans la table Site
			 */

			String sql = "INSERT INTO `authentification` (`login`,`password`) " + "VALUES(?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, authentification.getLogin());
			ps.setString(2, authentification.getPassword());

			/**
			 * Exécution de la requête
			 */
			ps.executeUpdate();

			return 1;

			/**
			 * Etape 4 : gestion des exceptions et libération 'automatique' des
			 * ressources
			 */

		} catch (SQLException e) {
			e.printStackTrace();

			return 0;
		}

	}

	@Override
	public List<Authentification> getAllAuthentification() {
		List<Authentification> maListeAuthentification = new ArrayList<Authentification>();

		try {

			/**
			 * récupération de la connexion
			 */
			Connection cn = ConnectionMYSQL.getInstance();

			/**
			 * préparation requête
			 */
			Statement st = cn.createStatement();

			String sql = "SELECT * FROM `authentification` ";
			

			ResultSet rs = st.executeQuery(sql);
			/**
			 * parcours du resultset
			 */

			while (rs.next()) {
				/**
				 * instanciation d'un objet authentification
				 */
				Authentification authentification = new Authentification();
				authentification.setIdAuthentification(rs.getInt("idAuthentification"));
				authentification.setLogin(rs.getString("login"));
				authentification.setPassword(rs.getString("password"));

				maListeAuthentification.add(authentification);

			}

			/**
			 * gestion des exceptions et libération 'automatique' des ressources
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return maListeAuthentification;

	}

	@Override
	public int enregistrerPretDao(Pret pret) {
		try {

			/**
			 * Etape de connection à la base de données
			 */
			Connection cn = ConnectionMYSQL.getInstance();

			/**
			 * Requête préparée d'insertion des données dans la table pret
			 */

			String sql = "INSERT INTO `pret` (`idAdherent`,`nomAdherent`,`montantpret`,`delaipret`) "
					+ "VALUES(?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, pret.getIdAdherent());
			ps.setString(2, pret.getNomAdherent());
			ps.setInt(3, pret.getMontantPret());
			ps.setString(4, pret.getDelaiPret());

			/**
			 * Exécution de la requête
			 */
			ps.executeUpdate();

			return 1;

			/**
			 * Etape 4 : gestion des exceptions et libération 'automatique' des
			 * ressources
			 */

		} catch (SQLException e) {
			e.printStackTrace();

			return 0;
		}

	}

	@Override
	public int enregistrerPretOrdinaireDao(PretOrdinaire pretOrdinaire) {
		try {

			/**
			 * Etape de connection à la base de données
			 */
			Connection cn = ConnectionMYSQL.getInstance();

			/**
			 * Requête préparée d'insertion des données dans la table pretordinaire
			 */

			String sql = "INSERT INTO `pretordinaire` (`idAdherent`,`nomAdherent`,`montantpret`,`delaipret`) "
					+ "VALUES(?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, pretOrdinaire.getIdAdherent());
			ps.setString(2, pretOrdinaire.getNomAdherent());
			ps.setInt(3, pretOrdinaire.getMontantPret());
			ps.setString(4, pretOrdinaire.getDelaiPret());

			/**
			 * Exécution de la requête
			 */
			ps.executeUpdate();

			return 1;

			/**
			 * Etape 4 : gestion des exceptions et libération 'automatique' des
			 * ressources
			 */

		} catch (SQLException e) {
			e.printStackTrace();

			return 0;
		}

	}

	@Override
	public int enregistrerParticipationDao(Participation participation) {
		try {

			/**
			 * Etape de connection à la base de données
			 */
			Connection cn = ConnectionMYSQL.getInstance();

			/**
			 * Requête préparée d'insertion des données dans la table participation
			 */

			String sql = "INSERT INTO `participation` (`idAdherent`,`nomAdherent`,`dateparticipation`,`montantparticipation`,`motifparticipation`) "
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, participation.getIdAdherent());
			ps.setString(2, participation.getNomAdherent());
			ps.setString(3, participation.getDateParticipation());
			ps.setInt(4, participation.getMontantParticipation());
			ps.setString(5, participation.getMotifParticipation());

			/**
			 * Exécution de la requête
			 */
			ps.executeUpdate();

			return 1;

			/**
			 * Etape 4 : gestion des exceptions et libération 'automatique' des
			 * ressources
			 */

		} catch (SQLException e) {
			e.printStackTrace();

			return 0;
		}

	}

	@Override
	public List<Pret> getAllPret() {
		List<Pret> maListePrets = new ArrayList<Pret>();

		try {

			/**
			 * récupération de la connexion
			 */
			Connection cn = ConnectionMYSQL.getInstance();

			/**
			 * préparation requête
			 */
			Statement st = cn.createStatement();

			String sql = "SELECT * FROM `pret` ";
			

			ResultSet rs = st.executeQuery(sql);
			/**
			 * parcours du resultset
			 */

			while (rs.next()) {
				/**
				 * instanciation d'un objet pret
				 */
				Pret pret = new Pret();
				pret.setIdPret(rs.getInt("idPret"));
				pret.setIdAdherent(rs.getInt("idAdherent"));
				pret.setNomAdherent(rs.getString("nomAdherent"));
				pret.setMontantPret(rs.getInt("montantpret"));
				pret.setDelaiPret(rs.getString("delaipret"));

				maListePrets.add(pret);

			}

			/**
			 * gestion des exceptions et libération 'automatique' des ressources
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return maListePrets;

	}

	@Override
	public List<PretOrdinaire> getAllPretOrdinaire() {
		List<PretOrdinaire> maListePretOrdinaires = new ArrayList<PretOrdinaire>();

		try {

			/**
			 * récupération de la connexion
			 */
			Connection cn = ConnectionMYSQL.getInstance();

			/**
			 * préparation requête
			 */
			Statement st = cn.createStatement();

			String sql = "SELECT * FROM `pretOrdinaire` ";
			

			ResultSet rs = st.executeQuery(sql);
			/**
			 * parcours du resultset
			 */

			while (rs.next()) {
				/**
				 * instanciation d'un objet pretOrdinaire
				 */
				Pret pretOrdinaire = new Pret();
				pretOrdinaire.setIdPret(rs.getInt("idPret"));
				pretOrdinaire.setIdAdherent(rs.getInt("idAdherent"));
				pretOrdinaire.setNomAdherent(rs.getString("nomAdherent"));
				pretOrdinaire.setMontantPret(rs.getInt("montantpret"));
				pretOrdinaire.setDelaiPret(rs.getString("delaipret"));

				maListePretOrdinaires.add((PretOrdinaire) pretOrdinaire);

			}

			/**
			 * gestion des exceptions et libération 'automatique' des ressources
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return maListePretOrdinaires;

	}

	@Override
	public List<Participation> getAllParticipation() {
		List<Participation> maListeParticipations = new ArrayList<Participation>();

		try {

			/**
			 * récupération de la connexion
			 */
			Connection cn = ConnectionMYSQL.getInstance();

			/**
			 * préparation requête
			 */
			Statement st = cn.createStatement();

			String sql = "SELECT * FROM `participation` ";
			

			ResultSet rs = st.executeQuery(sql);
			/**
			 * parcours du resultset
			 */

			while (rs.next()) {
				/**
				 * instanciation d'un objet participation
				 */
				Participation participation = new Participation();
				participation.setIdParticipation(rs.getInt("idParticipation"));
				participation.setIdAdherent(rs.getInt("idAdherent"));
				participation.setNomAdherent(rs.getString("nomAdherent"));
				participation.setDateParticipation(rs.getString("dateparticipation"));
				participation.setMontantParticipation(rs.getInt("montantparticipation"));
				participation.setMotifParticipation(rs.getString("motifparticipation"));

				maListeParticipations.add(participation);

			}

			/**
			 * gestion des exceptions et libération 'automatique' des ressources
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return maListeParticipations;

	}

	@Override
	public int authentificationDao(String login, String password) {

		try {

			/**
			 * récupération de la connexion
			 */
			Connection cn = ConnectionMYSQL.getInstance();

			Statement st = cn.createStatement();

			String requete = "SELECT * FROM authentification where ( (login='" + login + "') and (password='" + password
					+ "')) ";

			ResultSet rs = st.executeQuery(requete);

			if (rs.next()) {
				return 1;

			} else {
				return 0;
			}

		} catch (Exception ec) {
			return 0;
		}

	}

}
