package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.server.Page;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryModel;
import ch.bfh.btx8081.w2017.green.Spero.persistence.DiaryEntry;
import ch.bfh.btx8081.w2017.green.Spero.persistence.DiaryEntryList;
import ch.bfh.btx8081.w2017.green.Spero.view.DiaryViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

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
			
			this.refresh();
			break;
			
		case "menuButton":
			diaryView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
			break;
			
		case "sos":
			diaryView.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
			break;
	
		case "chat":
			diaryView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
			break;
		case "newButton":
			diaryView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
			break;
		
		// In the default the buttonId has to be a buttonId of a delete button in a panel.
		// Because this buttonId is the Primary Key of the specific DiaryEntry as well. We can Parse the buttonId to a Integer.
		// The Primary Key can be used to search the DiaryEntry, which should be deletet. 	
		default:
			int diaryID = Integer.parseInt(buttonId);
			DiaryEntryList list2 = diaryModel.getDiaryList();
			list2.deleteDiaryEntry(diaryID);
			
			// We need to relod the page to set the changes. 
			Page.getCurrent().reload();
			
			Notification.show("Eintrag wurde gelöscht",
	                  "",
	                  Notification.Type.HUMANIZED_MESSAGE);
			break;
		}
	}
	
	// This Method is calling, when the refresh button was clicked
	// Just DiaryEntry, which are not displayed yet, will be created. 
	private void refresh() {
		
		DiaryEntryList list = diaryModel.getDiaryList();
		
		// We will addEntryToView as long as the numberOfAddedEntry is less than the size of the DiaryList.
		// Are allready two DiaryEntry displayed (0,1). It will start with the third DiaryEntry (2)
		while(numberOfAddedEntry < list.getDiaryList().size()) {
			DiaryEntry diaryEntry = list.getDiaryList().get(numberOfAddedEntry);
			String title = diaryEntry.getTitle();
			String text = diaryEntry.getText();
			Mood moodParam = diaryEntry.getMoodparam();
			int diaryID = diaryEntry.getDiaryEntryNumber();
			
			diaryView.addEntryToView(diaryID,title, text, moodParam);
			numberOfAddedEntry++;
		}
		
	}
}
