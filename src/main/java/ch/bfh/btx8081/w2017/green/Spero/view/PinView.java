package ch.bfh.btx8081.w2017.green.Spero.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;

public class PinView extends CustomComponent implements SperoView {
	
	private final Label hallo;
	private final PasswordField pin;
	private final Button ok;
	
	public final Label pinException;
	
    private final List<ClickListener> listeners = new ArrayList<ClickListener>();

    public PinView() {
    	
    	final VerticalLayout layout = new VerticalLayout();
    	setCompositionRoot(layout);

    	final VerticalLayout titleBarBox = new VerticalLayout();
    	this.hallo = new Label("Hallo");
    	titleBarBox.addComponent(this.hallo);
    	layout.addComponent(titleBarBox);
    	
    	final HorizontalLayout contentLayout = new HorizontalLayout();
    	layout.addComponent(contentLayout);

    	final VerticalLayout content = new VerticalLayout();
    	content.setSizeFull();
    	content.setMargin(true);
    	content.setSpacing(true);
    	contentLayout.addComponent(content);

    	contentLayout.setExpandRatio(content, 9);

    	final VerticalLayout pinItems = new VerticalLayout();

    	this.pin = new PasswordField("PIN");
    	//this.pin.setId("pin");
    	pinItems.addComponent(this.pin);
    	
    	this.pinException = new Label("");
    	pinException.setId("pinValue");
    	pinItems.addComponent(this.pinException);
    	
    	this.ok = new Button("OK");
    	this.ok.addClickListener(this);
    	this.ok.setId("ok");
    	pinItems.addComponent(this.ok);
    	
    	content.addComponent(pinItems);
    	
    }
    
    public String getPin() {
    	return pin.getValue();
    }

    @Override
    public void buttonClick(ClickEvent event) {
	for (final ClickListener listener : this.listeners) {
	    listener.buttonClick(event);
	}
    }

	@Override
	public void addListener(SperoViewListener listener) {
		this.listeners.add(listener);
	}
}