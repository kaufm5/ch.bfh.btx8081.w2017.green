package ch.bfh.btx8081.w2017.green.Spero.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
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
	
	private Button menuButton;
	private Button refreshButton;
	private Button newButton;
	private Button sosButton;
	private Button chatButton;
	
	// TESTING test
	private Label display;
	
	public DiaryViewImpl() {
		layout = new VerticalLayout();
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
		
		VerticalLayout diaryBox =  new VerticalLayout();
		diaryBox.setSizeFull();
		diaryBox.setMargin(true);
		diaryBox.setSpacing(true);
		content.addComponent(diaryBox);
		title = new Label("Diary");
		diaryBox.addComponent(title);
		
		HorizontalLayout diaryButton = new HorizontalLayout();
		diaryBox.addComponent(diaryButton);
		refreshButton = new Button(VaadinIcons.REFRESH);
		refreshButton.addClickListener(this);
		refreshButton.setId("refreshButton");
		
		newButton = new Button(VaadinIcons.PLUS_CIRCLE);
		newButton.addClickListener(this);
		newButton.setId("newButton");
		diaryButton.addComponents(refreshButton, newButton);
		
		HorizontalLayout superButtonBox = new HorizontalLayout();
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
		
	}
	
/*	public void setDisplay() {
		display = new Label("TESTING");
		layout.addComponent(display);
		
	}*/
	
	
	public void addEntryToView(String title, String text, Mood moodParam) {
		panel = new Panel(title);
		panel.setHeight(100.0f, Unit.PERCENTAGE);
		
		VerticalLayout contentLayout = new VerticalLayout();
		contentLayout.setWidth(500, Unit.PIXELS);
		contentLayout.setSpacing(false);
		Label tx = new Label(text);
		Label strMoodParam = new Label(moodParam.toString());
		
		contentLayout.addComponent(strMoodParam);
		contentLayout.addComponent(tx);
		
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
