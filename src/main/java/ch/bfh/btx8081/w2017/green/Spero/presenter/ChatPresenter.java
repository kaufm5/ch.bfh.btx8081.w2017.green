package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.view.ChatView;
import ch.bfh.btx8081.w2017.green.Spero.view.MenuView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class ChatPresenter implements SperoViewListener {
private ChatView chatView;
	
	public ChatPresenter(ChatView chatView) {
		this.chatView = chatView;
		chatView.addListener(this);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();
		
		switch(buttonId) {
		case "menuButton":
			chatView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
		    break;
		case "sosButton":
			chatView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
		    break;
		case "attachment":
			//
			break;
		case "send":
			//
		    break;
	}
	}
}
