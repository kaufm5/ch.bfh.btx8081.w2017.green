package ch.bfh.btx8081.w2017.green.Spero.interfaceEnum;

import com.vaadin.ui.Button.ClickEvent;

public interface ButtonView {
//	public void setDisplay(double disp);
	
	interface ButtonClickListener {
		void buttonClick(ClickEvent event);
	}
	
	public void addListener(ButtonClickListener listener);

}
