package ro.shareyourcar.mvc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.shareyourcar.domain.Car;
import ro.shareyourcar.service.CarService;
import ro.shareyourcar.service.ValidationException;

@Controller
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;

	@RequestMapping("add")
	public ModelAndView renderAdd() {
		ModelAndView modelAndView = new ModelAndView("car/add");
		modelAndView.addObject("car", new Car());
		return modelAndView;
	}

	@RequestMapping("edit")
	public ModelAndView renderEdit(long id) {
		ModelAndView modelAndView = new ModelAndView("car/add");
		modelAndView.addObject("car", carService.get(id));
		return modelAndView;
	}

	@RequestMapping("save")
	public ModelAndView save(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult) {
		ModelAndView modelAndView = null;
		boolean hasErros = false;
		if (!bindingResult.hasErrors()) {
			try {
				carService.save(car);

				modelAndView = new ModelAndView();
				modelAndView.setView(new RedirectView("show"));
			} catch (ValidationException ex) {
				for (String msg : ex.getCauses()) {
					bindingResult.addError(new ObjectError("car", msg));
				}
				hasErros = true;
			}
		} else {
			hasErros = true;
		}

		if (hasErros) {
			modelAndView = new ModelAndView("car/add");
			modelAndView.addObject("car", car);
			modelAndView.addObject("errors", bindingResult.getAllErrors());
		}

		return modelAndView;
	}

	@RequestMapping("show")
	public ModelAndView list() throws Exception {
		ModelAndView modelAndView = new ModelAndView("car/list");
		modelAndView.addObject("cars", carService.listAll());
		return modelAndView;
	}
	
	@RequestMapping("delete")
	public ModelAndView delete(long id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("car/list");
		modelAndView.addObject("cars", carService.get(id));
		return modelAndView;
	}

}