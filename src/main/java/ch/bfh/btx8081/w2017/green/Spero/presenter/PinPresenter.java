package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.PinModel;
import ch.bfh.btx8081.w2017.green.Spero.view.PinView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class PinPresenter implements ClickListener, SperoViewListener {
    
    private final PinView pinView;
    private final PinModel pinModel;

    public PinPresenter(PinView pinView, PinModel pinModel) {
	this.pinView = pinView;
	this.pinModel = pinModel;
	pinView.addListener(this);
    }

    @Override
    public void buttonClick(ClickEvent event) /*throws IncorrectException*/ {
	final String buttonId = event.getButton().getId();
//	String code = pinView.getPin();
//	try {
//		pinModel.checkPin(code);
//		//pinView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
//	} catch (IncorrectException e) {
//		e.printStackTrace();
//		break;
//	}
	switch (buttonId) {
	case "ok":
		String code = pinView.getPin();
		System.out.println("Der Pin ist: " + code);
		
		try {
			pinModel.checkPin(code);
			//pinView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
		} catch (IncorrectException e) {
			e.printStackTrace();
			//String exceptionMessage = e.getMessage();
			pinView.pinValue.setValue(e.getMessage());
//			System.out.println("Der Pin ist: " + code);
			break;
		}
		pinView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
	    break;
	default:
	    //
	    break;
	}
    }
}