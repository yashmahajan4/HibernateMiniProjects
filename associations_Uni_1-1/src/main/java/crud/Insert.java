package crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Car;
import entity.Engine;

public class Insert {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgresql_associations_uni_1-1");
	
	public static void insertCar(int car_id, String brand, double price, int engine_id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine engine = em.find(Engine.class, engine_id);
		
		if(engine!=null)
		{
			Car car = new Car();
			
			car.setCid(car_id);
			car.setBrand(brand);
			car.setPrice(price);
			car.setEngine(engine);
			
			et.begin();
			em.persist(car);
			et.commit();
		}
		else
			System.out.println("Engine Not Found");
		
		em.close();
		
	}
	public static void insertEngine(int engine_id, int cc)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine engine = new Engine();
		
		engine.setEngineId(engine_id);
		engine.setCc(cc);
		
		et.begin();
		em.persist(engine);
		et.commit();
		em.close();
		
	}

}
