package cm.objis.gestionassociatives.presentation.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cm.objis.gestionassociatives.dao.Dao;
import cm.objis.gestionassociatives.dao.IDao;
import cm.objis.gestionassociatives.domaine.Adherent;
import cm.objis.gestionassociatives.domaine.Aide;
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
 * cette classe fournie un ensemble de fonctionalités permettant de recuperer
 * les proprietes d'une aide pour un enregistrement en base de donnée
 *
 */
public class AideVue extends JFrame {
	/**
	 * les attributs de AideVue
	 * 
	 */

	private JPanel contentPane;
	private JTextField textFieldMontant;
	private JTextField textFieldDelai;
	private JTextField textFieldTitre;
	private IDao dao4;
	private IService service4;

	/**
	 * Create the frame.
	 */
	public AideVue() {
		setTitle("ENREGISTRER UN ADHERENT");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomsEtPrenoms = new JLabel("ADHERENT :");
		lblNomsEtPrenoms.setBounds(43, 45, 131, 14);
		contentPane.add(lblNomsEtPrenoms);

		JComboBox comboBoxIdNoms = new JComboBox();
		comboBoxIdNoms.setBounds(195, 34, 195, 28);
		contentPane.add(comboBoxIdNoms);

		dao4 = new Dao();
		service4 = new Service(dao4);

		List<Adherent> adherents = service4.getAllAdherentService();

		String[] tabAdherents = new String[adherents.size()];

		int i = 0;

		for (Adherent ad : adherents) {
			tabAdherents[i] = ad.getIdAdherent() + ":" + ad.getNomsPrenoms();
			i++;
		}

		comboBoxIdNoms.setModel(new DefaultComboBoxModel(tabAdherents));

		JLabel lblMontantAide = new JLabel("MONTANT AIDE :");
		lblMontantAide.setBounds(43, 82, 131, 30);
		contentPane.add(lblMontantAide);

		textFieldMontant = new JTextField();
		textFieldMontant.setBounds(194, 82, 196, 30);
		contentPane.add(textFieldMontant);
		textFieldMontant.setColumns(10);

		JLabel lblDelaiAide = new JLabel("DELAI AIDE:");
		lblDelaiAide.setBounds(43, 134, 131, 30);
		contentPane.add(lblDelaiAide);

		textFieldDelai = new JTextField();
		textFieldDelai.setBounds(193, 134, 197, 30);
		contentPane.add(textFieldDelai);
		textFieldDelai.setColumns(10);

		JLabel lblTitreAide = new JLabel("TITRE AIDE :");
		lblTitreAide.setBounds(43, 187, 131, 20);
		contentPane.add(lblTitreAide);

		textFieldTitre = new JTextField();
		textFieldTitre.setBounds(195, 180, 195, 30);
		contentPane.add(textFieldTitre);
		textFieldTitre.setColumns(10);

		JButton btnEnregistrer = new JButton("ENREGISTRER");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((textFieldMontant.getText().length() == 0) || (textFieldTitre.getText().length() == 0)
						|| (textFieldDelai.getText().length() == 0)

				) {

					JOptionPane.showMessageDialog(null, "veillez remplir tous les champs");

				} else {

					int idAdherent;
					String nomAdherent;
					String MontantAide;
					String titreAide;
					String delaiAide;

					String idnom = comboBoxIdNoms.getSelectedItem().toString();

					String tabIdNom[] = idnom.split(":");

					idAdherent = Integer.valueOf(tabIdNom[0]).intValue();
					nomAdherent = tabIdNom[1];
					MontantAide = textFieldMontant.getText();
					titreAide = textFieldTitre.getText();
					delaiAide = textFieldDelai.getText();

					Aide aide4 = new Aide();

					aide4.setIdAdherent(idAdherent);
					aide4.setNomAdherent(nomAdherent);
					aide4.setMontantAide(MontantAide);
					aide4.setTitreAide(titreAide);
					aide4.setDelaiAide(delaiAide);

					int state = service4.enregistrerAideService(aide4);

					if (state == 1) {
						JOptionPane.showMessageDialog(null,
								"L'aide de" + aide4.getNomAdherent() + " " + "enregistré avec succès");
						comboBoxIdNoms.setToolTipText("");

						textFieldMontant.setText("");
						textFieldTitre.setText("");
						textFieldDelai.setText("");

					} else {
						JOptionPane.showMessageDialog(null, "echec d'enregistrement");

					}

				}

			}
		});
		btnEnregistrer.setBounds(230, 228, 160, 23);
		contentPane.add(btnEnregistrer);

		JButton btnListeDesAides = new JButton("FICHE D'ENREGISTREMENT D'UNE AIDE");
		btnListeDesAides.setBounds(95, 0, 238, 23);
		contentPane.add(btnListeDesAides);
	}
}
