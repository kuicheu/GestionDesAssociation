package cm.objis.gestionassociatives.presentation.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cm.objis.gestionassociatives.dao.Dao;
import cm.objis.gestionassociatives.dao.IDao;
import cm.objis.gestionassociatives.domaine.Adherent;
import cm.objis.gestionassociatives.domaine.Pret;
import cm.objis.gestionassociatives.service.IService;
import cm.objis.gestionassociatives.service.Service;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/**
 * Cette Class fournie un ensemble de fonctionalité permettant de prendre les
 * propriétés d'un prêt pour enregistrer
 *
 */
public class PretVue extends JFrame {
	
	/**
	 * les attributs de PretVue
	 */

	private JPanel contentPane;
	private JTextField textFieldMontantPret;
	private JTextField textFieldDelaiPret;
	private IDao dao10;
	private IService service10;

	/**
	 * Create the frame.
	 */
	public PretVue() {
		setTitle("ENREGISTRER UN PRET");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAdherent = new JLabel("ADHERENT :");
		lblAdherent.setBounds(44, 41, 129, 14);
		contentPane.add(lblAdherent);

		JComboBox comboBoxAdherentPret = new JComboBox();
		comboBoxAdherentPret.setBounds(182, 38, 202, 20);
		contentPane.add(comboBoxAdherentPret);

		dao10 = new Dao();
		service10 = new Service(dao10);

		List<Adherent> adherents = service10.getAllAdherentService();

		String[] tabAdherents = new String[adherents.size()];

		int i = 0;

		for (Adherent ad : adherents) {
			tabAdherents[i] = ad.getIdAdherent() + ":" + ad.getNomsPrenoms();
			i++;
		}

		comboBoxAdherentPret.setModel(new DefaultComboBoxModel(tabAdherents));

		JLabel lblMontantDuPret = new JLabel("MONTANT DU PRET :");
		lblMontantDuPret.setBounds(44, 84, 129, 14);
		contentPane.add(lblMontantDuPret);

		textFieldMontantPret = new JTextField();
		textFieldMontantPret.setBounds(184, 81, 200, 20);
		contentPane.add(textFieldMontantPret);
		textFieldMontantPret.setColumns(10);

		JLabel lblDelaiDuPret = new JLabel("DELAI DU PRET :");
		lblDelaiDuPret.setBounds(44, 138, 129, 14);
		contentPane.add(lblDelaiDuPret);

		textFieldDelaiPret = new JTextField();
		textFieldDelaiPret.setBounds(185, 135, 199, 20);
		contentPane.add(textFieldDelaiPret);
		textFieldDelaiPret.setColumns(10);

		JButton btnEnregistrer = new JButton("ENREGISTRER");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textFieldMontantPret.getText().length() == 0) || (textFieldDelaiPret.getText().length() == 0)

				) {

					JOptionPane.showMessageDialog(null, "veillez remplir tous les champs");

				} else {

					int idAdherent;
					String nomAdherent;
					int montantPret;
					String delaiPret;

					String idnom = comboBoxAdherentPret.getSelectedItem().toString();

					String tabIdNom[] = idnom.split(":");

					idAdherent = Integer.valueOf(tabIdNom[0]).intValue();
					nomAdherent = tabIdNom[1];
					montantPret = Integer.valueOf(textFieldMontantPret.getText()).intValue();
					delaiPret = textFieldDelaiPret.getText();

					Pret pret = new Pret();
					pret.setIdAdherent(idAdherent);
					pret.setNomAdherent(nomAdherent);
					pret.setMontantPret(montantPret);
					pret.setDelaiPret(delaiPret);

					int state = service10.enregistrerPretService(pret);

					if (state == 1) {
						JOptionPane.showMessageDialog(null,
								"Le pret  de     " + pret.getNomAdherent() + " " + "enregistré avec succès");
						comboBoxAdherentPret.setToolTipText("");

						textFieldMontantPret.setText("");
						textFieldDelaiPret.setText("");

					} else {
						JOptionPane.showMessageDialog(null, "echec d'enregistrement");

					}

				}
			}
		});
		btnEnregistrer.setBounds(213, 200, 129, 23);
		contentPane.add(btnEnregistrer);

	}
}
