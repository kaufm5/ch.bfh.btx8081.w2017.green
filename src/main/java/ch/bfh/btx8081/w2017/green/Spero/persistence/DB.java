package ch.bfh.btx8081.w2017.green.Spero.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public final class DB {
	private static DB INSTANCE;
	private EntityManager em;

	private static final String PERSISTENCE_UNIT_NAME = "spero2";

	/** Returns the static instance of DB (Singleton). */
	public static synchronized DB getInstance() {
		if (DB.INSTANCE == null) {
			DB.INSTANCE = new DB();
		}
		return DB.INSTANCE;
	}

	public DB() {
		initialize();
	}

	private void initialize() {
		this.em = Persistence
				.createEntityManagerFactory(DB.PERSISTENCE_UNIT_NAME)
				.createEntityManager();
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

	public List<?> getSperoLists(String entity) {
		return this.em.createNamedQuery(entity).getResultList();
	}

	public EntityTransaction getTransaction() {
		return this.em.getTransaction();
	}

}