package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.InventoryDao;
import com.project.dto.Inventory;

@Service
public class InventoryServiceImplementation implements InventoryService {

	@Autowired
	private InventoryDao inventoryDao;
	
	@Override
	public void addInventory(Inventory inventory) {
		
		inventoryDao.insertInventory(inventory);

	}

	@Override
	public void removeInventory(int itemId) {
		
		inventoryDao.deleteInventory(itemId);

	}

	@Override
	public Inventory findInventory(int itemId) {
		
		return inventoryDao.selectInventory(itemId);
	}

	@Override
	public void modifyInventory(Inventory inventory) {
		
		inventoryDao.updateInventory(inventory);

	}

	@Override
	public List<Inventory> selectAll(int userId) {
		
		return inventoryDao.selectAll(userId);
	}

}
