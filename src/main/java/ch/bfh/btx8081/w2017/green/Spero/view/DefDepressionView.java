package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.Button.ClickEvent;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;

public class DefDepressionView extends CustomComponent implements SperoView {
	
	private Button menuButton;
	private Button sosButton;
	private Button chatButton;
	private Label title;
	private TextArea definition;
	private HorizontalLayout superButtonBox;
	
	private List<SperoViewListener> listeners = new ArrayList<SperoViewListener>();
	
	public DefDepressionView() {
		
		VerticalLayout layout = new VerticalLayout();
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
		menuButton = new Button(VaadinIcons.MENU);
		//set id für Button 
		menuButton.addClickListener(this);
		menuButton.setId("menuButton");
		
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
		
		HorizontalLayout defintionTextBox = new HorizontalLayout();
		defintionTextBox.setSizeFull();
		defintionTextBox.setMargin(true);
		defintionTextBox.setSpacing(true);
		definition = new TextArea();
		definition.setPlaceholder("Was ist eine Depression? \n Eine Depression ist eine psychische Erkrankung, die sich in zahlreichen Beschwerden äußern kann. Eine anhaltende gedrückte Stimmung, eine Hemmung von Antrieb und Denken, Interessenverlust sowie vielfältige körperliche Symptome, die von Schlaflosigkeit über Appetitstörungen bis hin zu Schmerzzuständen reichen, sind mögliche Anzeichen einer Depression. Die Mehrheit der Betroffenen hegt früher oder später Suizidgedanken, 10 bis 15% aller Patienten mit wiederkehrenden schwer ausgeprägten depressiven Phasen sterben durch Suizid. \n Viele der Betroffenen suchen allerdings keinen Arzt auf, sei es aus Unwissenheit, Verdrängung oder aus Schamgefühl. Häufig werden aber auch Depressionen aufgrund ihres vielfältigen Erscheinungsbildes vom Hausarzt nicht erkannt. Es gehört neben medizinischem Fachwissen viel psychiatrische Erfahrung dazu, um eine Depression schnell und sicher zu diagnostizieren. \n Wird einmal die richtige Diagnose gestellt, ist die Lage alles andere als aussichtslos. In den letzten Jahrzehnten hat sich hinsichtlich der Therapie einiges getan und mehr als 80% der Erkrankten kann dauerhaft und erfolgreich geholfen werden. Deswegen ist es umso wichtiger, dass die Allgemeinbevölkerung für dieses Thema sensibilisiert und aufgeklärt wird: Denn eine Depression kann jeden treffen, unabhängig von Alter, Geschlecht und sozialem Status. \n \n Arten der Depression: \n 1)	Von unipolarer Depression spricht man, wenn depressive Phasen, jedoch keine manischen Phasen auftreten. \n 2)	Treten außer den Symptomen der Niedergeschlagenheit, Antriebsarmut und Interesselosigkeit auch Phasen grundloser, übermäßig gehobener und distanzloser Stimmung (Manie) auf, liegt eine so genannte bipolare Störung vor. Bei ca. 20% der Patienten mit Depressionen verläuft die Erkrankung bipolar. In den letzten Jahren fanden sich Hinweise darauf, dass bipolare Störungen mit leichteren maniformen Symptomen noch häufiger sind und nicht selten unerkannt bleiben. Die reine Manie ohne depressive Phase ist mit etwa 5% sehr selten. \n \n Beide Erkrankungen gehören zum Formenkreis der affektiven Störungen. Eigentlich wäre die Bezeichnung Stimmungsstörungen anstelle von affektiven Störungen präziser, da es sich um eine Störung der Grundgestimmtheit und weniger um eine Störung der Affektivität (Gefühlsaufwallung in emotionalen Ausnahmesituationen) im eigentlichen Sinne handelt.");
		definition.setEnabled(false);
		definition.setRows(25);
		definition.setSizeFull();
		definition.addStyleName("defitionText");
		defintionTextBox.addComponent(definition);
		content.addComponent(defintionTextBox);
		
		superButtonBox = new HorizontalLayout();
		superButtonBox.setSizeFull();
		superButtonBox.setMargin(true);
		superButtonBox.setSpacing(true);
		content.addComponent(superButtonBox);
		sosButton = new Button(VaadinIcons.PHONE);
		sosButton.addClickListener(this);
		sosButton.setId("sosButton");
		superButtonBox.addComponent(sosButton);
		superButtonBox.setComponentAlignment(sosButton, Alignment.MIDDLE_LEFT);
	}
	
	public void buildChatButton(){
		chatButton = new Button(VaadinIcons.CHAT);
		chatButton.addClickListener(this);
		chatButton.setId("chat");
		superButtonBox.addComponent(chatButton);
		superButtonBox.setComponentAlignment(chatButton, Alignment.MIDDLE_LEFT);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		for (SperoViewListener listener : this.listeners) {
			listener.buttonClick(event);
		}
		
	}

	@Override
	public void addListener(SperoViewListener listener) {
		listeners.add(listener);		
	}

}
