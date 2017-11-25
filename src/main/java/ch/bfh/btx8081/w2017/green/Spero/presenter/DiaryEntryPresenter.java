package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.event.Action.Listener;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.ButtonView;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryEntry;
import ch.bfh.btx8081.w2017.green.Spero.view.MainViewImpl;

public class DiaryEntryPresenter implements /*ButtonView,*/ ButtonView.ButtonClickListener {

	private MainViewImpl view;
	private DiaryEntry model;
	
	private String confirmButton;
	
	// constructor
	public DiaryEntryPresenter(MainViewImpl view, DiaryEntry model) {
		this.view = view;
		this.model = model;
		view.addListener(this);
	}
		
//	public static void confirmEvent() {
//		MainViewImpl.confirmButton.setCaption("test");
//	}

	/*@Override
	public void addListener(ButtonClickListener listener) {
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public void buttonClick(this.confirmButton) {
//		if(operation.equals("confirmButton")){
//		 MainViewImpl.confirmButton.setCaption("test");
//		}else{}
		MainViewImpl.confirmButton.setCaption("test");
	}
	


@Override
public void buttonClick(String operation) {
	// TODO Auto-generated method stub
	
}}
