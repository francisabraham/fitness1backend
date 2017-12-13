package com.fit.DaoImpl;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fit.Dao.CategoryDAO;

import com.fit.model.Category;


@Repository("categoryDaoImpl")
public  class CategoryDaoImpl implements CategoryDAO
{
	@Autowired 
	SessionFactory sessionFactory;
    @Autowired  
public  CategoryDaoImpl(SessionFactory sessionFactory)
{
	this.sessionFactory= sessionFactory;
}
public void insertCategory(Category category)
{Session session=sessionFactory.openSession();
session.beginTransaction();
session.saveOrUpdate(category);
session.getTransaction().commit();
session.close();
}

	
	
	
	public List<Category> retrieve()
	{
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	List<Category> list = session.createQuery("from Category").list();
	session.getTransaction().commit();
   	return list;
	 
	}


public Category findById(int cid)
{
	Session session=sessionFactory.openSession();
Category p=null;
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
public void deleteCategory(int cid) 
{
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.delete(cid);
	session.getTransaction().commit();
	session.close();	
}
public void update(Category c) {
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.update(c);
	session.getTransaction().commit();
	session.close();
}
}



	
