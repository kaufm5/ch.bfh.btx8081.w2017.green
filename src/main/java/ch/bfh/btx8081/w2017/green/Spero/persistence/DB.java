package ch.bfh.btx8081.w2017.green.Spero.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * The database manager class which represents connection configuration to the database 
 * and hold the entity manager which interacts with the persistence context
 */
public final class DB {

	private static DB INSTANCE;
	private static EntityManager em;

	private static final String PERSISTENCE_UNIT_NAME = "spero2";

	/** Returns the static instance of DB (Singleton). */
	public static synchronized DB getInstance() {
		if (DB.INSTANCE == null) {
			DB.INSTANCE = new DB();
		}
		return DB.INSTANCE;
	}

	/**
	 * Class constructor 
	 */
	private DB() {
		initialize();
	}

	private void initialize() {
		setEm(Persistence
				.createEntityManagerFactory(DB.PERSISTENCE_UNIT_NAME)
				.createEntityManager());
	}

	/**
	 * Make an instance managed and persistent
	 * 
	 * @param object - object instance
	 */
	public void persistObject(Object object) {
		EntityTransaction entityTransaction = getEm().getTransaction();

		entityTransaction.begin();
		getEm().persist(object);
		//getEm().flush();
		entityTransaction.commit();
	}

	/**
	 * Remove the object instance
	 * 
	 * @param object - object instance 
	 */
	public void removeObject(Object object) {
		EntityTransaction entityTransaction = getEm().getTransaction();

		entityTransaction.begin();
		getEm().remove(object);
		entityTransaction.commit();
	}

	/**
	 * Returns a list of the entity
	 * 
	 * @param entity
	 * @return a list of the entity
	 */
	public List<?> getSperoLists(String entity) {
		return getEm().createNamedQuery(entity).getResultList();
	}

	/**
	 * Return the resource-level EntityTransaction object
	 * The EntityTransaction instance may be used serially to begin and commit multiple transactions
	 * 
	 * @return EntityTransaction instance
	 */
	public EntityTransaction getTransaction() {
		return getEm().getTransaction();
	}

	/**
	 * Close an application-managed entity manager
	 */
	public static void close() { 
		getEm().close(); 
	}

	/**
	 * Gets the entity manager
	 *  
	 * @return the entity manager 
	 */
	public static EntityManager getEm() {
		return em;
	}

	/**
	 * Sets the entity manager 
	 * 
	 * @param em - the entity manager 
	 */
	public static void setEm(EntityManager em) {
		DB.em = em;
	}

}