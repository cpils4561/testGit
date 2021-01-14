package tw.iii.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao pDao;
	
	public Product insert(Product PD) {
		return pDao.insert(PD);
	}
	
	public boolean delete(int productid) {
		return pDao.delete(productid);
	}
	
	public Product update(int productid,String productname,int price,String Classification) {
		return pDao.update(productid, productname, price, Classification);
	}
	
	public Product select(int productid) {
		return pDao.select(productid);
	}
	public List<Product> selectAll(){
		return pDao.selectAll();
	}
	
	public List<Product> selectwhere(int max,int min){
		return pDao.selectwhere(max, min);
	}
	
	public Object count() {
		return pDao.count();
	}
	
	public Object countwhere(int max,int min) {
		return pDao.countwhere(max, min);
	}
	
	public boolean login(String username, String password) {
		return pDao.login(username, password);
	}
	public List<Product> selectclass(String Classification){
		return pDao.selectclass(Classification);
	}
	
	public Object countclass(String Classification) {
		return pDao.countclass(Classification);
	}
}
