package cm.objis.gestionassociatives.presentation.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import cm.objis.gestionassociatives.dao.Dao;
import cm.objis.gestionassociatives.dao.IDao;
import cm.objis.gestionassociatives.domaine.PretModel;
import cm.objis.gestionassociatives.domaine.PretOrdinaireModel;
import cm.objis.gestionassociatives.service.IService;
import cm.objis.gestionassociatives.service.Service;

import javax.swing.JTable;

/**
 * cette Class offre les fonctionalités permettant de lister les 
 * prets ordinaires enregistrés en base de donnée
 *
 */
public class ListePretOrdinaire extends JFrame {
	/**
	 * les attributs de liste pret.
	 */

	private JPanel contentPane;
	private JTable tablePretOrdinaire;
	private IDao dao8;
	private IService service8;
	

	
	/**
	 * Create the frame.
	 */
	public ListePretOrdinaire() {
		setTitle("LES DES PRETS ORDINAIRES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		dao8 = new Dao();
		service8 = new Service(dao8);
		
		PretOrdinaireModel pretOrdinairemodel = new PretOrdinaireModel(service8.getAllPretOrdinaireService());
		
		tablePretOrdinaire = new JTable(pretOrdinairemodel);
		contentPane.add(new JScrollPane(tablePretOrdinaire), BorderLayout.CENTER);
	}

}
