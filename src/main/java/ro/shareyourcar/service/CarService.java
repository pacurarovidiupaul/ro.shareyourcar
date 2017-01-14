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

	public Collection<Car> listAvailable() {
		return dao.getAvailableCars();
	}
<<<<<<< HEAD

=======
	
>>>>>>> e38bc0ad42ed5c1dd45659a8bf9af70588edfae3
	public Collection<Car> listBooked() {
		return dao.getBookedCars();
	}

	public Collection<Car> search(String query) {
		return dao.searchByUserName(query);
	}

	public boolean delete(Long id) {
		Car car = dao.findById(id);
		if (car != null) {
			dao.delete(car);
			return true;
		}

		return false;
	}

<<<<<<< HEAD
	public boolean book(int days, Long id) {
		Car car = dao.findById(id);
		if (car != null) {
			dao.book(days, car);
			return true;
		}
		return false;
	}

	public boolean unBook(Long id) {
		Car car = dao.findById(id);
		if (car != null) {
			dao.unBook(car);
			return true;
		}
		return false;
	}

=======
	public boolean book(Long id) {
		Car car = dao.findById(id);
		if (car != null ) {
				dao.book(car);	
				return true;
		}	
	return false;
	}



	public boolean unBook(Long id) {
		Car car = dao.findById(id);
		if (car != null ) {
				dao.unBook(car);	
				return true;
		}	
	return false;
	}


>>>>>>> e38bc0ad42ed5c1dd45659a8bf9af70588edfae3
	public Car get(Long id) {
		return dao.findById(id);

	}


	public void save(Car car) throws ValidationException {
		dao.update(car);
	}

	public void updateEdit(Car car) throws ValidationException {
		dao.updateEdit(car);
	}

	public CarDAO getDao() {
		return dao;
	}

	public void setDao(CarDAO dao) {
		this.dao = dao;	
	}

	
	
	
	
}
