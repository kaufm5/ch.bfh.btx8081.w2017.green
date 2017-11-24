package ch.bfh.btx8081.w2017.green.Spero.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;

public class DiaryEntry {
	private int diaryEntryNumber;
	private String diaryTitle ="";
	private String diaryText = "";
	private String tag = "";
	private List<String> tagList = new ArrayList<String>();
	private LocalDate date;
	private Mood moodParam;
	private Object attachment;
	
	
	public DiaryEntry(int diaryEntryNumber,String diaryTitle, String diaryText, Mood moodParam, String tag) {
		this.diaryEntryNumber = diaryEntryNumber;
		this.diaryTitle = diaryTitle;
		this.diaryText = diaryText;
		this.moodParam = moodParam;
		this.tag = tag;
		this.date = LocalDate.now();
		
		
	}
	
	public int getDiaryEntryNumber() {
		return this.diaryEntryNumber;
	}
	
	
	public void setMoodParam(Mood mood) {
		
	}
	
	public void write() {
		this.diaryTitle = diaryTitle;
		this.diaryText = diaryText;
		
	}
	
	public void setTag(String tag) {
		
	}
	
	public void setAttachment(Object attachment) {
		
	}
	
	public void save() {
	}

	public Object getAttachment() {
		return null;
	}

	public Mood getMoodparam() {
		
		return null;
	}

	public List<String> getTags() {
		
		return null;
	}

	public String getText() {
		
		return null;
	}

}
