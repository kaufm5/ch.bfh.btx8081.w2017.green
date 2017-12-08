package ch.bfh.btx8081.w2017.green.Spero;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ch.bfh.btx8081.w2017.green.Spero.interfaceEnum.Mood;
import ch.bfh.btx8081.w2017.green.Spero.model.Diary;
import ch.bfh.btx8081.w2017.green.Spero.model.DiaryEntry;
import persistence.DB;

public class HowToUseDB {
	
	public static void HowToUseDB() {
		// first of all, you need to get the EntityManager from the db
				EntityManager em = DB.getEntityManager();
				
				//Query q1 = em.createQuery("select d from Diary d"); // this is JPQL language! -> take a look at the slides if you don't remember how to do it :)

				Diary diary = em.find(Diary.class, 1);
				
				

	}

}
