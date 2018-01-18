package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.ButtonProvider;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;

public class DiaryViewImpl extends ButtonProvider {
	private Label title;
	private Panel panel;
	VerticalLayout layout;

	// TESTING test
	private Label display;

	public DiaryViewImpl() {
		layout = new VerticalLayout();
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

		VerticalLayout diaryBox = new VerticalLayout();
		diaryBox.setSizeFull();
		diaryBox.setMargin(true);
		diaryBox.setSpacing(true);
		content.addComponent(diaryBox);
		title = new Label("Diary");
		diaryBox.addComponent(title);

		HorizontalLayout diaryButton = new HorizontalLayout();
		diaryBox.addComponent(diaryButton);
		diaryButton.addComponents(refreshButton, newButton);

		HorizontalLayout superButtonBox = new HorizontalLayout();
		superButtonBox.setMargin(true);
		superButtonBox.setSpacing(true);
		content.addComponent(superButtonBox);
		superButtonBox.addComponents(sosButton, chatButton);

	}

	// Each DiaryEntry will be a Panel shown in the DiaryViewImpl.
	// The Method addEntryToView create such an Panel
	public void addEntryToView(int diaryID, String title, String text, Mood moodParam) {

		// The Panel title will be the title of the DiaryEntry
		panel = new Panel(title);
		panel.setHeight(100.0f, Unit.PERCENTAGE);

		VerticalLayout contentLayout = new VerticalLayout();
		contentLayout.setWidth(500, Unit.PIXELS);
		contentLayout.setSpacing(false);

		// In the body of the Panel are the DiaryEntry text,the selected Mood and a
		// button to delete the DiaryEntry
		Label tx = new Label(text);
		Label strMoodParam = new Label(moodParam.toString());

		Button buttonDelete = new Button(VaadinIcons.FILE_REMOVE);
		buttonDelete.addClickListener(this);
		buttonDelete.setId(Integer.toString(diaryID)); // The buttonID will be the Primary Key of the specific
														// DiaryEntry.

		contentLayout.addComponent(strMoodParam);
		contentLayout.addComponent(tx);
		contentLayout.addComponent(buttonDelete);

		panel.setContent(contentLayout);
		layout.addComponent(panel);
	}
}
