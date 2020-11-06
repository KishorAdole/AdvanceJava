package com.project.service;

import java.util.List;

import com.project.dto.Inventory;

public interface InventoryService {
	
	void addInventory(Inventory inventory);
	void removeInventory(int itemId);
	Inventory findInventory(int itemId);
	void modifyInventory(Inventory inventory);
	List<Inventory> selectAll(int userId);

}
