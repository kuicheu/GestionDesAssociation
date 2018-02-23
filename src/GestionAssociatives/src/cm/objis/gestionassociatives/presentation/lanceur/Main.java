package cm.objis.gestionassociatives.presentation.lanceur;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;





/**
 * cette Class est la classe principale de l application
 *
 */
public class Main {

	public static void main(String[] args) {
		
		try {
			LOGIN dialog = new LOGIN();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	

	}

}
