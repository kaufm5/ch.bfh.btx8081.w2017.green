package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import javafx.scene.chart.Chart;

import com.vaadin.ui.CustomComponent;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;

import org.atmosphere.container.Servlet30CometSupport;

import com.vaadin.icons.*;
import com.vaadin.server.Sizeable;


public class ReportView extends CustomComponent implements SperoView, ClickListener {

	private Button menuButton;
	private ComboBox choice;  
	private Button chatButton; 
	private Button sosButton;
	//private chart reportDiagram;
	private Label reportTitle; 

	public ReportView() { 
		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);


		VerticalLayout titleBarBox = new VerticalLayout(); 
		reportTitle = new Label("Statistik");
		titleBarBox.addComponent(reportTitle);
		layout.addComponent(titleBarBox);

		HorizontalLayout menuAndContent = new HorizontalLayout ();
		layout.addComponent(menuAndContent);

		VerticalLayout menuBox = new VerticalLayout(); 
		menuButton = new Button(VaadinIcons.MENU); 
		menuBox.addComponent(menuButton);
		menuAndContent.addComponent(menuBox);

		VerticalLayout content = new VerticalLayout(); 
		menuAndContent.addComponent(content);

		menuAndContent.setExpandRatio(menuBox, 1);
		menuAndContent.setExpandRatio(content, 9);
		HorizontalLayout comboBox = new HorizontalLayout(); 
		choice = new ComboBox();
		comboBox.addComponent(choice);
		content.addComponent(comboBox);





		HorizontalLayout superButtonBox = new HorizontalLayout ();
		content.addComponent(superButtonBox);
		sosButton = new Button(VaadinIcons.PHONE);
		chatButton = new Button(VaadinIcons.CHAT);
		superButtonBox.addComponents(sosButton, chatButton);


	}
	//		protected Component getChart() {
	//			Chart chart = new Chart();
	//			chart.setId("chart");
	//			Configuration config = chart.getConfiguration();
	//			config.setTitle("Customized crosshairs");
	//	
	//			Crosshair xCrossHair = new Crosshair();
	//			xCrossHair.setColor(SolidColor.BLACK);
	//			xCrossHair.setDashStyle(DashStyle.SOLID);
	//			xCrossHair.setWidth(10);
	//			xCrossHair.setZIndex(0);
	//			config.getxAxis().setCrosshair(xCrossHair);
	//	
	//			Crosshair yCrossHair = new Crosshair();
	//			yCrossHair.setColor(new SolidColor("#880000"));
	//			yCrossHair.setDashStyle(DashStyle.DOT);
	//			yCrossHair.setWidth(5);
	//			yCrossHair.setZIndex(1);
	//			config.getyAxis().setCrosshair(yCrossHair);
	//	
	//			ListSeries ls = new ListSeries();
	//			ls.setName("Data");
	//			ls.setData(29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4,
	//					194.1, 95.6, 54.4);
	//	
	//			config.setSeries(ls);
	//	
	//			chart.drawChart(config);
	//	
	//			return chart;
	//		}
	//		@Override
	//		public void addListener(ButtonClickListener listener) {
	//			menuButton.addClickListener(listener);


	@Override
	public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void click(ClickEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addListener(SperoViewListener listener) {
		// TODO Auto-generated method stub

	}



}

