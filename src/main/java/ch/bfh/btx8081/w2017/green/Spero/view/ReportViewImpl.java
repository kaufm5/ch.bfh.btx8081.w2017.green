package ch.bfh.btx8081.w2017.green.Spero.view;

import java.util.Arrays;
import java.util.Calendar;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.ButtonProvider;
import ch.bfh.btx8081.w2017.green.Spero.reportChart.HighChart;

/**
 * This class is the view of the diary entries report screen
 * 
 * @author mussi
 *
 */
public class ReportViewImpl extends ButtonProvider {
	private static final long serialVersionUID = 1L;

	private Label reportTitle; 
	private ComboBox<String> monthChoice; 
	private HorizontalLayout superButtonBox;
	private HighChart chart = new HighChart();


	public ReportViewImpl() { 
		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);

		VerticalLayout titleBarBox = new VerticalLayout(); 
		reportTitle = new Label("Statistik");
		titleBarBox.addComponent(reportTitle);
		layout.addComponent(titleBarBox);

		HorizontalLayout menuAndContent = new HorizontalLayout ();
		layout.addComponent(menuAndContent);

		VerticalLayout menuBox = new VerticalLayout(); 
		menuBox.addComponent(menuButton);
		menuAndContent.addComponent(menuBox);

		VerticalLayout content = new VerticalLayout(); 
		menuAndContent.addComponent(content);

		menuAndContent.setExpandRatio(menuBox, 1);
		menuAndContent.setExpandRatio(content, 9);

		HorizontalLayout comboBox = new HorizontalLayout(); 

		monthChoice = new ComboBox<String>("Month"); 
		comboBox.addComponent(monthChoice);
		content.addComponent(comboBox);
		monthChoice.setItems("Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August",
				"September", "Oktober", "November", "Dezember");

		VerticalLayout smileys = new VerticalLayout(); 
		smileys.addComponents(smileSchlecht, smileEherSchlecht, smileEherGut, smileGut);
		smileys.setComponentAlignment(smileSchlecht, Alignment.MIDDLE_CENTER);
		smileys.setComponentAlignment(smileEherSchlecht, Alignment.MIDDLE_CENTER);
		smileys.setComponentAlignment(smileEherGut, Alignment.MIDDLE_CENTER);
		smileys.setComponentAlignment(smileGut, Alignment.MIDDLE_CENTER);

		HorizontalLayout chartXY = new HorizontalLayout(); 
		chartXY.addComponents(smileys, chart);
		chartXY.setComponentAlignment(smileys, Alignment.MIDDLE_CENTER);
		chartXY.setComponentAlignment(chart, Alignment.MIDDLE_CENTER);

		chartXY.setComponentAlignment(chart, Alignment.MIDDLE_CENTER);
		content.addComponents(chartXY);
		content.setComponentAlignment(chartXY, Alignment.MIDDLE_CENTER);

		superButtonBox = new HorizontalLayout();
		superButtonBox.setSizeFull();
		superButtonBox.setMargin(true);
		superButtonBox.setSpacing(true);
		content.addComponent(superButtonBox);
		superButtonBox.addComponent(sosButton);
		superButtonBox.setComponentAlignment(sosButton, Alignment.MIDDLE_LEFT);

	}

	/**
	 * Shows the chart data and sets the title of the chart 
	 * 
	 * @param type  
	 * @param data 
	 */
	public void chartDataShow(String type, int[] data) {
		if (type.equals("year")) {
			chart.setHcjs("var options = { " + "title: { text: 'Mood report' }, "
					+ "xAxis: {categories:[" + getChartString("year") + "]},"
					+ "series: [{ name: 'Mood in month', data: "+ Arrays.toString(data) + "}] };");
		} 
	}

	/**
	 * Gets the x-axis data of the chart with the months 
	 * 
	 * @param type
	 * @return the x axis 
	 */
	private String getChartString(String type) {
		Calendar date = Calendar.getInstance();
		int month = date.get(Calendar.MONTH);
		String[] names = new String[] { "'Jan'", "'Feb'", "'Mar'", "'Apr'", "'May'", "'Jun'", "'Jul'", "'Aug'", "'Sep'", "'Oct'", "'Nov'", "'Dec'" };
		String xAxis = "";

		switch (type) {
		case "year":
			for (int i = 0; i < 12; i++) {
				if (month > 0) {
					xAxis = names[month] + xAxis;
					month--;
				} else {
					xAxis = names[month] + xAxis;
					month = 11;
				}
				if (i < 11) {
					xAxis = ", " + xAxis;
				}
			}
			break;
		}
		return xAxis;
	}

	/**
	 * Builds the chat button 
	 */
	public void buildChatButton(){
		superButtonBox.addComponent(chatButton);
		superButtonBox.setComponentAlignment(chatButton, Alignment.MIDDLE_LEFT);
	}
}

