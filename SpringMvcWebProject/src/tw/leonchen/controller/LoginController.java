package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping(path = "/login.mainPageController", method = RequestMethod.GET)
	public String processMainPage() {
		return "login";
	}

	@RequestMapping(path = "/login.checkController", method = RequestMethod.POST)
	public String processAction(@RequestParam(name = "userName") String user, @RequestParam(name = "userPwd") String pwd, Model m) {
		m.addAttribute("user", user);
		m.addAttribute("pwd", pwd);
		return "checkResult";
	}
}
