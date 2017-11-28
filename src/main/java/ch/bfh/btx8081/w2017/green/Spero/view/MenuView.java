package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;

public class MenuView extends CustomComponent implements SperoView {
	
	private Label menu;
	private Button chatButton; 
	private Button sosButton;
	
	public MenuView() {
		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);
		
		VerticalLayout titleBarBox = new VerticalLayout(); 
		menu = new Label("Menü");
		titleBarBox.addComponent(menu);
		layout.addComponent(titleBarBox);
		
		HorizontalLayout contentLayout = new HorizontalLayout ();
		layout.addComponent(contentLayout);
		
		
		
		
		VerticalLayout content = new VerticalLayout();
		contentLayout.addComponent(content);
		
		contentLayout.setExpandRatio(content, 9);
		
		HorizontalLayout superButtonBox = new HorizontalLayout ();
		content.addComponent(superButtonBox);
		sosButton = new Button(VaadinIcons.PHONE);
		chatButton = new Button(VaadinIcons.CHAT);
		superButtonBox.addComponents(sosButton, chatButton);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener(SperoViewListener listener) {
		// TODO Auto-generated method stub
		
	}

}
