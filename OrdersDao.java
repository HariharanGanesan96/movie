package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.Orders;
public class OrdersDao {
	
	// To get connection from connection util
	Connectionutil obj = new Connectionutil();
	
	//To insert the values on orders table
	public void insert(Orders ord) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "insert into orders(Customer_id,total_price) \r\n"
				+ "values(?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, ord.getCustomerId());
		pstmt.setDouble(2, ord.getTotalprice());
		int i=pstmt.executeUpdate();
		System.out.println( i+ " rows inserted");
	}
     
	// To update status in orders table
	public void update(Orders ord) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update animals_orders set status=? where Animal_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, ord.getOrderStatus());
		pstmt.setInt(2, ord.getOrderId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
    
	// To delete particular order from order table
	public void delete(Orders ord) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "delete from Animals_orders where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, ord.getOrderId());
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}
    
	// To show the all the orders
	public void show() throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "select Animals_name from Animals";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			System.out.println(re.getString(1));
		}

	}
	public List<Orders> showMyOrders(int cusId) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "select * from orders o inner join order_items oi"
				+ "on o.order_id=oi.order_id where customer_id='"+cusId+"'";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			
		}
		return null;

	}
    // To get last orderId value to insert
	public int orderId() throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		int orderid=0;
		String query = "select max(order_id) from orders";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			System.out.println(re.getString(1));
			orderid=re.getInt(1);
		}
       return orderid;
	}
}
