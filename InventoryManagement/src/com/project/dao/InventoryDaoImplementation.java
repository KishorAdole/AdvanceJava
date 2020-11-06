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

import com.project.dto.Inventory;

@Repository
public class InventoryDaoImplementation implements InventoryDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insertInventory(Inventory inventory) {
		
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				session.save(inventory);
				transaction.commit();
				session.flush();
				session.close();
				return null;
			}
		});

	}

	@Override
	public void deleteInventory(int itemId) {
		
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				session.delete(new Inventory(itemId));
				transaction.commit();
				session.flush();
				session.close();
				return null;
			}
		});
	}

	@Override
	public Inventory selectInventory(int itemId) {
		
		Inventory inventory = hibernateTemplate.execute(new HibernateCallback<Inventory>() {

			@Override
			public Inventory doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				Inventory items = (Inventory) session.get(Inventory.class, itemId);
				transaction.commit();
				session.flush();
				session.close();
				return items;
			}
		});
		
		return inventory;

	}

	@Override
	public void updateInventory(Inventory inventory) {
		
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				session.update(inventory);
				transaction.commit();
				session.flush();
				session.close();
				return null;
			}
		});
		

	}

	@Override
	public List<Inventory> selectAll(int userId) {
		List<Inventory> listItems = hibernateTemplate.execute(new HibernateCallback<List<Inventory>>() {

			@Override
			public List<Inventory> doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				Query query = session.createQuery("from Inventory where userId=?");
				query.setInteger(0, userId);
				List<Inventory> li=query.list();
				transaction.commit();
				session.flush();
				session.close();
				return li;
			}
		});
		
		return listItems;
	}
	
}

	