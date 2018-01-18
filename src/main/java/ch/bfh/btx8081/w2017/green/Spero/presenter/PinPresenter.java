package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.exceptionHandling.IncorrectException;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.PinModel;
import ch.bfh.btx8081.w2017.green.Spero.view.PinView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

/**
 * this class handles the events from the PinView
 * and connects the view with the model 
 * @author mirjam
 *
 */
public class PinPresenter implements SperoViewListener {
    
    private static final long serialVersionUID = 1L;
	private final PinView pinView;
    private final PinModel pinModel;

    /**
     * creates a PinPresenter constructor
     * @param pinView
     * @param pinModel
     */
    public PinPresenter(PinView pinView, PinModel pinModel) {
		this.pinView = pinView;
		this.pinModel = pinModel;
		pinView.init();
		pinView.addListener(this);
    }

    /**
     * handles the events from the view
     */
    @Override
    public void buttonClick(ClickEvent event) /*throws IncorrectException*/ {
	final String buttonId = event.getButton().getId();

	switch (buttonId) {
	
	//if the user clicks the ok Button
	case "ok":
		String code = pinView.getPin();
		System.out.println("Der Pin ist: " + code);
		
		/*checks the PIN, if it is correct
		 * if yes, the mainView opens
		 * if no, the user can try again
		 */
		try {
			pinModel.checkPin(code);
		} catch (IncorrectException e) {
			pinView.pinException.setValue(e.getMessage());
			break;
		}
		pinView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
	    break;
	    
	 // if the user has forgotten the PIN, the forgetPasswordView opens
	case "forgotten":
		pinView.getUI().getNavigator().navigateTo(Views.FORGET_PASSWORD_VIEW);
	    break;
	}
    }
}