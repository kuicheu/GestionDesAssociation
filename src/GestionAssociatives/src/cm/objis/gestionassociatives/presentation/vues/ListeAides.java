package cm.objis.gestionassociatives.presentation.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import cm.objis.gestionassociatives.dao.Dao;
import cm.objis.gestionassociatives.dao.IDao;
import cm.objis.gestionassociatives.domaine.AdherentModel;
import cm.objis.gestionassociatives.domaine.AideModel;
import cm.objis.gestionassociatives.service.IService;
import cm.objis.gestionassociatives.service.Service;

import javax.swing.JTable;

/**
 * cette class fournies un ensemble de fonctionalités permettant de d'afficher
 * les aides
 *
 */
public class ListeAides extends JFrame {
	/**
	 * les attributs de listeAide
	 */

	private JPanel contentPane;
	private JTable table;
	private IDao dao;
	private IService service;

	/**
	 * Create the frame.
	 */
	public ListeAides() {
		setTitle("LISTE DES AIDES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		dao = new Dao();
		service = new Service(dao);

		AideModel aidemodel = new AideModel(service.getAllAideService());

		table = new JTable(aidemodel);
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
	}

}
