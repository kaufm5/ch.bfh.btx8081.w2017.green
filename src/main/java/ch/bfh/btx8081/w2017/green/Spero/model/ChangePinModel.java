package ch.bfh.btx8081.w2017.green.Spero.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;
import ch.bfh.btx8081.w2017.green.Spero.persistence.DB;

/**
 * the changePinModel
 * checks if the Pins are correctly
 * @author mirjam
 *
 */
public class ChangePinModel {
	//private static final DB DATABASE_MANAGER = DB.getInstance();
	
	private String oldPin;
	private String newPin1;
	private String newPin2;
	
	/**
	 * the constructor of ChangePinModel
	 * @param oldPin
	 * @param newPin1
	 * @param newPin2
	 */
    public ChangePinModel(String oldPin, String newPin1, String newPin2) {
    	this.oldPin = oldPin;
    	this.newPin1 = newPin1;
    	this.newPin2 = newPin2;
    }
    
    /**
     * checks if the pin equals the saved pin
     * @param the field input of the user in the field oldPin
     * @throws IncorrectException
     */
    public void checkOldPin(String oldPin)
    		throws IncorrectException {
    	String str = "1234";
    	if (!oldPin.equals(str)) {
    		throw new IncorrectException("Die Änderungen können nicht vorgenommen werden, da der alte PIN" +
    				" falsch eingegeben wurde.");
    	} else {
    		System.out.println("oldPin korrekt");
    	}
    }
    
    /**
     * Checks if the user did the input correctly
     * if the first and the second input are the same
     * if the pin is not empty
     * if the pin has a length of 4
     * and if there are only numbers
     * @param the first field of the newPin from the input of the user
     * @param the second field of the newPin from the input of the user
     * @throws IncorrectException
     */
    public void checkNewPin(String newPin1, String newPin2) throws IncorrectException {
    	
    	if (!newPin2.equals(newPin1)) {
    		throw new IncorrectException("Die beiden neuen PINs stimmen nicht überein.");
    	} else if (newPin1.isEmpty()==true){
    		throw new IncorrectException("Der PIN darf nicht leer sein.");
    	} else if (newPin1.length() !=4) {
    		throw new IncorrectException("Der PIN hat mehr oder weniger als 4 Ziffern.");
    	} else {
    		System.out.println("newPin korrekt");
    	}
    	
    	try {
    		Integer.parseInt(newPin1.substring(0));
    	}
    	catch (Exception e) {
    		throw new IncorrectException("Der PIN darf nur aus Zahlen bestehen.");
    	}
    	}
    
    /**
     * saves the pin in setting.properties
     */
    public void savePin(String[] args) throws Exception {
    	try {
    		checkOldPin(oldPin);
    		checkNewPin(newPin1, newPin2);
    	} catch (Exception e) {
    		System.out.println(e);
    	}
	
    	//ChangePinModel.DATABASE_MANAGER.persistObject(newPin1);
		//;
		
    	File inFile = new File("setting.properties");
    	Scanner input = new Scanner(inFile);
    	
//		try (ObjectInputStream in = new ObjectInputStream (new FileInputStream(args[0]))) {
//			Message msg = (Message) in.readObject();
//			String text = msg.getText();
//			System.out.println();	
//			} catch (FileNotFoundException e) {}
		//}
	}
    
    }