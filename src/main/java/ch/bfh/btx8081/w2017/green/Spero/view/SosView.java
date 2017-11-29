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
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;

public class SosView extends CustomComponent implements SperoView{
	
	private Button menuButton;
	private Button chatButton;
	
	private Label call;
	private Label title;
	
	private List<SperoViewListener> listeners = new ArrayList<SperoViewListener>();
	
	public SosView() {
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
		call = new Label("Ruft Dargebotene Hand an: 143!!");
		//id für button
		menuButton.addClickListener(this);
		menuButton.setId("menuButton");
		
		menuBox.addComponent(menuButton);
		menuBox.addComponent(call);
		menuBox.setComponentAlignment(menuButton, Alignment.MIDDLE_LEFT);
		menuBox.setComponentAlignment(call, Alignment.MIDDLE_RIGHT);
		menuBox.addStyleName("menu");
		menuAndContent.addComponent(menuBox);
		
		VerticalLayout content = new VerticalLayout();
		content.setSizeFull();
		content.setMargin(true);
		content.setSpacing(true);
		menuAndContent.addComponent(content);

		HorizontalLayout superButtonBox = new HorizontalLayout();
		superButtonBox.setSizeFull();
		superButtonBox.setMargin(true);
		superButtonBox.setSpacing(true);
		content.addComponent(superButtonBox);
		chatButton = new Button(VaadinIcons.CHAT);
		chatButton.setId("chat");
		superButtonBox.addComponents(chatButton);
		superButtonBox.setComponentAlignment(chatButton, Alignment.MIDDLE_LEFT);
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
