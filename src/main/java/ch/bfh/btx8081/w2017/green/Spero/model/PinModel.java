package ch.bfh.btx8081.w2017.green.Spero.model;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;

public class PinModel {
	
	private String pin = "1234";
	
    // constructor
    public PinModel(String pin) {
    	this.pin = pin;
    }
    
    public void checkPin(String pin)
    		throws IncorrectException {
    	if (!pin.equals(this.pin)) {
    		throw new IncorrectException("PIN ist ungültig");
    	}
    }
    
}