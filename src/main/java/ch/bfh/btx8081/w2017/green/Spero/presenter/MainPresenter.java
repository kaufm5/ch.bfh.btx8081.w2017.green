package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryModel;
import ch.bfh.btx8081.w2017.green.Spero.persistence.DiaryEntryList;
import ch.bfh.btx8081.w2017.green.Spero.view.MainViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

/**
 * This class presents all the necessary data to the MainViewImpl 
 * and handles the clicks of the main view 
 * 
 * @author mussi & schmt5
 */
public class MainPresenter implements SperoViewListener {

	private static final long serialVersionUID = 1L;
	
	private MainViewImpl mainView;
	private DiaryModel mainModel;

	private Mood moodParam;

	/**
	 * Class constructor 
	 * 
	 * @param mainView - the main view
	 * @param mainModel - the main model 
	 */
	public MainPresenter(MainViewImpl mainView, DiaryModel mainModel) {
		this.mainView = mainView;
		this.mainModel = mainModel;
		mainView.init();
		mainView.addListener(this);
	}

	/**
	 * Method for handling button clicks to navigate to a new view via URL 
	 * 
	 * @param event - the click event 
	 */
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
			list.createDiaryEntry(mainView.diaryTitle.getValue(), mainView.diaryText.getValue(), moodParam);

			mainView.diaryTitle.clear();
			mainView.diaryText.clear();
			mainView.getUI().getNavigator().navigateTo(Views.DIARY_VIEW);
			break;
		}
	}
}