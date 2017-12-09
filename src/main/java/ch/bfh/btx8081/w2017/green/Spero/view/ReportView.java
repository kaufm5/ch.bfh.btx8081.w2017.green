package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import javafx.scene.chart.Chart;
import javafx.scene.chart.XYChart;

import com.vaadin.ui.CustomComponent;

import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.charts.ChartLayoutAnimator;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;

import com.vaadin.icons.*;


public class ReportView extends CustomComponent implements SperoView {

	private Button menuButton; 
	private Button chatButton; 
	private Button sosButton;
	private Label reportTitle; 
	private ComboBox choice; 
	
	private XYChart<Mood, String> chart; 
	
	private List<SperoViewListener> listeners = new ArrayList<SperoViewListener>();

	public ReportView() { 
		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);

		// gnuplot 
		//graphviz
		
		VerticalLayout titleBarBox = new VerticalLayout(); 
		reportTitle = new Label("Statistik");
		titleBarBox.addComponent(reportTitle);
		layout.addComponent(titleBarBox);

		HorizontalLayout menuAndContent = new HorizontalLayout ();
		layout.addComponent(menuAndContent);

		VerticalLayout menuBox = new VerticalLayout(); 
		menuButton = new Button(VaadinIcons.MENU); 
		menuButton.addClickListener(this);
		menuButton.setId("menuButton");
		menuBox.addComponent(menuButton);
		menuAndContent.addComponent(menuBox);

		VerticalLayout content = new VerticalLayout(); 
		menuAndContent.addComponent(content);

		menuAndContent.setExpandRatio(menuBox, 1);
		menuAndContent.setExpandRatio(content, 9);
		
		HorizontalLayout comboBox = new HorizontalLayout(); 
		//choice = new ComboBox();
		choice = new ComboBox<>("Month"); 
		comboBox.addComponent(choice);
		content.addComponent(comboBox);
		choice.setItems("Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember");
		
	


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
	public void addListener(SperoViewListener listener) {
		listeners.add(listener);
	}




	@Override
	public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
		for (SperoViewListener listener : this.listeners) {
			listener.buttonClick(event);
		}

	}}

