package crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Car;
import entity.Engine;

import java.util.List;

public class Fetch {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgresql_associations_uni_1-1");
	
	public static Car fetchCar(int car_id)
	{
		return emf.createEntityManager().find(Car.class, car_id);
	}
	public static Engine fetchEngine(int engine_id)
	{
		return emf.createEntityManager().find(Engine.class,engine_id);
	}
	public static Engine fetchCarEngine(int car_id)
	{
		return fetchCar(car_id).getEngine();
	}
	public static List<Car> fetchCars()
	{
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("select c from Car c");
		
		List<Car> resultList = query.getResultList();
		
		return resultList;
	}
	public static List<Car> fetchEngines()
	{
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("select e from Engine e");
		
		List<Car> resultList = query.getResultList();
		
		return resultList;
	}
}
