package ch.bfh.btx8081.w2017.green.Spero.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;


@Entity
public class Diary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int diaryID;
	
	@OneToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private Map<Integer, DiaryEntry> diaryEntryMap;
	
	public Diary() {
		diaryEntryMap = new HashMap<Integer, DiaryEntry>();
	}
	

//	public void persist() {
//		EntityManager em = DB.getEntityManager();
//		EntityTransaction trans = em.getTransaction();
//		trans.begin();
//		em.persist(this);
//		trans.commit();
//	}
	
	

	public void createEntry(String diaryTitle, String diaryText, Mood moodParam) {
		this.diaryEntryMap.put(getNumberOfDiaryEntry() + 1, new DiaryEntry(diaryTitle, diaryText, moodParam));		
	}

	public void deleteEntry(int diaryEntryNumber) {
		
		
		this.diaryEntryMap.remove(diaryEntryNumber);
		
	}

	public DiaryEntry searchEntry(int DiaryEntryNumber) {
		
		return diaryEntryMap.get(DiaryEntryNumber);
	}
	
	public int getNumberOfDiaryEntry() {
		return diaryEntryMap.size();
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
