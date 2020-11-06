package com.project.service;

import java.util.List;
import com.project.dto.Purchase;

public interface PurchaseService {
	
	void addInventory(Purchase purchase);
	List<Purchase> selectAll(int userId);

}
