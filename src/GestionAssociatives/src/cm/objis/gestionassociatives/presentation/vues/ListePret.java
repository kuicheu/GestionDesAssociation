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
import cm.objis.gestionassociatives.domaine.PretModel;
import cm.objis.gestionassociatives.service.IService;
import cm.objis.gestionassociatives.service.Service;

import javax.swing.JTable;

/**
 * cette Class offre les fonctionalités permettant de lister les prets
 * enrégistrer en base de données
 *
 */
public class ListePret extends JFrame {
	
	/**
	 * les attributs de ListePret.
	 */
	private JPanel contentPane;
	private JTable tablePret;
	private IDao dao7;
	private IService service7;

	/**
	 * Create the frame.
	 */
	public ListePret() {
		setTitle("LISTE DES PRETS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		dao7 = new Dao();
		service7 = new Service(dao7);
		
		PretModel pretmodel = new PretModel(service7.getAllPretService());
		
		tablePret = new JTable(pretmodel);
		contentPane.add(new JScrollPane(tablePret), BorderLayout.CENTER);
	}

}
