package asw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {
	
	@RequestMapping(value = "/home")
	public String home() {
		return "index";
	}
	
}
