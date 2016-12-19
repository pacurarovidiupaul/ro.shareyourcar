package ro.shareyourcar.ro.shareyourcar;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ro.shareyourcar.cfg.ApplicationConfiguration;
import ro.shareyourcar.service.CarService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class})

public class CarServiceTestWithConfiguration extends BaseCarServiceTest{

	@Autowired
	private CarService service;

	@Override
	protected CarService getCarService() {
		return service;
	}

}
