package ch.bfh.btx8081.w2017.green.Spero.model;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;

public class SettingsModel {
	
	private String username;
	private String reminder;
	private String snooze;
	private String chat;
	
    // constructor
    public SettingsModel(String username, String reminder, String snooze, String chat) {
    	this.username = username;
    	this.reminder = reminder;
    	this.snooze = snooze;
    	this.chat = chat;
    }
    
    public void checkSnooze(String snooze) 
    	throws IncorrectException {
    	 if (snooze.length() > 3 ) {
     		throw new IncorrectException("Bei der Snooze Zeit dürfen nicht mehr als 999 Minuten notiert werden.");
    	 } else if (snooze.isEmpty()) {
    		 throw new IncorrectException("Die Snooze Zeit darf nicht leer sein.");
    	 }
    	try {
    		Integer.parseInt(snooze.substring(0));
    	}
    	catch (Exception e) {
    		throw new IncorrectException("Bei der Snooze Zeit dürfen nur Zahlen notiert werden.");
    	}
    }
    
}
