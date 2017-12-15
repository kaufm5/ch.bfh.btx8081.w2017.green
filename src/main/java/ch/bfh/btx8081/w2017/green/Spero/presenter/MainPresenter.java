package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.Diary;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryModel;
import ch.bfh.btx8081.w2017.green.Spero.view.MainViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;
import persistence.DiaryEntry;
import persistence.DiaryEntryList;

public class MainPresenter implements SperoViewListener  {

	private MainViewImpl mainView;
	private DiaryEntryList mainModel;
	
	private Mood moodParam;
// test
	public MainPresenter(MainViewImpl mainView, DiaryModel mainModel) {
		this.mainView = mainView;
		
		
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
			
			
			
//			model.setTitle(mainView.diaryTitle.getValue());
//			model.setText(mainView.diaryText.getValue());
//			model.setTag(mainView.tags.getValue());
//			model.setMoodparam(moodParam);
		//	model.confirm();
//			diarymodel.createEntry(mainView.diaryTitle.getValue(), mainView.diaryText.getValue(), moodParam);
			mainView.getUI().getNavigator().navigateTo(Views.DIARY_VIEW);
			break;
		}
	}
}