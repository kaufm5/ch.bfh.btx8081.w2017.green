package ch.bfh.btx8081.w2017.green.Spero.model;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;

public class ChangePinModel {
	
	private String oldPin;
	private String newPin1;
	private String newPin2;
	
	 // constructor
    public ChangePinModel(String oldPin, String newPin1, String newPin2) {
    	this.oldPin = oldPin;
    	this.newPin1 = newPin1;
    	this.newPin2 = newPin2;
    }
    
    public void checkOldPin(String oldPin)
    		throws IncorrectException {
    	if (!oldPin.equals(this.oldPin)) {
    		throw new IncorrectException("Die Änderungen können nicht vorgenommen werden, da der alte PIN" +
    				" falsch eingegeben wurde.");
    	}
    }
    
    public void checkNewPin(String newPin1, String newPin2)
    	throws IncorrectException {
    	if (!newPin2.equals(newPin1)) {
    		throw new IncorrectException("Die beiden neuen PINs stimmen nicht überein.");
    	}
    }

}