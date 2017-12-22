package ch.bfh.btx8081.w2017.green.Spero.view;

import java.util.Observable;
import java.util.Observer;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.ButtonProvider;
import ch.bfh.btx8081.w2017.green.Spero.presenter.SettingsPresenter;

public class SettingsView extends ButtonProvider {
	private final Label settings;
	private final Label username;
	private final TextField name;
	private final Label remind;
	private Label snoozeTime;
	private TextField time;
	private final Label pinCode;
	private final Label chatLabel;
	public Label settingsException;
	private HorizontalLayout superButtonBox;
	public String chatValue;
	public RadioButtonGroup <String> einAusReminder;
	public RadioButtonGroup<String> einAusChat;
	
    public SettingsView() {
    	
    	final VerticalLayout layout = new VerticalLayout();
    	setCompositionRoot(layout);

    	final VerticalLayout titleBarBox = new VerticalLayout();
    	this.settings = new Label("Einstellungen");
    	titleBarBox.addComponent(this.settings);
    	layout.addComponent(titleBarBox);
    	
    	HorizontalLayout menuAndContent = new HorizontalLayout();
		menuAndContent.setSizeFull();
		menuAndContent.setMargin(true);
		menuAndContent.setSpacing(true);
		layout.addComponent(menuAndContent);

		VerticalLayout menuBox = new VerticalLayout();
		menuBox.setSpacing(true);
		menuBox.setMargin(true);
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
    	
    	einAusReminder = new RadioButtonGroup<String>();
    	einAusReminder.setItems("Ein", "Aus");
    	einAusReminder.setId("reminder");
    	reminder.addComponent(einAusReminder);
    	
    	settingsItems.addComponent(reminder);
    	
    	//snooze time reminder
    	final HorizontalLayout snooze = new HorizontalLayout();
    	
    	this.snoozeTime = new Label("Snooze time in min:");
    	snooze.addComponent(snoozeTime);
    	
    	this.time = new TextField();
    	time.setPlaceholder("Zeit in Minuten");
    	snooze.addComponent(time);
    	
    	settingsItems.addComponent(snooze);
    	
    	//change pin
    	final HorizontalLayout pin = new HorizontalLayout();

    	this.pinCode = new Label("PIN ändern:");
    	pin.addComponent(pinCode);
       	pin.addComponent(change);
    	
    	settingsItems.addComponent(pin);
    	
    	//chat
    	final HorizontalLayout chat = new HorizontalLayout();
    	
    	this.chatLabel = new Label("Chat:");
    	chat.addComponent(chatLabel);
    	
    	einAusChat = new RadioButtonGroup<>();
    	einAusChat.setItems("Ein", "Aus");
    	//einAusChat.
    	einAusChat.setId("chat");
    	chat.addComponent(einAusChat);
    	
    	settingsItems.addComponent(chat);
    	
    	//settings Exception
    	this.settingsException = new Label("");
    	settingsItems.addComponent(settingsException);    	
    	settingsItems.addComponent(ok);
    	
    	content.addComponent(settingsItems);
    	
    	superButtonBox = new HorizontalLayout ();
		content.addComponent(superButtonBox);
		superButtonBox.addComponent(sosButton);
    	
    }
    
    public String getChatValue() {
    	chatValue = einAusChat.getValue();
    	return chatValue;
    }
    
    public String getReminderValue() {
    	return einAusReminder.getValue();
    }
    
    public String getSnooze() {
    	return time.getValue();
    }
    
    public void buildChatButton(){
		superButtonBox.addComponent(chatButton);
	}
    
}