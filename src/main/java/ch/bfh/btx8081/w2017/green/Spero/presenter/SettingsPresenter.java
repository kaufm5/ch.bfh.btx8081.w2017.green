package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.SettingsModel;
import ch.bfh.btx8081.w2017.green.Spero.view.SettingsView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class SettingsPresenter implements SperoViewListener {
	
	private SettingsView settingsView;
	private SettingsModel settingsModel;
	
	public SettingsPresenter(SettingsView settingsView, SettingsModel settingsModel) {
		this.settingsView = settingsView;
		this.settingsModel = settingsModel;
		settingsView.addListener(this);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		String buttonId = event.getButton().getId();
		
		switch(buttonId) {
		case "gefuehlslage":
			//menuView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
		    break;
		}
	}

}
