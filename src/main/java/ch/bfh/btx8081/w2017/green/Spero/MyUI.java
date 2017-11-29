package ch.bfh.btx8081.w2017.green.Spero;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.model.Diary;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryEntry;
//import ch.bfh.btx8081.w2017.green.Spero.presenter.DiaryEntryPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.MainPresenter;
import ch.bfh.btx8081.w2017.green.Spero.view.ChatView;
import ch.bfh.btx8081.w2017.green.Spero.view.MainViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.MenuView;
import ch.bfh.btx8081.w2017.green.Spero.view.ReportView;
import ch.bfh.btx8081.w2017.green.Spero.view.SosView;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 * thierry & omar = beste
 */
@Theme("mytheme")
public class MyUI extends UI {
	
	Navigator navigator; 
	MainViewImpl mainView;
	Diary model;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
   	 final VerticalLayout layout = new VerticalLayout();
   	 setContent(layout);
   	 
   	 ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(layout); 
   	 navigator = new Navigator(UI.getCurrent(), viewDisplay);
   	 
   	 
   	 mainView = new MainViewImpl();
   	 model = new Diary();
   	 navigator.addView("", mainView);
   	 navigator.addView("report", new ReportView() );
   	 navigator.addView("menu", new MenuView());
   	 navigator.addView("sos", new SosView());
   	 navigator.addView("chat", new ChatView());
   	 new MainPresenter(mainView, model); 
   	 
   	 
    }
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
    
    
}
