package ch.bfh.btx8081.w2017.green.Spero.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;

public class SettingsView extends CustomComponent implements SperoView {

    private final List<ClickListener> listeners = new ArrayList<ClickListener>();

    public SettingsView() {
	// TODO: implement functionality
    }

    @Override
    public void buttonClick(ClickEvent event) {
	for (final ClickListener listener : this.listeners) {
	    listener.buttonClick(event);
	}
    }

    @Override
    public void addListener(ClickListener listener) {
	this.listeners.add(listener);
    }

}
