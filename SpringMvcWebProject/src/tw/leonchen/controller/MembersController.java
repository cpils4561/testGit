package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import tw.leonchen.model.Members;

@Controller
public class MembersController {
  
	@RequestMapping(path="/members" ,method = RequestMethod.GET)
	public String showform(Model m) {
		Members mem = new Members();
		m.addAttribute("members",mem);
		return "members";
	}

	
	@RequestMapping(path="/addMembers" ,method = RequestMethod.POST)
	public String submit(@ModelAttribute("members") Members members,BindingResult result,Model m) {
		if(result.hasErrors()) {
			return "membersError";
		}
		m.addAttribute("memberName",members.getMemberName());
		m.addAttribute("gender",members.getGender());
		m.addAttribute("age",members.getAge());
	
		return "membersResult";
	}
	
	 
	
}
