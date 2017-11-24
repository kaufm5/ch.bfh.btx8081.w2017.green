package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.event.Action.Listener;
import com.vaadin.navigator.View;

import ch.bfh.btx8081.w2017.green.Spero.model.DiaryEntry;
import ch.bfh.btx8081.w2017.green.Spero.view.MainViewImpl;

public class DiaryEntryPresenter implements MainViewImpl.MainViewImplListener {

	private MainViewImpl view;
	private DiaryEntry model;
	
	public DiaryEntryPresenter(MainViewImpl view, DiaryEntry model) {
		this.view = view;
		this.model = model;
		view.addListener(this);
	}
		
	public void buttonClick(Listener ButtonClickListener) {
		
	}
	
}
