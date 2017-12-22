package ch.bfh.btx8081.w2017.green.Spero.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Reads a config file and returns values with getter-methods. Singleton-Object,
 * can be used by all classes, other Manager-Classes are dependent.
 *
 * @author guillaume.fricker
 */
public final class ConfigManager {
	private static ConfigManager INSTANCE;
	private static final String SPERO_CONFIG_PATH = "settings.properties";

	private String username;
	private boolean isReminderEnabled;
	private int snoozeTimeInMinutes;
	private int pin;
	private boolean isChatEnabled;

	/** Returns the static instance of ConfigManager (Singleton). */
	public static synchronized ConfigManager getInstance() {
		if (ConfigManager.INSTANCE == null) {
			ConfigManager.INSTANCE = new ConfigManager();
		}
		return ConfigManager.INSTANCE;
	}

	private ConfigManager() {
		this.initialize();
	}

	private void initialize() {
		final Properties config = new Properties();
		try {
			config.load(ResourceUtils
					.getExternalFile(ConfigManager.SPERO_CONFIG_PATH));
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.setUsername(config.getProperty("spero.username",
				System.getProperty("user.name")));
		this.setReminderEnabled(Boolean.parseBoolean(
				config.getProperty("spero.reminder.enabled", "false")));
		this.setSnoozeTimeInMinutes(Integer
				.parseInt(config.getProperty("spero.reminder.time", "10")));
		this.setPin(Integer.parseInt(config.getProperty("spero.pin", "1234")));
		this.setChatEnabled(Boolean.parseBoolean(
				config.getProperty("spero.chat.enabled", "true")));

		System.out.println(
				"read config file : " + ConfigManager.SPERO_CONFIG_PATH);
		System.out.println("--------");
		System.out.println("spero.username : " + this.getUsername());
		System.out.println(
				"spero.reminder.enabled : " + this.isReminderEnabled());
		System.out.println(
				"spero.reminder.time : " + this.getSnoozeTimeInMinutes());
		System.out.println("spero.pin : " + this.getPin());
		System.out.println("spero.chat.enabled : " + this.isChatEnabled());
		System.out.println("--------");
	}

	public static String getSperoConfigPath() {
		return ConfigManager.SPERO_CONFIG_PATH;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isReminderEnabled() {
		return this.isReminderEnabled;
	}

	public void setReminderEnabled(boolean isReminderEnabled) {
		this.isReminderEnabled = isReminderEnabled;
	}

	public int getSnoozeTimeInMinutes() {
		return this.snoozeTimeInMinutes;
	}

	public void setSnoozeTimeInMinutes(int snoozeTimeInMinutes) {
		this.snoozeTimeInMinutes = snoozeTimeInMinutes;
	}

	public int getPin() {
		return this.pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public boolean isChatEnabled() {
		return this.isChatEnabled;
	}

	public void setChatEnabled(boolean isChatEnabled) {
		this.isChatEnabled = isChatEnabled;
	}
}
