package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.view.SosView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class SosPresenter implements SperoViewListener {
	private SosView sosView;
	
	public SosPresenter(SosView sosView) {
		this.sosView = sosView;
		sosView.init();
		sosView.addListener(this);
	}
// test
	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();
		
		switch(buttonId) {
		case "menuButton":
			sosView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
			break;
		case "chatButton":
			sosView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
			break;
	}
	}
}
