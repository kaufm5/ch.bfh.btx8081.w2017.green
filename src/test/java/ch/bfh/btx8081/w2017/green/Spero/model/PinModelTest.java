package ch.bfh.btx8081.w2017.green.Spero.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;

public class PinModelTest {

	@Test(expected = IncorrectException.class)
	public void testPinModel() throws IncorrectException {
		PinModel pinModel = new PinModel("1111");
		pinModel.checkPin();
	}

	@Test
	public void testCorrect() throws IncorrectException {
		PinModel pinModel = new PinModel("1234");
		pinModel.checkPin();
	}

}
