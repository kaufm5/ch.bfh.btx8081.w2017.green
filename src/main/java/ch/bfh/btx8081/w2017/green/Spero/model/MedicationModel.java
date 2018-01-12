package ch.bfh.btx8081.w2017.green.Spero.model;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ch.bfh.btx8081.w2017.green.Spero.persistence.DB;
import ch.bfh.btx8081.w2017.green.Spero.persistence.Medication;
import ch.bfh.btx8081.w2017.green.Spero.persistence.MedicationList;

/**
 * This is the medication information model which holds a list of the medication in the database
 * 
 * @author mussi
 *
 */
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
