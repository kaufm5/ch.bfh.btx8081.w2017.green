package ch.bfh.btx8081.w2017.green.Spero.presenter;

import java.util.Observable;

import com.vaadin.ui.Button.ClickEvent;
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

/**
 * the SettingsPresenter handels the events from the Settings view
 * @author mirjam
 *
 */
public class SettingsPresenter extends Observable implements SperoViewListener {
    
    private final SettingsView settingsView;
    private final SettingsModel settingsModel;
    private final ChangePinView changePinView;
    private final MenuView menuView;
    private final MainViewImpl mainView;
    private final DefDepressionView defDepView;
    private final MedInfoView medInfView;
    private final ReportView reportView;

    /**
     * 
     * @param settingsView
     * @param settingsModel
     * @param changePinView
     * @param menuView
     * @param mainView
     * @param defDepView
     * @param medInfView
     * @param reportView
     */
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
		settingsView.init();
		settingsView.addListener(this);
    }

    /**
     * handels the events, if the user clicks a button
     */
    @Override
    public void buttonClick(ClickEvent event) {
	final String buttonId = event.getButton().getId();

	switch (buttonId) {
	/**
	 * if the user clicks the menu button, the menu view opens
	 */
	case "menuButton":
		settingsView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
	    break;
	/**
	 * if the user clicks the change button, the change PIN view opens    
	 */
	case "change":
	    settingsView.getUI().getNavigator().navigateTo(Views.CHANGE_PIN_VIEW);
	    break;
	/**
	 * checks if no field is empty and then goes back to the menu view    
	 */
	case "ok":
		
		String reminderValue = settingsView.getReminderValue();
		System.out.println(reminderValue);
		
		try {
			settingsModel.checkReminder(reminderValue);
		} catch (IncorrectException e1) {
			settingsView.settingsException.setValue(e1.getMessage());
			break;
		}
		
		if (reminderValue.equals("Ein")) {
			System.out.println("Reminder ist Ein");
			String snoozeValue = settingsView.getSnooze();
			try {
				settingsModel.checkSnooze(snoozeValue);
			}
			catch (IncorrectException e) {
				settingsView.settingsException.setValue(e.getMessage());
				break;
			}	
		} else {
			System.out.println("Reminder ist Aus");
		}
		
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
			
		settingsView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
	    break;
	/**
	 * if the user clicks the sos button, the sos view opens    
	 */
	case "sos":
		settingsView.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
	    break;
	/**
	 * if the user clicks the chat button, the chat view opens    
	 */
	case "chat":
		settingsView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
	    break;
	}
    }

}