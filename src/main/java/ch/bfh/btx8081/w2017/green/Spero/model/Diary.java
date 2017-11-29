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

	public void createEntry(String diaryTitle, String diaryText, Mood moodParam) {
		
		
		this.diaryEntryMap.put(nextDiaryEntryNumber, new DiaryEntry(nextDiaryEntryNumber, diaryTitle, diaryText, moodParam));
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
	
	public String printDiaryEntry() {
		List<DiaryEntry> list = new ArrayList<DiaryEntry>();
		list.addAll(diaryEntryMap.values());
		String str = "";
		
		for(DiaryEntry diaryEntry : list) {
			str = str + diaryEntry.toString() + " /n";
		}
		
		return str;
	}
}
