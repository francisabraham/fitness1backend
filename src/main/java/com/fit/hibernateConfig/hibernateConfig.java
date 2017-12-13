package com.fit.hibernateConfig;
import com.fit.Dao.*;
import com.fit.DaoImpl.*;
import com.fit.model.*;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SuppressWarnings("unused")
@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class hibernateConfig {
	@Autowired
	@Bean(name="datasource")
	public DataSource getH2Data()
	{
		System.out.println("Hibernate bean initiated");
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
		datasource.setUsername("sa");
		datasource.setPassword("");
		System.out.print("H2 Connected");
		return datasource;
	}
	private Properties gethiberProp()
	{
		Properties p=new Properties();
		p.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		p.put("hibernate.hbm2ddl.auto", "update");
		p.put("hibernate.show_sql", "true");
		System.out.println("Data table created in H2");
		return p;
		
}
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFac(DataSource datasource)
	{LocalSessionFactoryBuilder sb=new LocalSessionFactoryBuilder(datasource);
	sb.addProperties(gethiberProp());
	sb.addAnnotatedClass(User.class);
	sb.addAnnotatedClass(Supplier.class);
	sb.addAnnotatedClass(Product.class);
	sb.addAnnotatedClass(Category.class);
	sb.addAnnotatedClass(Cart.class);
	sb.addAnnotatedClass(Orders.class);
	return sb.buildSessionFactory();
	}
	
	
	@Autowired
	@Bean(name="UserDaoImpl")
	
public UserDaoImpl getUseData(SessionFactory sessionFactory){
		return new UserDaoImpl(sessionFactory);
		}

	@Autowired
	@Bean(name="SupplierDaoImpl")
	public SupplierDaoImpl getSuppData(SessionFactory sessionFactory){
	return new SupplierDaoImpl(sessionFactory);
	}

	
@Autowired
	@Bean(name="ProductDaoImpl")
public ProductDaoImpl getUseData2(SessionFactory sessionFactory){
	return new ProductDaoImpl(sessionFactory);
	}

@Autowired
@Bean(name="CategoryDaoImpl")
public CategoryDaoImpl getUseData3(SessionFactory sessionFactory){
return new CategoryDaoImpl(sessionFactory);
}

@Autowired
@Bean(name="CartDaoImpl")
public CartDaoImpl getCartData(SessionFactory sessionFactory){
return new CartDaoImpl(sessionFactory);
}

@Autowired
@Bean(name="OrdersDaoImpl")
public OrdersDaoImpl getOrdersData(SessionFactory sessionFactory){
return new OrdersDaoImpl(sessionFactory);
}



	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager gettrans(SessionFactory sessionFactory)
	{
		HibernateTransactionManager tm=new HibernateTransactionManager(sessionFactory);
		return tm;
	}
}