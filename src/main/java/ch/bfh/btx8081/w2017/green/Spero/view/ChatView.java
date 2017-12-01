package ch.bfh.btx8081.w2017.green.Spero.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.annotations.Push;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Broadcaster;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Broadcaster.BroadcastListener;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;

/**
 * The class ChatView shows the chat view of the Spero-application
 *
 * @author stahm2
 */

@Push
public class ChatView extends CustomComponent implements SperoView, BroadcastListener {
    private final VerticalLayout layout = new VerticalLayout();

    private final Button menuButton, send, sosButton, attachment;
    private final Label title, username;
    private final TextField chat;

    private final List<ClickListener> listeners = new ArrayList<ClickListener>();

    /**
     * Constructs the chat view
     */
    public ChatView() {
	setCompositionRoot(this.layout);

	final VerticalLayout titleBarBox = new VerticalLayout();
	titleBarBox.addStyleName("titleBarBox");
	this.title = new Label("Spero");
	this.title.addStyleName("title");
	titleBarBox.addComponent(this.title);
	this.layout.addComponent(titleBarBox);

	final HorizontalLayout menuAndContent = new HorizontalLayout();
	menuAndContent.setSizeFull();
	menuAndContent.setMargin(true);
	menuAndContent.setSpacing(true);
	this.layout.addComponent(menuAndContent);

	final VerticalLayout menuBox = new VerticalLayout();
	menuBox.setSpacing(true);
	menuBox.setMargin(true);
	this.menuButton = new Button(VaadinIcons.MENU);
	// id für button
	this.menuButton.addClickListener(this);
	this.menuButton.setId("menuButton");

	menuBox.addComponent(this.menuButton);
	menuBox.setComponentAlignment(this.menuButton, Alignment.MIDDLE_LEFT);

	menuBox.addStyleName("menu");
	menuAndContent.addComponent(menuBox);

	final VerticalLayout content = new VerticalLayout();
	content.setSizeFull();
	content.setMargin(true);
	content.setSpacing(true);
	menuAndContent.addComponent(content);

	menuAndContent.setExpandRatio(menuBox, 1);
	menuAndContent.setExpandRatio(content, 9);

	final HorizontalLayout userBox = new HorizontalLayout();
	userBox.setMargin(true);
	userBox.setSpacing(true);
	this.username = new Label("Username");
	content.addComponent(userBox);
	userBox.addComponent(this.username);

	final HorizontalLayout sendBox = new HorizontalLayout();
	sendBox.setMargin(true);
	sendBox.setSpacing(true);
	this.chat = new TextField();
	this.chat.setPlaceholder("Enter your Text here!");
	this.send = new Button(VaadinIcons.PAPERPLANE_O);
	this.send.addClickListener(this);
	this.send.setId("send");

	this.attachment = new Button(VaadinIcons.PAPERCLIP);
	this.attachment.addClickListener(this);
	this.attachment.setId("attachment");
	sendBox.addComponents(this.chat, this.send, this.attachment);
	content.addComponent(sendBox);

	final HorizontalLayout superButtonBox = new HorizontalLayout();
	superButtonBox.setSizeFull();
	superButtonBox.setMargin(true);
	superButtonBox.setSpacing(true);
	content.addComponent(superButtonBox);
	this.sosButton = new Button(VaadinIcons.PHONE);
	this.sosButton.addClickListener(this);
	this.sosButton.setId("sosButton");
	superButtonBox.addComponent(this.sosButton);
	superButtonBox.setComponentAlignment(this.sosButton, Alignment.MIDDLE_LEFT);
	Broadcaster.register(this);
    }

    @Override
    public void addListener(ClickListener listener) {
	this.listeners.add(listener);
    }

    @Override
    public void buttonClick(ClickEvent event) {
	for (final ClickListener listener : this.listeners) {
	    listener.buttonClick(event);
	}
    }

    // Must also unregister when the UI expires
    @Override
    public void detach() {
	Broadcaster.unregister(this);
	super.detach();
    }

    @Override
    public void receiveBroadcast(final String message) {
	// Must lock the session to execute logic safely
	ChatView.this.getCompositionRoot().getUI().access(new Runnable() {
	    @Override
	    public void run() {
		// Show it somehow
		ChatView.this.layout.addComponent(new Label(message));
	    }
	});
    }
}
