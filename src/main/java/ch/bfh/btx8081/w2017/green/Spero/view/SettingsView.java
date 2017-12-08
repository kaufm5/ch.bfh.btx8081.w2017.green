package ch.bfh.btx8081.w2017.green.Spero.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.presenter.SettingsPresenter;

public class SettingsView extends CustomComponent implements SperoView, Observer {
	
	private final Label settings;
	private final Label username;
	private final TextField name;
	private final Label remind;
	private final Label pinCode;
	private final Button change;
	private final Label chatLabel;
	private Button chatButton;
	private Button sosButton;
	private HorizontalLayout superButtonBox;
	RadioButtonGroup<String> einAusChat;
	
	private final Button ok;

    private final List<ClickListener> listeners = new ArrayList<ClickListener>();

    private final SettingsPresenter settingsPresenter;
    
    public SettingsView(final SettingsPresenter settingsPresenter) {
    	this.settingsPresenter = settingsPresenter;
    	//this.settingsPresenter.addObserver(this);
	
    	final VerticalLayout layout = new VerticalLayout();
    	setCompositionRoot(layout);

    	final VerticalLayout titleBarBox = new VerticalLayout();
    	this.settings = new Label("Einstellungen");
    	titleBarBox.addComponent(this.settings);
    	layout.addComponent(titleBarBox);
    	
    	final HorizontalLayout contentLayout = new HorizontalLayout();
    	layout.addComponent(contentLayout);

    	final VerticalLayout content = new VerticalLayout();
    	content.setSizeFull();
    	content.setMargin(true);
    	content.setSpacing(true);
    	contentLayout.addComponent(content);

    	contentLayout.setExpandRatio(content, 9);

    	final VerticalLayout settingsItems = new VerticalLayout();
    	
    	//username
    	final HorizontalLayout user = new HorizontalLayout();

    	this.username = new Label("Username:");
    	user.addComponent(this.username);
    	
    	this.name = new TextField();
    	name.setPlaceholder("Username");
    	user.addComponent(this.name);
    	
    	settingsItems.addComponent(user);
    	
    	//reminder
    	final HorizontalLayout reminder = new HorizontalLayout();

    	this.remind = new Label("Reminder:");
    	reminder.addComponent(this.remind);
    	
    	RadioButtonGroup<String> einAusReminder = new RadioButtonGroup();
    	einAusReminder.setItems("Ein", "Aus");
    	reminder.addComponent(einAusReminder);
    	
    	settingsItems.addComponent(reminder);
    	
    	//change pin
    	final HorizontalLayout pin = new HorizontalLayout();

    	this.pinCode = new Label("PIN ändern:");
    	pin.addComponent(pinCode);
    	
    	this.change = new Button("Ändern");
    	this.change.addClickListener(this);
    	this.change.setId("change");
    	pin.addComponent(change);
    	
    	settingsItems.addComponent(pin);
    	
    	//chat
    	final HorizontalLayout chat = new HorizontalLayout();
    	
    	this.chatLabel = new Label("Chat:");
    	chat.addComponent(chatLabel);
    	
//    	ToggleButton einAusChat = new ToggleButton();
//    	chat.addComponent(einAusChat);
   	
    	einAusChat = new RadioButtonGroup<>();
    	einAusChat.setItems("Ein", "Aus");
    	//einAusChat.
    	einAusChat.setId("chat");
    	chat.addComponent(einAusChat);
    	
    	settingsItems.addComponent(chat);
    	
    	//confirm changes
    	this.ok = new Button("OK");
    	this.ok.addClickListener(this);
    	this.ok.setId("ok");
    	settingsItems.addComponent(ok);
    	
    	content.addComponent(settingsItems);
    	
    	superButtonBox = new HorizontalLayout ();
		content.addComponent(superButtonBox);
		sosButton = new Button(VaadinIcons.PHONE);
		sosButton.addClickListener(this);
		sosButton.setId("sos");
		superButtonBox.addComponent(sosButton);
    	//addChatButton();
    }
    
    public String getChatValue() {
    	return einAusChat.getValue();
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

	@Override
	public void update(Observable o, Object arg) {
		buildChatButton();
		//superButtonBox.addComponent(buildChatButton());
	}

}