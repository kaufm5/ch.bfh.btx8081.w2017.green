package ch.bfh.btx8081.w2017.green.Spero.model;

import ch.bfh.btx8081.w2017.green.Spero.exceptionHandling.MedicationNotFoundException;
import ch.bfh.btx8081.w2017.green.Spero.persistence.DB;
import ch.bfh.btx8081.w2017.green.Spero.persistence.Medication;
import ch.bfh.btx8081.w2017.green.Spero.persistence.MedicationList;

/**
 * This is the medication model which holds a list of the medication and its description in the database
 * 
 * @author mussi
 *
 */
public class MedicationModel {

	private static final DB DATABASE_MANAGER = DB.getInstance();

	private MedicationList mediList;

	/**
	 * Class constructor 
	 */
	public MedicationModel() {
		this.takeListFromDB();
	}

	/**
	 * A method which takes the medication list from the database 
	 */
	public void takeListFromDB() {

		if (MedicationModel.DATABASE_MANAGER.getSperoLists("MedicationList").size() == 0) {
			this.mediList = new MedicationList();

			mediList.createMedication("Aspirin", "Für Kopfschmerzen");
			mediList.createMedication("Panadol", "Für Inflammationen und schmerminderung");
			mediList.createMedication("Agomelatin", "ist ein Antidepressivum und wirkt indem es die Signalübertragung der melatonergen MT1- und MT2-Rezeptoren stimuliert und die serotonergen 5HT2C-Rezeptoren hemmt, auf diese Weise soll der circadiane Rhythmus resynchronisiert werden können");
			mediList.createMedication("Alutan", "Wirkstoff: Citalopram \r\n Wirkung auf Organismus als: Antidepressivum\r\n Medikament ist zugelassen und wird verkauft in der Schweiz (?).\r\n Indikation: Einsatz bei Depression, depressiven Störungen");
			mediList.createMedication("Amioxid", "Wirkstoff: Amitriptylinoxid (das Dihydrat von Amitriptylinoxid ist pharmakodynamisch das Arzneimittel Amitriptylin); das Medikament gehört zur Wirkstoffgruppe der trizyklischen Antidepressiva.\r\n Wirkung als: Antidepressivum.\r\n Medikament (gehört zu den Psychopharmaka) ist zugelassen und wird verkauft in Deutschland.\r\n \r\n Indikation: Einsatz bei Depression, depressiven Störungen.");
			mediList.createMedication("Cipralex", "Wirkstoff Escitalopram; Wirkstoffgruppe: Antidepressiva \r\n Wirkweise auf das Nervensystem / die Psyche: antidepressiv \r\n Arzneimittel ist zugelassen in Österreich, der Schweiz und in Deutschland.\r\n \r\n Medikament ist angezeigt bei Depression und verschiedenen Angststörungen.");
			mediList.createMedication("Deprilept", "Wirkstoff : Maprotilin \r\n Wirkung auf die Psyche als: Antidepressivum \r\n Medikament ist zugelassen und wird verkauft in Deutschland.\r\n Indikation, Anwendung bei: Depressionen.");
			mediList.createMedication("Dutonin", "Wirkstoff, Wirkstoffgruppe: Nefazodon \r\n Wirkung auf den Organismus als: Antidepressivum / Antidepressiva\r\n Arzneimittel ist zugelassen in Österreich. (Nicht mehr auf dem Markt)\r\n \r\n Mögliche Nebenwirkungen: Erfahrungen mit Dutonin in Langzeitanwendung sind noch sehr beschränkt. Erkenntnisse bis jetzt: \r\n \r\n Häufig bei Dutonin : Schläfrigkeit, Brechreiz, Schwindel, Mundtrockenheit, verschwommenes Sehen, andere Sehstörungen. ");
		} 
		else {
			this.mediList = (MedicationList) MedicationModel.DATABASE_MANAGER
					.getSperoLists("MedicationList").get(0);
		}
	}

	/**
	 * Gets the medication list 
	 * 
	 * @return medication list 
	 */
	public MedicationList getMediList() {
		return mediList;
	}

	/**
	 * Sets the medication list 
	 * 
	 * @param mediList - the medication list 
	 */
	public void setMediList(MedicationList mediList) {
		this.mediList = mediList;
	}

	/**
	 * A method which searches the medication by its name from the medication list  
	 * 
	 * @param search - the searched medication name  
	 * @return medication name and medication description 
	 */
	public Medication getMedicationByName(String search) throws MedicationNotFoundException {

		for(Medication med : this.mediList.getMedicationList()) {

			if(med.getMedName().equals(search)) {
				return med;
			}
		}
		throw new MedicationNotFoundException("Medication not found"); 
	}
}
