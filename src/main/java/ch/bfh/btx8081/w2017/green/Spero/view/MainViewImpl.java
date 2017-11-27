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

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.presenter.MainPresenter;

import com.vaadin.ui.CustomComponent;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.icons.*;
import com.vaadin.server.Responsive;
import com.vaadin.server.Sizeable;

public class MainViewImpl extends CustomComponent
implements SperoView, ClickListener {
	

	private Button menuButton;
	private Button sosButton;
	private Button chatButton;
	private Button confirmButton;
	private Button smileSchlecht;
	private Button smileEherSchlecht;
	private Button smileEherGut;
	private Button smileGut;
	
	private Label title;
	private TextField tags;
	private TextArea diaryText;

		
	private List<SperoViewListener> listeners = new ArrayList<SperoViewListener>();
	
	public MainViewImpl() {

		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);
//		layout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
		
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
		
		HorizontalLayout moodButtonsBox = new HorizontalLayout();
		moodButtonsBox.setSizeFull();
		moodButtonsBox.setMargin(true);
		moodButtonsBox.setSpacing(true);
		content.addComponent(moodButtonsBox);
		smileSchlecht = new Button(VaadinIcons.SMILEY_O);
		smileEherSchlecht = new Button(VaadinIcons.SMILEY_O);
		smileEherGut = new Button(VaadinIcons.SMILEY_O);
		smileGut = new Button(VaadinIcons.SMILEY_O);
		moodButtonsBox.addComponents(smileSchlecht, smileEherSchlecht, smileEherGut, smileGut);
		content.setComponentAlignment(moodButtonsBox, Alignment.MIDDLE_LEFT);
		content.addComponent(moodButtonsBox);
		
		HorizontalLayout diaryTitleBox = new HorizontalLayout();
		diaryTitleBox.setSizeFull();
		diaryTitleBox.setMargin(true);
		diaryTitleBox.setSpacing(true);
		TextField diaryTitleLabel = new TextField();
		diaryTitleLabel.setPlaceholder("Titel");
		diaryTitleLabel.addStyleName("diaryTitlelabel");
		diaryTitleBox.addComponent(diaryTitleLabel);
		content.addComponent(diaryTitleBox);
		
		HorizontalLayout diaryTextBox = new HorizontalLayout();
		diaryTextBox.setSizeFull();
		diaryTextBox.setMargin(true);
		diaryTextBox.setSpacing(true);
		diaryText = new TextArea();
		diaryText.setPlaceholder("Text");
		diaryText.addStyleName("diaryText");
		diaryTextBox.addComponent(diaryText);
		content.addComponent(diaryTextBox);
		
		HorizontalLayout confirmButtonBox = new HorizontalLayout();
		confirmButtonBox.setSizeFull();
		confirmButtonBox.setMargin(true);
		confirmButtonBox.setSpacing(true);
		confirmButton = new Button(VaadinIcons.CHECK);
		confirmButtonBox.addComponent(confirmButton);
		content.addComponent(confirmButtonBox);
		
		HorizontalLayout superButtonBox = new HorizontalLayout();
		superButtonBox.setSizeFull();
		superButtonBox.setMargin(true);
		superButtonBox.setSpacing(true);
		content.addComponent(superButtonBox);
		sosButton = new Button(VaadinIcons.PHONE);
		chatButton = new Button(VaadinIcons.CHAT);
		superButtonBox.addComponents(sosButton, chatButton);
		superButtonBox.setComponentAlignment(sosButton, Alignment.MIDDLE_LEFT);
		superButtonBox.setComponentAlignment(chatButton, Alignment.MIDDLE_LEFT);

		
		
		
		
		
		
		
		
		
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
		for (SperoViewListener listener: listeners)
			listener.buttonClick(event);
	}
	

	@Override
	public void click(com.vaadin.event.MouseEvents.ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener(SperoViewListener listener) {
		this.listeners.add(listener); 
		
	}



}
