package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import ch.bfh.btx8081.w2017.green.Spero.view.SosView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class SosPresenter implements ClickListener {
    private final SosView sosView;

    public SosPresenter(SosView sosView) {
	this.sosView = sosView;
	sosView.addListener(this);
    }

    @Override
    public void buttonClick(ClickEvent event) {
	final String buttonId = event.getButton().getId();

	switch (buttonId) {
	case "menuButton":
	    this.sosView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
	    break;
	case "chatButton":
	    this.sosView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
	    break;
	default:
	    //
	    break;
	}
    }
}
