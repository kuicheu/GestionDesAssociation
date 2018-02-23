package cm.objis.gestionassociatives.presentation.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import cm.objis.gestionassociatives.dao.Dao;
import cm.objis.gestionassociatives.dao.IDao;
import cm.objis.gestionassociatives.domaine.AuthenModel;
import cm.objis.gestionassociatives.service.IService;
import cm.objis.gestionassociatives.service.Service;

import javax.swing.JTable;

/**
 * cette Class offre les fonctionalités permettant de lister les utilisateurs
 * enrégistrer en base de donnée
 *
 */
public class ListeUtilisateurs extends JFrame {
	/**
	 * les attributs de ListeUtiliseur.
	 */

	private JPanel contentPane;
	private JTable tableUtilisateurs;
	private IDao dao2;
	private IService service2;

	/**
	 * Create the frame.
	 */
	public ListeUtilisateurs() {
		setTitle("LISTE DES UTILISATEURS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		dao2 = new Dao();
		service2 = new Service(dao2);
		AuthenModel authenmodel = new AuthenModel(service2.getAllAuthentificationService());

		tableUtilisateurs = new JTable(authenmodel);
		contentPane.add(new JScrollPane(tableUtilisateurs), BorderLayout.CENTER);
	}

}
