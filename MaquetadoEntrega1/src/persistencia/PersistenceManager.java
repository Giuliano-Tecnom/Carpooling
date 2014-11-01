package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	private static EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("MaquetadoEntrega1");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public static EntityManager getInstance() {
		return entityManager;
	}
}
