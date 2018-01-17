package ch.bfh.btx8081.w2017.green.Spero.exceptionHandling;

/**
 * A Class which handles the medication which are not found 
 * 
 * @author mussi
 *
 */
public class MedicationNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a medication not found exception.
	 * 
	 * @param message - the error message
	 * 
	 */
	public MedicationNotFoundException(String message) { 
		super(message) ; 

	}

	public void printException() { 
		System.out.println(this.getMessage());
	}
}

