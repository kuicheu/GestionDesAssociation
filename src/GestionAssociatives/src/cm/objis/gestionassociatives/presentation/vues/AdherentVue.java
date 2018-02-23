package cm.objis.gestionassociatives.presentation.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cm.objis.gestionassociatives.dao.Dao;
import cm.objis.gestionassociatives.dao.IDao;
import cm.objis.gestionassociatives.domaine.Adherent;
import cm.objis.gestionassociatives.service.IService;
import cm.objis.gestionassociatives.service.Service;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * cette class fournie un ensemble de fonctionalités permettant de récupérer les
 * proprietes d'un adherent fournies par un utilisateur pour un enregistrement
 * en base de données
 *
 */
public class AdherentVue extends JFrame {
	/**
	 * les attributs de QdherentVue
	 */

	private JPanel contentPane;
	private JTextField textFieldnoms;
	private JTextField textFielddate;
	private JTextField textFieldCNI;
	private JLabel lblResidenceEtNumero;
	private JTextField textFieldresidence;
	private JLabel lblSituationMatrimonialeEt;
	private JTextField textFieldsituation;
	private JLabel lblNomDuPere;
	private JTextField textFieldpere;
	private JLabel lblProcheAContacter;
	private JTextField textFieldproche;
	private IDao dao1;
	private IService service1;

	public AdherentVue() {
		setTitle("ENREGISTREMENT D'UN ADHERENT");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomsEtPrenoms = new JLabel("NOMS ET PRENOMS :");
		lblNomsEtPrenoms.setBounds(22, 61, 268, 14);
		contentPane.add(lblNomsEtPrenoms);

		textFieldnoms = new JTextField();
		textFieldnoms.setBounds(325, 58, 249, 20);
		contentPane.add(textFieldnoms);
		textFieldnoms.setColumns(10);

		JLabel lblDateEtLieu = new JLabel("DATE ET LIEU DE NAISSANCE :");
		lblDateEtLieu.setBounds(22, 111, 268, 14);
		contentPane.add(lblDateEtLieu);

		textFielddate = new JTextField();
		textFielddate.setBounds(325, 108, 249, 20);
		contentPane.add(textFielddate);
		textFielddate.setColumns(10);

		JLabel lblNumeroDeCni = new JLabel("NUMERO DE CNI DATE ET LIEU DE DELIVRANCE :");
		lblNumeroDeCni.setBounds(22, 161, 268, 14);
		contentPane.add(lblNumeroDeCni);

		textFieldCNI = new JTextField();
		textFieldCNI.setBounds(325, 158, 249, 20);
		contentPane.add(textFieldCNI);
		textFieldCNI.setColumns(10);

		lblResidenceEtNumero = new JLabel("RESIDENCE ET NUMERO DE TELEPHONE :");
		lblResidenceEtNumero.setBounds(22, 210, 268, 14);
		contentPane.add(lblResidenceEtNumero);

		textFieldresidence = new JTextField();
		textFieldresidence.setBounds(325, 207, 249, 20);
		contentPane.add(textFieldresidence);
		textFieldresidence.setColumns(10);

		lblSituationMatrimonialeEt = new JLabel("SITUATION MATRIMONIALE ET NOM DE L'EPOUX(SE) :");
		lblSituationMatrimonialeEt.setBounds(22, 256, 268, 14);
		contentPane.add(lblSituationMatrimonialeEt);

		textFieldsituation = new JTextField();
		textFieldsituation.setBounds(324, 253, 250, 20);
		contentPane.add(textFieldsituation);
		textFieldsituation.setColumns(10);

		lblNomDuPere = new JLabel("NOM DU PERE ET DE LA MERE :");
		lblNomDuPere.setBounds(22, 299, 268, 14);
		contentPane.add(lblNomDuPere);

		textFieldpere = new JTextField();
		textFieldpere.setBounds(325, 296, 249, 20);
		contentPane.add(textFieldpere);
		textFieldpere.setColumns(10);

		lblProcheAContacter = new JLabel("PROCHE A CONTACTER ET TELEPHONE  :");
		lblProcheAContacter.setBounds(22, 342, 268, 14);
		contentPane.add(lblProcheAContacter);

		textFieldproche = new JTextField();
		textFieldproche.setBounds(326, 339, 248, 20);
		contentPane.add(textFieldproche);
		textFieldproche.setColumns(10);

		JButton btnNewButton = new JButton("ENREGISTRER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((textFieldnoms.getText().length() == 0) || (textFielddate.getText().length() == 0)
						|| (textFieldCNI.getText().length() == 0) || (textFieldresidence.getText().length() == 0)
						|| (textFieldsituation.getText().length() == 0) || (textFieldpere.getText().length() == 0)
						|| (textFieldproche.getText().length() == 0)) {

					JOptionPane.showMessageDialog(null, "veillez remplir tous les champs");

				} else {

					String nomsprenoms;
					String datelieunaissance;
					String numerocnilieudelivrance;
					String residencetelephone;
					String situationmatrimonialenomepouse;
					String nomperemere;
					String procheacontacter;

					nomsprenoms = textFieldnoms.getText();
					datelieunaissance = textFielddate.getText();
					numerocnilieudelivrance = textFieldCNI.getText();
					residencetelephone = textFieldresidence.getText();
					situationmatrimonialenomepouse = textFieldsituation.getText();
					nomperemere = textFieldpere.getText();
					procheacontacter = textFieldproche.getText();

					Adherent adherent1 = new Adherent();

					adherent1.setNomsPrenoms(nomsprenoms);
					adherent1.setDateLieuNaissance(datelieunaissance);
					adherent1.setNumeroCniLieuDelivrance(numerocnilieudelivrance);
					adherent1.setResidenceTelephone(residencetelephone);
					adherent1.setSituationMatrimonialeNomEpouse(situationmatrimonialenomepouse);
					adherent1.setNomPereMere(nomperemere);
					adherent1.setProcheAContacter(procheacontacter);

					int state = service1.enregistrerAdherentService(adherent1);

					if (state == 1) {
						JOptionPane.showMessageDialog(null,
								"Adherent    " + adherent1.getNomsPrenoms() + " " + "enregistré avec succès");
						textFieldnoms.setText("");
						textFielddate.setText("");
						textFieldCNI.setText("");
						textFieldresidence.setText("");
						textFieldsituation.setText("");
						textFieldpere.setText("");
						textFieldproche.setText("");

					} else {
						JOptionPane.showMessageDialog(null, "echec d'enregistrement");

					}

				}

			}

		});
		btnNewButton.setBounds(407, 437, 167, 23);
		contentPane.add(btnNewButton);
		dao1 = new Dao();
		service1 = new Service(dao1);
	}
}
