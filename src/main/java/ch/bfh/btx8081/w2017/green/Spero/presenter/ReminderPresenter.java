package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.ReminderModel;
import ch.bfh.btx8081.w2017.green.Spero.view.ReminderView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class ReminderPresenter implements SperoViewListener{
	
private ReminderView view;
private ReminderModel model;
	
	public ReminderPresenter(ReminderView view, ReminderModel model) {
		this.view = view;
		this.model = model;
		view.init();
		view.addListener(this);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();
		
		switch(buttonId) {
		case "menuButton":
			view.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
		case "moreMedi":
			//view.chooseTime();
		case "sos":
			view.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
		    break;
		case "chat":
			view.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
		    break;
		case "confirmButton":
			model.time.add(view.timeText1.getValue());
			model.time.add(view.timeText2.getValue()); 
			model.time.add(view.timeText3.getValue()); 
			model.time.add(view.timeText4.getValue());

			model.startReminder(view.intervalRemind.getValue(), view.mediName.getValue());
	}
	}

}
