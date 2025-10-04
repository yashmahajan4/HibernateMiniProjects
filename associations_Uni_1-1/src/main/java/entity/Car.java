package entity;



import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;

@Entity
public class Car {
	@Id
    private int car_id;
    private String brand;
    private double price;
    
    @OneToOne
    private Engine engine;

    public Car() {
    }
 

    public int getCid() {
        return car_id;
    }

    public void setCid(int car_id) {
        this.car_id = car_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }
    
    public void setEngine(Engine engine) {
		this.engine = engine;
	}

    @Override
    public String toString() {
        return "Car {" +
                "cid=" + car_id +
                ", brand='" + brand + '\'' +
                ", price=₹" + price +
                ", engine=" + (engine != null ? engine.toString() : "No Engine Info") +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(car_id, brand, price, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Car))
            return false;
        Car other = (Car) obj;
        return car_id == other.car_id &&
               Double.compare(other.price, price) == 0 &&
               Objects.equals(brand, other.brand) &&
               Objects.equals(engine, other.engine);
    }
}
