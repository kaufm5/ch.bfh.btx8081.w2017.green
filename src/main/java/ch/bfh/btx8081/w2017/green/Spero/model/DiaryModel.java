package ch.bfh.btx8081.w2017.green.Spero.model;

import ch.bfh.btx8081.w2017.green.Spero.persistence.DB;
import ch.bfh.btx8081.w2017.green.Spero.persistence.DiaryEntryList;

public class DiaryModel {
	private static final DB DATABASE_MANAGER = DB.getInstance();

	private DiaryEntryList diaryList;

	public DiaryModel() {
		this.takeListFromDB();
	}

	public void takeListFromDB() {
		if (DiaryModel.DATABASE_MANAGER.getSperoLists("DiaryEntryList")
				.size() == 0) {
			this.diaryList = new DiaryEntryList();
		} else {
			this.diaryList = (DiaryEntryList) DiaryModel.DATABASE_MANAGER
					.getSperoLists("DiaryEntryList").get(0);
		}

	}

	public void persist(DiaryEntryList diaryList) {
		DiaryModel.DATABASE_MANAGER.persistObject(diaryList);
	}

	public DiaryEntryList getDiaryList() {
		return this.diaryList;
	}

	public void setDiaryList(DiaryEntryList diaryList) {
		this.diaryList = diaryList;
	}

}
