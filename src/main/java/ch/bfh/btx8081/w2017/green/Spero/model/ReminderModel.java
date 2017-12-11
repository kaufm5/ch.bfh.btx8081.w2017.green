package ch.bfh.btx8081.w2017.green.Spero.model;

import java.awt.Toolkit;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Timer;

public class ReminderModel {

	static Timer timer;
	private String date;
	private String time;
	private int day;
	private int month;
	private int year;
	private int hour;
	private int minute;
	private int repeatIntervalTime;
	private String currentDate;
	private String newDate;
	private DateFormat df;
	
	public ReminderModel(String time){
		this.time = time;
		
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal2.set(cal2.YEAR, 2017);
		if(cal2.YEAR == 2017){
			System.out.println("yes");
		}
		
		 if(time.length() == 5){
        	 hour = Integer.parseInt(time.substring(0,1));
        	 minute = Integer.parseInt(time.substring(3,4));
        	 
        	 cal2.set(year, month, day, hour, minute);
    	     currentDate =df.format(cal.getTime());
    	     newDate = df.format(cal2.getTime());
    	     
    	     if(currentDate.equals(newDate)){
    	    	 TimerTask1(repeatIntervalTime);
    	     }else{
    	    	 System.out.println("Timer nicht gestartet");
    	     }
         }
    	     else{
    	    	 System.out.println("falsche Zeit");
    	     }
		 
	}
	
	public void TimerTask1(int seconds) {
		timer = new Timer();
		timer.schedule(new ReminderTask(),0, seconds * 1000);
	}
	
}
