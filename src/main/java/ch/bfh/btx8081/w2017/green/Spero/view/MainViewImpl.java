package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
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
	private TextArea text;
	private TextField tags;
	
	
	public MainViewImpl() {
		GridLayout layout = new GridLayout(6,12);
		layout.addStyleName("example-gridlayout");
		
		//Buttons initialisieren mit Icons
		menuButton = new Button(VaadinIcons.MENU);
		sosButton = new Button("SOS");
		chatButton = new Button("Chat");
		confirmButton = new Button(VaadinIcons.CHECK);
		smileSchlecht = new Button("Schlecht");
		smileEherSchlecht = new Button("Eher Schlecht");
		smileEherGut = new Button("Eher Gut");
		smileGut = new Button("Gut");
		
		//Buttons plazieren
		layout.addComponent(menuButton, 1,1);
		layout.addComponent(sosButton, 2,11);
		layout.addComponent(chatButton, 5, 11);
		layout.addComponent(smileGut, 2, 3);
		layout.addComponent(smileEherGut, 3,3);
		layout.addComponent(smileEherSchlecht, 4,3);
		layout.addComponent(smileSchlecht, 5,3);
		layout.addComponent(confirmButton, 4, 9);
		//layout.addComponents(menuButton, sosButton, chatButton, 
//				confirmButton, smileSchlecht, smileEherSchlecht, smileEherGut, smileGut);
		
		//Textfelder initialisieren
		title = new TextField();
		title.setPlaceholder("Titel");
		text = new TextArea();
		text.setPlaceholder("Text");
		tags = new TextField();
		tags.setPlaceholder("Tags");
		
		//Textfleder zum Layout hinzufügen
		layout.addComponent(title, 2,5);
		layout.addComponent(text, 2, 7);
		layout.addComponent(tags, 2, 9);
		
		
		//layout als root setzen
		setCompositionRoot(layout);
		
		
	}

}
