package ch.bfh.btx8081.w2017.green.Spero.view;

import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;

import org.vaadin.addons.searchbox.SearchBox;
import org.vaadin.addons.searchbox.event.SearchListener;

import com.vaadin.event.ContextClickEvent.ContextClickListener;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.ButtonProvider;
import ch.bfh.btx8081.w2017.green.Spero.model.MedicationModel;
import ch.bfh.btx8081.w2017.green.Spero.persistence.DB;
import ch.bfh.btx8081.w2017.green.Spero.persistence.Medication;
import ch.bfh.btx8081.w2017.green.Spero.persistence.MedicationList;

public class MedicationViewImpl extends ButtonProvider {

	private TextField text; 
	private Button searchButton; 
	private Label title; 
	private HorizontalLayout superButtonBox;
	private Panel panel; 
	private VerticalLayout layout; 
	private VerticalLayout contentLayout; 

	public MedicationViewImpl() {

		layout = new VerticalLayout();
		setCompositionRoot(layout);

		panel = new Panel();
		contentLayout = new VerticalLayout();
		
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

		menuBox.addComponent(menuButton);
		menuBox.setComponentAlignment(menuButton, Alignment.MIDDLE_LEFT);
		menuBox.addStyleName("menu");
		menuAndContent.addComponent(menuBox);

		VerticalLayout content = new VerticalLayout();
		content.setSizeFull();
		content.setMargin(true);
		content.setSpacing(true);
		menuAndContent.addComponent(content);

		menuAndContent.setExpandRatio(menuBox, 1);
		menuAndContent.setExpandRatio(content, 9);

		HorizontalLayout searchBox = new HorizontalLayout(); 
		text = new TextField(); 
		text.setPlaceholder("medication name");

		searchButton = new Button(VaadinIcons.SEARCH); 
		searchButton.setDescription("Search Medication");
		searchButton.setId("searchMedication");
		searchButton.addClickListener(this); 

		content.addComponent(searchBox);
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

	public void buildChatButton(){
		superButtonBox.addComponent(chatButton);
		superButtonBox.setComponentAlignment(chatButton, Alignment.MIDDLE_LEFT);
	}

	public TextField getText() {
		return text;
	}

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
		layout.addComponent(panel);
	}

	//	public String searchMedication(String value) { 
	//
	//		if (value.equals(search.getPlaceholder())) { 
	//
	//			panel = new Panel(value); 
	//			panel.setHeight(100.0f, Unit.PERCENTAGE);
	//
	//			VerticalLayout contentLayout = new VerticalLayout();
	//			contentLayout.setWidth(500, Unit.PIXELS);
	//			contentLayout.setSpacing(false);
	//
	//			panel.setContent(contentLayout);
	//			layout.addComponent(panel);
	//		}
	//		Medication med = new Medication(); 
	//		return searchMedication(med.getMedName() + med.getMedDescription());
	//	}


}
