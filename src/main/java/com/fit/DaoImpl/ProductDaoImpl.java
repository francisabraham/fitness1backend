package com.fit.DaoImpl;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.fit.Dao.ProductDAO;
import com.fit.model.Category;
import com.fit.model.Product;

@Repository
public class ProductDaoImpl implements ProductDAO 
{
@Autowired
SessionFactory sessionFactory;
public ProductDaoImpl(SessionFactory sessionfactory)
{
	this.sessionFactory= sessionFactory;
	
}
public void insertProduct(Product product) 
{
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.saveOrUpdate(product);
	session.getTransaction().commit();
	session.close();
}
public List<Product>retrieve()
{
 Session session=sessionFactory.openSession();
 session.beginTransaction();
 List<Product> list=session.createQuery("from Product").list();
 session.getTransaction().commit();
 return list;
}
public Product findById(int pid)
{
	Session session= sessionFactory.openSession();
	Product p=null;
	
try{
	session.beginTransaction();
	//p=session.get(Categorydetails.class,cid)
	session.getTransaction().commit();
}
catch(HibernateException ex)
{ex.printStackTrace();
session.getTransaction().rollback();
	
}
return p;
}
public void update(Product prod2) {
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.update(prod2);
	session.getTransaction().commit();
	session.close();	
}
public void deleteProduct(int pid) {
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.delete(pid);
	session.getTransaction().commit();
	session.close();
}
public Product getProdById(int cid) {
	Session session=sessionFactory.openSession();
Product p=null;
try{
	session.beginTransaction();
	//p=session.get(Product.class,cid)
	session.getTransaction().commit();
}
catch(HibernateException ex)
{ex.printStackTrace();
session.getTransaction().rollback();
	
}
return p;
}
}
