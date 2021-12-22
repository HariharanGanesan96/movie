package com.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.PetDao;
import com.model.Customers;

public class CustomerMain {

	public void customer(Customers customer) throws ClassNotFoundException, SQLException, ParseException {

		// customer dao created for to access the methods
		CustomerDao cusDao = new CustomerDao();
		// scanner used for to get values
		Scanner scan = new Scanner(System.in);
		
		// information purpose
		System.out.println("1.Update Firstname\n" + "2.update Lastname\n" + "3.update username\n" + "4.update password\n"
					     + "5.update email\n" + "6.update mobilenumber\n" + "7.update bank\n" + "8.update address\n"
						 + "9.update pincode\n" + "10.update city\n" + "11.update image\n" + "12.Update bank and address"+"13.product realted option");
		
		int userOperation = Integer.parseInt(scan.nextLine());
		switch (userOperation) {

		// update first name
		case 1:
			String firstName;
			while (true) {
				System.out.println("enter the first name");
				firstName = scan.nextLine();
				if (firstName.matches("[a-zA-Z]{3,20}")) {
					break;
				}
				if (firstName.length() <= 2) {
					System.out.println("first name must have minimum 3 character");
				} else if (firstName.matches(".*\\W.*") || firstName.matches(".*\\d.*")) {
					System.out.println("name contains alphabet only");
				}
			}
			cusDao.updateFirstName(customer.getCustomerId(), firstName);
			break;
		// update last name
		case 2:
			String lastName;
			while (true) {
				System.out.println("enter the last name");
				lastName = scan.nextLine();
				if (lastName.matches("[a-zA-Z]{3,20}")) {
					break;
				}
				if (lastName.length() <= 2) {
					System.out.println("last name must have minimum 3 character");
				} else if (lastName.matches(".*\\W.*") || lastName.matches(".*\\d.*")) {
					System.out.println("name contains alphabet only");
				}
			}
			cusDao.updateLastName(customer.getCustomerId(), lastName);
			break;

		// update user name
		case 3:
			String userName;
			while (true) {
				System.out.println("enter the user name");
				userName = scan.nextLine();
				if (cusDao.ValidatUsername(userName)) {
					System.out.println("user name not available");
				} else if (userName.matches("[a-zA-Z0-9]{8,20}")) {
					break;
				} else if (userName.length() <= 7) {
					System.out.println("username must be minimum 8 character or more");
				} else {
					System.out.println("Don't use special for username");
				}
			}
			cusDao.updateUserName(customer.getCustomerId(), userName);
			break;
		
		// update password
		case 4:
			String passWord;
			while (true) {
				System.out.println("enter the password");
				passWord = scan.nextLine();
				if (passWord.matches("[a-zA-Z0-9!@#$%^&*()_+]{8,20}")) {
					break;
				}
				System.out.println("password nust be in 8 charcter or more");
			}
			cusDao.updatePassword(customer.getCustomerId(), passWord);
			break;

		// update email
		case 5:
			String email;
			while (true) {
				System.out.println("enter the email");
				email = scan.nextLine().toLowerCase();
				if (cusDao.ValidateEmail(email)) {
					System.out.println("email not available ");
				} else if (email.matches("[a-z][a-z0-9.]*@[a-z0-9]+[.][a-z]{2,4}$")) {
					break;
				} else {
					System.out.println("email should contains @ and .");
				}
			}
			cusDao.updateEmail(customer.getCustomerId(), email);
			break;

		// update mobile number
		case 6:
			String mobileNumber;
			while (true) {

				System.out.println("enter the mobile number");
				mobileNumber = scan.nextLine();
				if (mobileNumber.matches("[6-9][0-9]{9}")) {
					break;
				} else if (mobileNumber.matches("[0-5]")) {
					System.out.println("mobile number must be start with 6 or above");
				} else if (mobileNumber.matches(".*\\D.*")) {
					System.out.println("Accept number only");
				} else {
					System.out.println("length must be in 10 character");
				}

			}
			cusDao.updateNumber(customer.getCustomerId(), Long.parseLong(mobileNumber));
			break;
		
		// update bank
		case 7:
			String bank;
			while (true) {

				System.out.println("enter the bank number");
				bank = scan.nextLine();
				if (bank.matches("[0-9]{8,15}")) {
					break;
				} else if (bank.matches(".*\\D.*")) {
					System.out.println("Accept number only");
				} else {
					System.out.println("length must be in 8 character");
				}

			}
			cusDao.updateBank(customer.getCustomerId(), Long.parseLong(bank));
			break;
		
		// update address
		case 8:
			String address;
			while (true) {
				System.out.println("enter the Address");
				address = scan.nextLine();
				if (address.matches("[a-zA-Z0-9,-/]{3,50}")) {
					break;
				}
			}
			cusDao.updateAddress(customer.getCustomerId(), address);
			break;
		
		// update pincode
		case 9:
			String pincode;
			while (true) {
				System.out.println("enter the pincode");
				pincode = scan.nextLine();
				if (pincode.matches("[0-9]{6}")) {
					break;
				} else {
					System.out.println("pincode atlest 6 digits");
				}
			}
			cusDao.updatePincode(customer.getCustomerId(), Integer.parseInt(pincode));
			break;
		
		// update city
		case 10:
			String city;
			while (true) {
				System.out.println("enter the city");
				city = scan.nextLine();
				if (city.matches("[a-zA-Z]{3,20}")) {
					break;
				}
				if (city.length() <= 2) {
					System.out.println("city must have minimum 3 character");
				} else if (city.matches(".*\\W.*") || city.matches(".*\\d.*")) {
					System.out.println("city name contains alphabet only");
				}
			}
			cusDao.updateCity(customer.getCustomerId(), city);
			break;

		// update image
		case 11:
			String image;
			System.out.println("enter the city");
			image = scan.nextLine();
			cusDao.updateImage(customer.getCustomerId(), image);
			break;
			
		// to update bank and address and pin code 	
		case 12:
			System.out.println("enter the bank account number");
			long bankAccount = Long.parseLong(scan.nextLine());
			System.out.println("enter the address");
			 address = scan.nextLine();
			System.out.println("enter the city");
			 city = scan.nextLine();
			System.out.println("enter the pincode");
			int pincode1 = Integer.parseInt(scan.nextLine());
			System.out.println("enter the customer_id");
			int cusid = Integer.parseInt(scan.nextLine());
			Customers cusupdate = new Customers(cusid, bankAccount, address, city, pincode1);
			CustomerDao cusdaoup = new CustomerDao();
			cusdaoup.update(cusupdate);
			break;


	  // to perform pet related operation
		case 13:
			PetMain petmain = new PetMain();
			petmain.petDetils(customer);
			break;
		}

	}
}