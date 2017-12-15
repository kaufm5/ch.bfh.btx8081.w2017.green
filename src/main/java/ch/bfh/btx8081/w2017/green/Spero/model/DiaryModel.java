package ch.bfh.btx8081.w2017.green.Spero.model;

import persistence.DB;
import persistence.DiaryEntryList;

public class DiaryModel {
	private DiaryEntryList diaryList;
	private DB db;
	
	
	public DiaryModel() {
		this.db = new DB();
		this.diaryList = (DiaryEntryList) this.db.getSperoLists("DiaryEntryList").get(0);
	}


	public DiaryEntryList getDiaryList() {
		return diaryList;
	}


	public void setDiaryList(DiaryEntryList diaryList) {
		this.diaryList = diaryList;
	}
	
	
	

}
