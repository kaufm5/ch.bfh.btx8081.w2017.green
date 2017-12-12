package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DB {
private EntityManager em;
	
	private static final String PERSISTENCE_UNIT_NAME = "spero2";
	
	public DB() {
		this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}
	
	public EntityManager getEntitiyManager() {
		return this.em;
	}
	
	public void persistObject(Object object) {
		EntityTransaction entityTransaction = this.em.getTransaction();
		
		entityTransaction.begin();
		this.em.persist(object);
		entityTransaction.commit();
	}
	
	public void removeObject(Object object) {
		EntityTransaction entityTransaction = this.em.getTransaction();
		
		entityTransaction.begin();
		this.em.remove(object);
		entityTransaction.commit();
	}
	
	/**
	 * Returns a list of the Entity
	 * @param
	 * 
	 * @return a list of AnorexieInf
	 */
	public List<?> getSperoLists(String entity) {
		return this.em.createNamedQuery(entity).getResultList();
	}

	public EntityTransaction getTransaction() {
		return this.em.getTransaction();
	}
	
	//TODO should contain all read/write methods from Models to DB
}