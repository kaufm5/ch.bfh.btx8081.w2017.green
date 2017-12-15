package ch.bfh.btx8081.w2017.green.Spero.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

import com.vaadin.shared.ui.ui.Transport;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;

public class ForgetPasswordModel {
	
	public static final String HOST1 = "smtp.bfh.ch";
	public static final String PORT = "587";
	
//	public static void send(final String login, final String password, final String fromEmail, final String toEmail, final String subject, final String message)
//			throws MessagingException {
//
//		Properties props = new Properties();
//		props.put("mail.smtp.host", HOST);
//		props.put("mail.smtp.port", PORT);
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//
//		Authenticator auth = new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(login, password);
//			}
//		};
//
//		Session session = Session.getInstance(props, auth);
//
//		MimeMessage msg = new MimeMessage(session);
//
//		msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
//		msg.addHeader("Content-Transfer-Encoding", "8bit");
//
//		msg.setFrom(new InternetAddress(fromEmail));
//
//		msg.setSubject(subject, "UTF-8");
//		msg.setText(message, "UTF-8");
//		msg.setSentDate(new Date());
//
//		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
//		Transport.send(msg);
//	}
	
	private static Properties properties, props, login;
	//private static Session session;
	//private static MimeMessage message;
	private static String content, username, password, decriptedPassword;
	private final static String HOST2 = "smtp.gmail.com";
	private final static String TITLE = "Your Password for authentication";

	/**
	 * Establish a connection to gmail with smtp and sends the email with the
	 * password to the doctor
	 * @param doctor used for getting doctors e-mail and name
	 */
	//public static void sendEmail(iDoctor doctor) {
		public static void sendEmail(String mail) 
		throws IncorrectException {
			
		boolean check = checkEmail(mail);
		
		if (check == false ) {
			throw new IncorrectException("Die E-Mail Adresse ist nicht korrekt.");
		} else {
			
		properties = System.getProperties();
		properties.setProperty("mail.smtp", HOST2);

		props = new Properties();
		login = new Properties();

		// reads the file with the login properties
//		FileReader in = null;
//		try {
//			/// in = new FileReader("C:\\databases\\login.properties");
//			in = new FileReader("login.properties");
//			login.load(in);
//		
//			username = login.getProperty("username");
//			password = login.getProperty("password");
//			props.put("mail.smtp.auth", "true");
//			props.put("mail.smtp.starttls.enable", "true");
//			props.put("mail.smtp.host", HOST2);
//			props.put("mail.smtp.port", "587");

			// Get the Session object
//			session = Session.getInstance(props, new javax.mail.Authenticator() {
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication(username, password);
//				}
//			});
//			message = new MimeMessage(session);
//			try {
//				message.setFrom(new InternetAddress(username));
//			} catch (MessagingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				message.addRecipient(Message.RecipientType.TO, new InternetAddress(doctor.getEmail()));
//			} catch (MessagingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				message.setSubject(TITLE);
//			} catch (MessagingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			decriptedPassword = new PasswordHandler().decryptPassword(doctor.getPassword());
//			content = "Hello " + doctor.getName() + ",<br><br>Your Password is:<br>" + decriptedPassword
//					+ "<br><br>Yours sincerely<br>Mia Musterfeld";
//			try {
//				message.setContent(content, "text/html");
//			} catch (MessagingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				Transport.send(message);
//			} catch (MessagingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		}
	}
		
		public static boolean checkEmail(String mail){
			
			boolean correctEmail = true;
			
			int i = mail.indexOf("@");
			int j = mail.indexOf(".", i);
			
			if (i == 0) {
				correctEmail = false;
			}
			if (j == -1) {
				correctEmail = false;
			}
			if ((j-i) < 2) {
				correctEmail = false;
			}
			if (j == mail.length()-1) {
				correctEmail = false;
			}
			return correctEmail;
		}

}
