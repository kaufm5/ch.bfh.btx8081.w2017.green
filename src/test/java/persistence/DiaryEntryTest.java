package persistence;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import ch.bfh.btx8081.w2017.green.Spero.persistence.DiaryEntry;

public class DiaryEntryTest {

	@Test
	public void testDiaryEntry() {
		DiaryEntry diaryEntry2 = new DiaryEntry("MyTitle", "MyText", Mood.gut);
		assertFalse(diaryEntry2.getTitle() == null);
		assertFalse(diaryEntry2.getText() == null);
		assertFalse(diaryEntry2.getMoodparam() == null);
	}

	@Test
	public void testSetMoodparam() {
		DiaryEntry diaryEntry = new DiaryEntry();
		assertTrue(diaryEntry.getMoodparam() == null);

		diaryEntry.setMoodparam(Mood.gut);
		assertTrue(diaryEntry.getMoodparam().equals(Mood.gut));

	}

	@Test
	public void testSetText() {
		DiaryEntry diaryEntry = new DiaryEntry();
		assertTrue(diaryEntry.getText() == null);

		diaryEntry.setText("MyText");
		assertTrue(diaryEntry.getText().equals("MyText"));
	}

	@Test
	public void testSetTitle() {
		DiaryEntry diaryEntry = new DiaryEntry();
		assertTrue(diaryEntry.getTitle() == null);

		diaryEntry.setTitle("MyTitle");
		assertTrue(diaryEntry.getTitle().equals("MyTitle"));
	}

	@Test
	public void testGetDiaryEntryNumber() {
		DiaryEntry diaryEntry = new DiaryEntry();
		assertTrue(diaryEntry.getDiaryEntryNumber() == 0);

	}

	@Test
	public void testGetMoodparam() {
		DiaryEntry diaryEntry = new DiaryEntry();
		assertTrue(diaryEntry.getMoodparam() == null);

		DiaryEntry diaryEntry2 = new DiaryEntry("MyTitle", "MyText", Mood.gut);
		assertTrue(diaryEntry2.getMoodparam().equals(Mood.gut));
		assertFalse(diaryEntry2.getMoodparam().equals(Mood.schlecht));
	}

	@Test
	public void testGetText() {
		DiaryEntry diaryEntry = new DiaryEntry();
		assertTrue(diaryEntry.getText() == null);

		DiaryEntry diaryEntry2 = new DiaryEntry("MyTitle", "MyText", Mood.gut);
		assertTrue(diaryEntry2.getText().equals("MyText"));
		assertFalse(diaryEntry2.getText().equals("WrongText"));

	}

	@Test
	public void testGetTitle() {
		DiaryEntry diaryEntry = new DiaryEntry();
		assertTrue(diaryEntry.getTitle() == null);

		DiaryEntry diaryEntry2 = new DiaryEntry("MyTitle", "MyText", Mood.gut);
		assertTrue(diaryEntry2.getTitle().equals("MyTitle"));
		assertFalse(diaryEntry2.getTitle().equals("WrongText"));

	}

}
