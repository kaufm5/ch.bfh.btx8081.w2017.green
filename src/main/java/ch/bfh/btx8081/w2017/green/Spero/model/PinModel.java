package ch.bfh.btx8081.w2017.green.Spero.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;

@Entity
public class PinModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String pin = "1234";
	
    public PinModel(String pin) {
    	this.pin = pin;
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
    
}