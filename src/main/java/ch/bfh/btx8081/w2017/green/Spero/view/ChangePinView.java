package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
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
	
	private Button menuButton;
	private Label changePin;
	private Label oldPinLabel;
	private PasswordField oldPinPasswordField;
	private Label newPin1Label;
	private PasswordField newPin1PasswordField;
	private Label newPin2Label;
	private PasswordField newPin2PasswordField;	
	private Button ok;
	private Button sosButton;
	private Button chatButton;
	private HorizontalLayout superButtonBox;
	
	public Label pinException;
	
	private final List<ClickListener> listeners = new ArrayList<ClickListener>();
	
public ChangePinView() {
    	
    	final VerticalLayout layout = new VerticalLayout();
    	setCompositionRoot(layout);
    
		final VerticalLayout titleBarBox = new VerticalLayout();
    	this.changePin = new Label("PIN ändern");
    	titleBarBox.addComponent(this.changePin);
    	layout.addComponent(titleBarBox);

    	HorizontalLayout menuAndContent = new HorizontalLayout();
		menuAndContent.setSizeFull();
		menuAndContent.setMargin(true);
		menuAndContent.setSpacing(true);
		layout.addComponent(menuAndContent);

		VerticalLayout menuBox = new VerticalLayout();
		menuBox.setSpacing(true);
		menuBox.setMargin(true);
		menuButton = new Button(VaadinIcons.MENU);
		//set id für Button 
		menuButton.addClickListener(this);
		menuButton.setId("menuButton");

		menuBox.addComponent(menuButton);
		menuBox.setComponentAlignment(menuButton, Alignment.MIDDLE_LEFT);
		menuBox.addStyleName("menu");
		menuAndContent.addComponent(menuBox);

		VerticalLayout content = new VerticalLayout();
		content.setSizeFull();
		content.setMargin(true);
		content.setSpacing(true);
		menuAndContent.addComponent(content);

		menuAndContent.setExpandRatio(menuBox, 1);
		menuAndContent.setExpandRatio(content, 9);
		
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
    	
    	this.pinException = new Label("");
    	pinException.setId("pinValue");
    	changePinItems.addComponent(this.pinException);
    	
    	//confirm changes
    	this.ok = new Button("OK");
    	this.ok.addClickListener(this);
    	this.ok.setId("ok");
    	changePinItems.addComponent(this.ok);
    	
    	content.addComponent(changePinItems);
    	
    	superButtonBox = new HorizontalLayout ();
		content.addComponent(superButtonBox);
		sosButton = new Button(VaadinIcons.PHONE);
		sosButton.addClickListener(this);
		sosButton.setId("sos");
//		chatButton = new Button(VaadinIcons.CHAT);
//		chatButton.addClickListener(this);
//		chatButton.setId("chat");
		superButtonBox.addComponent(sosButton);
    	//addChatButton();
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
		
		public void buildChatButton(){
			chatButton = new Button(VaadinIcons.CHAT);
			chatButton.addClickListener(this);
			chatButton.setId("chat");
			superButtonBox.addComponent(chatButton);
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