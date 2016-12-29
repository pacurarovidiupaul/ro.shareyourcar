package ro.shareyourcar.mvc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.shareyourcar.domain.Owner;
import ro.shareyourcar.service.OwnerService;
import ro.shareyourcar.service.ValidationException;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private OwnerService ownerService;

	@RequestMapping("add")
	public ModelAndView renderAdd() {
		ModelAndView modelAndView = new ModelAndView("owner/add");
		modelAndView.addObject("owner", new Owner());
		return modelAndView;
	}

	@RequestMapping("edit")
	public ModelAndView renderEdit(long id) {
		ModelAndView modelAndView = new ModelAndView("owner/add");
		modelAndView.addObject("owner", ownerService.get(id));
		return modelAndView;
	}

	@RequestMapping("save")
	public ModelAndView save(@Valid @ModelAttribute("owner") Owner owner, BindingResult bindingResult) {
		ModelAndView modelAndView = null;
		boolean hasErros = false;
		if (!bindingResult.hasErrors()) {
			try {
				ownerService.save(owner);

				modelAndView = new ModelAndView();
				modelAndView.setView(new RedirectView(""));
			} catch (ValidationException ex) {
				for (String msg : ex.getCauses()) {
					bindingResult.addError(new ObjectError("owner", msg));
				}
				hasErros = true;
			}
		} else {
			hasErros = true;
		}

		if (hasErros) {
			modelAndView = new ModelAndView("owner/add");
			modelAndView.addObject("owner", owner);
			modelAndView.addObject("errors", bindingResult.getAllErrors());
		}

		return modelAndView;
	}

	@RequestMapping("")
	public ModelAndView list() throws Exception {
		ModelAndView modelAndView = new ModelAndView("owner/list");
		modelAndView.addObject("owners", ownerService.listAll());
		return modelAndView;
	}

}
