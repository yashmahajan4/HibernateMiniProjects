package crud;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Car;
import entity.Engine;

public class Update {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgresql_associations_uni_1-1");
	public static void updateEngineCcByEngineId(int engine_id, int new_cc)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine engine = em.find(Engine.class, engine_id);
		
		engine.setCc(new_cc);
		et.begin();
		em.merge(engine);
		et.commit();
		
		em.close();
	}
	
	
	
	public static void updateEngineCcByCc(int old_cc, int new_cc)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		//Using The Index Based Query Parameter
		Query query = em.createQuery("select e from Engine e where e.cc=?1");
		query.setParameter(1, old_cc);
		
		List resultList = query.getResultList();
		
		Iterator iterator = resultList.iterator();
		
		while(iterator.hasNext())
		{
			Engine engine= (Engine)iterator.next();
			engine.setCc(new_cc);
			et.begin();
			em.merge(engine);
			et.commit();
		}
		
		em.close();
	}
	public static void updateCarBrandByCarId(int car_id, String new_brand)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car car = em.find(Car.class, car_id);
		
		car.setBrand(new_brand);
		
		et.begin();
		em.merge(car);
		et.commit();
		
		em.close();
	}
	public static void updateCarBrandByBrand(String old_brand, String new_brand)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		// Naming Based Query Parameter
		Query query = em.createQuery("select c from Car c where c.brand=:brand");
		query.setParameter("brand", old_brand);
		
		List resultList = query.getResultList();
		
		Iterator iterator = resultList.iterator();
		
		while(iterator.hasNext())
		{
			Car car = (Car)iterator.next();
			car.setBrand(new_brand);
			
			et.begin();
			em.merge(car);
			et.commit();
		}
		em.close();
	}
	public static void updateCarEngineByCarId(int car_id, int engine_id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car car = em.find(Car.class, car_id);
		
		if(car!=null)
		{
			Engine new_engine = em.find(Engine.class, engine_id);
			
			if(new_engine!=null)
			{
				car.setEngine(new_engine);
				et.begin();
				em.merge(car);
				et.commit();
				System.out.println("Engine Updated");
			}
			else
				System.out.println("Engine Not Found");
		}
		else
		{
			System.out.println("Car Not Found");
		}
		
	}
	public static void updateCarEngineByEngineId(int old_engine_id, int new_engine_id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine new_engine = em.find(Engine.class, new_engine_id);
		if(new_engine==null)
		{
			System.out.println("New Engine Not Found");
			return;
		}
		Engine old_engine = em.find(Engine.class, old_engine_id);
		if(old_engine==null)
		{
			System.out.println("Old Engine Not Found");
			return;
		}
		
		
		Query query = em.createQuery("select c from Car c where c.engine=?1");
		query.setParameter(1,old_engine);
			
		List resultList = query.getResultList();	
		Iterator iterator = resultList.iterator();
		while(iterator.hasNext())
		{
			Object next = iterator.next();
			if(next instanceof Car) //Avoids The ClassCastException, else use Generics
			{
				Car car = (Car)next; //Downcasting
				if(new_engine != null)
				{
					car.setEngine(new_engine); //Setting new engine
				}
				
				et.begin();
				em.merge(car);
				et.commit();
			}
			else
				System.out.println("Non Car Object Present");
		}
		em.close();
			
	}

}
