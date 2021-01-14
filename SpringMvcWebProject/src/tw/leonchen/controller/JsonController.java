package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.leonchen.model.House;

@Controller
public class JsonController {

	@RequestMapping(path="/housebeanjson",method = RequestMethod.GET)
	public String processAction(Model m) {
		House hbean = new House();
		hbean.setHouseid(2001);
		hbean.setHousename("大破破貓");
		
		m.addAttribute("housebean",hbean);
		
		return "myhousebean";
	}
	
}
