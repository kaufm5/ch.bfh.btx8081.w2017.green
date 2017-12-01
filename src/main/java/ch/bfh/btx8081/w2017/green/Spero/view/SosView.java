package ch.bfh.btx8081.w2017.green.Spero.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;

/**
 * The class ChatView shows the chat view of the Spero-application
 *
 * @author stahm2
 */

public class SosView extends CustomComponent implements SperoView {

    private final Button menuButton, chatButton;
    private final Label call, title;

    private final List<ClickListener> listeners = new ArrayList<ClickListener>();

    /**
     * Constructs the chat view
     */
    public SosView() {
	final VerticalLayout layout = new VerticalLayout();
	setCompositionRoot(layout);

	final VerticalLayout titleBarBox = new VerticalLayout();
	titleBarBox.addStyleName("titleBarBox");
	this.title = new Label("Spero");
	this.title.addStyleName("title");
	titleBarBox.addComponent(this.title);
	layout.addComponent(titleBarBox);

	final HorizontalLayout menuAndContent = new HorizontalLayout();
	menuAndContent.setSizeFull();
	menuAndContent.setMargin(true);
	menuAndContent.setSpacing(true);
	layout.addComponent(menuAndContent);

	final VerticalLayout menuBox = new VerticalLayout();
	menuBox.setSpacing(true);
	menuBox.setMargin(true);
	this.menuButton = new Button(VaadinIcons.MENU);
	this.call = new Label("Ruft Dargebotene Hand an: 143!!");
	// id für button
	this.menuButton.addClickListener(this);
	this.menuButton.setId("menuButton");

	this.chatButton = new Button(VaadinIcons.CHAT);
	this.chatButton.addClickListener(this);
	this.chatButton.setId("chatButton");

	menuBox.addComponent(this.menuButton);
	menuBox.addComponent(this.call);
	menuBox.addComponent(this.chatButton);
	menuBox.setComponentAlignment(this.menuButton, Alignment.MIDDLE_LEFT);
	menuBox.addStyleName("menu");
	menuAndContent.addComponent(menuBox);
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
}
