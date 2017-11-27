package ch.bfh.btx8081.w2017.green.Spero.interfaceEnum;

import com.vaadin.event.MouseEvents.ClickEvent;

public interface MainView {
	public void setDisplay(String testText);

	interface MainViewListener {
		void buttonClick(char operation);
	}

	public void addListener(MainViewListener listener);
	
}
