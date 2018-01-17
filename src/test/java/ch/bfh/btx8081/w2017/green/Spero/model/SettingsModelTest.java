package ch.bfh.btx8081.w2017.green.Spero.model;

import org.junit.Test;

import ch.bfh.btx8081.w2017.green.Spero.exceptionHandling.IncorrectException;

/**
 * tests the settingsModel class
 * @author mirjam
 *
 */
public class SettingsModelTest {
	
	/**
	 * tests if an exception is thrown
	 * @throws IncorrectException
	 */
	@Test (expected = IncorrectException.class)
	public void testExceptions() throws IncorrectException {
			SettingsModel settingsModel = new SettingsModel("username", "", "", "on");
			settingsModel.checkSnooze("1234");
			settingsModel.checkSnooze("");
			settingsModel.checkSnooze("ea");
			settingsModel.checkReminder("");
	}

	/**
	 * tests if no exception is thrown
	 * @throws IncorrectException
	 */
	@Test
	public void testCorrect() throws IncorrectException {
			SettingsModel settingsModel = new SettingsModel("username", "10", "123", "on");
			settingsModel.checkSnooze("123");
			settingsModel.checkReminder("10");
	}

}
