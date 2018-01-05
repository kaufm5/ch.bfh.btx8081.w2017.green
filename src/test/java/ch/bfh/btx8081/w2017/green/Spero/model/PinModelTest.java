package ch.bfh.btx8081.w2017.green.Spero.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PinModelTest {

	private PinModel pinmodel;

	@Before
	public void setup() {
		this.pinmodel = new PinModel(null);
	}

	@Test
	public void testPinModel() {
		this.pinmodel = pinmodel;
		assertEquals(pinmodel, pinmodel.getPin());
	}

	@Test
	public void testCheckPin() {
		this.pinmodel = pinmodel;
		assertEquals(pinmodel.getPin(), "1234");
	}

}
