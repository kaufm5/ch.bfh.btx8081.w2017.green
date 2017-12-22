package ch.bfh.btx8081.w2017.green.Spero.model;

import java.awt.Toolkit;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;

public class ReminderModel {

	static Timer timer;
	private String name;
	public ArrayList<String> time = new ArrayList<String>();
	private int day;
	private int month;
	private int year;
	private int hour;
	private int minute;
	private int repeatIntervalTime;
	private String currentDate;
	private String newDate;
	private DateFormat df;
	
	Calendar cal = Calendar.getInstance();
	
	public ReminderModel(){ }
	
	public void startReminder(String intervall, String name){
		
		repeatIntervalTime = Integer.parseInt(intervall);
		this.name = name;
		
		df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		setYear(cal.getTimeInMillis());
		setMonth(cal.getTimeInMillis());
		setDay(cal.getTimeInMillis());

		for(int i=0; i<time.size(); i++){
			if(time.get(i).length() == 5){
	        	 hour = Integer.parseInt(time.get(i).substring(0,2));
	        	 minute = Integer.parseInt(time.get(i).substring(3, 5));
	        	 cal2.set(getYear(), getMonth(), getDay(), hour, minute);
	    	     currentDate =df.format(cal.getTime());
	    	     newDate = df.format(cal2.getTime());
	    	     
	    	     if(currentDate.equals(newDate)){
	    	    	 if(cal.get(Calendar.HOUR) == cal2.get(Calendar.HOUR) && cal.get(Calendar.MINUTE)==cal2.get(Calendar.MINUTE)){
	    	    		 TimerTask1(repeatIntervalTime);
	    	    	 }
	    	     }else{
	    	    	 System.out.println("Timer nicht gestartet");
	    	    }
			 }else{
	    	    	 System.out.println("falsche Zeit");
	    	 }
		}
	}
	
	public void setYear(Long millis){
		cal.setTimeInMillis(millis);;
		year = cal.get(Calendar.YEAR);
	}
	
	public int getYear(){
		return year;
	}
	
	public void setMonth(Long millis){
		cal.setTimeInMillis(millis);
		month = cal.get(Calendar.MONTH); 
		
	}
	
	public int getMonth(){
		return month;
	}
	
	public void setDay(Long millis){
		cal.setTimeInMillis(millis);
		day = cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getDay(){
		return day;
	}
	
	public void TimerTask1(int seconds) {
		timer = new Timer();
		timer.schedule(new ReminderTask(name),0, seconds * 1000);
	}
	
}
