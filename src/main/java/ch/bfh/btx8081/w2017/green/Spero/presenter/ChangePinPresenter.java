package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2017.green.Spero.exceptionHandling.IncorrectException;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.ChangePinModel;
import ch.bfh.btx8081.w2017.green.Spero.view.ChangePinView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

/**
 * connects the view and the model
 * processes the input and output
 * @author mirjam
 *
 */
public class ChangePinPresenter implements SperoViewListener {
	
	private static final long serialVersionUID = 1L;
	private final ChangePinView changePinView;
    private final ChangePinModel changePinModel;

    /**
     * creates the changePinPresenter
     * @param changePinView
     * @param changePinModel
     */
    public ChangePinPresenter(ChangePinView changePinView, ChangePinModel changePinModel) {
		this.changePinView = changePinView;
		this.changePinModel = changePinModel;
		changePinView.init();
		changePinView.addListener(this);
    }

    /**
     * handles the events of the ChangePinView
     */
	@Override
	public void buttonClick(ClickEvent event) {
		
		final String buttonId = event.getButton().getId();

		switch (buttonId) {
		
		//opens the menuView if the user clicks the menu button  
		case "menuButton":
			changePinView.getUI().getNavigator().navigateTo(Views.MENU_VIEW);
		    break;
		    
		/*opens the okView if the user clicks the ok button   
		 * and checks then if the old PIN is correct and
		 * if the newPin1 and newPin2 are equals, only numbers and consists four numbers   
		 */
		case "ok":
			String oldPin = changePinView.getOldPin();
			String newPin1 = changePinView.getNewPin1();
			String newPin2 = changePinView.getNewPin2();
			try {
				changePinModel.checkOldPin(oldPin);
				changePinModel.checkNewPin(newPin1, newPin2);
			} catch (IncorrectException e) {
				e.printStackTrace();
				changePinView.pinException.setValue(e.getMessage());
				break;
			}
			changePinView.pinException.setValue("Der PIN wurde erfolgreich geändert.");
			System.out.println("Der neue PIN ist: " + newPin1 + " und " + newPin2);
		    changePinView.getUI().getNavigator().navigateTo(Views.SETTINGS_VIEW);
		    break;
		    
		//opens the sosView if the user clicks the sos button      
		case "sos":
			changePinView.getUI().getNavigator().navigateTo(Views.SOS_VIEW);
		    break;
		    
		//opens the chatView if the user clicks the chat button      
		case "chat":
			changePinView.getUI().getNavigator().navigateTo(Views.CHAT_VIEW);
		    break;
		}
	}

}