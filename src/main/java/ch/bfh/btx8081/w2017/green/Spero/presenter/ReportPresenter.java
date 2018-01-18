package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.view.ReportViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

/**
 * This class presents all the necessary data to the ReportView 
 * and handles the clicks of the report view 
 * 
 * @author mussi
 */
public class ReportPresenter implements SperoViewListener{

	private static final long serialVersionUID = 1L;

	private ReportViewImpl view;

	/**
	 * Class constructor
	 * 
	 * @param view - the report view 
	 */
	public ReportPresenter(ReportViewImpl view) {
		this.view = view;
		view.init();
		view.addListener(this);
	}

	/**
	 * Method for handling button clicks to navigate to a new view via URL 
	 * 
	 * @param event - the click event 
	 */
	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();

		switch(buttonId) {
		case "menuButton":
			view.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
		case "sos":
			view.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
			break;
		case "chat":
			view.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
			break;
		}
	}

}
