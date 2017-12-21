package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryModel;
import ch.bfh.btx8081.w2017.green.Spero.view.DiaryViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;
import persistence.DiaryEntry;
import persistence.DiaryEntryList;

public class DiaryPresenter implements SperoViewListener {

	DiaryModel diaryModel;
	DiaryViewImpl diaryView;
	
	int numberOfAddedEntry = 0;
	
	public DiaryPresenter(DiaryModel diaryModel, DiaryViewImpl diaryView) {
		this.diaryModel = diaryModel;
		this.diaryView = diaryView;
		diaryView.init();
		diaryView.addListener(this);
		
		this.numberOfAddedEntry = 0;
	}

	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();

		switch (buttonId) {
		case "refreshButton":
			DiaryEntryList list = diaryModel.getDiaryList();
			
			while(numberOfAddedEntry < list.getDiaryList().size()) {
				DiaryEntry diaryEntry = list.getDiaryList().get(numberOfAddedEntry);
				String title = diaryEntry.getTitle();
				String text = diaryEntry.getText();
				Mood moodParam = diaryEntry.getMoodparam();
				
				diaryView.addEntryToView(title, text, moodParam);
				numberOfAddedEntry++;
			}
			
			break;
		case "menuButton":
			diaryView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
			break;
			
		case "sosButton":
			diaryView.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
			break;
	
		case "chatButton":
			diaryView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
			break;
		case "newButton":
			diaryView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
			break;
		}
	}
}
