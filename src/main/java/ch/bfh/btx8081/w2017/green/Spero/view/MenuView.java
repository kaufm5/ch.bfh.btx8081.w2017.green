package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.ButtonProvider;

/**
 * creates the menuView
 * with this view, it is possible, to access all other views
 * @author mirjam
 *
 */
public class MenuView extends ButtonProvider {
	
	private static final long serialVersionUID = 1L;
	private Label menu;
	private HorizontalLayout superButtonBox;
	
	/**
	 * creates the menuView
	 */
	public MenuView() {
		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);
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
		
		//menuItems
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
	
	/**
	 * builds the chat Button if the chat is on in the settings
	 */
	public void buildChatButton(){
		superButtonBox.addComponent(chatButton);
	}
}
