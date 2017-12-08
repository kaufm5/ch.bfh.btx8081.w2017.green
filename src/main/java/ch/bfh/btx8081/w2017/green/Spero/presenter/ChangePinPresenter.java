package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.ChangePinModel;
import ch.bfh.btx8081.w2017.green.Spero.view.ChangePinView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class ChangePinPresenter implements ClickListener, SperoViewListener {
	
	private final ChangePinView changePinView;
    private final ChangePinModel changePinModel;

    public ChangePinPresenter(ChangePinView changePinView, ChangePinModel changePinModel) {
	this.changePinView = changePinView;
	this.changePinModel = changePinModel;
	changePinView.addListener(this);
    }

	@Override
	public void buttonClick(ClickEvent event) {
		final String buttonId = event.getButton().getId();

		switch (buttonId) {
		case "ok":
			String oldPin = changePinView.getOldPin();
			String newPin1 = changePinView.getNewPin1();
			String newPin2 = changePinView.getNewPin2();
			try {
				changePinModel.checkOldPin(oldPin);
				changePinModel.checkNewPin(newPin1, newPin2);
			} catch (IncorrectException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    changePinView.getUI().getNavigator().navigateTo(Views.SETTINGS_VIEW);
		    break;
		case "sos":
			changePinView.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
		    break;
		case "chat":
			changePinView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
		    break;
		}
	}

}