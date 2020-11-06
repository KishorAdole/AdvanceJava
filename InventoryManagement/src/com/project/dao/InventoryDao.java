package com.project.dao;

import java.util.List;

import com.project.dto.Inventory;

public interface InventoryDao {
	
	void insertInventory(Inventory inventory);
	void deleteInventory(int itemId);
	Inventory selectInventory(int itemId);
	void updateInventory(Inventory inventory);
	List<Inventory> selectAll(int userId);

}
