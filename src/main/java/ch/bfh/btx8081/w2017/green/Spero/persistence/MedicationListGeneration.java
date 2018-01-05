package ch.bfh.btx8081.w2017.green.Spero.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class MedicationListGeneration {

	private DB db; 
	private EntityManager entityManager;

	public MedicationListGeneration() {
		db = new DB(); 

		new MedicationListFill(); 

		generateData(); 
	}

//	public static void main(String[] args) {
//		MedicationListGeneration medData = new MedicationListGeneration();
//	}

	/**
	 * This method generate all standard strings into DB
	 */
	private void generateData() {
		this.insertMedicationList();
	} 

	public void insertMedicationList()	{ 
		MedicationList medList = new MedicationList(); 

		Query q = this.entityManager.createQuery("select ml from MedicationList ml ");

		// is table empty
		if (q.getResultList().size() == 0) {
			MedicationListFill.fillMedName();
			MedicationListFill.fillMedDescription();
			
			for (int i = 0; i < MedicationListFill.medListSize; i++) {
				medList.createMedicationList(MedicationListFill.medName.get(i), MedicationListFill.medDescr.get(i));
			}
			this.db.persistObject(medList);
		}
	}

}
