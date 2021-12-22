package com.model;

import java.util.Objects;

public class CartItems {
	private int itemId;
	private int petId;
	private int customerId;
	private int quantity;
	private double unitPrice;
	private double totalPrice;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int animalId) {
		this.petId = animalId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int cartId) {
		this.customerId = cartId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public int hashCode() {
		return Objects.hash(petId, customerId, itemId, quantity, totalPrice, unitPrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItems other = (CartItems) obj;
		return petId == other.petId && customerId == other.customerId && itemId == other.itemId
				&& quantity == other.quantity
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& Double.doubleToLongBits(unitPrice) == Double.doubleToLongBits(other.unitPrice);
	}
	@Override
	public String toString() {
		return "CartItems [itemId=" + itemId + ", petId=" + petId + ", customerId=" + customerId + ", quantity="
				+ quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice + "]";
	}
	public CartItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItems(int itemId, int quantity) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
	}
	public CartItems(int petId, int customerId, int quantity, double unitPrice,double totalprice ) {
		super();
		this.petId = petId;
		this.customerId = customerId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice=totalprice;
	}
	public CartItems(int itemId, int petId, int customerId, int quantity, double unitPrice, double totalPrice) {
		super();
		this.itemId = itemId;
		this.petId = petId;
		this.customerId = customerId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}
	
	
	

}
