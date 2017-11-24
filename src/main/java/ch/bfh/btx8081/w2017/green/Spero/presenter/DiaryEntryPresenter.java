package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.event.Action.Listener;
import com.vaadin.navigator.View;

import ch.bfh.btx8081.w2017.green.Spero.model.DiaryEntry;

public class DiaryEntryPresenter {

	private View diaryEntryView;
	private DiaryEntry diaryEntry;
	private Listener ButtonClickListener;
	
	public DiaryEntryPresenter(View diaryEntryView, DiaryEntry diaryEntry) {
		this.diaryEntryView = diaryEntryView;
		this.diaryEntry = diaryEntry;
		
	}
	
	public void presenter(View diaryEntryView, DiaryEntry diaryEntry) {
		
		
	}
	
	public void buttonClick(Listener ButtonClickListener) {
		
	}
	
}
