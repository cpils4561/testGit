package tw.leonchen.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class RootAppConfig {
	
Environment env;


	
	@Autowired
	public void setEnv(Environment env) {
		this.env = env;
	}
	
	@Bean  //取代<bean id="sqlserverDataSource"
	public DataSource dataSource() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean jndiBean = new JndiObjectFactoryBean();
		jndiBean.setJndiName("java:comp/env/connectSQLServerJdbc/OrderService");		
		jndiBean.setProxyInterface(DataSource.class);
		jndiBean.setLookupOnStartup(false);
		jndiBean.afterPropertiesSet();
		DataSource ds = (DataSource)jndiBean.getObject();
		System.out.println("ds:" + ds);
		
//		ComboPooledDataSource ds = new ComboPooledDataSource();
//		ds.setUser(env.getProperty("spring.database.user"));
//		ds.setPassword(env.getProperty("spring.database.password"));
//		try {
//			ds.setDriverClass(env.getProperty("spring.database.driverclass"));
//		} catch (PropertyVetoException e) {
//			e.printStackTrace();
//		}
//		ds.setJdbcUrl(env.getProperty("spring.database.url"));
//		ds.setInitialPoolSize(Integer.parseInt((env.getProperty("spring.database.initialpoolsize"))));
//		ds.setMaxPoolSize(Integer.parseInt((env.getProperty("spring.database.maxpoolsize"))));
		return ds;
	}
	
	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", org.hibernate.dialect.SQLServerDialect.class);
		properties.put("hibernate.show_sql", Boolean.TRUE);
		properties.put("hibernate.format_sql", Boolean.TRUE);
		properties.put("hibernate.current_session_context_class", "thread");
//		properties.put("default_batch_fetch_size", 10);
//		properties.put("hibernate.hbm2ddl.auto", "validate");
		return properties;
	}
	
	@Bean(destroyMethod = "destroy")
	public LocalSessionFactoryBean sessionFactory() throws IllegalArgumentException, NamingException {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(new String[] { "tw.leonchen.model" });
		factory.setHibernateProperties(additionalProperties());
		return factory;
	}
	
	@Bean(name = "transactionManager")
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

	
	 

}
