package ch.bfh.btx8081.w2017.green.Spero.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;

public class ChatView extends CustomComponent implements SperoView {
		
	private Button menuButton;
	private Button send;
	private Button sosButton;
	private Button attachment;
	
	private Label title;
	private Label username;
	private TextField chat;
	
	private List<SperoViewListener> listeners = new ArrayList<SperoViewListener>();

	public ChatView() {
		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);

		VerticalLayout titleBarBox = new VerticalLayout();
		titleBarBox.addStyleName("titleBarBox");
		title = new Label("Spero");
		title.addStyleName("title");
		titleBarBox.addComponent(title);
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
		//id für button
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
		
		HorizontalLayout userBox = new HorizontalLayout();
		userBox.setMargin(true);
		userBox.setSpacing(true);
		username = new Label("Username");
		content.addComponent(userBox);
		userBox.addComponent(username);
		
		HorizontalLayout sendBox = new HorizontalLayout();
		sendBox.setMargin(true);
		sendBox.setSpacing(true);
		chat = new TextField();
		chat.setPlaceholder("Enter your Text here!");
		send = new Button(VaadinIcons.PAPERPLANE_O);
		send.addClickListener(this);
		send.setId("send");
		
		attachment = new Button(VaadinIcons.PAPERCLIP);
		attachment.addClickListener(this);
		attachment.setId("attachment");
		sendBox.addComponents(chat, send, attachment);
		content.addComponent(sendBox);
		
		HorizontalLayout superButtonBox = new HorizontalLayout();
		superButtonBox.setSizeFull();
		superButtonBox.setMargin(true);
		superButtonBox.setSpacing(true);
		content.addComponent(superButtonBox);
		sosButton = new Button(VaadinIcons.PHONE);
		sosButton.addClickListener(this);
		sosButton.setId("sosButton");
		superButtonBox.addComponent(sosButton);
		superButtonBox.setComponentAlignment(sosButton, Alignment.MIDDLE_LEFT);
	}
	@Override
	public void addListener(SperoViewListener listener) {
		listeners.add(listener);	
	}


	@Override
	public void buttonClick(ClickEvent event) {
		for (SperoViewListener listener : this.listeners) {
			listener.buttonClick(event);
	}
	}
}
