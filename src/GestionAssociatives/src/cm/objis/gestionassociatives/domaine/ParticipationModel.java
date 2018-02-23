package cm.objis.gestionassociatives.domaine;

import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * cette classe permet d'afficher les participations
 */
public class ParticipationModel extends AbstractTableModel {

	private final String[] entetes = { "identifiant1", "identifiant2", "nom", "date", "montant", "motif" };

	private List<Participation> maListeParticiaption;

	public ParticipationModel(List<Participation> maListeParticipation) {

		this.maListeParticiaption = maListeParticipation;

	}

	public List<Participation> getMaListeParticiaption() {
		return maListeParticiaption;
	}

	public void setMaListeParticiaption(List<Participation> maListeParticiaption) {
		this.maListeParticiaption = maListeParticiaption;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return maListeParticiaption.size();
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
			return maListeParticiaption.get(rowIndex).getIdParticipation();
		case 1:
			// NomsPrenoms
			return maListeParticiaption.get(rowIndex).getIdAdherent();
		case 2:
			// DateLieuNaissance
			return maListeParticiaption.get(rowIndex).getNomAdherent();
		case 3:
			// NumeroCniLieuDelivrance
			return maListeParticiaption.get(rowIndex).getDateParticipation();
		case 4:
			// ResidenceTelephone
			return maListeParticiaption.get(rowIndex).getMontantParticipation();
		case 5:
			// ResidenceTelephone
			return maListeParticiaption.get(rowIndex).getMotifParticipation();

		default:
			throw new IllegalArgumentException();

		}

	}

}
