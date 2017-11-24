package ch.bfh.btx8081.w2017.green.Spero.interfaceEnum;

import com.vaadin.event.MouseEvents.ClickEvent;

public interface ButtonView {
//	public void setDisplay(double disp);
	
	interface ButtonClickListener {
		  void buttonClick(String operation);
	}
	
	public void addListener(ButtonClickListener listener);

	//void buttonClick(ClickEvent event);

}
