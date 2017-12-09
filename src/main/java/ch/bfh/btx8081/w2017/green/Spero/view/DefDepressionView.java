package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.Button.ClickEvent;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;

public class DefDepressionView extends CustomComponent implements SperoView {
	
	private Button menuButton;
	private Button sosButton;
	private Button chatButton;
	private Label title;
	public TextArea definition;
	
	private List<SperoViewListener> listeners = new ArrayList<SperoViewListener>();
	
	public DefDepressionView() {
		
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
		
		HorizontalLayout defintionTextBox = new HorizontalLayout();
		defintionTextBox.setSizeFull();
		defintionTextBox.setMargin(true);
		defintionTextBox.setSpacing(true);
		definition = new TextArea();
		definition.setPlaceholder("Depression: \n ist eine Krankheit die schwankend auf dem Person autretet \n Es gibt zwei arten von Depression: \n 1)bla bla  \n 2) bla ldd");
		definition.addStyleName("defitionText");
		defintionTextBox.addComponent(definition);
		content.addComponent(defintionTextBox);
		
		HorizontalLayout superButtonBox = new HorizontalLayout();
		superButtonBox.setSizeFull();
		superButtonBox.setMargin(true);
		superButtonBox.setSpacing(true);
		content.addComponent(superButtonBox);
		sosButton = new Button(VaadinIcons.PHONE);
		sosButton.addClickListener(this);
		sosButton.setId("sosButton");
		chatButton = new Button(VaadinIcons.CHAT);
		chatButton.addClickListener(this);
		chatButton.setId("chatButton");
		superButtonBox.addComponents(sosButton, chatButton);
		superButtonBox.setComponentAlignment(sosButton, Alignment.MIDDLE_LEFT);
		superButtonBox.setComponentAlignment(chatButton, Alignment.MIDDLE_LEFT);
		
	}
	
	

	@Override
	public void buttonClick(ClickEvent event) {
		for (SperoViewListener listener : this.listeners) {
			listener.buttonClick(event);
		}
		
	}

	@Override
	public void addListener(SperoViewListener listener) {
		listeners.add(listener);		
	}

}
