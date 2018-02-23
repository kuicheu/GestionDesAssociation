package cm.objis.gestionassociatives.domaine;

import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * cette classe permet d'afficher les Aides enregistrer en base de donnée
 */
public class AideModel extends AbstractTableModel {

	private final String[] entetes = { "reference aide", "reference adherent", "nom de l'adherent", "montant de l'aide",
			"titre de l'aide", "delai de l'aide" };

	private List<Aide> maListeAide;

	public AideModel(List<Aide> maListeAide) {

		this.maListeAide = maListeAide;

	}

	public List<Aide> getMaListeAide() {
		return maListeAide;
	}

	public void setMaListeAide(List<Aide> maListeAide) {
		this.maListeAide = maListeAide;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return maListeAide.size();
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
			return maListeAide.get(rowIndex).getIdAide();
		case 1:
			// NomsPrenoms
			return maListeAide.get(rowIndex).getIdAdherent();
		case 2:
			// DateLieuNaissance
			return maListeAide.get(rowIndex).getNomAdherent();
		case 3:
			// NumeroCniLieuDelivrance
			return maListeAide.get(rowIndex).getMontantAide();
		case 4:
			// ResidenceTelephone
			return maListeAide.get(rowIndex).getTitreAide();
		case 5:
			// SituationMatrimonialeNomEpouse
			return maListeAide.get(rowIndex).getDelaiAide();

		default:
			throw new IllegalArgumentException();

		}
	}

}
