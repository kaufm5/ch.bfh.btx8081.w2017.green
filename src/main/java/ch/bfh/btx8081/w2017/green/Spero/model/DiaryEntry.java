package ch.bfh.btx8081.w2017.green.Spero.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
	
	@OneToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<String> tagList = new ArrayList<String>();
	
	@Temporal(TemporalType.DATE)
	private LocalDate date;
	
	//TODO: Map these Objects asap
	@Transient
	private Mood moodParam;
	@Transient
	private Object attachment;

	// constructor
	public DiaryEntry(String diaryTitle, String diaryText, Mood moodParam) {
		this.diaryTitle = diaryTitle;
		this.diaryText = diaryText;
		this.moodParam = moodParam;

		this.date = LocalDate.now();
	}

	// setter methods
	public void setAttachment(Object attachment) {
		this.attachment = attachment;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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

	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}

	public void setText(String text) {
		this.diaryText = text;
	}

	public void setTitle(String title) {
		this.diaryTitle = title;
	}

	// getter methods
	public Object getAttachment() {
		return this.attachment;
	}

	public LocalDate getDate() {
		return this.date;
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

	public List<String> getTagList() {
		return this.tagList;
	}

	public String getText() {
		return this.diaryText;
	}

	public String getTitle() {
		return this.diaryTitle;
	}

//	public void persist() {
//		EntityManager em = DB.getEntityManager();
//		EntityTransaction trans = em.getTransaction();
//		trans.begin();
//		em.persist(this);
//		trans.commit();

		// other methods
		// public void confirm() {
		// //speichern in die Datenbank
		// //speichern in ein txt File zu erst.
		// PrintWriter pWriter;
		// try {
		// pWriter = new PrintWriter(new BufferedWriter(new
		// FileWriter("diaryEntry.txt")));
		// // pWriter.println("test");
		// pWriter.println(date);
		// pWriter.println(getMoodparam());
		// pWriter.println(getTitle());
		// pWriter.println(getText());
		// pWriter.println(getTag());
		// pWriter.close();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// }

		// @Override
		// public String toString() {
		// String str = "Title: " + this.getTitle() + ", Nb. " +
		// this.getDiaryEntryNumber();
		// return str;
		//
		// }

	
}
