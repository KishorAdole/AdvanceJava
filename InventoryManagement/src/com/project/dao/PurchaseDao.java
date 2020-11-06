package com.project.dao;

import java.util.List;


import com.project.dto.Purchase;

public interface PurchaseDao {
	
	void insertItem(Purchase purchase);
	List<Purchase> selectAll(int userId);
}
