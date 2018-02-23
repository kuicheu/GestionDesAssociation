package cm.objis.gestionassociatives.presentation.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import cm.objis.gestionassociatives.dao.Dao;
import cm.objis.gestionassociatives.dao.IDao;
import cm.objis.gestionassociatives.domaine.ParticipationModel;
import cm.objis.gestionassociatives.domaine.PretOrdinaireModel;
import cm.objis.gestionassociatives.service.IService;
import cm.objis.gestionassociatives.service.Service;

import javax.swing.JTable;

/**
 * cette class fournie des fonctionalites permettant d'afficher la liste de
 * participations
 *
 */
public class ListeParticipation extends JFrame {
	/**
	 * les attributs de ListeParticipation
	 */

	private JPanel contentPane;
	private JTable tableParticipation;
	private IDao dao9;
	private IService service9;

	/**
	 * Create the frame.
	 */
	public ListeParticipation() {
		setTitle("LISTE DES PARTICIPATIONS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		dao9 = new Dao();
		service9 = new Service(dao9);

		ParticipationModel participationmodel = new ParticipationModel(service9.getAllParticipationService());

		tableParticipation = new JTable(participationmodel);
		contentPane.add(new JScrollPane(tableParticipation), BorderLayout.CENTER);
	}

}
