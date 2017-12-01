package ch.bfh.btx8081.w2017.green.Spero.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import lombok.Getter;

public class Diary {
    @Getter
    private int numberOfDiaryEntries = 0;
    private final Map<Integer, DiaryEntry> diaryEntryMap;

    public Diary() {
	this.diaryEntryMap = new HashMap<Integer, DiaryEntry>();
    }

    public void createEntry(String diaryTitle, String diaryText, Mood moodParam) {
	final int index = this.numberOfDiaryEntries + 1;
	final DiaryEntry diaryEntry = new DiaryEntry(index, diaryTitle, diaryText, moodParam);
	this.diaryEntryMap.put(index, diaryEntry);
	// increase index after putting into map
	this.numberOfDiaryEntries++;
    }

    public void deleteEntry(int diaryEntryNumber) {
	this.diaryEntryMap.remove(diaryEntryNumber);
    }

    public DiaryEntry searchEntry(int DiaryEntryNumber) {
	return this.diaryEntryMap.get(DiaryEntryNumber);
    }

    public List<DiaryEntry> searchTag() {
	// TODO: implementation
	return null;
    }

    public String printDiaryEntries() {
	final List<DiaryEntry> list = new ArrayList<DiaryEntry>();
	list.addAll(this.diaryEntryMap.values());
	String str = "";
	for (final DiaryEntry diaryEntry : list) {
	    str = str + diaryEntry.toString() + "/n";
	}
	return str;
    }
}
