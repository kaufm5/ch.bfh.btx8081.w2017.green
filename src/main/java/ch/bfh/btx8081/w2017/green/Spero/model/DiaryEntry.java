package ch.bfh.btx8081.w2017.green.Spero.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	
	//constructor
	public DiaryEntry() {
		
	}
	
	//constructor
	public DiaryEntry(int diaryEntryNumber,String diaryTitle, String diaryText,
			Mood moodParam) {
		this.diaryEntryNumber = diaryEntryNumber;
		this.diaryTitle = diaryTitle;
		this.diaryText = diaryText;
		this.moodParam = moodParam;

		this.date = LocalDate.now();
	}	
	
	//setter methods
	public void setAttachment(Object attachment) {
		this.attachment = attachment;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public void setDiaryEntryNumber(int diaryEntryNumber) {
		this.diaryEntryNumber = diaryEntryNumber;
	}
	
	public void setMoodparam(Mood mood) {
		this.moodParam = mood;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}
	
	public void setText(String text) {
		this.diaryText = text;
	}
	
	public void setTitle(String title) {
		this.diaryTitle = title;
	}

	//getter methods
	public Object getAttachment() {
		return this.attachment;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public int getDiaryEntryNumber() {
		return this.diaryEntryNumber;
	}

	public Mood getMoodparam() {
		return this.moodParam;
	}
	
	public String getTag() {
		return this.tag;
	}

	public List<String> getTagList() {
		return this.tagList;
	}

	public String getText() {
		return this.diaryText;
	}
	
	public String getTitle() {
		return this.diaryTitle;
	}
	
	//other methods
	public void confirm() {
		//speichern in die Datenbank
		//speichern in ein txt File zu erst.
			 PrintWriter pWriter;
			try {
				 pWriter = new PrintWriter(new BufferedWriter(new FileWriter("diaryEntry.txt")));
				// pWriter.println("test");
				 pWriter.println(date);
				 pWriter.println(getMoodparam());
				 pWriter.println(getTitle());
				 pWriter.println(getText());
			     pWriter.println(getTag());
			     pWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
	}
	
	@Override
	public String toString() {
		String str = "Title: " + this.getTitle() + ", Nb. " + this.getDiaryEntryNumber();
		return str;
		
	}

	

}
