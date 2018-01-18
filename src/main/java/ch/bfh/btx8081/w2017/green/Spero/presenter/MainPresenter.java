package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.server.Page;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;

import ch.bfh.btx8081.w2017.green.Spero.exceptionHandling.MoodParamNotFoundException;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryModel;
import ch.bfh.btx8081.w2017.green.Spero.persistence.DiaryEntryList;
import ch.bfh.btx8081.w2017.green.Spero.view.MainViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

/**
 * This class presents all the necessary data to the MainViewImpl and handles
 * the click events of the main view
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
	 * @param mainView
	 *            - the main view
	 * @param mainModel
	 *            - the main model
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
	 * @param event
	 *            - the click event
	 */
	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();

		switch (buttonId) {
		case "menuButton":
			mainView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
			break;
		case "chat":
			mainView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
			break;
		case "sos":
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
			
			// if no MoodParam was selectet, there will be an error when we want to display the DiaryEntrys
			// because of that, a MoodParam is necessary
			if (moodParam == null) {
				try {
					// Notification with default settings for a warning
					Notification notif = new Notification(
					    "Please select a Mood",
					    "",
					    Notification.TYPE_WARNING_MESSAGE);
					notif.setDelayMsec(2000);
					notif.show(Page.getCurrent());
					throw new MoodParamNotFoundException("");
					
				} catch (MoodParamNotFoundException e) {
					e.getMessage();
				}
			} else {
				DiaryEntryList list = mainModel.getDiaryList();
				list.createDiaryEntry(mainView.diaryTitle.getValue(), mainView.diaryText.getValue(), moodParam);
				
				// clear the TextFields
				mainView.diaryTitle.clear();
				mainView.diaryText.clear();
				
				// Navigate to the DiaryViewImpl
				mainView.getUI().getNavigator().navigateTo(Views.DIARY_VIEW);
				break;
			}
		}
	}
}