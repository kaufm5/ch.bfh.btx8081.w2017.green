package ch.bfh.btx8081.w2017.green.Spero.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;

public class DiaryViewImpl extends CustomComponent implements SperoView {
	
	private List<SperoViewListener> listeners = new ArrayList<>();
	
	private Label title;
	private Panel panel;
	VerticalLayout layout;
	private VerticalLayout contentLayout;
	private Button refreshButton;
	
	// TESTING
	private Label display;
	
	public DiaryViewImpl() {
		layout = new VerticalLayout();
		setCompositionRoot(layout);
		
		title = new Label("Diary");
		layout.addComponent(title);
		
		refreshButton = new Button(VaadinIcons.REFRESH);
		refreshButton.addClickListener(this);
		refreshButton.setId("refreshButton");
		layout.addComponent(refreshButton);
		
		
		
	}
	
	public void setDisplay() {
		display = new Label("TESTING");
		layout.addComponent(display);
		
	}
	
	
	public void addEntryToView(String title, String text, Mood moodParam) {
		panel = new Panel(title);
		panel.setHeight(100.0f, Unit.PERCENTAGE);
		
		contentLayout = new VerticalLayout();
		contentLayout.setWidth(500, Unit.PIXELS);
		contentLayout.setSpacing(false);
		contentLayout.addComponent(new Label(text));
		
		panel.setContent(contentLayout);
		layout.addComponent(panel);
		
		
		
	}

	
	

	@Override
	public void buttonClick(ClickEvent event) {
		for(SperoViewListener listener : this.listeners) {
			listener.buttonClick(event);
		}
		
	}

	@Override
	public void addListener(SperoViewListener listener) {
		listeners.add(listener);
		
	}

}
