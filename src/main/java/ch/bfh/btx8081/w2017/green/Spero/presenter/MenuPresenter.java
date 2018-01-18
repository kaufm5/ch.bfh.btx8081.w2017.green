package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.MenuModel;
import ch.bfh.btx8081.w2017.green.Spero.view.MenuView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

/**
 * connects the view with the model
 * handles the events
 * @author mirjam
 *
 */
public class MenuPresenter implements SperoViewListener {

	private static final long serialVersionUID = 1L;
	private MenuView menuView;
	private MenuModel menuModel;
	
	/**
	 * creates the menuPresenter
	 * @param menuView
	 * @param menuModel
	 */
	public MenuPresenter(MenuView menuView, MenuModel menuModel) {
		this.menuView = menuView;
		this.menuModel = menuModel;
		menuView.init();
		menuView.addListener(this);
	}

	/**
	 * handles the events from the MenuView class
	 */
	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();
		
		switch(buttonId) {
		
		//opens the mainView if the user clicks the gefühlslage button
		case "gefuehlslage":
			menuView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
		    break;
		    
		//opens the diaryView if the user clicks the diary button    
		case "diary":
			menuView.getUI().getNavigator().navigateTo(Views.DIARY_VIEW);
		    break;
		    
		//opens the reportView if the user clicks the report button    
		case "report":
			menuView.getUI().getNavigator().navigateTo(Views.REPORT_VIEW);
			break;
			
		//opens the reminderView if the user clicks the reminder button	
		case "reminder":
			menuView.getUI().getNavigator().navigateTo(Views.REMINDER_VIEW);
		    break;
		    
		//opens the medInfoView if the user clicks the medication information button    
		case "medInfo":
			menuView.getUI().getNavigator().navigateTo(Views.MEDICATION_INFORMATION_VIEW);
		    break;
		    
		//opens the depErkView if the user clicks the definition depression button    
		case "depErk":
			menuView.getUI().getNavigator().navigateTo(Views.DEFINITION_DEPRESSION_VIEW);
		    break;
		    
		//opens the settingsView if the user clicks the settings button    
		case "settings":
			menuView.getUI().getNavigator().navigateTo(Views.SETTINGS_VIEW);
		    break;
		    
		//opens the sosView if the user clicks the sos button
		case "sos":
			menuView.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
		    break;
		    
		//opens the chatView if the user clicks the chat button    
		case "chat":
			menuView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
		    break;
		}
	}

}
