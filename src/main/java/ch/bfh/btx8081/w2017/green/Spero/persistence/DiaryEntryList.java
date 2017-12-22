package ch.bfh.btx8081.w2017.green.Spero.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;

@Entity
@NamedQuery(name = "DiaryEntryList", query = "select el from DiaryEntryList el")
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
	
	public void deleteDiaryEntry(int diaryEntryNumber) {
		int diaryIndex = this.searchDiaryEntryIndex(diaryEntryNumber);
		this.getDiaryList().remove(diaryIndex);
		
	}
	
	private int searchDiaryEntryIndex(int diaryEntryNumber) {
		int diaryEntryIndex = -1;
		System.out.println(diaryEntryNumber);
		
		for(int i = 0; i < this.getDiaryList().size(); i++) {
			if (this.getDiaryList().get(i).getDiaryEntryNumber() == diaryEntryNumber) {
				System.out.println(i);
				diaryEntryIndex = i;
			}	
		}
		return diaryEntryIndex;
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
