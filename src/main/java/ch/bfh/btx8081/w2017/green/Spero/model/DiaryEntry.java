package ch.bfh.btx8081.w2017.green.Spero.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import lombok.Data;

@Data
public class DiaryEntry {
    private int diaryEntryNumber;
    private String diaryTitle;
    private String diaryText = "";
    private String tag = "";
    private List<String> tagList = new ArrayList<String>();
    private LocalDate date;
    private Mood moodParam;
    private Object attachment;

    public DiaryEntry() {

    }

    public DiaryEntry(int diaryEntryNumber, String diaryTitle, String diaryText, Mood moodParam) {
	this.diaryEntryNumber = diaryEntryNumber;
	this.diaryTitle = diaryTitle;
	this.diaryText = diaryText;
	this.moodParam = moodParam;
	this.date = LocalDate.now();
    }

    // other methods
    public void confirm() {
	// speichern in die Datenbank
	// speichern in ein txt File zu erst.
	PrintWriter pWriter;
	try {
	    pWriter = new PrintWriter(new BufferedWriter(new FileWriter("diaryEntry.txt")));
	    // pWriter.println("test");
	    pWriter.println(this.date);
	    pWriter.println(getMoodParam());
	    pWriter.println(getDiaryTitle());
	    pWriter.println(getDiaryText());
	    pWriter.println(getTag());
	    pWriter.close();
	} catch (final IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Override
    public String toString() {
	final String str = "Title: " + this.getDiaryTitle() + ", Nb. " + this.getDiaryEntryNumber();
	return str;
    }
}
