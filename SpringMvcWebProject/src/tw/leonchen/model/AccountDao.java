package tw.leonchen.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public boolean CheckLogin(Account account) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Account where username=:user and userpwd=:pwd";
        Query<Account> query = session.createQuery(sql, Account.class);
		query.setParameter("user", account.getUsername());
		query.setParameter("pwd", account.getUserpwd());
        Account result = query.uniqueResult();
		if (result != null) {
			return true;
		}
		return false;
	}

}
