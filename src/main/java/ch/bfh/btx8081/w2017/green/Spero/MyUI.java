package ch.bfh.btx8081.w2017.green.Spero;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.model.ChangePinModel;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryModel;
import ch.bfh.btx8081.w2017.green.Spero.model.ForgetPasswordModel;
import ch.bfh.btx8081.w2017.green.Spero.model.MedicationModel;
import ch.bfh.btx8081.w2017.green.Spero.model.MenuModel;
import ch.bfh.btx8081.w2017.green.Spero.model.PinModel;
import ch.bfh.btx8081.w2017.green.Spero.model.ReminderModel;
import ch.bfh.btx8081.w2017.green.Spero.model.SettingsModel;
import ch.bfh.btx8081.w2017.green.Spero.presenter.ChangePinPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.ChatPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.DefDepressionPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.DiaryPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.ForgetPasswordPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.MainPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.MedicationPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.MenuPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.PinPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.ReportPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.ReminderPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.SettingsPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.SosPresenter;
import ch.bfh.btx8081.w2017.green.Spero.view.ChangePinView;
import ch.bfh.btx8081.w2017.green.Spero.view.ChatView;
import ch.bfh.btx8081.w2017.green.Spero.view.DefDepressionViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.DiaryViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.ForgetPasswordView;
import ch.bfh.btx8081.w2017.green.Spero.view.MainViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.MedicationViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.MenuView;
import ch.bfh.btx8081.w2017.green.Spero.view.PinView;
import ch.bfh.btx8081.w2017.green.Spero.view.ReminderView;
import ch.bfh.btx8081.w2017.green.Spero.view.ReportViewImpl;
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
	private static final long serialVersionUID = 1L;
	
	Navigator navigator; 
	String code;
	String code2;
	String code3;
	String username;
	String reminder;
	String snooze;
	String chat;
	
	//all classes
	MainViewImpl mainView;
	DiaryModel modelDiaryEntry;
	MenuView menuView;
	MenuModel menuModel;
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
	ReminderView reminderView;
	ReminderModel reminderModel;
	ForgetPasswordView forgetPasswordView;
	ForgetPasswordModel forgetPasswordModel;
	ReportViewImpl reportView; 
	DefDepressionViewImpl defDepressionView;
	MedicationViewImpl medInfoView; 
	MedicationModel medInfoModel;

	/**
	 * the init method in vaadin
	 */
    @Override
    protected void init(VaadinRequest vaadinRequest) {
   	 final VerticalLayout layout = new VerticalLayout();
   	 setContent(layout);
   	 ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(layout); 
   	 navigator = new Navigator(UI.getCurrent(), viewDisplay);
   	 
   	 //all classes
   	 pinView = new PinView();
   	 mainView = new MainViewImpl();
     modelDiaryEntry = new DiaryModel();
     menuView = new MenuView();
     menuModel = new MenuModel();
     sosView = new SosView();
     chatView = new ChatView();
     diaryView = new DiaryViewImpl();
     settingsView = new SettingsView();
     settingsModel = new SettingsModel(username, reminder, snooze, chat);
     pinModel = new PinModel(code);
     changePinView = new ChangePinView();
     changePinModel = new ChangePinModel(code, code2, code3);
     reminderView = new ReminderView();
     reminderModel = new ReminderModel();
     forgetPasswordView = new ForgetPasswordView();
     forgetPasswordModel = new ForgetPasswordModel();
     reportView = new ReportViewImpl(); 
     defDepressionView = new DefDepressionViewImpl(); 
     medInfoView = new MedicationViewImpl(); 
     medInfoModel = new MedicationModel(); 
     
     //add Views to the navigator
   	 navigator.addView("main", mainView);
   	 navigator.addView("report", new ReportViewImpl() );
   	 navigator.addView("menu", menuView);
   	 navigator.addView("sos", sosView);
   	 navigator.addView("chat", chatView);
   	 navigator.addView("diary", diaryView);
   	 navigator.addView("settings", settingsView);
   	 navigator.addView("", pinView);
   	 navigator.addView("changePin", changePinView);
   	 navigator.addView("reminder", reminderView);
   	 navigator.addView("forgetPassword", forgetPasswordView);
   	 navigator.addView("report", reportView);
   	 navigator.addView("defDepression", defDepressionView);
   	 navigator.addView("medInfoView", medInfoView);
   	 
   	 //creates all presenters
   	 new MainPresenter(mainView, modelDiaryEntry);
   	 new MenuPresenter(menuView, menuModel);
   	 new SosPresenter(sosView);
   	 new ChatPresenter(chatView);
   	 new DiaryPresenter(modelDiaryEntry, diaryView);
   	 settingsPresenter = new SettingsPresenter(settingsView, settingsModel, changePinView, menuView,
   			 mainView, defDepressionView, medInfoView, reportView);
   	 new PinPresenter(pinView, pinModel);
   	 new ChangePinPresenter(changePinView, changePinModel);
  	 new ReminderPresenter(reminderView, reminderModel);
   	 new ForgetPasswordPresenter(forgetPasswordView, forgetPasswordModel);
   	 new ReportPresenter(reportView); 
   	 new DefDepressionPresenter(defDepressionView); 
   	 new MedicationPresenter(medInfoView, medInfoModel); 
   	 
    }
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
		private static final long serialVersionUID = 1L;
    }
    
    
}
