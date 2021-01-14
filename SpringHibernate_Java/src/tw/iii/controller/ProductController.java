package tw.iii.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.iii.model.Product;
import tw.iii.model.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService pService;
	private HttpSession session;
	
	//測試一下修改後的我
	//全部查詢
	@RequestMapping(path = "/selectAll",method = RequestMethod.POST)
	public String entryAction(Model m) {
		m.addAttribute("selection","all");
		m.addAttribute("productList",pService.selectAll());
		m.addAttribute("count",String.valueOf(pService.count()));
		return "WEB-INF/html/shop_list.jsp";
	}
	
	//種類查詢
	@RequestMapping(path = "/selectClass",method = RequestMethod.POST)
	public String selectClass(@RequestParam(name="Classification")String classf,Model m) {
		m.addAttribute("selection","selectClass");
		m.addAttribute("productList",pService.selectclass(classf));
		m.addAttribute("count",String.valueOf(pService.countclass(classf)));
		return "WEB-INF/html/shop_list.jsp";
	}
	//價格查詢
	@RequestMapping(path = "/selectPrice",method = RequestMethod.POST)
	public String selectPrice(@RequestParam(name="max")String max, 
			@RequestParam(name="min")String min,Model m) {
		m.addAttribute("selection","limitPrice");
		m.addAttribute("productList",pService.selectwhere(Integer.parseInt(max),Integer.parseInt(min)));
		m.addAttribute("count",String.valueOf(pService.countwhere(Integer.parseInt(max),Integer.parseInt(min))));
		return "WEB-INF/html/shop_list.jsp";
	}
	
	//新增
	@RequestMapping(path = "/addAction",method = RequestMethod.POST)
	public String addAction(@RequestParam(name="name")String pName,
			@RequestParam(name="price")String price, 
			@RequestParam(name="classification")String classf,Model m) {
		
		Product pBean = new Product();
		pBean.setProductName(pName);
		pBean.setPrice(Integer.parseInt(price));
		pBean.setClassification(classf);
		
		pService.insert(pBean);
		
		m.addAttribute("selection","all");
		m.addAttribute("productList",pService.selectAll());
		m.addAttribute("count",pService.count());
		return "WEB-INF/html/shop_list.jsp";
	}
	
	//刪除
	@RequestMapping(path="/delAction",method = RequestMethod.GET)
	public String delAction(@RequestParam(name="id")String id,Model m) {
		pService.delete(Integer.parseInt(id));
		
		m.addAttribute("selection","all");
		m.addAttribute("productList",pService.selectAll());
		m.addAttribute("count",pService.count());
		return "WEB-INF/html/shop_list.jsp";
	}
	
	//跳轉至新增
	@RequestMapping(path="/select",method = RequestMethod.GET)
	public String select(@RequestParam(name="id")String id,Model m) {
		Product pbean = pService.select(Integer.parseInt(id));
		m.addAttribute("id",pbean.getProductID());
		m.addAttribute("name",pbean.getProductName());
		m.addAttribute("price",pbean.getPrice());
		
		m.addAttribute("selection","all");
		m.addAttribute("productList",pService.selectAll());
		m.addAttribute("count",pService.count());
		return "WEB-INF/html/updatePage.jsp";
	}
	
	//更新
	@RequestMapping(path="/updateAction",method = RequestMethod.POST)
	public String updateAction(@RequestParam(name="id")String id
			,@RequestParam(name="name")String productname
			,@RequestParam(name="price")String price
			,@RequestParam(name="classification")String classification
			,Model m) {

		pService.update(Integer.parseInt(id), productname,Integer.parseInt(price), classification);
		
		m.addAttribute("selection","all");
		m.addAttribute("productList",pService.selectAll());
		m.addAttribute("count",pService.count());
		return "WEB-INF/html/shop_list.jsp";
	}
	
	
}
