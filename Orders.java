package com.model;

import java.sql.Date;
import java.util.Objects;

public class Orders {
	
	private int orderId;
	private int customerId;
	private double Totalprice;
	private String orderStatus;
	private Date orderDate;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getTotalprice() {
		return Totalprice;
	}
	public void setTotalprice(double totalprice) {
		Totalprice = totalprice;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerId=" + customerId + ", Totalprice=" + Totalprice
				+ ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + "]";
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(int customerId, double totalprice) {
		super();
		this.customerId = customerId;
		Totalprice = totalprice;
	}
	public Orders(int orderId, int customerId, double totalprice, String orderStatus, Date orderDate) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		Totalprice = totalprice;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}

	
}
