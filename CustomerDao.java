package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Customers;

public class CustomerDao {

	Connectionutil obj = new Connectionutil();

	public void insert(Customers cus) throws ClassNotFoundException, SQLException {
		Connection con = obj.getDbConnect();
		String query = "insert into Customers(customer_firstname,customer_lastname,"
				+ "customer_username,customer_password,customer_email,customer_mobilenumber,customer_gender)\r\n"
				+ "values (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, cus.getFirstName());
		pstmt.setString(2, cus.getLastName());
		pstmt.setString(3, cus.getUserName());
		pstmt.setString(4, cus.getPassword());
		pstmt.setString(5, cus.getEmail());
		pstmt.setLong(6, cus.getNumber());
		pstmt.setString(7, cus.getGender());
		int i = pstmt.executeUpdate();
		System.out.println(i + " row updated");
	}

	public void update(Customers cus) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Customers set customer_bank=?,customer_address=?,customer_pincode=?,customer_city=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setLong(1, cus.getBank());
		pstmt.setString(2, cus.getAddress());
		pstmt.setInt(3, cus.getPincode());
		pstmt.setString(4, cus.getCity());
		;
		pstmt.setInt(5, cus.getCustomerId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}	

	public void delete(int cus) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "delete from Customers where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cus);
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}

	public String cusValidation(Customers cus) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "select customer_firstname from customers where customer_username=? and customer_password=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, cus.getUserName());
		pstmt.setString(2, cus.getPassword());
		ResultSet re = pstmt.executeQuery();
		if (re.next()) {
			cus.setFirstName(re.getString(1));
			return "1" + re.getString(1);
		} else if (true) {
			query = "select Admin_firstname from admin_details where admin_username=? and admin_password=?";
			PreparedStatement pstmt1 = con.prepareStatement(query);
			pstmt1.setString(1, cus.getUserName());
			pstmt1.setString(2, cus.getPassword());
			ResultSet re1 = pstmt1.executeQuery();
			if (re1.next()) {
				cus.setFirstName(re1.getString(1));
				return "2" + re1.getString(1);
			}
		}
		return null;
	}

	public boolean ValidatUsername(String cus) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		boolean flag = false;
		String query = "select * from customers where customer_username=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, cus);
		ResultSet re = pstmt.executeQuery();
		if (re.next()) {

			flag = true;
		} else if (true) {
			query = "select admin_firstname from admin_details where admin_username=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cus);
			ResultSet re1 = pstmt.executeQuery();
			if (re1.next()) {
				flag = true;

			}
		}
		return flag;
	}

	public boolean ValidateEmail(String cus) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		boolean flag = false;
		String query = "select * from customers where customer_email=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, cus);
		ResultSet re = pstmt.executeQuery();
		if (re.next()) {
			flag = true;
		} else if (true) {
			query = "select admin_email from admin_details where admin_email=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cus);
			ResultSet re1 = pstmt.executeQuery();
			if (re1.next()) {
				flag = true;
			}
		}
		return flag;
	}

	public List<Customers> showAll() throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		List<Customers> customerList = new ArrayList<Customers>();
		String query = "select * from customers";

		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			Customers customer = new Customers(re.getInt(1), re.getString(2), re.getString(3), re.getString(4),
					re.getString(5), re.getString(6), re.getString(7), re.getLong(8), re.getLong(9), re.getDate(10),
					re.getString(11), re.getInt(12), re.getString(12), re.getString(14));
			customerList.add(customer);
		}

		return customerList;
	}
	public Customers customerDetails(String userName) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "select * from customers where Customer_username='"+userName+"'";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		Customers customer =null;
		while (re.next()) {
			 customer=new Customers(re.getInt(1), re.getString(2), re.getString(3), re.getString(4),
					re.getString(5), re.getString(6), re.getString(7), re.getLong(8), re.getLong(9), re.getDate(10),
					re.getString(11), re.getInt(12), re.getString(12), re.getString(14));
			
		}

		return customer;
	}

	public long shownumber() throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();

		String query = "select customer_mobilenumber from customers where customer_id=1";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		long number = 0;
		while (re.next()) {
			number = re.getLong(1);

		}

		return number;
	}

	public void updateBank(int cusId,long bank) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Customers set customer_bank=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setLong(1, bank);
		pstmt.setInt(2, cusId);
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void updateFirstName(int cusId,String firstName) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Customers set customer_firstname=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, firstName);
		pstmt.setInt(2, cusId);
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void updateLastName(int cusId,String lastName) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Customers set customer_lastname=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, lastName);
		pstmt.setInt(2, cusId);
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void updateUserName(int cusId,String userName) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Customers set customer_username=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, userName);
		pstmt.setInt(2, cusId);
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void updatePassword(int cusId,String password) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Customers set customer_password=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, password);
		pstmt.setInt(2, cusId);
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void updateNumber(int cusId,long number) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Customers set customer_mobilenumber=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setLong(1, number);
		pstmt.setInt(2, cusId);
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void updateGender(Customers cus) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Customers set customer_gender=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, cus.getGender());
		pstmt.setInt(2, cus.getCustomerId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void updateEmail(int cusId,String email) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Customers set customer_email=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, email);
		pstmt.setInt(2, cusId);
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void updateAddress(int cusId,String address) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Customers set customer_address=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1,address );
		pstmt.setInt(2, cusId);
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void updatePincode(int cusId,int pincode) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Customers set customer_pincode=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1,pincode );
		pstmt.setInt(2, cusId);
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void updateCity(int cusId,String city) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Customers set customer_city=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, city);
		pstmt.setInt(2, cusId);
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void updateImage(int cusId,String image) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Customers set customer_image=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, image);
		pstmt.setInt(2, cusId);
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void updateAddressPincode(Customers cus) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Customers set customer_address=?,customer_pincode=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, cus.getAddress());
		pstmt.setInt(2, cus.getPincode());
		pstmt.setInt(3, cus.getCustomerId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
}
