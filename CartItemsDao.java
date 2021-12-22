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

public class CartItemsDao {
	
	       // To get Connection from connection util
	       Connectionutil obj = new Connectionutil();
	       PreparedStatement pstmt =null;
	       public void insert(CartItems cartit) {		
		Connection con;
	
		try {
			con = obj.getDbConnect();
			String query = "insert into Cart_items(pet_id,customer_id,quantity,unit_price,total_price) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cartit.getPetId());
			pstmt.setInt(2, cartit.getCustomerId());
			pstmt.setInt(3, cartit.getQuantity());
			pstmt.setDouble(4, cartit.getUnitPrice());
			pstmt.setDouble(5, cartit.getTotalPrice());
			System.out.println(pstmt.executeUpdate() + " rows inserted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	// To update order qtr
	public void update(CartItems cartit) throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "update Cart_items set Quantity=? where item_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cartit.getQuantity());
		pstmt.setInt(2, cartit.getItemId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void delete(int itemId) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "delete from cart_items where item_id="+itemId+"";
		PreparedStatement pstmt = con.prepareStatement(query);
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}

	
	public List<CartItems> show(Customers cus) throws SQLException, ClassNotFoundException {
		
		Connection con = obj.getDbConnect();
		List<CartItems> cartList= new ArrayList<CartItems>();
		CartItems cartItem=null;
		String query = "select * from cart_items where customer_id='"+cus.getCustomerId()+"'";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			cartItem=new CartItems(re.getInt(1),re.getInt(2),re.getInt(3),re.getInt(4),re.getDouble(5),re.getDouble(6));
		cartList.add(cartItem);
		}
      return cartList;
	}
}
