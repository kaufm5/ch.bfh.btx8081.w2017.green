
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

/**
 * This class has all necessary medication from the database in a list 
 * 
 * @author mussi
 *
 */
@Entity
@NamedQuery(name = "MedicationList", query = "select m from MedicationList m")
public class MedicationList {

	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int medID;

	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<Medication> medicationList = new ArrayList<Medication>(); 

	/**
	 * An empty constructor 
	 */
	public MedicationList() {

	}

	/**
	 * Adds a new medication to the medication list and persist it 
	 * 
	 * @param medName - the medication name 
	 * @param medDescription - the medication description 
	 */
	public void createMedication(String medName, String medDescription) { 
		Medication med = new Medication(medName, medDescription);
		medicationList.add(med); 

		DB.getInstance().persistObject(this);
	}
	
	/**
	 * Gets the medication id 
	 * 
	 * @return - the medication id 
	 */
	public int getMedID() {
		return medID;
	}
	
	/**
	 * Sets the medication id 
	 * 
	 * @param medID - the medication id 
	 */
	public void setMedID(int medID) {
		this.medID = medID;
	}
	
	/**
	 * Gets the list of all the medications from the database 
	 * 
	 * @return the medication list 
	 */
	public List<Medication> getMedicationList() {
		return medicationList;
	}
	
	/**
	 * Sets a new medication list 
	 * 
	 * @param medicationList - the medication list  
	 */
	public void setMedicationList(List<Medication> medicationList) {
		this.medicationList = medicationList;
	}



}
