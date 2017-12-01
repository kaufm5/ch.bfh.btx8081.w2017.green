package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import ch.bfh.btx8081.w2017.green.Spero.model.Diary;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryEntry;
import ch.bfh.btx8081.w2017.green.Spero.view.DiaryViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class DiaryPresenter implements ClickListener {
    private final Diary diaryModel;
    private final DiaryViewImpl diaryView;

    public DiaryPresenter(Diary diaryModel, DiaryViewImpl diaryView) {
	this.diaryModel = diaryModel;
	this.diaryView = diaryView;
	diaryView.addListener(this);
    }

    @Override
    public void buttonClick(ClickEvent event) {
	final String buttonId = event.getButton().getId();

	switch (buttonId) {
	case "refreshButton":
	    if (this.diaryModel.getNumberOfDiaryEntries() > 0) {
		final DiaryEntry diaryEntry = this.diaryModel.searchEntry(1);
		final String title = diaryEntry.getDiaryTitle();
		final String text = diaryEntry.getDiaryText();
		final Mood moodParam = diaryEntry.getMoodParam();

		this.diaryView.addEntryToView(title, text, moodParam);
	    }
	    break;
	case "menuButton":
	    this.diaryView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
	    break;
	case "sosButton":
	    this.diaryView.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
	    break;
	case "chatButton":
	    this.diaryView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
	    break;
	case "newButton":
	    this.diaryView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
	    break;
	default:
	    //
	    break;
	}
    }

    public void addEntry(String title, String text) {
    }
}
