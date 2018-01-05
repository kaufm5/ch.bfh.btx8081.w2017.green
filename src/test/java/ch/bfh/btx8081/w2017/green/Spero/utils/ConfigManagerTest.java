package ch.bfh.btx8081.w2017.green.Spero.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Properties;

import org.junit.Test;

public class ConfigManagerTest {
	@Test
	public void testConfigGetterMethod() {
		final ConfigManager configManager = ConfigManager.getInstance();
		assertNotEquals(null, configManager.getPin());
		assertNotEquals(null, configManager.isChatEnabled());
		assertNotEquals(null, configManager.isReminderEnabled());
	}

	@Test
	public void testEmptyProperty() {
		final Properties properties = new Properties();
		assertEquals(null, properties.get("key"));
	}
}
