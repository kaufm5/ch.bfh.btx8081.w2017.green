package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.ButtonProvider;

/**
 * The class ChatView shows the chat view of the Spero-application
 * @author stahm2
 */

public class SosView extends ButtonProvider {	
	private Label call;
	private Label title;
	
	/**
	 * Constructs the chat view
	 */
	public SosView() {
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
		call = new Label("Ruft Dargebotene Hand an: 143!!");
		
		menuBox.addComponent(menuButton);
		menuBox.addComponent(call);
		menuBox.setComponentAlignment(menuButton, Alignment.MIDDLE_LEFT);
		menuBox.addStyleName("menu");
		menuAndContent.addComponent(menuBox);
	}
}
