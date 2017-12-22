package ch.bfh.btx8081.w2017.green.Spero.model;

import ch.bfh.btx8081.w2017.green.Spero.persistence.DB;
import ch.bfh.btx8081.w2017.green.Spero.persistence.MedicationList;

public class MedInfoModel {
		
		private MedicationList medicationList;
		private DB db; 
		
	public MedInfoModel() {
		this.db = new DB(); 
		this.medicationList = (MedicationList) this.db.getSperoLists("MedicationList").get(0); 
	}

	public void persist(MedicationList medicationList) { 
		db.persistObject(medicationList);
	}

	public MedicationList getMedicationList() {
		return medicationList;
	}

	public void setMedicationList(MedicationList medicationList) {
		this.medicationList = medicationList;
	}	
	
}
