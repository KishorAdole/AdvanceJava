package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dto.Inventory;
import com.project.dto.User;
import com.project.service.InventoryService;


@Controller
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;

	@RequestMapping(value = "prepare_inventory_add_form.htm", method = RequestMethod.GET)
	public String prepareInventoryAddForm(ModelMap map) {
		map.put("inventory",new Inventory());
		return "inventory_add_form";
		
	}
	
	@RequestMapping(value = "inventory_add.htm", method = RequestMethod.POST)
	public String addItems(Inventory inventory, HttpSession session) {
		int userId = ((User)session.getAttribute("user")).getUserId();
		inventory.setUserId(userId);
		inventoryService.addInventory(inventory);
		return "home";
		
	}
	
	@RequestMapping(value = "inventory_list.htm", method = RequestMethod.GET)
	public String allInventory(ModelMap map, HttpSession session) {
		int userId = ((User)session.getAttribute("user")).getUserId();
		List<Inventory> li=inventoryService.selectAll(userId);
		map.put("inventoryList", li);
		return "inventory_list" ;
		 
	}
	
	@RequestMapping(value = "inventory_delete.htm", method = RequestMethod.GET)
	public String deleteItem(@RequestParam int itemId, ModelMap map, HttpSession session) {
		
		inventoryService.removeInventory(itemId);
		int userId = ((User)session.getAttribute("user")).getUserId();
		List<Inventory> li=inventoryService.selectAll(userId);
		map.put("inventoryList", li);
		return "inventory_list" ;
		 
	}
	
	@RequestMapping(value = "inventory_update_form.htm", method = RequestMethod.GET)
	public String updateItemForm(@RequestParam int itemId, ModelMap map) {
		
		Inventory inventory=inventoryService.findInventory(itemId);
		
		map.put("inventory", inventory);
		return "inventory_update_form" ;
		 
	}
	
	@RequestMapping(value = "inventory_update.htm", method = RequestMethod.POST)
	public String updateItems(Inventory inventory,ModelMap map, HttpSession session) {
			
		int userId = ((User)session.getAttribute("user")).getUserId();
		inventory.setUserId(userId);
		inventoryService.modifyInventory(inventory);
		List<Inventory> li=inventoryService.selectAll(userId);
		map.put("inventoryList", li);
		return "inventory_list";
		
	}
	
	
	
	
	
}
