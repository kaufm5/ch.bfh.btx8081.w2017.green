package ch.bfh.btx8081.w2017.green.Spero.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;

/**
 * The class MainViewImpl shows the main view of the Spero-application
 *
 * @author besio1
 */
public class MainViewImpl extends CustomComponent implements SperoView {
    private final Button menuButton, sosButton, chatButton, confirmButton, smileSchlecht, smileEherSchlecht,
	    smileEherGut, smileGut;

    private final Label title;
    public final TextField tags, diaryTitle;
    public final TextArea diaryText;

    private final List<ClickListener> listeners = new ArrayList<ClickListener>();

    /**
     * Constructs the main view
     */
    public MainViewImpl() {
	final VerticalLayout layout = new VerticalLayout();
	setCompositionRoot(layout);

	final VerticalLayout titleBarBox = new VerticalLayout();
	titleBarBox.addStyleName("titleBarBox");
	this.title = new Label("Spero");
	this.title.addStyleName("title");
	titleBarBox.addComponent(this.title);
	layout.addComponent(titleBarBox);

	final HorizontalLayout menuAndContent = new HorizontalLayout();
	menuAndContent.setSizeFull();
	menuAndContent.setMargin(true);
	menuAndContent.setSpacing(true);
	layout.addComponent(menuAndContent);

	final VerticalLayout menuBox = new VerticalLayout();
	menuBox.setSpacing(true);
	menuBox.setMargin(true);
	this.menuButton = new Button(VaadinIcons.MENU);
	// set id für Button
	this.menuButton.addClickListener(this);
	this.menuButton.setId("menuButton");

	menuBox.addComponent(this.menuButton);
	menuBox.setComponentAlignment(this.menuButton, Alignment.MIDDLE_LEFT);
	menuBox.addStyleName("menu");
	menuAndContent.addComponent(menuBox);

	final VerticalLayout content = new VerticalLayout();
	content.setSizeFull();
	content.setMargin(true);
	content.setSpacing(true);
	menuAndContent.addComponent(content);

	menuAndContent.setExpandRatio(menuBox, 1);
	menuAndContent.setExpandRatio(content, 9);

	final HorizontalLayout moodButtonsBox = new HorizontalLayout();
	moodButtonsBox.setSizeFull();
	moodButtonsBox.setMargin(true);
	moodButtonsBox.setSpacing(true);

	this.smileSchlecht = new Button(VaadinIcons.FROWN_O);
	this.smileSchlecht.addClickListener(this);
	this.smileSchlecht.setId("smileSchlecht");

	this.smileEherSchlecht = new Button(VaadinIcons.MEH_O);
	this.smileEherSchlecht.addClickListener(this);
	this.smileEherSchlecht.setId("smileEherSchlecht");

	this.smileEherGut = new Button(VaadinIcons.SMILEY_O);
	this.smileEherGut.addClickListener(this);
	this.smileEherGut.setId("smileEherGut");

	this.smileGut = new Button(VaadinIcons.SMILEY_O);
	this.smileGut.addClickListener(this);
	this.smileGut.setId("smileGut");

	moodButtonsBox.addComponents(this.smileSchlecht, this.smileEherSchlecht, this.smileEherGut, this.smileGut);
	content.addComponent(moodButtonsBox);

	final HorizontalLayout diaryTitleBox = new HorizontalLayout();
	diaryTitleBox.setSizeFull();
	diaryTitleBox.setMargin(true);
	diaryTitleBox.setSpacing(true);
	this.diaryTitle = new TextField();
	this.diaryTitle.setPlaceholder("Titel");
	// diaryTitle.addStyleName("diaryTitlelabel");
	diaryTitleBox.addComponent(this.diaryTitle);
	content.addComponent(diaryTitleBox);

	final HorizontalLayout diaryTextBox = new HorizontalLayout();
	diaryTextBox.setSizeFull();
	diaryTextBox.setMargin(true);
	diaryTextBox.setSpacing(true);
	this.diaryText = new TextArea();
	this.diaryText.setPlaceholder("Text");
	this.diaryText.addStyleName("diaryText");
	diaryTextBox.addComponent(this.diaryText);
	content.addComponent(diaryTextBox);

	final HorizontalLayout confirmButtonBox = new HorizontalLayout();
	confirmButtonBox.setSizeFull();
	confirmButtonBox.setMargin(true);
	confirmButtonBox.setSpacing(true);
	this.tags = new TextField();
	this.tags.setPlaceholder("Tag");
	this.confirmButton = new Button(VaadinIcons.CHECK);
	this.confirmButton.addClickListener(this);
	this.confirmButton.setId("confirmButton");
	confirmButtonBox.addComponents(this.tags, this.confirmButton);
	content.addComponent(confirmButtonBox);

	final HorizontalLayout superButtonBox = new HorizontalLayout();
	superButtonBox.setSizeFull();
	superButtonBox.setMargin(true);
	superButtonBox.setSpacing(true);
	content.addComponent(superButtonBox);
	this.sosButton = new Button(VaadinIcons.PHONE);
	this.sosButton.addClickListener(this);
	this.sosButton.setId("sosButton");
	this.chatButton = new Button(VaadinIcons.CHAT);
	this.chatButton.addClickListener(this);
	this.chatButton.setId("chatButton");
	superButtonBox.addComponents(this.sosButton, this.chatButton);
	superButtonBox.setComponentAlignment(this.sosButton, Alignment.MIDDLE_LEFT);
	superButtonBox.setComponentAlignment(this.chatButton, Alignment.MIDDLE_LEFT);
    }

    @Override
    public void addListener(ClickListener listener) {
	this.listeners.add(listener);
    }

    @Override
    public void buttonClick(ClickEvent event) {
	for (final ClickListener listener : this.listeners) {
	    listener.buttonClick(event);
	}
    }
}
