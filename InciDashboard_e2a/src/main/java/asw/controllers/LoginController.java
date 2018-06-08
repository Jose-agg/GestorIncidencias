package asw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login")
	public String login(Model model) {
		return "/login/login";
	}

	@RequestMapping(value = "/login/error")
	public String loginError(Model model) {
		return "/login/error";
	}
}
