package ch.bfh.btx8081.w2017.green.Spero.presenter;

import java.util.Observable;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.SettingsModel;
import ch.bfh.btx8081.w2017.green.Spero.view.SettingsView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class SettingsPresenter extends Observable implements ClickListener, SperoViewListener {
    
    private final SettingsView settingsView;
    private final SettingsModel settingsModel;

    public SettingsPresenter(SettingsView settingsView, SettingsModel settingsModel) {
	this.settingsView = settingsView;
	this.settingsModel = settingsModel;
	settingsView.addListener(this);
    }

    @Override
    public void buttonClick(ClickEvent event) {
	final String buttonId = event.getButton().getId();

	switch (buttonId) {
	case "menuButton":
		settingsView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
	    break;
	case "change":
	    settingsView.getUI().getNavigator().navigateTo(Views.CHANGE_PIN_VIEW);
	    break;
	case "ok":
		String snoozeValue = settingsView.getSnooze();
		try {
			settingsModel.checkSnooze(snoozeValue);
		}
		catch (IncorrectException e) {
			settingsView.settingsException.setValue(e.getMessage());
			break;
		}
		
//		String chatValue = settingsView.getChatValue();
//			if (chatValue.equals("Ein")){
//				this.setChanged();
//				this.notifyObservers();
//			}
			
		settingsView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
	    break;
	case "sos":
		settingsView.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
	    break;
	case "chat":
		settingsView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
	    break;
	}
    }

}