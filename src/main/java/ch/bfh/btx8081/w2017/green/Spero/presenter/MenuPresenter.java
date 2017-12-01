package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import ch.bfh.btx8081.w2017.green.Spero.view.MenuView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class MenuPresenter implements ClickListener {
    private final MenuView menuView;

    public MenuPresenter(MenuView menuView) {
	this.menuView = menuView;
	menuView.addListener(this);
    }

    @Override
    public void buttonClick(ClickEvent event) {
	final String buttonId = event.getButton().getId();

	switch (buttonId) {
	case "gefuehlslage":
	    this.menuView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
	    break;
	case "diary":
	    this.menuView.getUI().getNavigator().navigateTo(Views.DIARY_VIEW);
	    break;
	case "report":
	    this.menuView.getUI().getNavigator().navigateTo(Views.REPORT_VIEW);
	    break;
	case "reminder":
	    // menuView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
	    break;
	case "medInfo":
	    // menuView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
	    break;
	case "depErk":
	    // menuView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
	    break;
	case "settings":
	    this.menuView.getUI().getNavigator().navigateTo(Views.SETTINGS_VIEW);
	    break;
	case "sos":
	    this.menuView.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
	    break;
	case "chat":
	    this.menuView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
	    break;
	default:
	    //
	    break;
	}
    }
}
