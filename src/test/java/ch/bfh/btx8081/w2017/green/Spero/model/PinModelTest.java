package ch.bfh.btx8081.w2017.green.Spero.model;

import org.junit.Test;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;

public class PinModelTest {

	@Test(expected = IncorrectException.class)
	public void testPinModel() throws IncorrectException {
		PinModel pinModel = new PinModel("1111");
		pinModel.checkPin("1111");
	}

	@Test
	public void testCorrect() throws IncorrectException {
		PinModel pinModel = new PinModel("1234");
		pinModel.checkPin("1234");
	}

}
