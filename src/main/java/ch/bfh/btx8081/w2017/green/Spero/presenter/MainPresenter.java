package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.Diary;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryEntry;
import ch.bfh.btx8081.w2017.green.Spero.view.MainViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class MainPresenter implements SperoViewListener {

	private MainViewImpl mainView;
	private DiaryEntry model;
	
	private Mood moodParam;

	public MainPresenter(MainViewImpl mainView, DiaryEntry model) {
		this.mainView = mainView;
		this.model = model;
		mainView.addListener(this);
	}


	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();
		
		//TODO add links to other views
		switch(buttonId) {
		case "menuButton":
			mainView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
			break;
		case "chatButton":
			mainView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
			break;
		case "sosButton":
			mainView.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
			break;
		case "smileGut":
			moodParam = Mood.gut;
			break; 
		case "smileEherGut":
			moodParam = Mood.eherGut;
			break;
		case "smileEherSchlecht":
			moodParam = Mood.eherSchlecht;
			break;
		case "smileSchlecht":
			moodParam = Mood.schlecht;
			break;
		case "confirmButton":
			model.setTitle(mainView.diaryTitle.getValue());
			model.setText(mainView.diaryText.getValue());
			model.setTag(mainView.tags.getValue());
			model.confirm();
			//model.createEntry("Title", "Text", moodParam);
			break;
		}
	}
}