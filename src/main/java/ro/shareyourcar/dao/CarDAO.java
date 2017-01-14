package ro.shareyourcar.dao;

import java.util.Collection;

import ro.shareyourcar.domain.Car;

public interface CarDAO extends BaseDAO<Car> {

<<<<<<< HEAD
	Collection<Car> searchByUserName(String query);

	Collection<Car> getAvailableCars();

	Collection<Car> getBookedCars();

	boolean book(int days, Car model);

	boolean unBook(Car model);
=======
public interface CarDAO extends BaseDAO<Car>{
	
	Collection<Car> searchByUserName(String query);
	
	Collection<Car> getAvailableCars();
	
	Collection<Car> getBookedCars();
	
	boolean book(Car model);
	
	boolean unBook(Car model);

	

	


	
>>>>>>> e38bc0ad42ed5c1dd45659a8bf9af70588edfae3

}
