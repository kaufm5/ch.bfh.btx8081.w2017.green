package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.event.Action.Listener;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.MainView;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryEntry;
import ch.bfh.btx8081.w2017.green.Spero.view.MainViewImpl;

public class DiaryEntryPresenter implements /* ButtonView, */ MainView.MainViewListener {

	private MainView view;
	private DiaryEntry model;

	private String confirmButton;

	// constructor
	public DiaryEntryPresenter(MainView view, DiaryEntry model) {
		this.view = view;
		this.model = model;
		view.addListener(this);
	}

	@Override
	public void buttonClick(char operation) {
		view.setDisplay("" + operation);

	}
}