package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Link;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.view.MenuView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class MenuPresenter implements SperoViewListener {
	
	private MenuView menuView;
	
	public MenuPresenter(MenuView menuView) {
		this.menuView = menuView;
		menuView.addListener(this);
	}
// test
	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();
		
		switch(buttonId) {
		case "gefuehlslage":
			menuView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
		    break;
		case "diary":
			menuView.getUI().getNavigator().navigateTo(Views.DIARY_VIEW);
		    break;
		case "report":
			menuView.getUI().getNavigator().navigateTo(Views.REPORT_VIEW);
			break;
		case "reminder":
			//menuView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
		    break;
		case "medInfo":
			menuView.getUI().getPage().setLocation("https://compendium.ch/home/de");
		    break;
		case "depErk":
			//menuView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
		    break;
		case "settings":
			menuView.getUI().getNavigator().navigateTo(Views.SETTINGS_VIEW);
		    break;
		case "sos":
			menuView.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
		    break;
		case "chat":
			menuView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
		    break;
	}
	}

}
