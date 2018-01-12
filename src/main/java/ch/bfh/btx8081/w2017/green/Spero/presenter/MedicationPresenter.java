package ch.bfh.btx8081.w2017.green.Spero.presenter;

import java.util.List;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.MedicationModel;
import ch.bfh.btx8081.w2017.green.Spero.persistence.Medication;
import ch.bfh.btx8081.w2017.green.Spero.view.MedInfoView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class MedicationPresenter implements SperoViewListener{

	private static final long serialVersionUID = 1L;

	private MedInfoView medView;
	
	private MedicationModel medModel; 
	
	private List<Medication> medList; 

	public MedicationPresenter(MedInfoView medView, MedicationModel medModel) {
		this.medView = medView;
		this.medModel = medModel;
		
		//this.medList = this.medModel.getMediList().getMedicationList();
		
		medView.init();
		medView.addListener(this);
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();

		switch(buttonId) {
		case "menuButton":
			medView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
		case "sosButton":
			medView.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
			break;
		case "chatButton":
			medView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
			break;
		case "searchMedication":
			// 
			//
			break;
		}
	}

}
