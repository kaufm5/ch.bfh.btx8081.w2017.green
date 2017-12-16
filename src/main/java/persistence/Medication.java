package persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medication implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int medicationID;
	private String medName; 
	private String medDescription; 

	public Medication() {

	}

	public Medication(String medName, String medDescription) {
		this.medName = medName; 
		this.medDescription = medDescription; 
	}

	public int getMedicationID() {
		return medicationID;
	}

	public void setMedicationID(int medicationID) {
		this.medicationID = medicationID;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public String getMedDescription() {
		return medDescription;
	}

	public void setMedDescription(String medDescription) {
		this.medDescription = medDescription;
	}

		

}
