package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.CustomComponent;
import com.vaadin.icons.*;

public class MainViewImpl extends CustomComponent{
	
	private Button menuButton;
	private Button sosButton;
	private Button chatButton;
	private Button confirmButton;
	private Button smileSchlecht;
	private Button smileEherSchlecht;
	private Button smileEherGut;
	private Button smileGut;
	
	private TextField title;
	private TextField text;
	private TextField tags;
	
	
	public MainViewImpl() {
		GridLayout layout = new GridLayout(6,12);
		layout.addStyleName("example-gridlayout");
		
		menuButton = new Button(VaadinIcons.MENU);
		sosButton = new Button("SOS");
		chatButton = new Button("Chat");
		confirmButton = new Button(VaadinIcons.CHECK);
		smileSchlecht = new Button("Schlecht");
		smileEherSchlecht = new Button("Eher Schlecht");
		smileEherGut = new Button("Eher Gut");
		smileGut = new Button("Gut");
		
		layout.addComponents(menuButton, sosButton, chatButton, 
				confirmButton, smileSchlecht, smileEherSchlecht, smileEherGut, smileGut);
		setCompositionRoot(layout);
		
		
	}

}
