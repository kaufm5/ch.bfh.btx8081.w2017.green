package ch.bfh.btx8081.w2017.green.Spero.view;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;

public class ForgetPasswordView extends CustomComponent implements SperoView {
	
	private Label forget;
	private Label mail;
	private TextField mailAddress;
	public Label mailException;
	private final Button ok;
	
	private final List<ClickListener> listeners = new ArrayList<ClickListener>();
	
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
    	
    	this.ok = new Button("OK");
    	this.ok.addClickListener(this);
    	this.ok.setId("ok");
    	forgetPasswordItems.addComponent(this.ok);
    	
    	content.addComponent(forgetPasswordItems);
		
	}
	
	public String getEmail(){
		return mailAddress.getValue();
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
