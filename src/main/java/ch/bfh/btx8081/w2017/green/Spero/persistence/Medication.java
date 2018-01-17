package ch.bfh.btx8081.w2017.green.Spero.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This is an entity class for medication informations  
 * 
 * @author mussi
 *
 */
@Entity
public class Medication implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int medicationID;

	private String medName; 

	@Column(columnDefinition = "text")
	private String medDescription; 

	/**
	 * An empty class constructor 
	 */
	public Medication() {

	}

	/**
	 * The class constructor 
	 * 
	 * @param medName - the medication name 
	 * @param medDescription - the medication description 
	 */
	public Medication(String medName, String medDescription) {
		this.medName = medName; 
		this.medDescription = medDescription; 
	}

	/**
	 * Gets the medication id   
	 * 
	 * @return the medication id 
	 */
	public int getMedicationID() {
		return medicationID;
	}

	/**
	 * Sets the medication id 
	 *
	 * @param medicationID - the medication id 
	 */
	public void setMedicationID(int medicationID) {
		this.medicationID = medicationID;
	}

	/**
	 * Gets the medication name 
	 * 
	 * @return the medication name 
	 */
	public String getMedName() {
		return medName;
	}

	/**
	 * Sets the medication name 
	 * 
	 * @param medName - the medication name 
	 */
	public void setMedName(String medName) {
		this.medName = medName;
	}

	/**
	 * Gets the medication description 
	 * 
	 * @return the medication description 
	 */
	public String getMedDescription() {
		return medDescription;
	}

	/**
	 * Sets the medication description 
	 * 
	 * @param medDescription - the medication description 
	 */
	public void setMedDescription(String medDescription) {
		this.medDescription = medDescription;
	}
}
