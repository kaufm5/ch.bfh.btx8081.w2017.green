package ch.bfh.btx8081.w2017.green.Spero.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ForgetPasswordModelTest {
	
	private ForgetPasswordModel forgetPasswordModel;

//	@Test
//	public void testSendEmail() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testCheckEmail() {
		try {
			forgetPasswordModel.checkEmail("jaksdfgmailcom");
			forgetPasswordModel.checkEmail("jaksdf@gmailcom");
			forgetPasswordModel.checkEmail("@gmail.com");
			forgetPasswordModel.checkEmail("jaksdf@gmail.");
			forgetPasswordModel.checkEmail("jaksdf@gmail.c");
			forgetPasswordModel.checkEmail("jaksdf@.com");
			forgetPasswordModel.checkEmail("jaksdf@gmail.com");
			}
			catch (Exception e) {
				System.out.println(e);
			}
	}

}
