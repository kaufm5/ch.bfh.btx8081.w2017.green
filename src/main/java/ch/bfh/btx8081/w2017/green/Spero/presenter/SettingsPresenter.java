package ch.bfh.btx8081.w2017.green.Spero.presenter;

import java.util.Observable;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.SettingsModel;
import ch.bfh.btx8081.w2017.green.Spero.view.ChangePinView;
import ch.bfh.btx8081.w2017.green.Spero.view.DefDepressionView;
import ch.bfh.btx8081.w2017.green.Spero.view.MainViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.MedInfoView;
import ch.bfh.btx8081.w2017.green.Spero.view.MenuView;
import ch.bfh.btx8081.w2017.green.Spero.view.ReportView;
import ch.bfh.btx8081.w2017.green.Spero.view.SettingsView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class SettingsPresenter extends Observable implements ClickListener, SperoViewListener {
    
    private final SettingsView settingsView;
    private final SettingsModel settingsModel;
    private final ChangePinView changePinView;
    private final MenuView menuView;
    private final MainViewImpl mainView;
    private final DefDepressionView defDepView;
    private final MedInfoView medInfView;
    private final ReportView reportView;

    public SettingsPresenter(SettingsView settingsView, SettingsModel settingsModel, ChangePinView changePinView,
    		MenuView menuView, MainViewImpl mainView, DefDepressionView defDepView, MedInfoView medInfView,
    		ReportView reportView) {
	this.settingsView = settingsView;
	this.settingsModel = settingsModel;
	this.changePinView = changePinView;
	this.menuView = menuView;
	this.mainView = mainView;
	this.defDepView = defDepView;
	this.medInfView = medInfView;
	this.reportView = reportView;
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
//		String snoozeValue = settingsView.getSnooze();
//		try {
//			settingsModel.checkSnooze(snoozeValue);
//		}
//		catch (IncorrectException e) {
//			settingsView.settingsException.setValue(e.getMessage());
//			break;
//		}
		
		String chatValue = settingsView.getChatValue();
			if (!chatValue.equals("Aus")){
				System.out.println("Ein");
				settingsView.buildChatButton();
				changePinView.buildChatButton();
				menuView.buildChatButton();
				mainView.buildChatButton();
				defDepView.buildChatButton();
				medInfView.buildChatButton();
				reportView.buildChatButton();
				this.setChanged();
				this.notifyObservers();
			} else {
				System.out.println("Aus");
			}
			
		//settingsView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
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