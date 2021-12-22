package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Carts;


public class CartDao {
	public void insert(Carts cart) throws SQLException, ClassNotFoundException {

		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "insert into Carts values(?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cart.getCardId());
		pstmt.setInt(2, cart.getCustomerId());
		int i=pstmt.executeUpdate();
		System.out.println( i+ " rows inserted");
	}

	public void update(Carts cart) throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "update carts set Customer_id=? where cart_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cart.getCustomerId());
		pstmt.setInt(2, cart.getCardId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void delete(Carts cart) throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "delete from carts where cart_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cart.getCardId());
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}

	public void show() throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "select Customer_id from Carts";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			System.out.println(re.getInt(1));
		}

	}

}
