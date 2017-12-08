package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;

public class ChangePinView extends CustomComponent implements SperoView {
	
	private Label changePin;
	private Label oldPinLabel;
	private PasswordField oldPinPasswordField;
	private Label newPin1Label;
	private PasswordField newPin1PasswordField;
	private Label newPin2Label;
	private PasswordField newPin2PasswordField;
	
	private Button ok;
	
	private final List<ClickListener> listeners = new ArrayList<ClickListener>();
	
public ChangePinView() {
    	
    	final VerticalLayout layout = new VerticalLayout();
    	setCompositionRoot(layout);

    	final VerticalLayout titleBarBox = new VerticalLayout();
    	this.changePin = new Label("PIN ändern");
    	titleBarBox.addComponent(this.changePin);
    	layout.addComponent(titleBarBox);
    	
    	final HorizontalLayout contentLayout = new HorizontalLayout();
    	layout.addComponent(contentLayout);

    	final VerticalLayout content = new VerticalLayout();
    	content.setSizeFull();
    	content.setMargin(true);
    	content.setSpacing(true);
    	contentLayout.addComponent(content);

    	contentLayout.setExpandRatio(content, 9);

    	final VerticalLayout changePinItems = new VerticalLayout();
    	
    	//old PIN
    	final HorizontalLayout oldPin = new HorizontalLayout();
    	
    	this.oldPinLabel = new Label("Alter PIN:");
    	oldPin.addComponent(this.oldPinLabel);
    	
    	this.oldPinPasswordField = new PasswordField();
    	//oldPinPasswordField.setPlaceholder("Alter PIN");
    	oldPin.addComponent(this.oldPinPasswordField);
    	
    	changePinItems.addComponent(oldPin);
    	
    	//new PIN1
    	final HorizontalLayout newPin1 = new HorizontalLayout();
    	
    	this.newPin1Label = new Label("Neuer PIN:");
    	newPin1.addComponent(this.newPin1Label);
    	
    	this.newPin1PasswordField = new PasswordField();
    	//newPin1PasswordField.setPlaceholder("Neuer PIN");
    	newPin1.addComponent(this.newPin1PasswordField);
    	
    	changePinItems.addComponent(newPin1);
    	
    	//new PIN2
    	final HorizontalLayout newPin2 = new HorizontalLayout();
    	
    	this.newPin2Label = new Label("Bestätigung des neuen PIN:");
    	newPin2.addComponent(this.newPin2Label);
    	
    	this.newPin2PasswordField = new PasswordField();
    	//newPin2PasswordField.setPlaceholder("PIN Bestätigung");
    	newPin2.addComponent(this.newPin2PasswordField);
    	
    	changePinItems.addComponent(newPin2);
    	
    	//confirm changes
    	this.ok = new Button("OK");
    	this.ok.addClickListener(this);
    	this.ok.setId("ok");
    	changePinItems.addComponent(this.ok);
    	
    	content.addComponent(changePinItems);
    	
}

		public String getOldPin() {
			return oldPinPasswordField.getValue();
		}
		
		public String getNewPin1() {
			return newPin1PasswordField.getValue();
		}
		
		public String getNewPin2() {
			return newPin2PasswordField.getValue();
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