package ch.bfh.btx8081.w2017.green.Spero.model;

public class ChatMessage {
    private final long currentTimeMillis;
    private final String senderName;
    private final String fulltextMessage;

    public ChatMessage(long manualTestingTime, String senderName, String fulltextMessage) {
	this.currentTimeMillis = manualTestingTime;
	this.senderName = senderName;
	this.fulltextMessage = fulltextMessage;
    }

    public ChatMessage(String senderName, String fulltextMessage) {
	this.currentTimeMillis = System.currentTimeMillis();
	this.senderName = senderName;
	this.fulltextMessage = fulltextMessage;
    }

    public long getCurrentTimeMillis() {
	return this.currentTimeMillis;
    }

    public String getSenderName() {
	return this.senderName;
    }

    public String getFulltextMessage() {
	return this.fulltextMessage;
    }
}
