package com.fit.DaoImpl;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fit.Dao.UserDAO;
import com.fit.model.Supplier;
import com.fit.model.User;


@Entity
@Repository("userDaoImpl")
@Service
public class UserDaoImpl implements UserDAO 
	{
	@Autowired
	SessionFactory sessionFactory;
		@Autowired
		public UserDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory=sessionFactory;
		}


		@Override
		public void insertUser(User user) 
		{
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(user);
			session.getTransaction().commit();
			session.close();
			
		}
		public List<User> retrieve()
		{Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		List<User> list = session.createQuery("from User").list();
		session.getTransaction().commit();
		    
		return list;
		}
		public  User findUserById(String userEmail) 
		{
				Session session=sessionFactory.openSession();
		User cr=null;
		try{
			session.beginTransaction();
		cr=(User) session.get(User.class,userEmail);
			session.getTransaction().commit();
		}
		catch(HibernateException ex)
		{ex.printStackTrace();
		session.getTransaction().rollback();
			
		}
		return cr;
		}
		
	}


