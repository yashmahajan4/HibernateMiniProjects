package utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Hibernates {
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("postgresql_associations_uni_1-n");
	}
	
	public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }
	
}
