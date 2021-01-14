package tw.leonchen.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("houseDao")
public class HouseDao {

	private SessionFactory sessionFactory;
	
	@Autowired 
	public HouseDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public House select(int houseid) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(House.class, houseid);
	}
	
	public List<House> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<House> query = session.createQuery("from House", House.class);
		return query.list();
	}

}
