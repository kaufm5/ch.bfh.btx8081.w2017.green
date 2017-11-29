package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.Button.ClickEvent;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;

public class MenuView extends CustomComponent implements SperoView {
	
	private Label menu;
	private Button gefuehlslage;
	private Button diary;
	private Button report;
	private Button reminder;
	private Button settings;
	private Button chatButton; 
	private Button sosButton;
	
	private List<SperoViewListener> listeners = new ArrayList<SperoViewListener>();
	
	public MenuView() {
		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);
		
		VerticalLayout titleBarBox = new VerticalLayout(); 
		menu = new Label("Menü");
		titleBarBox.addComponent(menu);
		layout.addComponent(titleBarBox);
		
		HorizontalLayout contentLayout = new HorizontalLayout ();
		layout.addComponent(contentLayout);		
		
		VerticalLayout content = new VerticalLayout();
		content.setSizeFull();
		content.setMargin(true);
		content.setSpacing(true);
		contentLayout.addComponent(content);
		
		contentLayout.setExpandRatio(content, 9);
		
		VerticalLayout menuItems = new VerticalLayout();
		
		gefuehlslage = new Button("Gefühlslage");
		gefuehlslage.addClickListener(this);
		gefuehlslage.setId("gefuehlslage");
		menuItems.addComponent(gefuehlslage);
		
		diary = new Button("Tagebuch");
		diary.addClickListener(this);
		diary.setId("diary");
		menuItems.addComponent(diary);
		
		report = new Button("Statistik");
		report.addClickListener(this);
		report.setId("report");
		menuItems.addComponent(report);
		
		reminder = new Button("Erinnerung der Medikamenteneinnahme/Reminder");
		reminder.addClickListener(this);
		reminder.setId("reminder");
		menuItems.addComponent(reminder);
		
		settings = new Button("Einstellungen");
		settings.addClickListener(this);
		settings.setId("settings");
		menuItems.addComponent(settings);
		
		content.addComponent(menuItems);
		
		HorizontalLayout superButtonBox = new HorizontalLayout ();
		content.addComponent(superButtonBox);
		sosButton = new Button(VaadinIcons.PHONE);
		sosButton.addClickListener(this);
		sosButton.setId("sos");
		chatButton = new Button(VaadinIcons.CHAT);
		chatButton.addClickListener(this);
		chatButton.setId("chat");
		superButtonBox.addComponents(sosButton, chatButton);
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
