package ch.bfh.btx8081.w2017.green.Spero.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.btx8081.w2017.green.Spero.exceptionHandling.MedicationNotFoundException;

/**
 * JUnit test for the MedicationModel class 
 * 
 * @author mussi
 *
 */
public class MedicationModelTest {
	MedicationModel model; 
	
	/**
	 * Initializes the medication model 
	 */
	@Before
	public void setup() { 
		this.model = new MedicationModel();
	}
	
	/**
	 * Tests the GetMedicationByName method 
	 * 
	 * @throws MedicationNotFoundException - if medication name not found 
	 */
	@Test
	public void testGetMedicationByName() throws MedicationNotFoundException {
		assertEquals("Aspirin", model.getMedicationByName("Aspirin").getMedName());
	}
	
	/**
	 * Tests if an exception is thrown
	 * 
	 * @throws MedicationNotFoundException - if medication name is not found 
	 */
	@Test(expected = MedicationNotFoundException.class)
	public void testMedicationNotFoundException() throws MedicationNotFoundException {
		assertEquals("Ogmantin", model.getMedicationByName("Ogmantin").getMedName());
	}


}
