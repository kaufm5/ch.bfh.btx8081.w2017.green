package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.Diary;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryEntry;
import ch.bfh.btx8081.w2017.green.Spero.view.DiaryViewImpl;

public class DiaryPresenter implements SperoViewListener {

	Diary model;
	DiaryViewImpl view;

	public DiaryPresenter(Diary model, DiaryViewImpl view) {
		this.model = model;
		this.view = view;
		view.addListener(this);

	}

	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();

		switch (buttonId) {
		case "refreshButton":

			if (model.getNumberOfDiaryEntry() > 0) {
				DiaryEntry diaryEntry = model.searchEntry(1);
				String title = diaryEntry.getTitle();
				String text = diaryEntry.getText();
				Mood moodParam = diaryEntry.getMoodparam();

				view.addEntryToView(title, text, moodParam);

			}
			break;
		}

	}

	public void addEntry(String title, String text) {

	}

}
