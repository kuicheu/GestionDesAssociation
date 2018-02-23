package cm.objis.gestionassociatives.presentation.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cm.objis.gestionassociatives.dao.Dao;
import cm.objis.gestionassociatives.dao.IDao;
import cm.objis.gestionassociatives.domaine.Adherent;
import cm.objis.gestionassociatives.domaine.Participation;
import cm.objis.gestionassociatives.domaine.Pret;
import cm.objis.gestionassociatives.service.IService;
import cm.objis.gestionassociatives.service.Service;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

/**
 * cette Class offre les fonctionalités permettant de prendre les 
 * paramettre d'une participation pour un enregistrement en base de donnée
 *
 */
public class ParticipationVue extends JFrame {
	/**
	 * les attributs de participation vue.
	 */

	private JPanel contentPane;
	private JTextField textFieldDate;
	private JTextField textFieldMontant;
	private JTextField textFieldMotif;
	private IDao dao12;
	private IService service12;

	
	/**
	 * Create the frame.
	 */
	public ParticipationVue() {
		setTitle("ENREGISTRER UNE PARTICIPATION");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdherent = new JLabel("ADHERENT :");
		lblAdherent.setBounds(38, 23, 129, 14);
		contentPane.add(lblAdherent);
		
		JComboBox comboBoxParticipation = new JComboBox();
		comboBoxParticipation.setBounds(187, 20, 192, 20);
		contentPane.add(comboBoxParticipation);
		
		dao12 = new Dao();
		service12 = new Service(dao12);

		List<Adherent> adherents = service12.getAllAdherentService();

		String[] tabAdherents = new String[adherents.size()];

		int i = 0;

		for (Adherent ad : adherents) {
			tabAdherents[i] = ad.getIdAdherent() + ":" + ad.getNomsPrenoms();
			i++;
		}

		comboBoxParticipation.setModel(new DefaultComboBoxModel(tabAdherents));
		
		
		
		
		
		
		
		
		
		
		JLabel lblDateParticipation = new JLabel("DATE PARTICIPATION:");
		lblDateParticipation.setBounds(38, 60, 129, 14);
		contentPane.add(lblDateParticipation);
		
		textFieldDate = new JTextField();
		textFieldDate.setBounds(187, 57, 192, 20);
		contentPane.add(textFieldDate);
		textFieldDate.setColumns(10);
		
		JLabel lblMontantParticipation = new JLabel("MONTANT PARTICIPATION :");
		lblMontantParticipation.setBounds(38, 100, 149, 14);
		contentPane.add(lblMontantParticipation);
		
		textFieldMontant = new JTextField();
		textFieldMontant.setBounds(187, 97, 192, 20);
		contentPane.add(textFieldMontant);
		textFieldMontant.setColumns(10);
		
		JLabel lblMotifParticipation = new JLabel("MOTIF PARTICIPATION :");
		lblMotifParticipation.setBounds(38, 138, 141, 14);
		contentPane.add(lblMotifParticipation);
		
		textFieldMotif = new JTextField();
		textFieldMotif.setBounds(186, 135, 193, 20);
		contentPane.add(textFieldMotif);
		textFieldMotif.setColumns(10);
		
		JButton btnNewButton = new JButton("ENREGISTRER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ((textFieldDate.getText().length() == 0) ||
						(textFieldMontant.getText().length() == 0)||
						(textFieldMotif.getText()).length() == 0)

						{

							JOptionPane.showMessageDialog(null, "veillez remplir tous les champs");

						} else {

							int idAdherent;
							String nomAdherent;
						    String dateParticipation;
						    int montantParticipation;
						    String motifParticipation;

							String idnom = comboBoxParticipation.getSelectedItem().toString();

							String tabIdNom[] = idnom.split(":");

							idAdherent = Integer.valueOf(tabIdNom[0]).intValue();
							nomAdherent = tabIdNom[1];
							dateParticipation = textFieldDate.getText();
							montantParticipation = Integer.valueOf(textFieldMontant.getText()).intValue();
							motifParticipation = textFieldMotif.getText();

							Participation participation = new Participation();
							participation.setIdAdherent(idAdherent);
							participation.setNomAdherent(nomAdherent);
							participation.setDateParticipation(dateParticipation);
							participation.setMontantParticipation(montantParticipation);
							participation.setMotifParticipation(motifParticipation);
							
							int state = service12.enregistrerparticipationService(participation);
							
							if(state == 1) {
								JOptionPane.showMessageDialog(null, "La participation  de       " + participation.getNomAdherent() + " " +"enregistré avec succès");
								comboBoxParticipation.setToolTipText("");
								textFieldDate.setText("");
								textFieldMontant.setText("");
								textFieldMotif.setText("");
							
								
								
							}else {
								JOptionPane.showMessageDialog(null, "echec d'enregistrement");
							
								
								
							}
								
										
								
						}			
								
				
				
				
			}
		});
		btnNewButton.setBounds(246, 196, 133, 23);
		contentPane.add(btnNewButton);
	}

}
