package cm.objis.gestionassociatives.domaine;

import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * cette classe permet d'afficher les prets
 */
public class PretModel extends AbstractTableModel {

	private final String[] entetes = { "identifiant1", "identifiant2", "nom", "montant", "delai" };

	private List<Pret> maListePret;

	public PretModel(List<Pret> maListePret) {

		this.maListePret = maListePret;

	}

	public List<Pret> getMaListePret() {
		return maListePret;
	}

	public void setMaListePret(List<Pret> maListePret) {
		this.maListePret = maListePret;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return maListePret.size();
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
			return maListePret.get(rowIndex).getIdPret();
		case 1:
			// NomsPrenoms
			return maListePret.get(rowIndex).getIdAdherent();
		case 2:
			// DateLieuNaissance
			return maListePret.get(rowIndex).getNomAdherent();
		case 3:
			// NumeroCniLieuDelivrance
			return maListePret.get(rowIndex).getMontantPret();
		case 4:
			// ResidenceTelephone
			return maListePret.get(rowIndex).getDelaiPret();

		default:
			throw new IllegalArgumentException();

		}
	}

}
