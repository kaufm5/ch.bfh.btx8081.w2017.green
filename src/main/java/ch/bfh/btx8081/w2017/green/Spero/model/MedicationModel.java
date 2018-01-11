package ch.bfh.btx8081.w2017.green.Spero.model;

import ch.bfh.btx8081.w2017.green.Spero.persistence.DB;
import ch.bfh.btx8081.w2017.green.Spero.persistence.DiaryEntryList;
import ch.bfh.btx8081.w2017.green.Spero.persistence.MedicationList;

public class MedicationModel {
	private static final DB DATABASE_MANAGER = DB.getInstance();

	private MedicationList mediList;

	public MedicationModel() {
		this.takeListFromDB();
	}

	public void takeListFromDB() {
		if (MedicationModel.DATABASE_MANAGER.getSperoLists("MedicationList")
				.size() == 0) {
			this.mediList = new MedicationList();
			mediList.createMedicationList("Aspirin", "Für Kopfschmerzen");
			mediList.createMedicationList("Panadol", "Für Dünnschiss");
			
//			Medication medi = new Medication("Aspirin", "Gegen Kopfschmerzen");
//			mediList.getMedicationList().add(medi);

			DATABASE_MANAGER.persistObject(mediList);
		} 
		else {
			this.mediList = (MedicationList) MedicationModel.DATABASE_MANAGER
					.getSperoLists("MedicationList").get(0);
		}



	}

	public MedicationList getMediList() {
		return mediList;
	}

	public void setMediList(MedicationList mediList) {
		this.mediList = mediList;
	}


}
