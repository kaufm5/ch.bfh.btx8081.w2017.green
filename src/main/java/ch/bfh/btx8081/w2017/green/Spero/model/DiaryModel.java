package ch.bfh.btx8081.w2017.green.Spero.model;

import persistence.DB;
import persistence.DiaryEntryList;

public class DiaryModel {
	private DiaryEntryList diaryList;
	private DB db;
	
	
	public DiaryModel() {
		this.db = new DB();
		
//		this.diaryList = new DiaryEntryList();
		
		this.diaryList = db.getEntitiyManager().find(DiaryEntryList.class, 1);
		
//		this.diaryList = (DiaryEntryList) this.db.getSperoLists("diaryentrylist").get(0);
	}


	public DiaryEntryList getDiaryList() {
		return diaryList;
	}


	public void setDiaryList(DiaryEntryList diaryList) {
		this.diaryList = diaryList;
	}
	
	
	

}
