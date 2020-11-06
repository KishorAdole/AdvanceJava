package com.project.dao;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.project.dto.User;

@Repository
public class UserDaoImplementation implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void registerUser(User user) {
		
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				session.save(user);
				transaction.commit();
				session.flush();
				session.close();
				return null;
			}
		});

	}

	@Override
	public boolean verifyUser(User user) {
		
		boolean flag = hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			
			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				Query query = session.createQuery("from User where userName = ? and userPassword = ?");
				query.setString(0, user.getUserName());
				query.setString(1, user.getUserPassword());
				List<User> li = query.list();
				boolean val=!li.isEmpty();
				user.setUserId(li.get(0).getUserId()); 
				transaction.commit();
				session.flush();
				session.close();
				return val;
			}
		});
		
		return flag;
	}

}
