package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = {"notify", "orientation"})
public class HappyController {
	
	@RequestMapping(path = "/travel.controller", method = RequestMethod.GET)
	public String processOrigin(Model m) {
		m.addAttribute("orientation", "South");
		return "/happy.controller";
	}

	@RequestMapping(path = "/happy.controller", method = RequestMethod.GET)
	public String processAction(Model model, @ModelAttribute(name = "orientation") String orion) {
		model.addAttribute("notify", "keep writing java:" + orion);
		return "result";
	}

}
