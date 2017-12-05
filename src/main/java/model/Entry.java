package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the entry database table.
 * 
 */
@Entity
@NamedQuery(name="Entry.findAll", query="SELECT e FROM Entry e")
public class Entry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="diaryEntryNumber")
	private Integer diaryEntryNumber;

	private String tags;

	private String text;

	private String title;

	public Entry() {
	}

	public Integer getDiaryEntryNumber() {
		return this.diaryEntryNumber;
	}

	public void setDiaryEntryNumber(Integer diaryEntryNumber) {
		this.diaryEntryNumber = diaryEntryNumber;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}