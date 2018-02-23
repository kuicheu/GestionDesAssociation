package cm.objis.gestionassociatives.presentation.lanceur;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cm.objis.gestionassociatives.dao.Dao;
import cm.objis.gestionassociatives.dao.IDao;
import cm.objis.gestionassociatives.service.IService;
import cm.objis.gestionassociatives.service.Service;
import cm.objis.gestionassociatives.utils.ConnectionMYSQL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

/**
 * cette class offre les fonctionalites permettant d acceder
 * a notre application
 *
 */
public class LOGIN extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private IDao dao1;
	private IService service1;

	/**
	 * Create the dialog.
	 */
	public LOGIN() {
		
		dao1 = new Dao();
		service1 = new Service(dao1);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUtilisateur = new JLabel("Utilisateur  :");
		lblUtilisateur.setBounds(121, 46, 77, 28);
		contentPanel.add(lblUtilisateur);
		
		textField = new JTextField();
		textField.setBounds(254, 50, 115, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe  :");
		lblMotDePasse.setBounds(121, 103, 77, 14);
		contentPanel.add(lblMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(254, 100, 115, 20);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
						
						int reponse = service1.authentificationService(textField.getText(), passwordField.getText().toString());
						if(reponse == 1){
							JOptionPane.showMessageDialog(null, "login et mot de passe OK!"   );
							dispose();
							AccueilGestionAssociativesLanceur window = new AccueilGestionAssociativesLanceur();
							window.frameGestionAssociative.setVisible(true);
							
						}else {
							JOptionPane.showMessageDialog(null, "login et mot de passe  Incorrect!"   );
						}	
						
						

										
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
