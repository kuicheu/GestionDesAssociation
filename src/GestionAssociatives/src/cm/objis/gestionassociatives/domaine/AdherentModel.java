package cm.objis.gestionassociatives.domaine;

import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * cette Class offre les fonctionalites permettant d'afficher les differents
 * adherents enregistrés en base
 *
 */
public class AdherentModel extends AbstractTableModel {

	private final String[] entetes = { "identifiant", "noms et prenoms", "date et lieu de naissance",
			"N° CNI et lieu de delivrance", "residence et telephone", "SM et nom epouse", "nom pere et mere",
			"proche à contacter" };

	private List<Adherent> maListeAdherent;

	public AdherentModel(List<Adherent> maListeAdherent) {

		this.maListeAdherent = maListeAdherent;

	}

	public List<Adherent> getMaListeAdherent() {
		return maListeAdherent;
	}

	public void setMaListeAdherent(List<Adherent> maListeAdherent) {
		this.maListeAdherent = maListeAdherent;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return maListeAdherent.size();
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
			return maListeAdherent.get(rowIndex).getIdAdherent();
		case 1:
			// NomsPrenoms
			return maListeAdherent.get(rowIndex).getNomsPrenoms();
		case 2:
			// DateLieuNaissance
			return maListeAdherent.get(rowIndex).getDateLieuNaissance();
		case 3:
			// NumeroCniLieuDelivrance
			return maListeAdherent.get(rowIndex).getNumeroCniLieuDelivrance();
		case 4:
			// ResidenceTelephone
			return maListeAdherent.get(rowIndex).getResidenceTelephone();
		case 5:
			// SituationMatrimonialeNomEpouse
			return maListeAdherent.get(rowIndex).getSituationMatrimonialeNomEpouse();
		case 6:
			// NomPereMere
			return maListeAdherent.get(rowIndex).getNomPereMere();
		case 7:
			// ProcheAContacterTelephone
			return maListeAdherent.get(rowIndex).getProcheAContacter();

		default:
			throw new IllegalArgumentException();

		}
	}

}
