package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;

public class ReportView extends CustomComponent implements SperoView {
    private final Button menuButton, chatButton, sosButton;
    private final Label reportTitle;
    private final ComboBox<String> choice;

    public ReportView() {
	final VerticalLayout layout = new VerticalLayout();
	setCompositionRoot(layout);

	// gnuplot
	// graphviz

	final VerticalLayout titleBarBox = new VerticalLayout();
	this.reportTitle = new Label("Statistik");
	titleBarBox.addComponent(this.reportTitle);
	layout.addComponent(titleBarBox);

	final HorizontalLayout menuAndContent = new HorizontalLayout();
	layout.addComponent(menuAndContent);

	final VerticalLayout menuBox = new VerticalLayout();
	this.menuButton = new Button(VaadinIcons.MENU);
	this.menuButton.addClickListener(this);
	this.menuButton.setId("menuButton");
	menuBox.addComponent(this.menuButton);
	menuAndContent.addComponent(menuBox);

	final VerticalLayout content = new VerticalLayout();
	menuAndContent.addComponent(content);

	menuAndContent.setExpandRatio(menuBox, 1);
	menuAndContent.setExpandRatio(content, 9);

	final HorizontalLayout comboBox = new HorizontalLayout();
	// choice = new ComboBox();
	this.choice = new ComboBox<>("Month");
	comboBox.addComponent(this.choice);
	content.addComponent(comboBox);
	this.choice.setItems("Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September",
		"Oktober", "November", "Dezember");

	final HorizontalLayout superButtonBox = new HorizontalLayout();
	content.addComponent(superButtonBox);
	this.sosButton = new Button(VaadinIcons.PHONE);
	this.chatButton = new Button(VaadinIcons.CHAT);
	superButtonBox.addComponents(this.sosButton, this.chatButton);

    }

    @Override
    public void buttonClick(ClickEvent event) {
	// TODO Auto-generated method stub
    }

    @Override
    public void addListener(ClickListener listener) {
	// TODO Auto-generated method stub
    }

}
