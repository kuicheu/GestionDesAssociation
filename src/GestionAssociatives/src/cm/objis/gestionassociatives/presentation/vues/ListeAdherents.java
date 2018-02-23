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
import cm.objis.gestionassociatives.service.IService;
import cm.objis.gestionassociatives.service.Service;

import javax.swing.JTable;

/**
 * cette class fournies un ensemble de fonctionalités permettant d'afficher la
 * liste des adherents enrégsitrer
 *
 */
public class ListeAdherents extends JFrame {
	/**
	 * les attrubuts de liste adherents
	 */

	private JPanel contentPane;
	private JTable tableAdherents;
	private IDao dao;
	private IService service;

	/**
	 * Create the frame.
	 */
	public ListeAdherents() {
		setTitle("LISTES DES ADHERENTS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		dao = new Dao();
		service = new Service(dao);

		AdherentModel adherentmodel = new AdherentModel(service.getAllAdherentService());

		tableAdherents = new JTable(adherentmodel);
		contentPane.add(new JScrollPane(tableAdherents), BorderLayout.CENTER);
	}

}
