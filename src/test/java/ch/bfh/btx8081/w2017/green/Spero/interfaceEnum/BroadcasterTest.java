package ch.bfh.btx8081.w2017.green.Spero.interfaceEnum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.btx8081.w2017.green.Spero.view.ChatView;

public class BroadcasterTest {
	ChatView chatView;
	Broadcaster broadcaster;

	@Before
	public void setup() {
		this.chatView = new ChatView();
		this.broadcaster = new Broadcaster();
		Broadcaster.register(this.chatView);
	}

	@Test
	public void testRegister() {
		assertTrue(Broadcaster.isRegisered(this.chatView));
	}

	@Test
	public void testUnregister() {
		Broadcaster.unregister(this.chatView);
		assertFalse(Broadcaster.isRegisered(this.chatView));
	}

	@Test
	public void testBroadcast() throws InterruptedException {
		Broadcaster.broadcast("test message");
		this.chatView.receiveBroadcast("test message");
		assertEquals(1, this.chatView.getMessages().size());
	}

}
