package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.ButtonProvider;

/**
 * This class is the view of the diary entries report screen
 * 
 * @author mussi
 *
 */
public class ReportViewImpl extends ButtonProvider {
	private static final long serialVersionUID = 1L;

	private Label reportTitle; 
	private ComboBox<String> choice; 
	private HorizontalLayout superButtonBox;

	public ReportViewImpl() { 
		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);

		VerticalLayout titleBarBox = new VerticalLayout(); 
		reportTitle = new Label("Statistik");
		titleBarBox.addComponent(reportTitle);
		layout.addComponent(titleBarBox);

		HorizontalLayout menuAndContent = new HorizontalLayout ();
		layout.addComponent(menuAndContent);

		VerticalLayout menuBox = new VerticalLayout(); 
		menuBox.addComponent(menuButton);
		menuAndContent.addComponent(menuBox);

		VerticalLayout content = new VerticalLayout(); 
		menuAndContent.addComponent(content);

		menuAndContent.setExpandRatio(menuBox, 1);
		menuAndContent.setExpandRatio(content, 9);

		HorizontalLayout comboBox = new HorizontalLayout(); 

		choice = new ComboBox<String>("Month"); 
		comboBox.addComponent(choice);
		content.addComponent(comboBox);
		choice.setItems("Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August",
				"September", "Oktober", "November", "Dezember");

		superButtonBox = new HorizontalLayout();
		superButtonBox.setSizeFull();
		superButtonBox.setMargin(true);
		superButtonBox.setSpacing(true);
		content.addComponent(superButtonBox);
		superButtonBox.addComponent(sosButton);
		superButtonBox.setComponentAlignment(sosButton, Alignment.MIDDLE_LEFT);

	}
	
	/**
	 * Builds the chat button 
	 */
	public void buildChatButton(){
		superButtonBox.addComponent(chatButton);
		superButtonBox.setComponentAlignment(chatButton, Alignment.MIDDLE_LEFT);
	}
}

