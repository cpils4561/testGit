package tw.leonchen.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class PictureDao {
	
	@Autowired
    private SessionFactory factory;
	
	public PictureDao() {
		
	}


	public List<Picture> selectAll() {
		Session session=factory.getCurrentSession();
		Query<Picture> query = session.createQuery("from Picture", Picture.class);
		return query.list();
	}
	
	
	public Picture insert(Picture pic) {
	   Session session = factory.getCurrentSession();
	   
	   if(pic!=null) {
		   session.save(pic);		   
	   }
		
	   return pic;
	}
}
