package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import ch.bfh.btx8081.w2017.green.Spero.model.Diary;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryEntry;
import ch.bfh.btx8081.w2017.green.Spero.view.MainViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class MainPresenter implements ClickListener {
    private final MainViewImpl mainView;
    private final DiaryEntry model;
    private final Diary diarymodel;

    private Mood moodParam;

    public MainPresenter(MainViewImpl mainView, DiaryEntry model, Diary diarymodel) {
	this.mainView = mainView;
	this.model = model;
	this.diarymodel = diarymodel;
	mainView.addListener(this);
    }

    @Override
    public void buttonClick(ClickEvent event) {
	final String buttonId = event.getButton().getId();

	// TODO add links to other views
	switch (buttonId) {
	case "menuButton":
	    this.mainView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
	    break;
	case "chatButton":
	    this.mainView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
	    break;
	case "sosButton":
	    this.mainView.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
	    break;
	case "smileGut":
	    this.moodParam = Mood.gut;
	    break;
	case "smileEherGut":
	    this.moodParam = Mood.eherGut;
	    break;
	case "smileEherSchlecht":
	    this.moodParam = Mood.eherSchlecht;
	    break;
	case "smileSchlecht":
	    this.moodParam = Mood.schlecht;
	    break;
	case "confirmButton":
	    this.model.setDiaryTitle(this.mainView.diaryTitle.getValue());
	    this.model.setDiaryText(this.mainView.diaryText.getValue());
	    this.model.setTag(this.mainView.tags.getValue());
	    this.model.setMoodParam(this.moodParam);
	    this.model.confirm();
	    this.diarymodel.createEntry("Title", "Text", this.moodParam);
	    this.mainView.getUI().getNavigator().navigateTo(Views.DIARY_VIEW);
	    break;
	default:
	    //
	    break;
	}
    }
}