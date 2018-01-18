package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;

import ch.bfh.btx8081.w2017.green.Spero.exceptionHandling.MedicationNotFoundException;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.MedicationModel;
import ch.bfh.btx8081.w2017.green.Spero.persistence.Medication;
import ch.bfh.btx8081.w2017.green.Spero.view.MedicationViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

/**
 * This class presents all the necessary data to the MedicationViewImpl 
 * and handles the click events of the medication view 
 * 
 * @author mussi
 *
 */
public class MedicationPresenter implements SperoViewListener{

	private static final long serialVersionUID = 1L;

	private MedicationViewImpl medView;

	private MedicationModel medModel; 

	/**
	 * The class constructor 
	 * 
	 * @param medView - the medication view 
	 * @param medModel - the medication model 
	 */
	public MedicationPresenter(MedicationViewImpl medView, MedicationModel medModel) {
		this.medView = medView;
		this.medModel = medModel;

		medView.init();
		medView.addListener(this);
	}

	/**
	 * Method for handling button clicks to navigate to a new view via URL 
	 * 
	 * @param event - the click event 
	 */
	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();

		switch(buttonId) {
		case "menuButton":
			medView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
		case "sos":
			medView.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
			break;
		case "chatButton":
			medView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
			break;
		case "searchMedication":
			String search = medView.getText().getValue();
			try {
				Medication med = this.medModel.getMedicationByName(search);
				this.medView.buildMedPanel(med); 

			} catch (MedicationNotFoundException e) {
				Notification.show("Medication not found", "", Notification.Type.HUMANIZED_MESSAGE);
				e.printException();
			}	
			break;
		}
	}
}


