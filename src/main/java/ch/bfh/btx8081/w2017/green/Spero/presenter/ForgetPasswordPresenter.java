package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.ForgetPasswordModel;
import ch.bfh.btx8081.w2017.green.Spero.view.ForgetPasswordView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

/**
 * connects the ForgetPasswordView with the ForgetPasswordModel
 * processes the input and the output
 * @author mirjam
 *
 */
public class ForgetPasswordPresenter implements SperoViewListener {
	
	private static final long serialVersionUID = 1L;
	private final ForgetPasswordView forgetPasswordView;
	private final ForgetPasswordModel forgetPasswordModel;

	/**
	 * builds the ForgetPasswordPresenter
	 * @param forgetPasswordView
	 * @param forgetPasswordModel
	 */
	public ForgetPasswordPresenter(ForgetPasswordView forgetPasswordView, ForgetPasswordModel forgetPasswordModel) {
		this.forgetPasswordView = forgetPasswordView;
		this.forgetPasswordModel = forgetPasswordModel;
		forgetPasswordView.init();
		forgetPasswordView.addListener(this);
	    }

	/**
	 * Handles the events    
	 */
	@Override
	public void buttonClick(ClickEvent event) {
		final String buttonId = event.getButton().getId();

		switch (buttonId) {
		
		/*checks the mail address if the user clicks the ok button
		* if the mail address is correcty, the new PIN is shown
		*/
		case "ok":
			String mail = forgetPasswordView.getEmail();
			boolean correctMail = ForgetPasswordModel.checkEmail(mail);
			
			if (correctMail == true) {
				forgetPasswordView.mailException.setValue("Der neue PIN ist 1234.");
			} else {
				forgetPasswordView.mailException.setValue("Die Email Adresse ist nicht korrekt.");
			}							
		    break;
		   
		// if the user clicks the back button, the PIN View is shown
		case "back":
			forgetPasswordView.getUI().getNavigator().navigateTo(Views.PIN_VIEW);
	}
	}

}
