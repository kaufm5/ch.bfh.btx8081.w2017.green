package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryModel;
import ch.bfh.btx8081.w2017.green.Spero.view.MainViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;
import persistence.DiaryEntry;
import persistence.DiaryEntryList;

public class MainPresenter implements SperoViewListener {

	private MainViewImpl mainView;
	private DiaryModel mainModel;

	private Mood moodParam;

	public MainPresenter(MainViewImpl mainView, DiaryModel mainModel) {
		this.mainView = mainView;
		this.mainModel = mainModel;

		mainView.addListener(this);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();

		switch (buttonId) {
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
			DiaryEntryList list = mainModel.getDiaryList();
			System.out.println(moodParam);
			list.createDiaryEntry(mainView.diaryTitle.getValue(), mainView.diaryText.getValue(), moodParam);
			mainModel.persist(list);

			mainView.diaryTitle.clear();
			mainView.diaryText.clear();

			mainView.getUI().getNavigator().navigateTo(Views.DIARY_VIEW);
			break;
		}
	}
}