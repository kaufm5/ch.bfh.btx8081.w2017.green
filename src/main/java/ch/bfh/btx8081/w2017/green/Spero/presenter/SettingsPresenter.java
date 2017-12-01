package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import ch.bfh.btx8081.w2017.green.Spero.model.SettingsModel;
import ch.bfh.btx8081.w2017.green.Spero.view.SettingsView;

public class SettingsPresenter implements ClickListener {
    // TODO: implement pinView and pinModel interactions
    private final SettingsView settingsView;
    private final SettingsModel settingsModel;

    public SettingsPresenter(SettingsView settingsView, SettingsModel settingsModel) {
	this.settingsView = settingsView;
	this.settingsModel = settingsModel;
	settingsView.addListener(this);
    }

    @Override
    public void buttonClick(ClickEvent event) {
	final String buttonId = event.getButton().getId();

	switch (buttonId) {
	case "gefuehlslage":
	    // menuView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
	    break;
	default:
	    //
	    break;
	}
    }

}
