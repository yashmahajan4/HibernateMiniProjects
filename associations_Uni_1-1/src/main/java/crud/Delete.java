package crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Car;
import entity.Engine;

public class Delete {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgresql_associations_uni_1-1");
	public static void deleteCarByCarId(int car_id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car car = em.find(Car.class, car_id);
		
		et.begin();
		em.remove(car);
		et.commit();
		
		em.close();
	}
	
	public static void deleteEngineByEngineId(int engine_id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine engine = em.find(Engine.class, engine_id);
		
		et.begin();
		em.remove(engine);
		et.commit();
		
		em.close();
	}

}
