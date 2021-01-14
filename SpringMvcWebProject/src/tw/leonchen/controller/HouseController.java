package tw.leonchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.leonchen.model.House;
import tw.leonchen.model.HouseService;

@Controller
public class HouseController {
	
  @Autowired
  private HouseService hservice;
	
	 @RequestMapping(path="/house.controller", method = RequestMethod.GET)
	  public String prcesssaction(Model m) {
	    House house =  hservice.select(1003);	  
		if(house!=null) {
			m.addAttribute("id",house.getHouseid());
			m.addAttribute("name",house.getHousename());
		}  else {
			m.addAttribute("no","沒結果");			
		}
	    
		  return "houseresult";
		  
	  }
}
