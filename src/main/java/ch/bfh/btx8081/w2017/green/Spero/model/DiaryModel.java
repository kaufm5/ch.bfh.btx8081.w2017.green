package ch.bfh.btx8081.w2017.green.Spero.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistence.DB;
import persistence.DiaryEntry;
import persistence.DiaryEntryList;

public class DiaryModel {
	private DiaryEntryList diaryList;
	private DB db;

	public DiaryModel() {
		this.db = new DB();
		this.takeListFromDB();
	}

	public void takeListFromDB() {
		if (this.db.getSperoLists("DiaryEntryList").size() == 0) {
			this.diaryList = new DiaryEntryList();
		} else {
			this.diaryList = (DiaryEntryList) this.db.getSperoLists("DiaryEntryList").get(0);
		}

	}

	public void persist(DiaryEntryList diaryList) {
		db.persistObject(diaryList);
		;
	}

	public DiaryEntryList getDiaryList() {
		return diaryList;
	}

	public void setDiaryList(DiaryEntryList diaryList) {
		this.diaryList = diaryList;
	}

}
