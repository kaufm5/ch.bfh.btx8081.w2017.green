package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
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
	private TextField tags;
	private TextArea text;
	
	private Label speroTitle;
	
	public MainViewImpl() {

		Layout layout = new VerticalLayout();
		layout.setSizeFull();
		setCompositionRoot(layout);
		
		Layout titleBarBox = new HorizontalLayout ();
		layout.addComponent(titleBarBox);
		speroTitle = new Label("Spero");
		titleBarBox.addComponent(speroTitle);
		
		Layout event = new HorizontalLayout();
		Layout menuColumn = new VerticalLayout();
		Layout restColumn = new VerticalLayout();
		event.addComponents(menuColumn, restColumn);
	
		menuButton = new Button(VaadinIcons.MENU);
		menuColumn.addComponent(menuButton);
		
		smileSchlecht = new Button(VaadinIcons.SMILEY_O);
		smileEherSchlecht = new Button(VaadinIcons.SMILEY_O);
		smileEherGut = new Button(VaadinIcons.SMILEY_O);
		smileGut = new Button(VaadinIcons.SMILEY_O);
		Layout moods = new HorizontalLayout();
		moods.addComponents(smileSchlecht, smileEherSchlecht, smileEherGut, smileGut);
		restColumn.addComponent(moods);
	
		//Buttons mit der dazugehörigen Initialisierung
		
		sosButton = new Button("SOS");
		chatButton = new Button("Chat");
		confirmButton = new Button(VaadinIcons.CHECK);
		
		
	}

}
