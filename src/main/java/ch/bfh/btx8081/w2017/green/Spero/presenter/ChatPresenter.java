package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import ch.bfh.btx8081.w2017.green.Spero.view.ChatView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class ChatPresenter implements ClickListener {
    private final ChatView chatView;

    public ChatPresenter(ChatView chatView) {
	this.chatView = chatView;
	chatView.addListener(this);
    }

    @Override
    public void buttonClick(ClickEvent event) {
	final String buttonId = event.getButton().getId();

	switch (buttonId) {
	case "menuButton":
	    this.chatView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
	    break;
	case "sosButton":
	    this.chatView.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
	    break;
	case "attachment":
	    //
	    break;
	case "send":
	    //
	    break;
	default:
	    //
	    break;
	}
    }
}
