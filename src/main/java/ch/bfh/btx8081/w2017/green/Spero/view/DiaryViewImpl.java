package ch.bfh.btx8081.w2017.green.Spero.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoView;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.SperoViewListener;

public class DiaryViewImpl extends CustomComponent implements SperoView {
	
	private List<SperoViewListener> listeners = new ArrayList<>();
	
	private Panel panel;
	
	public DiaryViewImpl() {
		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);
		
		panel = new Panel("PanelTest");
		panel.setHeight(100.0f, Unit.PERCENTAGE);
		
		VerticalLayout contentLayout = new VerticalLayout();
		contentLayout.setWidth(500, Unit.PIXELS);
		contentLayout.setSpacing(false);
		contentLayout.addComponent(new Label("PanelTestLabel"));
		
		panel.setContent(contentLayout);
		
		
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
