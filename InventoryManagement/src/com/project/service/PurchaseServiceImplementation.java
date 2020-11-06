package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.PurchaseDao;
import com.project.dto.Purchase;

@Service
public class PurchaseServiceImplementation implements PurchaseService {

	@Autowired
	private PurchaseDao purchaseDao;
	
	@Override
	public void addInventory(Purchase purchase) {
		purchaseDao.insertItem(purchase);
	}

	@Override
	public List<Purchase> selectAll(int userId) {
		return purchaseDao.selectAll(userId);
	}

}
