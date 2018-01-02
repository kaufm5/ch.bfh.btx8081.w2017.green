package ch.bfh.btx8081.w2017.green.Spero.persistence;

import java.util.ArrayList;

public class MedicationListFill {
	
	public static ArrayList<String> medName = new ArrayList<>();
	public static ArrayList<String> medDescr = new ArrayList<>();
	
	public static int medListSize = 2;
	
	public MedicationListFill() {
		
	}
	
	public static void fillMedName() { 
		medName.add("Aspirin"); 
		medName.add("Panadol"); 
	}
	
	public static void fillMedDescription() { 
		medDescr.add("ist für Kopfschmerzen"); 
		medDescr.add("ist für Entzündungen und schmerzen"); 
	}
	

}
