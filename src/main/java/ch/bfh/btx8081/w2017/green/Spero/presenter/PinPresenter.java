package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;
import ch.bfh.btx8081.w2017.green.Spero.model.PinModel;
import ch.bfh.btx8081.w2017.green.Spero.view.PinView;
import ch.bfh.btx8081.w2017.green.Spero.view.Views;

public class PinPresenter implements ClickListener {
    // TODO: implement pinView and pinModel interactions
    private final PinView pinView;
    private final PinModel pinModel;

    public PinPresenter(PinView pinView, PinModel pinModel) {
	this.pinView = pinView;
	this.pinModel = pinModel;
	pinView.addListener(this);
    }

    @Override
    public void buttonClick(ClickEvent event) {
	final String buttonId = event.getButton().getId();

	switch (buttonId) {
	case "ok":
//		String code = pinView.getPin();
//		try {
//			pinModel.checkPin(code);
//		} catch (IncorrectException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    pinView.getUI().getNavigator().navigateTo(Views.MAIN_VIEW);
	    break;
	default:
	    //
	    break;
	}
    }
}
