package cm.objis.gestionassociatives.presentation.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cm.objis.gestionassociatives.dao.Dao;
import cm.objis.gestionassociatives.dao.IDao;
import cm.objis.gestionassociatives.domaine.Adherent;
import cm.objis.gestionassociatives.domaine.Authentification;
import cm.objis.gestionassociatives.service.IService;
import cm.objis.gestionassociatives.service.Service;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * cette classe fournie un ensemble de fonctionalité permettant de recuperer le
 * login et le mot de passe d'un utilisateur pour un enregistrement en base de
 * donnée
 *
 */
public class AuthentificationVue extends JFrame {

	/**
	 * les attributs de AuthentificationVue
	 */

	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JTextField passwordFieldMot;
	private IDao dao1;
	private IService service1;

	/**
	 * * Create the frame.
	 */
	public AuthentificationVue() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(87, 79, 46, 14);
		contentPane.add(lblLogin);

		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(194, 76, 186, 20);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);

		JLabel lblMotDePasse = new JLabel("MOT DE PASSE");
		lblMotDePasse.setBounds(40, 139, 93, 14);
		contentPane.add(lblMotDePasse);

		passwordFieldMot = new JPasswordField();
		passwordFieldMot.setBounds(194, 136, 186, 20);
		contentPane.add(passwordFieldMot);

		JButton btnEntrer = new JButton("ENREGISTRER");
		btnEntrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((textFieldLogin.getText().length() == 0) ||

						(passwordFieldMot.getText().length() == 0)) {

					JOptionPane.showMessageDialog(null, "veillez remplir tous les champs");

				} else {

					String Login;
					String Password;

					Login = textFieldLogin.getText();
					Password = passwordFieldMot.getText();

					Authentification authen1 = new Authentification();

					authen1.setLogin(Login);
					authen1.setPassword(Password);

					int state = service1.enregistrerauthentificationService(authen1);

					if (state == 1) {
						JOptionPane.showMessageDialog(null,
								"l'utilisateur" + authen1.getLogin() + " " + "enregistré avec succès");
						textFieldLogin.setText("");
						passwordFieldMot.setText("");

					} else {
						JOptionPane.showMessageDialog(null, "echec d'enregistrement");

					}

				}

			}
		});
		btnEntrer.setBounds(194, 203, 164, 23);
		contentPane.add(btnEntrer);

		dao1 = new Dao();
		service1 = new Service(dao1);
	}
}
