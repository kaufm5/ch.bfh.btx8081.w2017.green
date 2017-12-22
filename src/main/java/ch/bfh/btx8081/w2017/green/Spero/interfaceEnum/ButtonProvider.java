package ch.bfh.btx8081.w2017.green.Spero.interfaceEnum;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;

import ch.bfh.btx8081.w2017.green.Spero.utils.ConfigManager;

public class ButtonProvider extends CustomComponent implements SperoView {
	private static final ConfigManager CONFIG_MANAGER = ConfigManager
			.getInstance();
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
	public final Button settings = new Button("Einstellungen");
	public final Button forgotten = new Button("Passwort vergessen?");
	public final Button moreMedi = new Button(VaadinIcons.PLUS);
	public final Button change = new Button("Ändern");

	public void init() {
		this.menuButton.addClickListener(this);
		this.menuButton.setId("menuButton");

		this.chatButton.addClickListener(this);
		this.chatButton.setId("chat");
		if (!ButtonProvider.CONFIG_MANAGER.isChatEnabled()) {
			this.chatButton.setVisible(false);
		}

		this.sosButton.addClickListener(this);
		this.sosButton.setId("sos");

		this.ok.addClickListener(this);
		this.ok.setId("ok");

		this.send.addClickListener(this);
		this.send.setId("send");

		this.attachment.addClickListener(this);
		this.attachment.setId("attachment");

		this.refreshButton.addClickListener(this);
		this.refreshButton.setId("refreshButton");

		this.newButton.addClickListener(this);
		this.newButton.setId("newButton");

		this.smileSchlecht.addClickListener(this);
		this.smileSchlecht.setId("smileSchlecht");

		this.smileEherSchlecht.addClickListener(this);
		this.smileEherSchlecht.setId("smileEherSchlecht");

		this.smileEherGut.addClickListener(this);
		this.smileEherGut.setId("smileEherGut");

		this.smileGut.addClickListener(this);
		this.smileGut.setId("smileGut");

		this.confirmButton.addClickListener(this);
		this.confirmButton.setId("confirmButton");

		this.gefuehlslage.addClickListener(this);
		this.gefuehlslage.setId("gefuehlslage");

		this.diary.addClickListener(this);
		this.diary.setId("diary");

		this.report.addClickListener(this);
		this.report.setId("report");

		this.reminder.addClickListener(this);
		this.reminder.setId("reminder");

		this.medInfo.addClickListener(this);
		this.medInfo.setId("medInfo");

		this.depErk.addClickListener(this);
		this.depErk.setId("depErk");

		this.settings.addClickListener(this);
		this.settings.setId("settings");

		this.forgotten.addClickListener(this);
		this.forgotten.setId("forgotten");

		this.moreMedi.addClickListener(this);
		this.moreMedi.setId("moreMedis");

		this.change.addClickListener(this);
		this.change.setId("change");

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
