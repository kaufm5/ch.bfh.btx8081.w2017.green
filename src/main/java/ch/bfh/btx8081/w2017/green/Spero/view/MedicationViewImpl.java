package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.ButtonProvider;
import ch.bfh.btx8081.w2017.green.Spero.persistence.Medication;

/**
 * This class is the view of the medication description screen
 * 
 * @author mussi
 *
 */
public class MedicationViewImpl extends ButtonProvider {

	private static final long serialVersionUID = 1L;

	private TextField text; 
	private Button searchButton; 
	private Label title, searchDescription; 
	private HorizontalLayout superButtonBox;
	private Panel panel; 
	private VerticalLayout layout, contentLayout, content; 

	/**
	 * The class constructor 
	 */
	public MedicationViewImpl() {

		layout = new VerticalLayout();
		setCompositionRoot(layout);

		panel = new Panel();
		contentLayout = new VerticalLayout();

		VerticalLayout titleBarBox = new VerticalLayout();
		titleBarBox.addStyleName("titleBarBox");
		title = new Label("Medication Description");
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

		menuBox.addComponent(menuButton);
		menuBox.setComponentAlignment(menuButton, Alignment.MIDDLE_LEFT);
		menuBox.addStyleName("menu");
		menuAndContent.addComponent(menuBox);

		content = new VerticalLayout();
		content.setSizeFull();
		content.setMargin(true);
		content.setSpacing(true);
		menuAndContent.addComponent(content);

		menuAndContent.setExpandRatio(menuBox, 1);
		menuAndContent.setExpandRatio(content, 9);

		HorizontalLayout searchLabel = new HorizontalLayout(); 
		searchDescription = new Label("Write medication name for example: Agomelatin, Alutan, Amioxid,  Cipralex, Deprilept, Dutonin"); 

		content.addComponent(searchDescription);
		content.addComponent(searchLabel);
		searchLabel.addComponent(searchDescription);

		HorizontalLayout searchBox = new HorizontalLayout(); 
		text = new TextField(); 
		text.setPlaceholder("medication name");

		searchButton = new Button(VaadinIcons.SEARCH); 
		searchButton.setDescription("Search Medication");
		searchButton.setId("searchMedication");
		searchButton.addClickListener(this); 

		content.addComponent(searchBox);
		searchBox.addComponents(text, searchButton);

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

	/**
	 * Gets the text field 
	 * 
	 * @return text field 
	 */
	public TextField getText() {
		return text;
	}

	/**
	 * Builds the panel for the medication name and description 
	 * 
	 * @param med - the medication which holds its name and description 
	 */
	public void buildMedPanel(Medication med) {

		contentLayout.removeAllComponents();
		panel.setHeight(100.0f, Unit.PERCENTAGE);

		contentLayout.setWidth(500, Unit.PIXELS);
		contentLayout.setSpacing(false);

		Label name = new Label(med.getMedName());
		Label description = new Label(med.getMedDescription());

		contentLayout.addComponent(name);
		contentLayout.addComponent(description);

		panel.setContent(contentLayout);
		content.addComponent(panel);
	}
}
