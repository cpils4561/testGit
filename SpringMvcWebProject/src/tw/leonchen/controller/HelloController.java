package tw.leonchen.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class HelloController extends AbstractController {
	
	@RequestMapping(path = "/hello.mycontroller", method = RequestMethod.GET)
	public String processAction(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
		
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		
		if(userName==null || userName.length()==0) {
			errors.put("msg", "name is still required");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "form";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		return "success";
	};

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		
		if(userName==null || userName.length()==0) {
			errors.put("msg", "name is required");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return new ModelAndView("form");
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		return new ModelAndView("success");
	}
}








