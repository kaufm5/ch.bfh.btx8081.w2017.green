package ch.bfh.btx8081.w2017.green.Spero.model;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;

/**
 * the PIN Model Class
 * @author mirjam
 *
 */
public class PinModel {
	private String pin = "1234";
	
	/**
	 * 
	 * @param pin
	 */
    public PinModel(String pin) {
    	this.setPin(pin);
    }
    
    /**
     * checks if the input of the pin is correct
     * @param the input pin
     * @throws IncorrectException
     */
    public void checkPin(String pin)
    		throws IncorrectException {
    	String str = "1234";
    	if (!pin.equals(str)) {
    		throw new IncorrectException("PIN ist nicht korrekt!");
    	} else {
    		System.out.println("PIN ist korrekt");
    	}
    }

    /**
     * gets the pin
     * @return the pin
     */
	public String getPin() {
		return pin;
	}

	/**
	 * sets the pin
	 * @param pin
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}
    
}