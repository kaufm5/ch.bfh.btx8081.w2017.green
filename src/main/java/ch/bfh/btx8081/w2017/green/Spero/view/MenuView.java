package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.ButtonProvider;

public class MenuView extends ButtonProvider {
	
	private Label menu;
	private HorizontalLayout superButtonBox;
		
	public MenuView() {
		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);
		// test
		VerticalLayout titleBarBox = new VerticalLayout(); 
		titleBarBox.addStyleName("titleBox");
		menu = new Label("Menü");
		titleBarBox.addComponent(menu);
		
		HorizontalLayout contentLayout = new HorizontalLayout ();
		layout.addComponent(contentLayout);		
		
		VerticalLayout content = new VerticalLayout();
		content.setSizeFull();
		content.setMargin(true);
		content.setSpacing(true);
		contentLayout.addComponent(content);
		
		contentLayout.setExpandRatio(content, 9);
		
		VerticalLayout menuItems = new VerticalLayout();
		menuItems.addComponent(gefuehlslage);
		menuItems.addComponent(diary);
		menuItems.addComponent(report);
		menuItems.addComponent(reminder);
		menuItems.addComponent(medInfo);
		menuItems.addComponent(depErk);
		menuItems.addComponent(settings);
		content.addComponent(menuItems);
		
		superButtonBox = new HorizontalLayout ();
		content.addComponent(superButtonBox);
		superButtonBox.addComponents(sosButton);
	}
	
	public void buildChatButton(){
		superButtonBox.addComponent(chatButton);
	}
}
