package ch.bfh.btx8081.w2017.green.Spero.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChatMessageTest {
	private static final String MESSAGE = "Hello World";
	private static final String USER = "testuser";
	private static final long CURRENT_TESTING_TIME = System.currentTimeMillis();

	@Test
	public void testChatMessageLongStringString() {
		final ChatMessage message = new ChatMessage(ChatMessageTest.CURRENT_TESTING_TIME, ChatMessageTest.USER,
				ChatMessageTest.MESSAGE);
		assertEquals(ChatMessageTest.USER, message.getSenderName());
		assertEquals(ChatMessageTest.CURRENT_TESTING_TIME, message.getCurrentTimeMillis());
		assertEquals(ChatMessageTest.MESSAGE, message.getFulltextMessage());
	}

	@Test
	public void testChatMessageStringString() {
		final ChatMessage message = new ChatMessage(ChatMessageTest.USER, ChatMessageTest.MESSAGE);
		assertEquals(ChatMessageTest.USER, message.getSenderName());
		assertEquals(System.currentTimeMillis(), message.getCurrentTimeMillis());
		assertEquals(ChatMessageTest.MESSAGE, message.getFulltextMessage());
		
	}
}
