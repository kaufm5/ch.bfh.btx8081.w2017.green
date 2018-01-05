package ch.bfh.btx8081.w2017.green.Spero.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.annotations.Push;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Broadcaster;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Broadcaster.BroadcastListener;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.ButtonProvider;
import ch.bfh.btx8081.w2017.green.Spero.model.ChatMessage;

/**
 * The class ChatView shows the chat view of the Spero-application
 *
 * @author stahm2
 */

@Push
public class ChatView extends ButtonProvider implements BroadcastListener {
	private final VerticalLayout layout = new VerticalLayout();
	private final Label title, username;
	private final TextField chat;

	final Grid<ChatMessage> grid = new Grid<ChatMessage>();
	private final List<ChatMessage> chatMessages = new ArrayList<ChatMessage>();

	/**
	 * Constructs the chat view
	 */
	public ChatView() {
		setCompositionRoot(this.layout);
		final VerticalLayout titleBarBox = new VerticalLayout();
		titleBarBox.addStyleName("titleBarBox");
		this.title = new Label("Spero");
		this.title.addStyleName("title");
		titleBarBox.addComponent(this.title);
		this.layout.addComponent(titleBarBox);

		final HorizontalLayout menuAndContent = new HorizontalLayout();
		menuAndContent.setSizeFull();
		menuAndContent.setMargin(true);
		menuAndContent.setSpacing(true);
		this.layout.addComponent(menuAndContent);

		final VerticalLayout menuBox = new VerticalLayout();
		menuBox.setSpacing(true);
		menuBox.setMargin(true);

		menuBox.addComponent(this.menuButton);
		menuBox.setComponentAlignment(this.menuButton, Alignment.MIDDLE_LEFT);

		menuBox.addStyleName("menu");
		menuAndContent.addComponent(menuBox);

		final VerticalLayout content = new VerticalLayout();
		content.setSizeFull();
		content.setMargin(true);
		content.setSpacing(true);
		menuAndContent.addComponent(content);

		menuAndContent.setExpandRatio(menuBox, 1);
		menuAndContent.setExpandRatio(content, 9);

		final HorizontalLayout userBox = new HorizontalLayout();
		userBox.setMargin(true);
		userBox.setSpacing(true);
		this.username = new Label("Username");
		content.addComponent(userBox);
		userBox.addComponent(this.username);

		final HorizontalLayout sendBox = new HorizontalLayout();
		sendBox.setMargin(true);
		sendBox.setSpacing(true);
		this.chat = new TextField();
		this.chat.setPlaceholder("Enter your Text here!");
		sendBox.addComponents(this.chat, this.send, this.attachment);
		content.addComponent(sendBox);

		this.grid.setItems(this.chatMessages);
		this.grid.addColumn(ChatMessage::getCurrentTimeMillis).setCaption("Time");
		this.grid.addColumn(ChatMessage::getSenderName).setCaption("From");
		this.grid.addColumn(ChatMessage::getFulltextMessage).setCaption("Message");
		this.layout.addComponent(this.grid);

		final HorizontalLayout superButtonBox = new HorizontalLayout();
		superButtonBox.setSizeFull();
		superButtonBox.setMargin(true);
		superButtonBox.setSpacing(true);
		content.addComponent(superButtonBox);
		superButtonBox.addComponent(this.sosButton);
		superButtonBox.setComponentAlignment(this.sosButton, Alignment.MIDDLE_LEFT);

		this.send.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// Broadcast the message
				Broadcaster.broadcast(ChatView.this.chat.getValue());
				ChatView.this.chat.setValue("");
			}
		});

		Broadcaster.register(this);
	}

	// Must also unregister when the UI expires
	@Override
	public void detach() {
		Broadcaster.unregister(this);
		super.detach();
	}

	@Override
	public void receiveBroadcast(final String message) {
		// Must lock the session to execute logic safely
		ChatView.this.getCompositionRoot().getUI().access(new Runnable() {
			@Override
			public void run() {
				// Show it somehow
				pushMessage(System.currentTimeMillis(), System.getProperty("user.name"), message);
			}
		});
	}

	public void pushMessage(long currentTimeMillis, String senderName, String fulltextMessage) {
		this.chatMessages.add(new ChatMessage(currentTimeMillis, senderName, fulltextMessage));
		ChatView.this.grid.setItems(ChatView.this.chatMessages);
	}

	public List<ChatMessage> getMessages() {
		return this.chatMessages;
	}
}
