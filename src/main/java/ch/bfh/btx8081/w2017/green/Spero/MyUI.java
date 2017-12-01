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

import ch.bfh.btx8081.w2017.green.Spero.model.Diary;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryEntry;
import ch.bfh.btx8081.w2017.green.Spero.model.PinModel;
import ch.bfh.btx8081.w2017.green.Spero.model.SettingsModel;
import ch.bfh.btx8081.w2017.green.Spero.presenter.ChatPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.DiaryPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.MainPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.MenuPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.PinPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.SettingsPresenter;
import ch.bfh.btx8081.w2017.green.Spero.presenter.SosPresenter;
import ch.bfh.btx8081.w2017.green.Spero.view.ChatView;
import ch.bfh.btx8081.w2017.green.Spero.view.DiaryViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.MainViewImpl;
import ch.bfh.btx8081.w2017.green.Spero.view.MenuView;
import ch.bfh.btx8081.w2017.green.Spero.view.PinView;
import ch.bfh.btx8081.w2017.green.Spero.view.ReportView;
import ch.bfh.btx8081.w2017.green.Spero.view.SettingsView;
import ch.bfh.btx8081.w2017.green.Spero.view.SosView;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality. thierry & omar = beste
 */
@Theme("mytheme")
public class MyUI extends UI {
    private final VerticalLayout layout = new VerticalLayout();

    private Navigator navigator;
    private final MainViewImpl mainView = new MainViewImpl();
    private final Diary modelDiary = new Diary();
    private final DiaryEntry modelDiaryEntry = new DiaryEntry();
    private final MenuView menuView = new MenuView();
    private final SosView sosView = new SosView();
    private final ChatView chatView = new ChatView();
    private final DiaryViewImpl diaryView = new DiaryViewImpl();
    private final SettingsView settingsView = new SettingsView();
    private final SettingsModel settingsModel = new SettingsModel();
    private final PinView pinView = new PinView();
    private final PinModel pinModel = new PinModel();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
	setContent(this.layout);

	final ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(this.layout);
	this.navigator = new Navigator(UI.getCurrent(), viewDisplay);

	this.navigator.addView("", this.mainView);
	this.navigator.addView("report", new ReportView());
	this.navigator.addView("menu", this.menuView);
	this.navigator.addView("sos", this.sosView);
	this.navigator.addView("chat", this.chatView);
	this.navigator.addView("diary", this.diaryView);
	this.navigator.addView("settings", this.settingsView);
	this.navigator.addView("pin", this.pinView);

	new MainPresenter(this.mainView, this.modelDiaryEntry, this.modelDiary);
	new MenuPresenter(this.menuView);
	new SosPresenter(this.sosView);
	new ChatPresenter(this.chatView);
	new DiaryPresenter(this.modelDiary, this.diaryView);
	new SettingsPresenter(this.settingsView, this.settingsModel);
	new PinPresenter(this.pinView, this.pinModel);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
