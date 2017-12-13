package com.fit.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fit.Dao.*;
import com.fit.model.Category;
import com.fit.model.Supplier;
@Repository("supplierDaoImpl")
public class SupplierDaoImpl implements SupplierDAO {
	@Autowired
SessionFactory sessionFactory;
	@Autowired
	public SupplierDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	
	
	public void insertSupplier(Supplier supplier)
	{
		Session session=sessionFactory.openSession();
	session.beginTransaction();
// session.persist(supplier);
	session.saveOrUpdate(supplier);
	session.getTransaction().commit();
	session.close();
	}
		
	public List<Supplier> retrieve()
	{Session session=sessionFactory.openSession();
	session.beginTransaction();
	
	List<Supplier> list = session.createQuery("from Supplier").list();
	session.getTransaction().commit();
	    
	return list;
	}
	
	
	public Supplier findById(int sid)
	{
		Session session=sessionFactory.openSession();
	Supplier p=null;
	try{
		session.beginTransaction();
		//p=session.get(Category.class,cid)
		session.getTransaction().commit();
	}
	catch(HibernateException ex)
	{ex.printStackTrace();
	session.getTransaction().rollback();
		
	}
	return p;
	}
	public void deleteSupplier(int sid) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.delete(sid);
		session.getTransaction().commit();
		session.close();	
	}
	public void update(Supplier s) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(s);
		session.getTransaction().commit();
		session.close();
	}	
		

	
	
}
