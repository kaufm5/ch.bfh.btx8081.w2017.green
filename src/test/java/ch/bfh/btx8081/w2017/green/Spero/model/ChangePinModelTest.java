package ch.bfh.btx8081.w2017.green.Spero.model;

import org.junit.Test;

import ch.bfh.btx8081.w2017.green.Spero.model.ChangePinModel;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;

public class ChangePinModelTest {
	
	private ChangePinModel changePinModel;

	@Test
	public void testCheckOldPin() throws IncorrectException {
		try {
		changePinModel.checkOldPin("2345");
		changePinModel.checkOldPin("1234");
		}
		catch (Exception e) {
		      System.out.println(e);
		}
	}

	@Test
	public void testCheckNewPin() throws IncorrectException {
		try {
		changePinModel.checkNewPin("1", "1");
		changePinModel.checkNewPin("", "");
		changePinModel.checkNewPin("abcd", "abcd");
		changePinModel.checkNewPin("1234", "1235");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
