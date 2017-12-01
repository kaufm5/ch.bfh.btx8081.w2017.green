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
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;

public class DiaryViewImpl extends CustomComponent implements SperoView {
    private final List<ClickListener> listeners = new ArrayList<>();

    private Label title;
    private Panel panel;
    private final VerticalLayout layout;

    private final Button menuButton, refreshButton, newButton, sosButton, chatButton;
    // TESTING
    private Label display;

    public DiaryViewImpl() {
	this.layout = new VerticalLayout();
	setCompositionRoot(this.layout);

	final VerticalLayout titleBarBox = new VerticalLayout();
	titleBarBox.addStyleName("titleBarBox");
	this.title = new Label("Spero");
	this.title.addStyleName("title");
	titleBarBox.addComponent(this.title);
	this.layout.addComponent(titleBarBox);

	final HorizontalLayout menuAndContent = new HorizontalLayout();
	menuAndContent.setSizeFull();
	menuAndContent.setMargin(true);
	menuAndContent.setSpacing(true);
	this.layout.addComponent(menuAndContent);

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

	final VerticalLayout diaryBox = new VerticalLayout();
	diaryBox.setSizeFull();
	diaryBox.setMargin(true);
	diaryBox.setSpacing(true);
	content.addComponent(diaryBox);
	this.title = new Label("Diary");
	diaryBox.addComponent(this.title);

	final HorizontalLayout diaryButton = new HorizontalLayout();
	diaryBox.addComponent(diaryButton);
	this.refreshButton = new Button(VaadinIcons.REFRESH);
	this.refreshButton.addClickListener(this);
	this.refreshButton.setId("refreshButton");

	this.newButton = new Button(VaadinIcons.PLUS_CIRCLE);
	this.newButton.addClickListener(this);
	this.newButton.setId("newButton");
	diaryButton.addComponents(this.refreshButton, this.newButton);

	final HorizontalLayout superButtonBox = new HorizontalLayout();
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

    }

    // public void setDisplay() {
    // this.display = new Label("TESTING");
    // this.layout.addComponent(this.display);
    //
    // }

    public void addEntryToView(String title, String text, Mood moodParam) {
	this.panel = new Panel(title);
	this.panel.setHeight(100.0f, Unit.PERCENTAGE);

	final VerticalLayout contentLayout = new VerticalLayout();
	contentLayout.setWidth(500, Unit.PIXELS);
	contentLayout.setSpacing(false);
	final Label tx = new Label(text);
	final Label str = new Label(moodParam.toString());
	contentLayout.addComponent(tx);
	contentLayout.addComponent(str);

	this.panel.setContent(contentLayout);
	this.layout.addComponent(this.panel);

    }

    @Override
    public void buttonClick(ClickEvent event) {
	for (final ClickListener listener : this.listeners) {
	    listener.buttonClick(event);
	}
    }

    @Override
    public void addListener(ClickListener listener) {
	this.listeners.add(listener);
    }
}
