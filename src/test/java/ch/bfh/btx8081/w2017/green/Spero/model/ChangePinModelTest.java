package ch.bfh.btx8081.w2017.green.Spero.model;

import org.junit.Test;

import ch.bfh.btx8081.w2017.green.Spero.model.ChangePinModel;
import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;

public class ChangePinModelTest {

	@Test(expected = IncorrectException.class)
	public void testCheckExceptions() throws IncorrectException {
		ChangePinModel changePinModel1 = new ChangePinModel("1235","23","23");
		changePinModel1.checkOldPin("1235");
		changePinModel1.checkNewPin("23", "23");
		ChangePinModel changePinModel2 = new ChangePinModel("", "", "");
		changePinModel2.checkOldPin("");
		changePinModel2.checkNewPin("", "");
		ChangePinModel changePinModel3 = new ChangePinModel("abcd", "abcd", "abcd");
		changePinModel3.checkOldPin("abcd");
		changePinModel3.checkNewPin("abcd", "abcd");
	}

	@Test
	public void testCorrect() throws IncorrectException {
		ChangePinModel changePinModel = new ChangePinModel("1234", "2345", "2345");
		changePinModel.checkOldPin("1234");
		changePinModel.checkNewPin("2345", "2345");
	}

}
