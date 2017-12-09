package ch.bfh.btx8081.w2017.green.Spero.presenter;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;
import ch.bfh.btx8081.w2017.green.Spero.model.ForgetPasswordModel;
import ch.bfh.btx8081.w2017.green.Spero.view.ForgetPasswordView;

public class ForgetPasswordPresenter implements ClickListener, SperoViewListener {
	
	 private final ForgetPasswordView forgetPasswordView;
	 private final ForgetPasswordModel forgetPasswordModel;

	    public ForgetPasswordPresenter(ForgetPasswordView forgetPasswordView,
	    		ForgetPasswordModel forgetPasswordModel) {
		this.forgetPasswordView = forgetPasswordView;
		this.forgetPasswordModel = forgetPasswordModel;
		forgetPasswordView.addListener(this);
	    }

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

}
