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
	public ModelAndView renderEdit(Car car, long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		if(currentPrincipalName.equals(car.getOwnerUserName())){
		ModelAndView modelAndView = new ModelAndView("car/edit");
		modelAndView.addObject("car", carService.get(id));
		return modelAndView;}
		else { ModelAndView modelAndView = new ModelAndView("car/list");
		modelAndView.setView(new RedirectView("list"));
		return modelAndView;}
	}

	@RequestMapping("save")
	public ModelAndView save(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult) {
		ModelAndView modelAndView = null;
		boolean hasErros = false;
		if (!bindingResult.hasErrors()) {
			try {
				carService.save(car);

				modelAndView = new ModelAndView();
				modelAndView.setView(new RedirectView("/owner"));
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
			modelAndView = new ModelAndView("car/edit");
			modelAndView.addObject("car", car);
			modelAndView.addObject("errors", bindingResult.getAllErrors());
		}

		return modelAndView;
	}

	@RequestMapping("update")
	public ModelAndView update(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult) {
		ModelAndView modelAndView = null;
		boolean hasErros = false;
		if (!bindingResult.hasErrors()) {
			try {
				carService.updateEdit(car);

				modelAndView = new ModelAndView();
				modelAndView.setView(new RedirectView("/owner"));
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
			modelAndView = new ModelAndView("car/edit");
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

	@RequestMapping("available")
	public ModelAndView listAvailable() throws Exception {
		ModelAndView modelAndView = new ModelAndView("car/listclient");
		modelAndView.addObject("cars", carService.listAvailable());
		return modelAndView;
	}

	@RequestMapping("booked")
	public ModelAndView listBooked() throws Exception {
		ModelAndView modelAndView = new ModelAndView("car/listbooked");
		modelAndView.addObject("cars", carService.listBooked());
		return modelAndView;
	}

	@RequestMapping("list")
	public ModelAndView listByUserName(String query) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		ModelAndView modelAndView = new ModelAndView("car/listowner");
		modelAndView.addObject("cars", carService.search(currentPrincipalName));
		return modelAndView;
	}

	@RequestMapping("delete")
	public ModelAndView delete(Car car, long id) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		if(currentPrincipalName.equals(car.getOwnerUserName())){
		ModelAndView modelAndView = new ModelAndView("car/list");
		modelAndView.addObject("cars", carService.delete(id));
		modelAndView.setView(new RedirectView("list"));
		return modelAndView;}
		else {
			ModelAndView modelAndView = new ModelAndView("car/list");
			modelAndView.setView(new RedirectView("list"));
			return modelAndView;
		}
		}

	@RequestMapping("book")
	public ModelAndView book(int days, long id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("car/list");
		modelAndView.addObject("cars", carService.book(days, id));
		modelAndView.setView(new RedirectView("available"));
		return modelAndView;
	}

	@RequestMapping("unbook")
	public ModelAndView ride(long id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("car/list");
		modelAndView.addObject("cars", carService.unBook(id));
		modelAndView.setView(new RedirectView("/client"));
		return modelAndView;
	}

	@RequestMapping("showpos")
	public ModelAndView shoPos(long id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("car/position");
		return modelAndView;

	}

	@RequestMapping("showroute")
	public ModelAndView showRoute(long id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("car/route");
		return modelAndView;
	}
}