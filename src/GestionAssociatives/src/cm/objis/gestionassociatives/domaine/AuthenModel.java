package cm.objis.gestionassociatives.domaine;

import java.util.List;
/**
 * cette classe permet d'afficher les utilisateurs
 */

import javax.swing.table.AbstractTableModel;

public class AuthenModel extends AbstractTableModel {
	

	private final String[] entetes = { "identifiant", "utilisateurs", "mot de passe" };

	private List<Authentification> maListeAuthentification;

	public AuthenModel(List<Authentification> maListeAuthentification) {

		this.maListeAuthentification = maListeAuthentification;

	}

	public List<Authentification> getMaListeAuthentification() {
		return maListeAuthentification;
	}

	public void setMaListeAuthentification(List<Authentification> maListeAuthentification) {
		this.maListeAuthentification = maListeAuthentification;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return maListeAuthentification.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub

		return entetes.length;
	}

	public String getColumnName(int ColumnIndex) {
		return entetes[ColumnIndex];
	}

	// public String[] getEntetes() {
	// return entetes;
	// }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		switch (columnIndex) {

		case 0:
			// idAdherent
			return maListeAuthentification.get(rowIndex).getIdAuthentification();
		case 1:
			// NomsPrenoms
			return maListeAuthentification.get(rowIndex).getLogin();
		case 2:
			// DateLieuNaissance
			return maListeAuthentification.get(rowIndex).getPassword();

		default:
			throw new IllegalArgumentException();

		}

	}

}
