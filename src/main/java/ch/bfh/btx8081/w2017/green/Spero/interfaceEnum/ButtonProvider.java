package ch.bfh.btx8081.w2017.green.Spero.interfaceEnum;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;

public class ButtonProvider extends CustomComponent implements SperoView {
	private final List<SperoViewListener> listeners = new ArrayList<SperoViewListener>();

	public final Button menuButton = new Button(VaadinIcons.MENU);
	public final Button ok = new Button("OK");
	public final Button sosButton = new Button(VaadinIcons.PHONE);
	public final Button chatButton = new Button(VaadinIcons.CHAT);
	public final Button send = new Button(VaadinIcons.PAPERPLANE_O);
	public final Button attachment = new Button(VaadinIcons.PAPERCLIP);
	public final Button refreshButton = new Button(VaadinIcons.REFRESH);
	public final Button newButton = new Button(VaadinIcons.PLUS_CIRCLE);
	public final Button confirmButton = new Button(VaadinIcons.CHECK);
	public final Button smileSchlecht = new Button(VaadinIcons.FROWN_O);
	public final Button smileEherSchlecht = new Button(VaadinIcons.MEH_O);
	public final Button smileEherGut = new Button(VaadinIcons.SMILEY_O);
	public final Button smileGut = new Button(VaadinIcons.SMILEY_O);
	public final Button gefuehlslage = new Button("Gefühlslage");
	public final Button diary = new Button("Tagebuch");
	public final Button report = new Button("Statistik");
	public final Button reminder = new Button("Reminder");
	public final Button medInfo = new Button("Informationen zu der Medikation");
	public final Button depErk = new Button("Erläuterung der Depression");
	public final Button settings= new Button("Einstellungen");
	public final Button forgotten = new Button("Passwort vergessen?");
	public final Button moreMedi = new Button(VaadinIcons.PLUS);
	public final Button change = new Button("Ändern");
	
	public void init(){
		menuButton.addClickListener(this);
		menuButton.setId("menuButton");
		
		chatButton.addClickListener(this);
		chatButton.setId("chat");
		
		sosButton.addClickListener(this);
		sosButton.setId("sos");

    	ok.addClickListener(this);
    	ok.setId("ok");

    	send.addClickListener(this);
    	send.setId("send");

    	attachment.addClickListener(this);
    	attachment.setId("attachment");

		refreshButton.addClickListener(this);
		refreshButton.setId("refreshButton");

		newButton.addClickListener(this);
		newButton.setId("newButton");

		smileSchlecht.addClickListener(this);
		smileSchlecht.setId("smileSchlecht");

		smileEherSchlecht.addClickListener(this);
		smileEherSchlecht.setId("smileEherSchlecht");

		smileEherGut.addClickListener(this);
		smileEherGut.setId("smileEherGut");

		smileGut.addClickListener(this);
		smileGut.setId("smileGut");

		confirmButton.addClickListener(this);
		confirmButton.setId("confirmButton");

		gefuehlslage.addClickListener(this);
		gefuehlslage.setId("gefuehlslage");

		diary.addClickListener(this);
		diary.setId("diary");

		report.addClickListener(this);
		report.setId("report");

		reminder.addClickListener(this);
		reminder.setId("reminder");

		medInfo.addClickListener(this);
		medInfo.setId("medInfo");

		depErk.addClickListener(this);
		depErk.setId("depErk");

		settings.addClickListener(this);
		settings.setId("settings");

    	forgotten.addClickListener(this);
    	forgotten.setId("forgotten");

		moreMedi.addClickListener(this);
		moreMedi.setId("moreMedis");

    	change.addClickListener(this);
    	change.setId("change");

	}

	@Override
	public void buttonClick(ClickEvent event) {
		for (final ClickListener listener : this.listeners) {
		    listener.buttonClick(event);
		}		
	}

	@Override
	public void addListener(SperoViewListener listener) {
		this.listeners.add(listener);
	}
}
