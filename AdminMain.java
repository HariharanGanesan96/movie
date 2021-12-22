package com.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.PetDao;
import com.model.Admin;
import com.model.Customers;
import com.model.PetDetails;

public class AdminMain {
	
	public void adminMain(Admin admin) throws ClassNotFoundException, SQLException {
		Scanner scan=new Scanner(System.in);
		System.out.println("1.list of all user\n2.List of all request\n");
		int adminOperation=Integer.parseInt(scan.nextLine());
		CustomerDao cusDao=new CustomerDao();
		switch(adminOperation) {
		
		// list of all user
		case 1:
			List<Customers> cusList=new ArrayList<Customers>();
			cusList=cusDao.showAll();
			for(Customers i:cusList) {
				System.out.println(i);
			}
			
			System.out.println("Do you want delete customer yes/No");
			String choice=scan.nextLine().toLowerCase();
			if(choice.equals("yes")) {
				System.out.println("Enter the customer id need to delete");
				int cusid=Integer.parseInt(scan.nextLine());
				cusDao.delete(cusid);	
			}
			else {
				System.out.println("Choice other operation");
			}
			System.out.println("Do you want delete user yes/no");
			String deleteChoice=scan.nextLine().toLowerCase();
			if(deleteChoice.equals("yes")) {
				System.out.println("Enter the youser id to delete");
				
			}
	
			
			break;
			
			
		case 2:
			// 
			PetDao animalDao=new PetDao();
			List<PetDetails>animalList=new ArrayList<PetDetails>();
			animalList=animalDao.showAllNotapproved();
			for(PetDetails i:animalList) {
				System.out.println(i);
			}
			System.out.println("update status");
			char c;
			do {
			System.out.println("enter the Pet id");
			int petId=Integer.parseInt(scan.nextLine());
			System.out.println("enter the status");
			System.out.println("1.approved\n2.decline");
			String status=scan.nextLine();
			animalDao.updateStatus(petId, status,admin.getAdminId());
			System.out.println("do you want continue y/n");
			c=scan.nextLine().toLowerCase().charAt(0);
			}while(c=='y');	
		}
	}

}
