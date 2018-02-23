package cm.objis.gestionassociatives.presentation.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cm.objis.gestionassociatives.dao.Dao;
import cm.objis.gestionassociatives.dao.IDao;
import cm.objis.gestionassociatives.domaine.Adherent;
import cm.objis.gestionassociatives.domaine.Pret;
import cm.objis.gestionassociatives.domaine.PretOrdinaire;
import cm.objis.gestionassociatives.service.IService;
import cm.objis.gestionassociatives.service.Service;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Cette Class fournie un ensemble de fonctionalité permettant d'enrégistrer un
 * prêt ordinaire
 *
 */
public class PretOrdinaireVue extends JFrame {
	/**
	 * les attributs de PretOrdinaireVue.
	 */
	private JPanel contentPane;
	private JTextField textFieldMontant;
	private JTextField textFieldDelai;
	private IDao dao11;
	private IService service11;

	/**
	 * Create the frame.
	 */
	public PretOrdinaireVue() {
		setTitle("ENREGISTRER UN PRET ORDINAIRE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAdherent = new JLabel("ADHERENT :");
		lblAdherent.setBounds(41, 37, 143, 14);
		contentPane.add(lblAdherent);

		JComboBox comboBoxAdherent = new JComboBox();
		comboBoxAdherent.setBounds(214, 34, 210, 20);
		contentPane.add(comboBoxAdherent);

		dao11 = new Dao();
		service11 = new Service(dao11);

		List<Adherent> adherents = service11.getAllAdherentService();

		String[] tabAdherents = new String[adherents.size()];

		int i = 0;

		for (Adherent ad : adherents) {
			tabAdherents[i] = ad.getIdAdherent() + ":" + ad.getNomsPrenoms();
			i++;
		}

		comboBoxAdherent.setModel(new DefaultComboBoxModel(tabAdherents));

		JLabel lblMontantDuPret = new JLabel("MONTANT DU PRET OR:");
		lblMontantDuPret.setBounds(39, 78, 145, 14);
		contentPane.add(lblMontantDuPret);

		textFieldMontant = new JTextField();
		textFieldMontant.setBounds(214, 75, 210, 20);
		contentPane.add(textFieldMontant);
		textFieldMontant.setColumns(10);

		JLabel lblDelaiDuPret = new JLabel("DELAI DU PRET :");
		lblDelaiDuPret.setBounds(41, 131, 143, 14);
		contentPane.add(lblDelaiDuPret);

		textFieldDelai = new JTextField();
		textFieldDelai.setBounds(215, 128, 209, 20);
		contentPane.add(textFieldDelai);
		textFieldDelai.setColumns(10);

		JButton btnEnregistrer = new JButton("ENREGISTRER");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((textFieldMontant.getText().length() == 0) || (textFieldDelai.getText().length() == 0)

				) {

					JOptionPane.showMessageDialog(null, "veillez remplir tous les champs");

				} else {

					int idAdherent;
					String nomAdherent;
					int montantPret;
					String delaiPret;

					String idnom = comboBoxAdherent.getSelectedItem().toString();

					String tabIdNom[] = idnom.split(":");

					idAdherent = Integer.valueOf(tabIdNom[0]).intValue();
					nomAdherent = tabIdNom[1];
					montantPret = Integer.valueOf(textFieldMontant.getText()).intValue();
					delaiPret = textFieldDelai.getText();

					Pret pretOrdinaire = new Pret();
					pretOrdinaire.setIdAdherent(idAdherent);
					pretOrdinaire.setNomAdherent(nomAdherent);
					pretOrdinaire.setMontantPret(montantPret);
					pretOrdinaire.setDelaiPret(delaiPret);

					int state = service11.enregistrerPretService(pretOrdinaire);

					if (state == 1) {
						JOptionPane.showMessageDialog(null, "Le pret ordinaire de    " + pretOrdinaire.getNomAdherent()
								+ " " + "enregistré avec succès");
						comboBoxAdherent.setToolTipText("");

						textFieldMontant.setText("");
						textFieldDelai.setText("");

					} else {
						JOptionPane.showMessageDialog(null, "echec d'enregistrement");

					}

				}

			}
		});
		btnEnregistrer.setBounds(226, 199, 198, 23);
		contentPane.add(btnEnregistrer);
	}
}
