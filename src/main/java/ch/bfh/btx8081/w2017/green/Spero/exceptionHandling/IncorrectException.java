package ch.bfh.btx8081.w2017.green.Spero.exceptionHandling;

/**
 * the IncorrectException class
 * @author mirjam
 *
 */
public class IncorrectException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * throws an exception and shows a message, why the exception is thrown
	 * @param message
	 */
	public IncorrectException(String message){
		super(message);
	}

}