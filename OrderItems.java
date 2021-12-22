package com.model;

import java.util.Objects;

public class OrderItems {
    private int itemId;
    private int orderId;
    private int petId;
    private int quantity;
    private double unitPrice;
    private double totalPrice=unitPrice*quantity;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int animalId) {
		this.petId = animalId;
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
	      return this.totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public int hashCode() {
		return Objects.hash(petId, itemId, orderId, quantity, totalPrice, unitPrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItems other = (OrderItems) obj;
		return petId == other.petId && itemId == other.itemId && orderId == other.orderId
				&& quantity == other.quantity && totalPrice == other.totalPrice && unitPrice == other.unitPrice;
	}
	@Override
	public String toString() {
		return "OrderItems [itemId=" + itemId + ", orderId=" + orderId + ", animalId=" + petId + ", quantity="
				+ quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice + "]";
	}
	public OrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItems(int itemId, int quantity) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
	}
	public OrderItems( int animalId, int quantity, double unitPrice, double totalPrice) {
		super();
		this.petId = animalId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}
	public OrderItems(int itemId, int orderId, int petId, int quantity, double unitPrice, double totalPrice) {
		super();
		this.itemId = itemId;
		this.orderId = orderId;
		this.petId = petId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}
	
	
}