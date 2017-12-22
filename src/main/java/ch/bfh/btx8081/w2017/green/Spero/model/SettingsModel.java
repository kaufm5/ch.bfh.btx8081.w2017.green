package ch.bfh.btx8081.w2017.green.Spero.model;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;
import ch.bfh.btx8081.w2017.green.Spero.persistence.DB;

public class SettingsModel {
	
	private String username;
	private String reminder;
	private String snooze;
	private String chat;
	
	private DB db;
	
    // constructor
    public SettingsModel(String username, String reminder, String snooze, String chat) {
    	this.username = username;
    	this.reminder = reminder;
    	this.snooze = snooze;
    	this.chat = chat;
    }
    
    public void persist(String username, String reminder, String snooze, String chat) {
		db.persistObject(username);
		db.persistObject(reminder);
		db.persistObject(snooze);
		;
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
    
    public void checkReminder(String reminder) throws IncorrectException {
    	if (reminder.equals(null)) {
    		throw new IncorrectException("Reminder Value darf nicht leer sein.");
    	}
    }
    
}
