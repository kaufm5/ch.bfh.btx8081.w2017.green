package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.icons.*;
import com.vaadin.server.Sizeable;

public class MainViewImpl extends CustomComponent{
	

	private Button menuButton;
	private Button sosButton;
	private Button chatButton;
	public static Button confirmButton;
	private Button smileSchlecht;
	private Button smileEherSchlecht;
	private Button smileEherGut;
	private Button smileGut;
	
	private TextField title;
	private TextField tags;
	private TextArea text;
	
	private Label speroTitle;
	
	public MainViewImpl() {

		Layout layout = new VerticalLayout();
		setCompositionRoot(layout);
		
		Layout titleBarBox = new HorizontalLayout ();
		layout.addComponent(titleBarBox);
		speroTitle = new Label("Spero");
		titleBarBox.addComponent(speroTitle);
		
		Layout menuBarBox = new HorizontalLayout ();
		layout.addComponent(menuBarBox);
		menuButton = new Button(VaadinIcons.MENU);
		menuBarBox.addComponent(menuButton);
		
		Layout event = new HorizontalLayout();
		layout.addComponent(event);

		Layout moods = new HorizontalLayout();
		layout.addComponent(moods);
		smileSchlecht = new Button(VaadinIcons.SMILEY_O);
		smileEherSchlecht = new Button(VaadinIcons.SMILEY_O);
		smileEherGut = new Button(VaadinIcons.SMILEY_O);
		smileGut = new Button(VaadinIcons.SMILEY_O);
		moods.setSizeFull();
		moods.addComponents(smileSchlecht, smileEherSchlecht, smileEherGut, smileGut);
	
		Layout diaryTitleBox = new HorizontalLayout ();
		layout.addComponent(diaryTitleBox);
		title = new TextField();
		title.setPlaceholder("Titel");
		diaryTitleBox.addComponent(title);
		
		Layout diaryTextBox = new HorizontalLayout ();
		layout.addComponent(diaryTextBox);
		text = new TextArea();
		text.setPlaceholder("Text");
		diaryTextBox.addComponent(text);
		
		Layout tagsBox = new HorizontalLayout ();
		layout.addComponent(tagsBox);
		tags = new TextField();
		tags.setPlaceholder("Tags");
		tagsBox.addComponent(tags);
		
		Layout superButtonBox = new HorizontalLayout ();
		layout.addComponent(superButtonBox);
		sosButton = new Button("SOS");
		chatButton = new Button("Chat");
		superButtonBox.addComponents(sosButton, chatButton);
		
		Layout confirmButtonBox = new HorizontalLayout ();
		layout.addComponent(confirmButtonBox);
		confirmButton = new Button(VaadinIcons.CHECK);
		confirmButtonBox.addComponent(confirmButton);
		
	}

}
