package ch.bfh.btx8081.w2017.green.Spero.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.IncorrectException;

public class PinModelTest {

	private PinModel pinmodel;

	@Before
	public void setup() {
		this.pinmodel = new PinModel("1234");
		this.pinmodel = new PinModel("1111");
	}

	@Test(expected = IncorrectException.class)
	public void testPinModel throws IncorrectException() {
		this.pinmodel = pinmodel;
	     new PinModel(null);
	}

	@Test
	public void testCheckPin() {
		this.pinmodel = pinmodel;
		assertEquals(pinmodel.getPin(), "1234");
	}

}
