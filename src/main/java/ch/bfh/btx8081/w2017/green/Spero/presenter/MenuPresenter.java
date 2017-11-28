package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.view.MenuView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class MenuPresenter implements SperoViewListener {
	
	private MenuView menuView;
	
	public MenuPresenter(MenuView menuView) {
		this.menuView = menuView;
		menuView.addListener(this);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();
		
		switch(buttonId) {
		case "gefuehlslage":
			menuView.getUI().getNavigator().navigateTo("");
		    break;
		case "report":
			menuView.getUI().getNavigator().navigateTo(Views.REPORT_VIEW);
			break;
	}
	}

}
