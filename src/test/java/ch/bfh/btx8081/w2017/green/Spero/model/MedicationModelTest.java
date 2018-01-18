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
	 * Tests the getMedicationByName method 
	 * 
	 * @throws MedicationNotFoundException - if medication name not found 
	 */
	@Test
	public void testGetMedicationByName() throws MedicationNotFoundException {
		assertEquals("Aspirin", model.getMedicationByName("Aspirin").getMedName());
	}

	/**
	 * Tests the getMedicationByName method with null 
	 * 
	 * @throws MedicationNotFoundException - if no name is inputted 
	 */
	@Test (expected = MedicationNotFoundException.class)
	public void testGetMedicationWithNull() throws MedicationNotFoundException {
		model.getMedicationByName(null);
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
