package ch.bfh.btx8081.w2017.green.Spero.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;

public class Diary {
	private int numberOfDiaryEntry = 0;
	private Map<Integer, DiaryEntry> diaryEntryMap;
	//test
	
	public Diary() {
		diaryEntryMap = new HashMap<>();
	}

	public void createEntry(String diaryTitle, String diaryText, Mood moodParam) {
		
		
		this.diaryEntryMap.put(numberOfDiaryEntry + 1, new DiaryEntry(numberOfDiaryEntry + 1, diaryTitle, diaryText, moodParam));
		this.numberOfDiaryEntry++;
		
	}

	public void deleteEntry(int diaryEntryNumber) {
		
		
		this.diaryEntryMap.remove(diaryEntryNumber);
		
	}

	public DiaryEntry searchEntry(int DiaryEntryNumber) {
		
		return diaryEntryMap.get(DiaryEntryNumber);
	}
	
	public int getNumberOfDiaryEntry() {
		return numberOfDiaryEntry;
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
