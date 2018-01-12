package ch.bfh.btx8081.w2017.green.Spero.model;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;

public class PinModel {
	private String pin = "1234";
	
    public PinModel(String pin) {
    	this.setPin(pin);
    }
    
    public void checkPin(String pin)
    		throws IncorrectException {
    	String str = "1234";
    	if (!pin.equals(str)) {
    		throw new IncorrectException("PIN ist nicht korrekt!");
    	} else {
    		System.out.println("PIN ist korrekt");
    	}
    }

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
    
}