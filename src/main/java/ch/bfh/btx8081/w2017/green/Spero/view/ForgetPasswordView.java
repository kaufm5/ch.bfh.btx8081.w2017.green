package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.ButtonProvider;

public class ForgetPasswordView extends ButtonProvider {
	private Label forget;
	private Label mail;
	private TextField mailAddress;
	public Label mailException;
		
	public ForgetPasswordView() {
		
		final VerticalLayout layout = new VerticalLayout();
    	setCompositionRoot(layout);

    	final VerticalLayout titleBarBox = new VerticalLayout();
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

    	this.mail = new Label("E-mail: ");
    	mailLayout.addComponent(mail);
    	
    	this.mailAddress = new TextField();
    	this.mailAddress.setPlaceholder("e-mail");
    	mailLayout.addComponent(mailAddress);
    	
    	forgetPasswordItems.addComponent(mailLayout);
    	
    	this.mailException = new Label("");
    	mailException.setId("pinValue");
    	forgetPasswordItems.addComponent(this.mailException);
       	forgetPasswordItems.addComponent(this.ok);
    	
    	content.addComponent(forgetPasswordItems);
	}
	
	public String getEmail(){
		return mailAddress.getValue();
	}
}
