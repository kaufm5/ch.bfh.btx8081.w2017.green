package persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;

@Entity
public class DiaryEntry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int diaryEntryNumber;
	private String diaryTitle;
	private String diaryText;
	private String tag;
	private Mood moodParam;

	public DiaryEntry() {

	}

	// constructor
	public DiaryEntry(String diaryTitle, String diaryText, Mood moodParam) {
		this.diaryTitle = diaryTitle;
		this.diaryText = diaryText;
		this.moodParam = moodParam;

		// this.date = LocalDate.now();
	}

	public void setDiaryEntryNumber(int diaryEntryNumber) {
		this.diaryEntryNumber = diaryEntryNumber;
	}

	public void setMoodparam(Mood mood) {
		this.moodParam = mood;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setText(String text) {
		this.diaryText = text;
	}

	public void setTitle(String title) {
		this.diaryTitle = title;
	}

	public int getDiaryEntryNumber() {
		return this.diaryEntryNumber;
	}

	public Mood getMoodparam() {
		return this.moodParam;
	}

	public String getTag() {
		return this.tag;
	}

	public String getText() {
		return this.diaryText;
	}

	public String getTitle() {
		return this.diaryTitle;
	}
}
