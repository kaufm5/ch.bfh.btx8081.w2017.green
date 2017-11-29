package ch.bfh.btx8081.w2017.green.Spero.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;

public class DiaryViewImpl extends CustomComponent implements SperoView {
	
	private List<SperoViewListener> listeners = new ArrayList<>();
	
	public DiaryViewImpl() {
		
	}
	
	
	

	@Override
	public void buttonClick(ClickEvent event) {
		for(SperoViewListener listener : this.listeners) {
			listener.buttonClick(event);
		}
		
	}

	@Override
	public void addListener(SperoViewListener listener) {
		listeners.add(listener);
		
	}

}
