package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.Diary;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryEntry;
import ch.bfh.btx8081.w2017.green.Spero.view.DiaryViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class DiaryPresenter implements SperoViewListener {

	Diary diaryModel;
	DiaryViewImpl diaryView;
//test
	public DiaryPresenter(Diary diaryModel, DiaryViewImpl diaryView) {
		this.diaryModel = diaryModel;
		this.diaryView = diaryView;
		diaryView.addListener(this);

	}

	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();

		switch (buttonId) {
		case "refreshButton":

			if (diaryModel.getNumberOfDiaryEntry() > 0) {
				DiaryEntry diaryEntry = diaryModel.searchEntry(1);
				String title = diaryEntry.getTitle();
				String text = diaryEntry.getText();
				Mood moodParam = diaryEntry.getMoodparam();

				diaryView.addEntryToView(title, text, moodParam);

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

	public void addEntry(String title, String text) {

	}

}
