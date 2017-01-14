package ro.shareyourcar.dao;

import java.util.Collection;

import ro.shareyourcar.domain.Car;

public interface CarDAO extends BaseDAO<Car> {

	Collection<Car> searchByUserName(String query);

	Collection<Car> getAvailableCars();

	Collection<Car> getBookedCars();

	boolean book(int days, Car model);

	boolean unBook(Car model);

}
