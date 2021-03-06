package com.project.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory_list")
public class Inventory {

	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "price")
	private float price;
	
	private int userId;
	
	
	public Inventory() {
		
	}
	

	public Inventory(int itemId) {
		super();
		this.itemId = itemId;
	}




	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public int getQuantity() {
		return quantity;
	}
	

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public void setPrice(float price) {
		this.price = price;
	}

}
