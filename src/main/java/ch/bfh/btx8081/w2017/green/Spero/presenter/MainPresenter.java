package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.Diary;
import ch.bfh.btx8081.w2017.green.Spero.view.MainViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class MainPresenter implements SperoViewListener {

	private MainViewImpl mainView;
	private Diary model;

	public MainPresenter(MainViewImpl mainView, Diary model) {
		this.mainView = mainView;
		this.model = model;
		mainView.addListener(this);
	}


	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();
		
		//TODO add links to other views
		switch(buttonId) {
		case "menuButton":
			mainView.getUI().getNavigator().navigateTo(Views.REPORT_VIEW);
			break;
		case "chatButton":
			break;
		case "sosButton":
			break;
		case "smileGut":
			break; 
		case "smileEherGut":
			break;
		case "smileEherSchlecht":
			break;
		case "smileSchlecht":
			break;
		}
	}
}