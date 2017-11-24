package ch.bfh.btx8081.w2017.green.Spero.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;

public class Diary {
	private int nextDiaryEntryNumber = 1;
	private Map<Integer, DiaryEntry> diaryEntryMap;
	
	
	public Diary() {
	}

	public void createEntry(String diaryTitle, String diaryText, Mood moodParam, String tag) {
		
		
		this.diaryEntryMap.put(nextDiaryEntryNumber, new DiaryEntry(nextDiaryEntryNumber, diaryTitle, diaryText, moodParam, tag));
		this.nextDiaryEntryNumber++;
		
	}

	public void deleteEntry(int diaryEntryNumber) {
		
		
		this.diaryEntryMap.remove(diaryEntryNumber);
		
	}

	public DiaryEntry searchEntry() {
		
		return null;
	}

	public List<DiaryEntry> searchTag() {
		
		return null;
	}
}
