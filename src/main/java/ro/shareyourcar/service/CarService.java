package ro.shareyourcar.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.shareyourcar.dao.CarDAO;
import ro.shareyourcar.domain.Car;

@Service
public class CarService {

	@Autowired
	private CarDAO dao;

	public Collection<Car> listAll() {
		return dao.getAll();
	}

	public Collection<Car> search(String query) {
		return dao.searchByName(query);

	}

	public void showFuelLevel() {
		// TODO Auto-generated method stub

	}

	public CarDAO getDao() {
		return dao;
	}

	public void setDao(CarDAO dao) {
		this.dao = dao;

	}

}
