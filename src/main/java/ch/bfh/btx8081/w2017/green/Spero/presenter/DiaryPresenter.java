package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.Diary;
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
		// TODO Auto-generated method stub
		
	}

}
