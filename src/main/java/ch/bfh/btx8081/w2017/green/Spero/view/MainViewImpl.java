package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.ButtonView;

import com.vaadin.ui.CustomComponent;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.icons.*;
import com.vaadin.server.Responsive;
import com.vaadin.server.Sizeable;

public class MainViewImpl extends CustomComponent
implements ButtonView, ClickListener {
	

	private Button menuButton;
	private Button sosButton;
	private Button chatButton;
	private Button confirmButton;
	private Button smileSchlecht;
	private Button smileEherSchlecht;
	private Button smileEherGut;
	private Button smileGut;
	
	private TextField title;
	private TextField tags;
	private TextArea text;
	
	private Label speroTitle;
		
	private List<ButtonClickListener> listeners = new ArrayList<ButtonClickListener>();
	
	public MainViewImpl() {

		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);
//		layout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
		
		VerticalLayout titleBarBox = new VerticalLayout();
		titleBarBox.addStyleName("titleBarBox");
		Label title = new Label("Spero");
		title.addStyleName("title");
		titleBarBox.addComponent(title);
		layout.addComponent(titleBarBox);
		titleBarBox.setSizeFull();
		titleBarBox.setComponentAlignment(title, Alignment.MIDDLE_CENTER);
		
		
		HorizontalLayout menuAndContent = new HorizontalLayout();
		menuAndContent.setSizeFull();
		layout.addComponent(menuAndContent);
		
		VerticalLayout menu = new VerticalLayout();
		menu.setWidth("100%");
		menuButton = new Button(VaadinIcons.MENU);
		menu.addComponent(menuButton);
		menu.addStyleName("menu");
		menuAndContent.addComponent(menu);
		
		VerticalLayout content = new VerticalLayout();
		content.setSpacing(true);
		content.setMargin(true);
		menuAndContent.addComponent(content);
		
		menuAndContent.setExpandRatio(menu, 2);
		menuAndContent.setExpandRatio(content, 8);
		
		HorizontalLayout moodButtonsBox = new HorizontalLayout();
		moodButtonsBox.setSpacing(true);
		content.addComponent(moodButtonsBox);
		smileSchlecht = new Button(VaadinIcons.SMILEY_O);
		smileEherSchlecht = new Button(VaadinIcons.SMILEY_O);
		smileEherGut = new Button(VaadinIcons.SMILEY_O);
		smileGut = new Button(VaadinIcons.SMILEY_O);
		moodButtonsBox.addComponents(smileSchlecht, smileEherSchlecht, smileEherGut, smileGut);
		
		TextField diaryTitleLabel = new TextField();
		diaryTitleLabel.setPlaceholder("Titel");
		diaryTitleLabel.addStyleName("diaryTitlelabel");
		content.addComponent(diaryTitleLabel);
		
		
		TextArea diaryText = new TextArea();
		diaryText.setPlaceholder("Text");
		diaryText.addStyleName("diaryText");
		content.addComponent(diaryText);
		
		confirmButton = new Button(VaadinIcons.CHECK);
		content.addComponent(confirmButton);
		
		HorizontalLayout superButtonBox = new HorizontalLayout();
		content.addComponent(superButtonBox);
		sosButton = new Button(VaadinIcons.PHONE);
		chatButton = new Button(VaadinIcons.CHAT);
		superButtonBox.addComponents(sosButton, chatButton);
		

		
		
		
		
		
		
		
		
		
		//--------altes Design-----------------------------------------------------//
	//	Button menuButton = new Button(VaadinIcons.MENU);
		
		
		
		
//		Layout titleBarBox = new HorizontalLayout ();
//		titleBarBox.setSizeFull();
//		layout.addComponent(titleBarBox);
//		speroTitle = new Label("Spero");
//		titleBarBox.addComponent(speroTitle);
		
//		Layout menuBarBox = new HorizontalLayout ();
//		layout.addComponent(menuBarBox);
//		menuButton = new Button(VaadinIcons.MENU);
//		menuBarBox.addComponent(menuButton);
		
//		Layout event = new HorizontalLayout();
//		layout.addComponent(event);
//
//		Layout moods = new HorizontalLayout();
//		layout.addComponent(moods);
//		smileSchlecht = new Button(VaadinIcons.SMILEY_O);
//		smileEherSchlecht = new Button(VaadinIcons.SMILEY_O);
//		smileEherGut = new Button(VaadinIcons.SMILEY_O);
//		smileGut = new Button(VaadinIcons.SMILEY_O);
//		moods.setSizeFull();
//		moods.addComponents(smileSchlecht, smileEherSchlecht, smileEherGut, smileGut);
//	
//		Layout diaryTitleBox = new HorizontalLayout ();
//		layout.addComponent(diaryTitleBox);
//		title = new TextField();
////		Responsive.makeResponsive(title);
////		title.setSizeFull();
//		title.setPlaceholder("Titel");
//		diaryTitleBox.addComponent(title);
//		
//		Layout diaryTextBox = new HorizontalLayout ();
//		layout.addComponent(diaryTextBox);
//		text = new TextArea();
//		text.setPlaceholder("Text");
//		diaryTextBox.addComponent(text);
//		
//		Layout tagsBox = new HorizontalLayout ();
//		layout.addComponent(tagsBox);
//		tags = new TextField();
//		tags.setPlaceholder("Tags");
//		tagsBox.addComponent(tags);
//		
//		Layout superButtonBox = new HorizontalLayout ();
//		layout.addComponent(superButtonBox);
//		sosButton = new Button("SOS");
//		chatButton = new Button("Chat");
//		superButtonBox.addComponents(sosButton, chatButton);
//		
//		Layout confirmButtonBox = new HorizontalLayout ();
//		layout.addComponent(confirmButtonBox);
//		confirmButton = new Button(VaadinIcons.CHECK);
//		confirmButtonBox.addComponent(confirmButton);
		
	}

	@Override
	public void buttonClick(ClickEvent event) {
		for (ButtonClickListener listener: listeners)
			listener.buttonClick(event.getButton().getCaption().toString());
	}

	@Override
	public void setDisplay(double disp) {
		
	}

	@Override
	public void addListener(ButtonClickListener listener) {
		listeners.add(listener);		
	}



}
