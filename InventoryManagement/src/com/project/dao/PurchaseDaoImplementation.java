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

import com.project.dto.Purchase;

@Repository
public class PurchaseDaoImplementation implements PurchaseDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void insertItem(Purchase purchase) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				session.save(purchase);
				transaction.commit();
				session.flush();
				session.close();
				return null;
			}
		});

	}

	@Override
	public List<Purchase> selectAll(int userId) {
		List<Purchase> listItems = hibernateTemplate.execute(new HibernateCallback<List<Purchase>>() {

			@Override
			public List<Purchase> doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				Query query = session.createQuery("from Purchase where userId=?");
				query.setInteger(0, userId);
				List<Purchase> li=query.list();
				transaction.commit();
				session.flush();
				session.close();
				return li;
			}
		});
		
		return listItems;
	}

}
