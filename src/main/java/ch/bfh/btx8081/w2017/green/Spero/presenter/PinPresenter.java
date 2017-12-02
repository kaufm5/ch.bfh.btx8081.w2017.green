package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.PinModel;
import ch.bfh.btx8081.w2017.green.Spero.view.PinView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class PinPresenter implements SperoViewListener {

	private PinView pinView;
	private PinModel pinModel;
	
	public PinPresenter(PinView pinView, PinModel pinModel) {
		this.pinView = pinView;
		this.pinModel = pinModel;
		pinView.addListener(this);
	}
// test
	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();
		
		switch(buttonId) {
		case "gefuehlslage":
			//menuView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
		    break;
		}
	}
	
}
