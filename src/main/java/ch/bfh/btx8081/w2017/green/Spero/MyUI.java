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

import ch.bfh.btx8081.w2017.green.Spero.model.ChangePinModel;
import ch.bfh.btx8081.w2017.green.Spero.model.Diary;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryEntry;
import ch.bfh.btx8081.w2017.green.Spero.model.PinModel;
import ch.bfh.btx8081.w2017.green.Spero.model.SettingsModel;
import ch.bfh.btx8081.w2017.green.Spero.presenter.ChangePinPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.ChatPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.DiaryPresenter;
//import ch.bfh.btx8081.w2017.green.Spero.presenter.DiaryEntryPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.MainPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.MenuPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.PinPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.SettingsPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.SosPresenter;
import ch.bfh.btx8081.w2017.green.Spero.view.ChangePinView;
import ch.bfh.btx8081.w2017.green.Spero.view.ChatView;
import ch.bfh.btx8081.w2017.green.Spero.view.DiaryViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.MainViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.MenuView;
import ch.bfh.btx8081.w2017.green.Spero.view.PinView;
import ch.bfh.btx8081.w2017.green.Spero.view.ReportView;
import ch.bfh.btx8081.w2017.green.Spero.view.SettingsView;
import ch.bfh.btx8081.w2017.green.Spero.view.SosView;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 * thierry & omar = beste, test
 */
@Theme("mytheme")
public class MyUI extends UI {
	
	Navigator navigator; 
	String code;
	String code2;
	String code3;
	
	MainViewImpl mainView;
	Diary modelDiary;
	DiaryEntry modelDiaryEntry;
	MenuView menuView;
	SosView sosView;
	ChatView chatView;
	DiaryViewImpl diaryView;
	SettingsView settingsView;
	SettingsPresenter settingsPresenter;
	SettingsModel settingsModel;
	PinView pinView;
	PinModel pinModel;
	ChangePinView changePinView;
	ChangePinModel changePinModel;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
   	 final VerticalLayout layout = new VerticalLayout();
   	 setContent(layout);
   	 
   	 ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(layout); 
   	 navigator = new Navigator(UI.getCurrent(), viewDisplay);
   	 
   	 pinView = new PinView();
   	 mainView = new MainViewImpl();
     modelDiary = new Diary();
     modelDiaryEntry = new DiaryEntry();
     menuView = new MenuView();
     sosView = new SosView();
     chatView = new ChatView();
     diaryView = new DiaryViewImpl();
     settingsView = new SettingsView(settingsPresenter);
     settingsModel = new SettingsModel();
     pinModel = new PinModel(code);
     changePinView = new ChangePinView();
     changePinModel = new ChangePinModel(code, code2, code3);
     
   	 navigator.addView("main", mainView);
   	 navigator.addView("report", new ReportView() );
   	 navigator.addView("menu", menuView);
   	 navigator.addView("sos", sosView);
   	 navigator.addView("chat", chatView);
   	 navigator.addView("diary", diaryView);
   	 navigator.addView("settings", settingsView);
   	 navigator.addView("", pinView);
   	 navigator.addView("changePin", changePinView);
   	 
   	 new MainPresenter(mainView, modelDiaryEntry, modelDiary);
   	 new MenuPresenter(menuView);
   	 new SosPresenter(sosView);
   	 new ChatPresenter(chatView);
   	 new DiaryPresenter(modelDiary, diaryView);
   	 settingsPresenter = new SettingsPresenter(settingsView, settingsModel);
   	 new PinPresenter(pinView, pinModel);
   	 new ChangePinPresenter(changePinView, changePinModel);
   	 
    }
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
    
    
}
