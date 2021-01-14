package tw.leonchen.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.leonchen.model.Account;
import tw.leonchen.model.AccountDao;

@Controller
@SessionAttributes(names = {"errors"})
public class Loginsystemcontrooler {

	@Autowired
	private AccountDao adao;
	
	@RequestMapping(path = "/loginpage.controller",method = RequestMethod.GET) 
	public String processMainPageAction() {		
		
		return "loginSystem";
	}
	
	
	@RequestMapping(path="/logincheck.controller",method = RequestMethod.POST)
	public String processCheckLoginAction(@RequestParam(name = "username")String username,
			@RequestParam(name = "userpwd") String pwd,Model m) {
		Map<String,String> errors = new HashMap<String,String>();
		if(username==null || username.length()==0) {
			errors.put("name","輸入拉乾");			
		}
		
		if(pwd==null || pwd.length()==0) {
			errors.put("pwd","輸入密碼哦");			
		}
		
		m.addAttribute("errors",errors);		
		if(errors!=null &&!errors.isEmpty()) {
			return "loginSystem";		
		}
		
	boolean checkstatus = adao.CheckLogin(new Account(username,pwd));
		if(checkstatus) {
			m.addAttribute("myuser",username);
			m.addAttribute("mypwd",pwd);
			return "loginsuccess";			
		}
		errors.put("msg","沒這個人 笨蛋");
		 	
		return "loginSystem";
		
	}
	
}
