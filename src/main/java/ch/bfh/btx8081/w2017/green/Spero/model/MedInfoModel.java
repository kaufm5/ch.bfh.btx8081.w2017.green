package ch.bfh.btx8081.w2017.green.Spero.model;

import ch.bfh.btx8081.w2017.green.Spero.persistence.DB;
import ch.bfh.btx8081.w2017.green.Spero.persistence.MedicationList;

public class MedInfoModel {
	private static final DB DATABASE_MANAGER = DB.getInstance();

	private MedicationList medicationList;

	public MedInfoModel() {
		this.medicationList = (MedicationList) MedInfoModel.DATABASE_MANAGER
				.getSperoLists("MedicationList").get(0);
	}

	public void persist(MedicationList medicationList) {
		MedInfoModel.DATABASE_MANAGER.persistObject(medicationList);
	}

	public MedicationList getMedicationList() {
		return this.medicationList;
	}

	public void setMedicationList(MedicationList medicationList) {
		this.medicationList = medicationList;
	}

}
