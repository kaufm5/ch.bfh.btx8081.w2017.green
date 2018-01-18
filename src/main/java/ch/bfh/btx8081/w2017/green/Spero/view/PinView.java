package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.event.Action;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.ButtonProvider;

/**
 * this class provides the PinView
 * this view is shown first, when the user opens the application
 * @author mirjam
 *
 */
public class PinView extends ButtonProvider {
	
	private static final long serialVersionUID = 1L;
	private final Label hallo;
	private final PasswordField pin;
	public final Label pinException;
	
	/**
	 * creates the PinView
	 */
    public PinView() {
    	
    	final VerticalLayout layout = new VerticalLayout();
    	setCompositionRoot(layout);

    	final VerticalLayout titleBarBox = new VerticalLayout();
    	this.hallo = new Label("Hallo");
    	titleBarBox.addComponent(this.hallo);
    	layout.addComponent(titleBarBox);
    	
    	final HorizontalLayout contentLayout = new HorizontalLayout();
    	layout.addComponent(contentLayout);

    	final VerticalLayout content = new VerticalLayout();
    	content.setSizeFull();
    	content.setMargin(true);
    	content.setSpacing(true);
    	contentLayout.addComponent(content);

    	contentLayout.setExpandRatio(content, 9);

    	final VerticalLayout pinItems = new VerticalLayout();

    	//PIN
    	this.pin = new PasswordField("PIN");
    	pinItems.addComponent(this.pin);
    	
    	this.pinException = new Label("");
    	pinException.setId("pinValue");
    	//this.pin.addShortcutListener(new ShortcutListener("enter", ShortcutAction.KeyCode.ENTER, null));
    	//Action action_ok = new ShortcutAction("Default key", ShortcutAction.KeyCode.ENTER, null);
    	this.ok.setClickShortcut(KeyCode.ENTER);
    	//this.pin.addShortcutListener(new ShortcutListener(this.pin, KeyCode.ENTER, null));
    	pinItems.addComponent(this.pinException);
       	pinItems.addComponent(this.ok);
    	pinItems.addComponent(this.forgotten);
    	content.addComponent(pinItems);
    }
    
    /**
     * gets the value of the PIN
     * @return value of the PIN
     */
    public String getPin() {
    	return pin.getValue();
    }
}