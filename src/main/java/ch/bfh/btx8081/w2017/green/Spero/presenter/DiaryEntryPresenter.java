package ch.bfh.btx8081.w2017.green.Spero.presenter;


import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.MainView;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryEntry;


public class DiaryEntryPresenter implements MainView.MainViewListener {

	private MainView view;
	private DiaryEntry model;


	// constructor
	public DiaryEntryPresenter(MainView view, DiaryEntry model) {
		this.view = view;
		this.model = model;
		// Testing
		view.setDisplay("TEST_Konstruktor");
		
		view.addListener(this);
	}


	@Override
	public void buttonClick(char operation) {
		view.setDisplay("TEST_ButtonClick");
		
	}

	
}