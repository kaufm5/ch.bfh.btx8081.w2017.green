package ch.bfh.btx8081.w2017.green.Spero.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DBManager {
	
private EntityManager em;

private static final String PERSISTENCE_UNIT_NAME = "spero";

public DBManager() {
	this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
}

public List<?> getResultSet(String queryText) {
	Query query = this.em.createQuery(queryText);
	return query.getResultList();
}

public void persistObject(Object object) {
	EntityTransaction entityTransaction = this.em.getTransaction();
	
	entityTransaction.begin();
	
	this.em.persist(object);
	this.em.flush();
	
	entityTransaction.commit();
	
}
	
}
