package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.CartItems;
import com.model.Customers;
import com.model.OrderItems;



public class OrderItemsDao {
	
	Connectionutil obj = new Connectionutil();
	public void insert(OrderItems orditm) throws SQLException, ClassNotFoundException {

		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "insert into order_items (order_id,pet_id,quantity,unit_price,total_price) values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, orditm.getOrderId());
		pstmt.setInt(2, orditm.getPetId());
		pstmt.setInt(3, orditm.getQuantity());
		pstmt.setDouble(4, orditm.getUnitPrice());
		pstmt.setDouble(5, orditm.getTotalPrice());
		System.out.println(pstmt.executeUpdate() + " rows inserted");
	}

	public void update(OrderItems orditm) throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "update animals_orderitems set Quantity=? where item_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, orditm.getQuantity());
		pstmt.setInt(2, orditm.getOrderId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void delete(OrderItems ord) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "delete from Animals_orderitems where item_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, ord.getOrderId());
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}

	public List<OrderItems> showMyOrders(Customers cus) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		List<OrderItems> orderList= new ArrayList<OrderItems>();
		OrderItems orderItem=null;
		String query = "select oi.item_id,oi.order_id,oi.pet_id,oi.quantity,oi.unit_price,oi.total_price from order_items oi inner join orders o on "
				+ "oi.order_id=o.order_id where customer_id="+cus.getCustomerId()+"";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			orderItem=new OrderItems(re.getInt(1),re.getInt(2),re.getInt(3),re.getInt(4),re.getDouble(5),re.getDouble(6));
		orderList.add(orderItem);
		}
     return orderList;
	}
	
}
