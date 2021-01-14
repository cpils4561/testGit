package tw.iii.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.iii.model.ProductService;

@Controller
public class LoginController {
	
	@Autowired
	private ProductService pService;
	
	@RequestMapping(path="/login.controller",method = RequestMethod.POST)
	public String processAction(@RequestParam(name="userName")String username
			,@RequestParam(name="password")String password,Model m,HttpServletRequest req) {
		
		Map<String,String> err=new HashMap<String,String>();
		
		boolean isLogin=pService.login(username, password);
		
		if(username==null||username.length()==0) {
			err.put("userName","請輸入帳號" );
		}
		if(password==null||password.length()==0) {
			err.put("password", "請輸入密碼");
		}
		
		if(isLogin) {
			HttpSession session=req.getSession();
			session.setAttribute("isLogin", isLogin);
			m.addAttribute("selection","all");
			m.addAttribute("productList",pService.selectAll());
			m.addAttribute("count",pService.count());
			return "WEB-INF/html/shop_list.jsp";
		}
		m.addAttribute("err",err);
		if(err!=null&&!err.isEmpty()) {
			return "index.jsp";
		}
		
		err.put("msg", "帳號或密碼錯誤，請重新輸入!");
		return "index.jsp";
	}

}
