package tw.leonchen.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("houseService")
public class HouseService {

	private HouseDao hDao;

	@Autowired
	public HouseService(HouseDao hDao) {
       this.hDao = hDao;
	}
	
	public House select(int houseid) {
		return hDao.select(houseid);
	}
	
	public List<House> selectAll() {
		return hDao.selectAll();
	}

}
