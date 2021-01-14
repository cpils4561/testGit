package tw.leonchen.model;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureService {
 
 @Autowired	
  private PictureDao pdao;
 
 public Picture insert(Picture pic) {
	
	 return pdao.insert(pic);
	 
 }
 
 public List<Picture> selectAll() {
		return pdao.selectAll();
	}
 
 
}
