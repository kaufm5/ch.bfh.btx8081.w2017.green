package persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;

@Entity
public class DiaryEntryList {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int diarID; 
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<DiaryEntry> diaryList = new ArrayList<DiaryEntry>();
	
	public DiaryEntryList() { 
		
	}
	public void createDiaryEntry(String title, String text, Mood moodparam) {
		DiaryEntry diary = new DiaryEntry(title, text, moodparam);
		diaryList.add(diary);
	}

	public int getDiarID() {
		return diarID;
	}

	public void setDiarID(int diarID) {
		this.diarID = diarID;
	}

	public List<DiaryEntry> getDiaryList() {
		return diaryList;
	}

	public void setDiaryList(List<DiaryEntry> diaryList) {
		this.diaryList = diaryList;
	}
	
}
