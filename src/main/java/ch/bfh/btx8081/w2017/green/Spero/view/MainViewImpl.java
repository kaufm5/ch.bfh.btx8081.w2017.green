package ch.bfh.btx8081.w2017.green.Spero.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;

/**
 * The class MainViewImpl shows the main view of the Spero-application
 * @author besio1
 */
public class MainViewImpl extends CustomComponent implements SperoView {

	private Button menuButton;
	private Button sosButton;
	private Button chatButton;
	private Button confirmButton;
	private Button smileSchlecht;
	private Button smileEherSchlecht;
	private Button smileEherGut;
	private Button smileGut;
	private Label title;
	public TextField tags;
	public TextArea diaryText;
	public TextField diaryTitle;
	private HorizontalLayout superButtonBox;

	private List<SperoViewListener> listeners = new ArrayList<SperoViewListener>();

	/**
	 * Constructs the main view
	 */
	public MainViewImpl() {

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

		HorizontalLayout moodButtonsBox = new HorizontalLayout();
		moodButtonsBox.setSizeFull();
		moodButtonsBox.setMargin(true);
		moodButtonsBox.setSpacing(true);

		smileSchlecht = new Button(VaadinIcons.FROWN_O);
		smileSchlecht.addClickListener(this);
		smileSchlecht.setId("smileSchlecht");

		smileEherSchlecht = new Button(VaadinIcons.MEH_O);
		smileEherSchlecht.addClickListener(this);
		smileEherSchlecht.setId("smileEherSchlecht");

		smileEherGut = new Button(VaadinIcons.SMILEY_O);
		smileEherGut.addClickListener(this);
		smileEherGut.setId("smileEherGut");

		smileGut = new Button(VaadinIcons.SMILEY_O);
		smileGut.addClickListener(this);
		smileGut.setId("smileGut");

		moodButtonsBox.addComponents(smileSchlecht, smileEherSchlecht, smileEherGut, smileGut);
		content.addComponent(moodButtonsBox);

		HorizontalLayout diaryTitleBox = new HorizontalLayout();
		diaryTitleBox.setSizeFull();
		diaryTitleBox.setMargin(true);
		diaryTitleBox.setSpacing(true);
		diaryTitle = new TextField();
		diaryTitle.setPlaceholder("Titel");
		diaryTitle.setSizeFull();
		//diaryTitle.addStyleName("diaryTitlelabel");
		diaryTitleBox.addComponent(diaryTitle);
		content.addComponent(diaryTitleBox);

		HorizontalLayout diaryTextBox = new HorizontalLayout();
		diaryTextBox.setSizeFull();
		diaryTextBox.setMargin(true);
		diaryTextBox.setSpacing(true);
		diaryText = new TextArea();
		diaryText.setPlaceholder("Text");
		diaryText.setSizeFull();
		diaryText.addStyleName("diaryText");
		diaryTextBox.addComponent(diaryText);
		content.addComponent(diaryTextBox);
		
		HorizontalLayout tagsBox = new HorizontalLayout();
		tagsBox.setSizeFull();
		tagsBox.setMargin(true);
		tagsBox.setSpacing(true);
		tags = new TextField();
		tags.setPlaceholder("tags");
		tags.setSizeFull();
		tags.addStyleName("tags");
		tagsBox.addComponent(tags);
		content.addComponent(tagsBox);
		

		HorizontalLayout confirmButtonBox = new HorizontalLayout();
		confirmButtonBox.setSizeFull();
		confirmButtonBox.setMargin(true);
		confirmButtonBox.setSpacing(true);
		confirmButton = new Button(VaadinIcons.CHECK);
		confirmButton.addClickListener(this);
		confirmButton.setId("confirmButton");
		confirmButtonBox.addComponents(confirmButton);
		content.addComponent(confirmButtonBox);

		superButtonBox = new HorizontalLayout();
		superButtonBox.setSizeFull();
		superButtonBox.setMargin(true);
		superButtonBox.setSpacing(true);
		content.addComponent(superButtonBox);
		sosButton = new Button(VaadinIcons.PHONE);
		sosButton.addClickListener(this);
		sosButton.setId("sosButton");
		superButtonBox.addComponents(sosButton);
		superButtonBox.setComponentAlignment(sosButton, Alignment.MIDDLE_LEFT);
		}
	
	public void buildChatButton(){
		chatButton = new Button(VaadinIcons.CHAT);
		chatButton.addClickListener(this);
		chatButton.setId("chat");
		superButtonBox.addComponent(chatButton);
		superButtonBox.setComponentAlignment(chatButton, Alignment.MIDDLE_LEFT);
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
