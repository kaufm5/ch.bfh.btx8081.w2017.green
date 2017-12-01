package ch.bfh.btx8081.w2017.green.Spero.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;

public class MenuView extends CustomComponent implements SperoView {

    private final Label menu;
    private final Button gefuehlslage, diary, report, reminder, medInfo, depErk, settings, chatButton, sosButton;

    private final List<ClickListener> listeners = new ArrayList<ClickListener>();

    public MenuView() {
	final VerticalLayout layout = new VerticalLayout();
	setCompositionRoot(layout);

	final VerticalLayout titleBarBox = new VerticalLayout();
	this.menu = new Label("Menü");
	titleBarBox.addComponent(this.menu);
	layout.addComponent(titleBarBox);

	final HorizontalLayout contentLayout = new HorizontalLayout();
	layout.addComponent(contentLayout);

	final VerticalLayout content = new VerticalLayout();
	content.setSizeFull();
	content.setMargin(true);
	content.setSpacing(true);
	contentLayout.addComponent(content);

	contentLayout.setExpandRatio(content, 9);

	final VerticalLayout menuItems = new VerticalLayout();

	this.gefuehlslage = new Button("Gefühlslage");
	this.gefuehlslage.addClickListener(this);
	this.gefuehlslage.setId("gefuehlslage");
	menuItems.addComponent(this.gefuehlslage);

	this.diary = new Button("Tagebuch");
	this.diary.addClickListener(this);
	this.diary.setId("diary");
	menuItems.addComponent(this.diary);

	this.report = new Button("Statistik");
	this.report.addClickListener(this);
	this.report.setId("report");
	menuItems.addComponent(this.report);

	this.reminder = new Button("Reminder");
	this.reminder.addClickListener(this);
	this.reminder.setId("reminder");
	menuItems.addComponent(this.reminder);

	this.medInfo = new Button("Informationen zu der Medikation");
	this.medInfo.addClickListener(this);
	this.medInfo.setId("medInfo");
	menuItems.addComponent(this.medInfo);

	this.depErk = new Button("Erläuterung der Depression");
	this.depErk.addClickListener(this);
	this.depErk.setId("depErk");
	menuItems.addComponent(this.depErk);

	this.settings = new Button("Einstellungen");
	this.settings.addClickListener(this);
	this.settings.setId("settings");
	menuItems.addComponent(this.settings);

	content.addComponent(menuItems);

	final HorizontalLayout superButtonBox = new HorizontalLayout();
	content.addComponent(superButtonBox);
	this.sosButton = new Button(VaadinIcons.PHONE);
	this.sosButton.addClickListener(this);
	this.sosButton.setId("sos");
	this.chatButton = new Button(VaadinIcons.CHAT);
	this.chatButton.addClickListener(this);
	this.chatButton.setId("chat");
	superButtonBox.addComponents(this.sosButton, this.chatButton);
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
