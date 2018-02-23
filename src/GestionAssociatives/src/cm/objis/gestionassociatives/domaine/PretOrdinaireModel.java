package cm.objis.gestionassociatives.domaine;

import java.util.List;
/**
 * cette classe permet d'afficher les prets ordinaires
 */

import javax.swing.table.AbstractTableModel;

public class PretOrdinaireModel extends AbstractTableModel {

	private final String[] entetes = { "identifiant1", "identifiant2", "nom", "montant", "delai" };

	private List<PretOrdinaire> maListePretOrdinaire;

	public PretOrdinaireModel(List<PretOrdinaire> maListePretOrdinaire) {

		this.maListePretOrdinaire = maListePretOrdinaire;

	}

	public List<PretOrdinaire> getMaListePretOrdinaire() {
		return maListePretOrdinaire;
	}

	public void setMaListePretOrdinaire(List<PretOrdinaire> maListePretOrdinaire) {
		this.maListePretOrdinaire = maListePretOrdinaire;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return maListePretOrdinaire.size();
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
			return maListePretOrdinaire.get(rowIndex).getIdPret();
		case 1:
			// NomsPrenoms
			return maListePretOrdinaire.get(rowIndex).getIdAdherent();
		case 2:
			// DateLieuNaissance
			return maListePretOrdinaire.get(rowIndex).getNomAdherent();
		case 3:
			// NumeroCniLieuDelivrance
			return maListePretOrdinaire.get(rowIndex).getMontantPret();
		case 4:
			// ResidenceTelephone
			return maListePretOrdinaire.get(rowIndex).getDelaiPret();

		default:
			throw new IllegalArgumentException();

		}

	}

}
