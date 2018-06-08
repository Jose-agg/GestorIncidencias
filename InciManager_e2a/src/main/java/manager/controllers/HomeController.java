package manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	/**
	 * Devuelve la pagina de incio login
	 * 
	 * @param model
	 * @return pagina log HTML
	 */
	@RequestMapping(value = { "/", "/portal" }, method = RequestMethod.GET)
	public String showView(Model model) {
		return "log";
	}
}