package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Employee;
import com.model.PetDetails;

public class EmployeeDao {
	
	public void insert(Employee emp) throws SQLException, ClassNotFoundException {

		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "insert into animals_employees values"
				+ "(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, emp.getEmployeeId());
		pstmt.setString(2, emp.getFirstName());
		pstmt.setString(3, emp.getLastName());
		pstmt.setDate(4, emp.getDobDate());
		pstmt.setDate(5, emp.getDojDate());
		pstmt.setString(6, emp.getEmail());
		pstmt.setLong(7, emp.getEmployeenumber());
		pstmt.setDouble(8, emp.getEmployeesalary());
		pstmt.setDate(9, emp.getRegDate());
		System.out.println(pstmt.executeUpdate() + " rows inserted");
	}

	public void update(Employee anim) throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "update animals_employees employee_dob=? where employee_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setDate(1, anim.getDobDate());
		pstmt.setInt(2, anim.getEmployeeId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void delete(PetDetails anim) throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "delete from animals_employees where employee_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, anim.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}

	public void show() throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "select employee_name from animals_employees";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			System.out.println(re.getString(1));
		}

	}

}
