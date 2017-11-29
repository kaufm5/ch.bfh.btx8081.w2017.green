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
		
		username = new Label("Username");
		
		menuBox.addComponent(menuButton);
		menuBox.setComponentAlignment(menuButton, Alignment.MIDDLE_LEFT);
		menuBox.addComponent(username);
		menuBox.setComponentAlignment(username, Alignment.MIDDLE_RIGHT);
		menuBox.addStyleName("menu");
		menuAndContent.addComponent(menuBox);


		VerticalLayout content = new VerticalLayout();
		content.setSizeFull();
		content.setMargin(true);
		content.setSpacing(true);
		menuAndContent.addComponent(content);

		menuAndContent.setExpandRatio(menuBox, 1);
		menuAndContent.setExpandRatio(content, 9);
		
		HorizontalLayout textBox = new HorizontalLayout();
		textBox.setSizeFull();
		textBox.setMargin(true);
		textBox.setSpacing(true);
		chat = new TextField();
		chat.setPlaceholder("Titel");
		chat.addStyleName("chat");
		content.addComponent(textBox);
		
		HorizontalLayout sendBox = new HorizontalLayout();
		sendBox.setSizeFull();
		sendBox.setMargin(true);
		sendBox.setSpacing(true);
		send = new Button(VaadinIcons.PAPERPLANE_O);
		send.addClickListener(this);
		send.setId("send");
		
		attachment = new Button(VaadinIcons.PAPERCLIP);
		attachment.addClickListener(this);
		attachment.setId("attachment");
		sendBox.addComponents(send, attachment);
		content.addComponent(sendBox);
		
		HorizontalLayout superButtonBox = new HorizontalLayout();
		superButtonBox.setSizeFull();
		superButtonBox.setMargin(true);
		superButtonBox.setSpacing(true);
		content.addComponent(superButtonBox);
		sosButton = new Button(VaadinIcons.PHONE);
		superButtonBox.addComponent(sosButton);
		sosButton.setId("sos");
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
