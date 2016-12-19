package ro.shareyourcar.ro.shareyourcar;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import ro.shareyourcar.domain.Car;
import ro.shareyourcar.service.CarService;

public abstract class BaseCarServiceTest {
	
	protected abstract CarService getCarService();
	
	@Test
	public void test_empty_car_get_all() {
		Collection<Car> cars = getCarService().listAll();
		Assert.assertTrue(cars.isEmpty());
	}

}
