package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.ButtonProvider;

/**
 * Creates the ForgetPasswordView with all the buttons
 * @author mirjam
 *
 */
public class ForgetPasswordView extends ButtonProvider {
	
	private static final long serialVersionUID = 1L;
	private Button back;
	private Label forget;
	private Label mail;
	private TextField mailAddress;
	public Label mailException;
	
	/**
	 * this creates the view for forgetPassword
	 */
	public ForgetPasswordView() {
		
		final VerticalLayout layout = new VerticalLayout();
    	setCompositionRoot(layout);

    	final VerticalLayout titleBarBox = new VerticalLayout();
    	this.back = new Button(VaadinIcons.ARROW_LEFT);
    	this.back.addClickListener(this);
    	back.setId("back");
    	titleBarBox.addComponent(this.back);
    	
    	this.forget = new Label("PIN vergessen");
    	titleBarBox.addComponent(this.forget);
    	layout.addComponent(titleBarBox);
    	
    	final HorizontalLayout contentLayout = new HorizontalLayout();
    	layout.addComponent(contentLayout);

    	final VerticalLayout content = new VerticalLayout();
    	content.setSizeFull();
    	content.setMargin(true);
    	content.setSpacing(true);
    	contentLayout.addComponent(content);

    	contentLayout.setExpandRatio(content, 9);

    	final VerticalLayout forgetPasswordItems = new VerticalLayout();
    	
    	final HorizontalLayout mailLayout = new HorizontalLayout();

    	//eMail
    	this.mail = new Label("E-mail: ");
    	mailLayout.addComponent(mail);
    	
    	this.mailAddress = new TextField();
    	this.mailAddress.setPlaceholder("e-mail");
    	mailLayout.addComponent(mailAddress);
    	
    	forgetPasswordItems.addComponent(mailLayout);
    	
    	//mailException
    	this.mailException = new Label("");
    	mailException.setId("pinValue");
    	forgetPasswordItems.addComponent(this.mailException);
    	this.ok.setClickShortcut(KeyCode.ENTER);
       	forgetPasswordItems.addComponent(this.ok);
    	
    	content.addComponent(forgetPasswordItems);
	}
	
	/**
	 * gets the email address
	 * @return the value of the email address
	 */
	public String getEmail(){
		return mailAddress.getValue();
	}
}
