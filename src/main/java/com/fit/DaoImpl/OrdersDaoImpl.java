package com.fit.DaoImpl;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fit.model.Orders;

@Repository("ordersDaoImpl")
public class OrdersDaoImpl 
{
@Autowired

SessionFactory sessionFactory;
public OrdersDaoImpl(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
	}
public  void insert(Orders order)
{
  Session session=sessionFactory.openSession();
  session.beginTransaction();
  session.persist(order);
  session.getTransaction().commit();
}

}
