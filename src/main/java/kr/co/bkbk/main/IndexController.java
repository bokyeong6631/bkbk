package kr.co.bkbk.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping(value="/index.java6", method=RequestMethod.GET)
	public String index() {
		return "redirect:/login.java6";
	}
	
	@RequestMapping(value="/login.java6", method=RequestMethod.GET)
	public void login() {
		
	}
}
