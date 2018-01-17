package ch.bfh.btx8081.w2017.green.Spero.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * tests the ForgetPasswordModel Class
 * @author mirjam
 *
 */
public class ForgetPasswordModelTest {

	/**
	 * tests if the email is correctly checked
	 */
	@Test
	public void testCheckEmail() {
		assertFalse(ForgetPasswordModel.checkEmail("jaksdfgmailcom"));
		assertFalse(ForgetPasswordModel.checkEmail("jaksdf@gmailcom"));
		assertFalse(ForgetPasswordModel.checkEmail("@gmail.com"));
		assertFalse(ForgetPasswordModel.checkEmail("jaksdf@gmail."));
		assertFalse(ForgetPasswordModel.checkEmail("jaksdf@.com"));
		assertTrue(ForgetPasswordModel.checkEmail("jaksdf@gmail.com"));
	}

}
