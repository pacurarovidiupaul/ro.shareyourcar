package ro.shareyourcar.dao;

import java.util.Collection;

import ro.shareyourcar.domain.Car;


public interface CarDAO extends BaseDAO<Car>{
	
	Collection<Car> searchByName(String query);

}
