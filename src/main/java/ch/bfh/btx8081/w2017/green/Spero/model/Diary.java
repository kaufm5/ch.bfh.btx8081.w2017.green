package ch.bfh.btx8081.w2017.green.Spero.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import persistence.DB;


@Entity
public class Diary {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE)
	private int diaryID = 1;
	
	private int numberOfDiaryEntry = 0;
	private Map<Integer, DiaryEntry> diaryEntryMap;
	
	public Diary() {
		diaryEntryMap = new HashMap<>();
	}
	

	public void persist() {
		EntityManager em = DB.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		em.persist(this);
		trans.commit();
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
