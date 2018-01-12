package ch.bfh.btx8081.w2017.green.Spero.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SettingsModelTest {
	
	private SettingsModel settingsModel;

	@Test
	public void testCheckSnooze() {
		try {
			settingsModel.checkSnooze("1234");
			settingsModel.checkSnooze("");
			settingsModel.checkSnooze("ea");
			settingsModel.checkSnooze("123");
		}
		catch (NullPointerException e1) {
			System.out.println(e1);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void testCheckReminder() {
		try {
			settingsModel.checkReminder("");
			settingsModel.checkReminder("10");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
