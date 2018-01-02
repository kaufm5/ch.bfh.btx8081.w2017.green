package ch.bfh.btx8081.w2017.green.Spero.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "MedicationList", query = "select m from MedicationList m")
public class MedicationList {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int medID;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<Medication> medicationList = new ArrayList<>(); 
	
	
	public MedicationList() {
		
	}
	
	public void createMedicationList(String medName, String medDescription) { 
		Medication med = new Medication(medName, medDescription); 
		medicationList.add(med); 
	}

	public int getMedID() {
		return medID;
	}

	public void setMedID(int medID) {
		this.medID = medID;
	}

	public List<Medication> getMedicationList() {
		return medicationList;
	}

	public void setMedicationList(List<Medication> medicationList) {
		this.medicationList = medicationList;
	}
	
	

}
