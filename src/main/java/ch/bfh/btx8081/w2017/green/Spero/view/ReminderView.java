package ch.bfh.btx8081.w2017.green.Spero.view;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.datefield.DateTimeResolution;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.InlineDateTimeField;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;

public class ReminderView extends CustomComponent implements SperoView{

	private Button menuButton;
	private Button sosButton;
	private Button chatButton;
	//private Button moreTime;
	private Button moreMedi;
	private Button monday;
	private Button tuesday;
	private Button wednesday;
	private Button thursday;
	private Button friday;
	private Button saturday;
	private Button sunday;
	private Button confirmButton;
	private Label time1;
	private Label time2;
	private Label time3;
	private Label time4;
	private Label repetition;
	private Label title;
	public TextField mediName;
	public TextField intervalRemind;
	public TextField timeText1;
	public TextField timeText2;
	public TextField timeText3;
	public TextField timeText4;
	//public ComboBox timeChoice;
	VerticalLayout content;

	private List<SperoViewListener> listeners = new ArrayList<SperoViewListener>();
	
	public ReminderView(){
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

		content = new VerticalLayout();
		content.setSizeFull();
		content.setMargin(true);
		content.setSpacing(true);
		menuAndContent.addComponent(content);

		menuAndContent.setExpandRatio(menuBox, 1);
		menuAndContent.setExpandRatio(content, 9);

	    chooseTime();
	  //  chooseTime();
	    
	    HorizontalLayout confirmButtonBox = new HorizontalLayout();
	
		confirmButton = new Button(VaadinIcons.CHECK);
		confirmButton.addClickListener(this);
		confirmButton.setId("confirmButton");
		moreMedi = new Button(VaadinIcons.PLUS);
		moreMedi.addClickListener(this);
		moreMedi.setId("moreMedis");
		confirmButtonBox.addComponents(moreMedi, confirmButton);
		content.addComponent(confirmButtonBox);

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
	
	public void chooseTime(){
		HorizontalLayout intervalBox = new HorizontalLayout();
		repetition = new Label("Intervall in sek");
		intervalRemind = new TextField();
		intervalRemind.setPlaceholder("Intervall in sekunden");
		intervalBox.addComponents(repetition, intervalRemind);
		content.addComponent(intervalBox);
		
		HorizontalLayout mediNameBox = new HorizontalLayout();
		mediName = new TextField();
		mediName.setPlaceholder("hier Medikamentenname eingeben");
		mediNameBox.addComponent(mediName);
		
		HorizontalLayout timeBox1 = new HorizontalLayout();
		time1 = new Label("Morgen");
		timeText1 = new TextField();
		timeText1.setPlaceholder("HH:MM");
		timeBox1.addComponents(time1, timeText1);
		
		HorizontalLayout timeBox2 = new HorizontalLayout();
		time2 = new Label("Mittag");
		timeText2 = new TextField();
		timeText2.setPlaceholder("HH:MM");
		timeBox2.addComponents(time2, timeText2);
		
		HorizontalLayout timeBox3 = new HorizontalLayout();
		time3 = new Label("Abend");
		timeText3 = new TextField();
		timeText3.setPlaceholder("HH:MM");
		timeBox3.addComponents(time3, timeText3);
		
		HorizontalLayout timeBox4 = new HorizontalLayout();
		time4 = new Label("Nacht");
		timeText4 = new TextField();
		timeText4.setPlaceholder("HH:MM");
		timeBox4.addComponents(time4, timeText4);
		content.addComponents(mediNameBox, timeBox1, timeBox2, timeBox3, timeBox4);
		
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
