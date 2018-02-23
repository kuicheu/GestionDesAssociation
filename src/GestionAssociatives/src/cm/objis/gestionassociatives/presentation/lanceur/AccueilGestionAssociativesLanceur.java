package cm.objis.gestionassociatives.presentation.lanceur;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import cm.objis.gestionassociatives.presentation.vues.AdherentVue;
import cm.objis.gestionassociatives.presentation.vues.AideVue;
import cm.objis.gestionassociatives.presentation.vues.AuthentificationVue;
import cm.objis.gestionassociatives.presentation.vues.ListeAdherents;
import cm.objis.gestionassociatives.presentation.vues.ListeAides;
import cm.objis.gestionassociatives.presentation.vues.ListeParticipation;
import cm.objis.gestionassociatives.presentation.vues.ListePret;
import cm.objis.gestionassociatives.presentation.vues.ListePretOrdinaire;
import cm.objis.gestionassociatives.presentation.vues.ListeUtilisateurs;
import cm.objis.gestionassociatives.presentation.vues.ParticipationVue;
import cm.objis.gestionassociatives.presentation.vues.PretOrdinaireVue;
import cm.objis.gestionassociatives.presentation.vues.PretVue;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * cette class offre les fonctionalites permettant appeler toutes les autres
 * fenetre
 *
 */
public class AccueilGestionAssociativesLanceur {

	JFrame frameGestionAssociative;

	/**
	 * Create the application.
	 */
	public AccueilGestionAssociativesLanceur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameGestionAssociative = new JFrame();
		frameGestionAssociative.setTitle("GESTION DES ASSOCIATIONS");
		frameGestionAssociative.setBounds(200, 200, 900, 600);
		frameGestionAssociative.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frameGestionAssociative.setJMenuBar(menuBar);

		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		JMenuItem fermer = new JMenuItem("Fermer");
		fermer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});
		mnFichier.add(fermer);

		JMenu mnTraitement = new JMenu("Traitement");
		menuBar.add(mnTraitement);
		JMenu parametre = new JMenu("Parametre");
		menuBar.add(parametre);
		JMenu structure = new JMenu("Structure");
		menuBar.add(structure);
		JMenu edition = new JMenu("Edition");
		menuBar.add(edition);
		/**
		 * appel de la fenetre permettant d enregistrer un adherent.
		 */
		JMenuItem enregistrer = new JMenuItem("enregistrer un adherent");
		enregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdherentVue frame = new AdherentVue();
				frame.setVisible(true);
			}
		});
		structure.add(enregistrer);
		/**
		 * appel de la fenetre permettant de lister les adherents.
		 */
		JMenuItem lire = new JMenuItem("consulter la liste des adherents ");
		lire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeAdherents frame = new ListeAdherents();
				frame.setVisible(true);
			}
		});
		edition.add(lire);
		/**
		 * appel de la fenetre d enregistrer un utilisateur.
		 */
		JMenuItem enregistrer2 = new JMenuItem("enrégistrer un utilisateur");
		enregistrer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AuthentificationVue frame = new AuthentificationVue();
				frame.setVisible(true);
			}
		});
		parametre.add(enregistrer2);
		/**
		 * appel de la fenetre permettant de consulter les utilisateurs.
		 */
		JMenuItem lire2 = new JMenuItem("Consulter la liste des utilisateurs");
		lire2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeUtilisateurs frame = new ListeUtilisateurs();
				frame.setVisible(true);
			}
		});
		edition.add(lire2);
		/**
		 * appel de la fenetre permettant d enregistrer une aide.
		 */
		JMenuItem enregistreraide = new JMenuItem("enregistrer une aide");
		enregistreraide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AideVue frame = new AideVue();
				frame.setVisible(true);

			}
		});
		mnTraitement.add(enregistreraide);
		/**
		 * appel de la fenetre permettant de consulter les aides.
		 */
		JMenuItem lireListeAides = new JMenuItem("Consulter liste des aides");
		lireListeAides.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeAides frame = new ListeAides();
				frame.setVisible(true);

			}
		});
		edition.add(lireListeAides);
		/**
		 *appel de la fenetre permettant d enregistrer un pret .
		 */
		JMenuItem enregistrerpret = new JMenuItem("enregistrer un pret");
		enregistrerpret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PretVue frame = new PretVue();
				frame.setVisible(true);
			}
		});
		mnTraitement.add(enregistrerpret);
		/**
		 * appel de la fenetre permettant d enregistrer un pret ordinaire.
		 */
		JMenuItem enregistrerpretOrdinaire = new JMenuItem("enregistrer un pret ordinaire");
		enregistrerpretOrdinaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PretOrdinaireVue frame = new PretOrdinaireVue();
				frame.setVisible(true);

			}
		});
		mnTraitement.add(enregistrerpretOrdinaire);
		/**
		 * appel de la fenetre permettant d enregistrer une participation.
		 */
		JMenuItem enregistrerparticipation = new JMenuItem("enregistrer un participation");
		enregistrerparticipation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParticipationVue frame = new ParticipationVue();
				frame.setVisible(true);

			}
		});
		mnTraitement.add(enregistrerparticipation);
		/**
		 * appel de la fenetre permettant de consulter les prets.
		 */
		JMenuItem afficherpret = new JMenuItem("consulter les prets");
		afficherpret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListePret frame = new ListePret();
				frame.setVisible(true);

			}
		});
		edition.add(afficherpret);
		/**
		 * appel de la fenetre permettant de consulter les prets ordinaires.
		 */
		JMenuItem afficherpretordinaire = new JMenuItem("consulter les prets ordinaires");
		afficherpretordinaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListePretOrdinaire frame = new ListePretOrdinaire();
				frame.setVisible(true);

			}
		});
		edition.add(afficherpretordinaire);
		/**
		 * appel de la fenetre permettant de consulter les participations.
		 */
		JMenuItem afficherparticipation = new JMenuItem("consulter les  participations");
		afficherparticipation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeParticipation frame = new ListeParticipation();
				frame.setVisible(true);
			}
		});
		edition.add(afficherparticipation);

	}

}
