package com.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.CustomerDao;
import com.dao.PetDao;
import com.model.Admin;
import com.model.Customers;
import com.model.PetDetails;

public class TestMain2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {

		Scanner scan = new Scanner(System.in);

		// Asking for operation
		System.out.println("Enter the operation");
		System.out.println("1.register\n" + "2.login validation\n" + "3.bank and address updataion\n"
				+ "4.list of user\n" + "5.delete\n");

		int operation = Integer.parseInt(scan.nextLine());

		// customersdao created for calling customerdao methods
		CustomerDao cusDao = new CustomerDao();

		switch (operation) {

		// Register operation
		case 1:
			cusDao = new CustomerDao();
			String[] input = new String[7];

			// Input first name
			while (true) {
				System.out.println("enter the first name");
				input[0] = scan.nextLine();
				if (input[0].matches("[a-zA-Z]{3,20}")) {
					break;
				}
				if (input[0].length() <= 2) {
					System.out.println("first name must have minimum 3 character");
				} else if (input[0].matches(".*\\W.*") || input[0].matches(".*\\d.*")) {
					System.out.println("name contains alphabet only");
				}
			}

			// input last name
			while (true) {
				System.out.println("enter the last name");
				input[1] = scan.nextLine();
				if (input[1].matches("[a-zA-Z]{3,20}")) {
					break;
				}
				if (input[1].length() <= 2) {
					System.out.println("lastname must have minimum 3 character");
				} else if (input[1].matches(".*\\W.*") || input[1].matches(".*\\d.*")) {
					System.out.println("name contains alphabet only");
				}

			}

			// input user name
			while (true) {
				System.out.println("enter the user name");
				input[2] = scan.nextLine();
				if (cusDao.ValidatUsername(input[2])) {
					System.out.println("user name not available");
				} else if (input[2].matches("[a-zA-Z0-9]{8,20}")) {
					break;
				} else if (input[2].length() <= 7) {
					System.out.println("username must be minimum 8 character or more");
				} else {
					System.out.println("Don't use special for username");
				}
			}

			// input password
			while (true) {
				System.out.println("enter the password");
				input[3] = scan.nextLine();
				if (input[3].matches("[a-zA-Z0-9!@#$%^&*()_+]{8,20}")) {
					break;
				}
				System.out.println("password nust be in 8 charcter or more");
			}

			// input email
			while (true) {
				System.out.println("enter the email");
				input[4] = scan.nextLine().toLowerCase();
				if (cusDao.ValidateEmail(input[4])) {
					System.out.println("email not available ");
				} else if (input[4].matches("[a-z][a-z0-9.]*@[a-z0-9]+[.][a-z]{2,4}$")) {
					break;
				} else {
					System.out.println("email should contains @ and .");
				}
			}

			// input mobile number
			while (true) {

				System.out.println("enter the mobile number");
				input[5] = scan.nextLine();
				if (input[5].matches("[6-9][0-9]{9}")) {
					break;
				} else if (input[5].matches("[0-5]")) {
					System.out.println("mobile numst be start with 6 or above");
				} else if (input[5].matches(".*\\D.*")) {
					System.out.println("Accept number only");
				} else {
					System.out.println("length must be in 10 character");
				}
			}

			// input gender
			while (true) {
				System.out.println("male,female or others");
				input[6] = scan.nextLine().toLowerCase();
				if (input[6].equals("male") || input[6].equals("female") || input[6].equals("others")) {
					break;
				}
				System.out.println("invalid input");
			}

			// store the all the values in customer object
			Customers cus = new Customers(input[0], input[1], input[2], input[3], input[4], Long.parseLong(input[5]),
					input[6]);
			cusDao.insert(cus);
			break;

		// Login validation
		case 2:
			cusDao = new CustomerDao();
			String username = "";
			String password = "";

			// user name input
			while (true) {
				System.out.println("enter the username");
				username = scan.nextLine();
				if (username.matches("[a-zA-Z0-9]{8,20}")) {
					break;
				} else if (username.length() <= 7) {
					System.out.println("username must be minimum 8 character or more");
				} else {
					System.out.println("special character username");
				}
			}

			// password input
			while (true) {
				System.out.println("enter the password");
				password = scan.nextLine();
				if (password.matches("[a-zA-Z0-9!@#$%^&*()_+]{8,20}")) {
					break;
				}
				System.out.println("invalid password");
			}

			// store the values for execution
			Customers cusvalidate = new Customers(username, password);

			// validate user name password
			String valdata = cusDao.cusValidation(cusvalidate);

			// check whether its user or admin

			if (valdata != null) {
				String name = valdata.substring(1);
				// customer login
				if (valdata.charAt(0) == '1') {
					System.out.println("welcome user: " + name);
					Customers customer = new Customers();
					customer = cusDao.customerDetails(username);
					System.out.println(customer);
					CustomerMain customermain=new CustomerMain();
					customermain.customer(customer);
				}
				
				// admin user login
				else {
					System.out.println("welcome Admin: " + username);
					
					AdminDao adminDao=new AdminDao();
					Admin admin = adminDao.show(username);
					System.out.println(admin);
					AdminMain adminmain=new AdminMain();
					adminmain.adminMain(admin);
				}
			} else {
				System.out.println("invalid user name or password");
			}
			break;

		// update of bank,address and pin code
		case 3:
			System.out.println("enter the bank account number");
			long bankAccount = Long.parseLong(scan.nextLine());
			System.out.println("enter the address");
			String address = scan.nextLine();
			System.out.println("enter the city");
			String city = scan.nextLine();
			System.out.println("enter the pincode");
			int pincode = Integer.parseInt(scan.nextLine());
			System.out.println("enter the customer_id");
			int cusid = Integer.parseInt(scan.nextLine());
			Customers cusupdate = new Customers(cusid, bankAccount, address, city, pincode);
			CustomerDao cusdaoup = new CustomerDao();
			cusdaoup.update(cusupdate);
			break;

		// Show all user
		case 4:
			System.out.println("show the all customers");
			List<Customers> customerList = new ArrayList<Customers>();
			cusDao = new CustomerDao();
			customerList = cusDao.showAll();
			for (Customers i : customerList) {
				System.out.println(i);
			}
			break;

		// delete user
		case 5:
			cusDao = new CustomerDao();
			System.out.println("Enter customer id need to delete");
			int cusiddelet = Integer.parseInt(scan.nextLine());
			cusDao.delete(cusiddelet);
			break;

		}

	}

}
