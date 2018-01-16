package ch.bfh.btx8081.w2017.green.Spero.model;

import ch.bfh.btx8081.w2017.green.Spero.persistence.DB;
import ch.bfh.btx8081.w2017.green.Spero.persistence.MedicationList;

/**
 * This is the medication information model which holds a list of the medication in the database
 * 
 * @author mussi
 *
 */
public class MedicationModel {
	private static final DB DATABASE_MANAGER = DB.getInstance();

	private MedicationList mediList;

	public MedicationModel() {
		this.takeListFromDB();
	}

	public void takeListFromDB() {
		if (MedicationModel.DATABASE_MANAGER.getSperoLists("MedicationList").size() == 0) {
			this.mediList = new MedicationList();
			
			mediList.createMedication("Agomelatin", "ist ein Antidepressivum und wirkt indem es die Signalübertragung der melatonergen MT1- und MT2-Rezeptoren stimuliert und die serotonergen 5HT2C-Rezeptoren hemmt, auf diese Weise soll der circadiane Rhythmus resynchronisiert werden können. Hersteller ist Servier. Die Handelsnamen sind Valdoxan, Thymanax. Das Medikament ist dem Melatonin chemisch verwandt. Es wird bei Major Depression Episoden bei Erwachsenen angewendet.");
			mediList.createMedication("Amineurin", "Der Wirkstoff ist Amitriptylin, welches ein trizyklisches Antidepressivum ist.\r\n" + "Wirkt auf den Organismus, als: Antidepressivum. Die Anwendungsgebiete sind chronische Schmerzen (Spannungskopfschmerz, Migräne, Fibromyalgie) und Depressionen.\r\n");
			mediList.createMedication("Amioxid", "Wirkstoff: Amitriptylinoxid (das Dihydrat von Amitriptylinoxid ist pharmakodynamisch das Arzneimittel Amitriptylin); das Medikament gehört zur Wirkstoffgruppe der trizyklischen Antidepressiva.\r\n" + "Wirkung als: Antidepressivum.");
			mediList.createMedication("Apimostinel", "Apimostinel (ehemaliger Entwicklungscodename NRX-1074) ist ein neuartiges Antidepressivum. Das Medikament wirkt als selektiver partieller Agonist indem es an einem allosterischen Ort der Glycin-Site des NMDA-Rezeptorkomplexes fungiert. Das Medikament wird von Naurex (kürzlich von Allergan übernommen) untersucht und zur Behandlung von schweren depressiven Störungen eingesetzt.");
			mediList.createMedication("", "");
			mediList.createMedication("", "");
			mediList.createMedication("", "");
			mediList.createMedication("", "");
			mediList.createMedication("", "");


			DATABASE_MANAGER.persistObject(mediList);
		} 
		else {
			this.mediList = (MedicationList) MedicationModel.DATABASE_MANAGER
					.getSperoLists("MedicationList").get(0);

		}
	}

	public MedicationList getMediList() {
		return mediList;
	}

	public void setMediList(MedicationList mediList) {
		this.mediList = mediList;
	}

}
