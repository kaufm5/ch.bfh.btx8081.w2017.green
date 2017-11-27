package ch.bfh.btx8081.w2017.green.Spero.interfaceEnum;

import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button.ClickEvent;

public interface ButtonView extends ClickListener {
//	public void setDisplay(double disp);
	
	interface ButtonClickListener extends View, ButtonView {
		void buttonClick(ClickEvent event);
	}
	
	public void addListener(ButtonClickListener listener);


}
