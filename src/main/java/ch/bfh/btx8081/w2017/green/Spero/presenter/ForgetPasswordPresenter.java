package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.ForgetPasswordModel;
import ch.bfh.btx8081.w2017.green.Spero.view.ForgetPasswordView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class ForgetPasswordPresenter implements SperoViewListener {
	
	 private final ForgetPasswordView forgetPasswordView;
	 private final ForgetPasswordModel forgetPasswordModel;

	    public ForgetPasswordPresenter(ForgetPasswordView forgetPasswordView,
	    		ForgetPasswordModel forgetPasswordModel) {
		this.forgetPasswordView = forgetPasswordView;
		this.forgetPasswordModel = forgetPasswordModel;
		forgetPasswordView.init();
		forgetPasswordView.addListener(this);
	    }

	@Override
	public void buttonClick(ClickEvent event) {
		final String buttonId = event.getButton().getId();

		switch (buttonId) {
		case "ok":
			String mail = forgetPasswordView.getEmail();
			
			try {
				forgetPasswordModel.sendEmail(mail);
			} catch (IncorrectException e) {
				forgetPasswordView.mailException.setValue(e.getMessage());
				break;
			}
			
			forgetPasswordView.getUI().getNavigator().navigateTo(Views.PIN_VIEW);
		    break;
	}
	}

}
