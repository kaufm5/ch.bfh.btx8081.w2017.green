package ch.bfh.btx8081.w2017.green.Spero.interfaceEnum;

import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button.ClickEvent;

public interface SperoView extends View, SperoViewListener {
//	public void setDisplay(double disp); test
	
	public void addListener(SperoViewListener listener);


}
