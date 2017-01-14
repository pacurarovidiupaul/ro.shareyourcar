package ro.shareyourcar.dao.inmemory;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import org.springframework.util.StringUtils;

import ro.shareyourcar.dao.CarDAO;
import ro.shareyourcar.domain.Car;

public class IMCarDAO extends IMBaseDAO<Car> implements CarDAO {

	public Collection<Car> searchByName(String query) {
		if (StringUtils.isEmpty(query)) {
			return getAll();
		}

		Collection<Car> all = new LinkedList<Car>(getAll());
		for (Iterator<Car> it = all.iterator(); it.hasNext();) {
			Car car = it.next();
			String ss = car.getProducer() + " " + car.getModel();
			if (!ss.toLowerCase().contains(query.toLowerCase())) {
				it.remove();
			}
		}
		return all;
	}

	@Override
	public boolean book(int days, Car model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Car> getAvailableCars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean unBook(Car model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Car> searchByUserName(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Car> getBookedCars() {
		// TODO Auto-generated method stub
		return null;
	}

}
