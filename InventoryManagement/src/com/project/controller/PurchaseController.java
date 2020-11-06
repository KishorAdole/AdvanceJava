package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.dto.Purchase;
import com.project.dto.User;
import com.project.service.PurchaseService;

@Controller
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	@RequestMapping(value = "prepare_item_add_form.htm", method = RequestMethod.GET)
	public String prepareItemAddForm(ModelMap map) {
		map.put("purchase",new Purchase());
		return "item_add_form";
		
	}
	
	@RequestMapping(value = "purchase_add.htm", method = RequestMethod.POST)
	public String addItems(Purchase purchase, HttpSession session) {
		int userId = ((User)session.getAttribute("user")).getUserId();
		purchase.setUserId(userId);
		purchaseService.addInventory(purchase);
		return "user_home";
		
	}
	
	@RequestMapping(value = "purchase_list.htm", method = RequestMethod.GET)
	public String allItems(ModelMap map, HttpSession session) {
		int userId = ((User)session.getAttribute("user")).getUserId();
		List<Purchase> li=purchaseService.selectAll(userId);
		map.put("purchaseList", li);
		return "purchase_list" ;
		 
	}
	
	
	@RequestMapping(value = "buy_items.htm", method = RequestMethod.GET)
	public String updateItems(){
		return null;
		
	}
	
	

}
