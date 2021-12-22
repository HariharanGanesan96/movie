package com.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.dao.CartItemsDao;
import com.dao.OrderItemsDao;
import com.dao.OrdersDao;
import com.dao.PetDao;
import com.model.CartItems;
import com.model.Customers;
import com.model.OrderItems;
import com.model.Orders;
import com.model.PetDetails;

public class PetMain {

	public void petDetils(Customers customer) throws ClassNotFoundException, SQLException, ParseException {
		
		// scanner used for get input from user
		Scanner scan = new Scanner(System.in);
		// pet dao created for access the methods from that class
		PetDao petDao = new PetDao();
		// for information purpose 
		System.out.println("select you option");
		System.out.println(
				"1.Register new pet\n2.update my pet detilas\n3.order\n5.myorders\n4.add to cart item\n6.show cart item\n7.delete cartitem");
		int PetOperation = Integer.parseInt(scan.nextLine());

		switch (PetOperation) {
		
		// animal register
		case 1:
		
			// pet type
			String petType;
			while (true) {
				System.out.println("enter the pet type");
				petType = scan.nextLine();
				if (petType.matches("[a-zA-Z]{3,20}")) {
					break;
				}
				if (petType.length() <= 2) {
					System.out.println("Must have minimum 3 character");
				} else if (petType.matches(".*\\W.*") || petType.matches(".*\\d.*")) {
					System.out.println("Alphabet only");
				}
			}

			// pet name
			String petName;
			while (true) {
				System.out.println("enter the pet name");
				petName = scan.nextLine();
				if (petName.matches("[a-zA-Z ]{3,20}")) {
					break;
				}
				if (petName.length() <= 2) {
					System.out.println("Must have minimum 3 character");
				} else if (petName.matches(".*\\W.*") || petName.matches(".*\\d.*")) {
					System.out.println("Alphabet only");
				}

			}

			// pet gender
			String petGender;
			while (true) {
				System.out.println("male or female");
				petGender = scan.nextLine().toLowerCase();
				if (petGender.equals("male") || petGender.equals("female")) {
					break;
				}
				System.out.println("invalid input");
			}

			// pet Dob
			String petDob;
			SimpleDateFormat dateFormet = new SimpleDateFormat("dd-mm-yyyy");
			System.out.println("enter the Pet dob dd-mm-yyyy");
			petDob = scan.nextLine();
			Date date = dateFormet.parse(petDob);

			// input Description
			String Description;
			while (true) {
				System.out.println("enter the Description");
				Description = scan.nextLine();
				if (Description.length() <= 30) {
					System.out.println("minmum 30 character");
				}

				// color
				String petColor;
				while (true) {

					System.out.println("enter the color");
					petColor = scan.nextLine();
					if (petColor.matches("[a-zA-z]+")) {
						break;
					} else {
						System.out.println("invalid color name");
					}
				}

				// pet Qty
				String petQty;
				System.out.println("enter the quantity");
				petQty = scan.nextLine();
			
				// pet price
				String petPrice;
				System.out.println("enter the pet price");
				petPrice = scan.nextLine();

				// pet Image
				String petImage;
				System.out.println("enter link address of image");
				petImage = scan.nextLine();

				// create object for insert values
				PetDetails pet = new PetDetails(petType, petName, petGender, date, Integer.parseInt(petQty),
						Description, petColor, Double.parseDouble(petPrice), petImage, customer.getCustomerId(),
						Integer.parseInt(petQty));

				petDao.insert(pet);

				break;
			}
		
		// to my pet details and update
		case 2:
			// list created for to display the values
			List<PetDetails> petList = new ArrayList<PetDetails>();
			petList = petDao.showMypetdetails(customer.getCustomerId());
			
			// To print my pet Details
			for (PetDetails i : petList) {
				System.out.println(i);
			}
			
			// used to store the values
			PetDetails pet = new PetDetails();
			
			// asking id for updating 
			
			System.out.println("enter pet id value need to update");
			int update = Integer.parseInt(scan.nextLine());
			pet.setCustomerId(update);
			
			// asking which value need to update
			
			System.out.println("enter the update operation");
			System.out.println("1.Update pettype\n" + "2.update PetName\n" + "3.update petGender\n" + "4.update Dob\n"
					+ "5.update qty\n" + "6.update price\n" + "7.update description\n" + "8.update color\n"
					+ "9.update image\n10.delete");

			int updateOperation = Integer.parseInt(scan.nextLine());

			switch (updateOperation) {

			// update pet type
			case 1:
				while (true) {
					System.out.println("enter the pet type");
					petType = scan.nextLine();
					if (petType.matches("[a-zA-Z]{3,20}")) {
						break;
					}
					if (petType.length() <= 2) {
						System.out.println("Must have minimum 3 character");
					} else if (petType.matches(".*\\W.*") || petType.matches(".*\\d.*")) {
						System.out.println("Alphabet only");
					}
				}
				pet.setPetType(petType);
				petDao.updatePetType(pet);
				break;
			// update petName
			case 2:
				while (true) {
					System.out.println("enter the pet Name");
					petName = scan.nextLine();
					if (petName.matches("[a-zA-Z]{3,20}")) {
						break;
					}
					if (petName.length() <= 2) {
						System.out.println("Must have minimum 3 character");
					} else if (petName.matches(".*\\W.*") || petName.matches(".*\\d.*")) {
						System.out.println("Alphabet only");
					}
				}
				pet.setPetName(petName);
				petDao.updatePetName(pet);
				break;
			// update Pet Gender
			case 3:
				while (true) {
					System.out.println("enter the pet type");
					petGender = scan.nextLine();
					if (petGender.matches("[a-zA-Z]{3,20}")) {
						break;
					}
					if (petGender.length() <= 2) {
						System.out.println("Must have minimum 3 character");
					} else if (petGender.matches(".*\\W.*") || petGender.matches(".*\\d.*")) {
						System.out.println("Alphabet only");
					}
				}
				pet.setPetGender(petGender);
				petDao.updatePetGender(pet);
				break;
			// update pet DOB
			case 4:

				dateFormet = new SimpleDateFormat("dd-mm-yyyy");
				System.out.println("enter the Pet dob dd-mm-yyyy");
				petDob = scan.nextLine();
				date = dateFormet.parse(petDob);
				pet.setPetDob(date);
				petDao.updatePetDob(pet);

				break;
			
			// pet qty
			case 5:
				System.out.println("enter the quantity");
				int petQty = Integer.parseInt(scan.nextLine());
				pet.setPetQty(petQty);
				petDao.updatePetQty(pet);
				break;
            
			// pet price
			case 6:
				System.out.println("enter the pet price");
				double petPrice = Double.parseDouble(scan.nextLine());
				pet.setPetprice(petPrice);
				petDao.updatePetPrice(pet);
				break;
			
			// update description
			case 7:
				while (true) {
					System.out.println("enter the Description");
					Description = scan.nextLine();
					if (Description.length() <= 30) {
						System.out.println("minmum 30 character");
					} else {
						break;
					}

				}
				pet.setDescription(Description);
				petDao.updatePetDescription(pet);
				break;
			
			// update color
			case 8:
				String petColor;
				while (true) {
					System.out.println("enter the color");
					petColor = scan.nextLine();
					if (petColor.matches("[a-zA-z]+")) {
						break;
					} else {
						System.out.println("invalid color name");
					}
				}
				pet.setPetColor(petColor);
				petDao.updatePetColor(pet);
				break;

			// update Image
			case 9:
				System.out.println("enter link address of image");
				String petImage = scan.nextLine();
				pet.setPetImage(petImage);
				petDao.updatePetPrice(pet);
				break;

			// delete pet
			case 10:
				System.out.println("enter pet id need to delete");
				petDao.delete(pet);
			}
		break;
		
		// to order items
		case 3:
			
			// to show all the pets except own user
			petList = new ArrayList<PetDetails>();
			petList = petDao.showAllpets();
			for (PetDetails i : petList) {
				System.out.println(i);
			}
			
			// order and orderitems dao object created for to acess methods
			OrdersDao ordersDao = new OrdersDao();
			OrderItemsDao orderItemsDao = new OrderItemsDao();
			
			// list is used to store temporary orderitems data
			List<OrderItems> itemlist = new ArrayList<OrderItems>();
			String choice = null;
			
			// Asking for add items
			double sum = 0;
			do {
				System.out.println("enter pet id need to order");
				int petId = Integer.parseInt(scan.nextLine());
				PetDetails petdetails = petDao.showPet(petId);
				System.out.println("enter the quantity");
				int qty = Integer.parseInt(scan.nextLine());
				
				// checking for qty matching
				if (petdetails.getAvilableQty() < qty) {
					System.out.println("invalid quantity");	
				} 
				// if quantity matched its do update operation
				else {
					petdetails.setAvilableQty((petdetails.getAvilableQty()) - qty);
					petDao.updatePetAviQty(petdetails);
					
				// store the values in list
					OrderItems ordersItem = new OrderItems(petId, qty, petdetails.getPetprice(),
							(qty * petdetails.getPetprice()));
					itemlist.add(ordersItem);
					sum += qty * petdetails.getPetprice();
				}
				System.out.println("do you want Continue yes/no");
				choice = scan.nextLine();
			} while (choice.equals("yes"));
            
			// insert the values in order items
			Orders order = new Orders(customer.getCustomerId(), sum);
			ordersDao.insert(order);
			
			//insert the value in orderitems
			int orderId = ordersDao.orderId();
			for (OrderItems i : itemlist) {
				i.setOrderId(orderId);
				orderItemsDao.insert(i);
			}
			break;
		
		// to add item into carts
		case 4:
		
		// to show all values
			petList = new ArrayList<PetDetails>();
			petList = petDao.showAllpets();
			for (PetDetails i : petList) {
				System.out.println(i);
			}
			
			// cartitems dao created for to access metods
			CartItemsDao cartItemsDao = new CartItemsDao();
			choice = null;
			
			
			double totalPrice = 0;
			do {
				System.out.println("enter pet id to add cart");
				int petId = Integer.parseInt(scan.nextLine());
				PetDetails petdetails = petDao.showPet(petId);
				System.out.println("enter the quantity");
				int qty = Integer.parseInt(scan.nextLine());
				
				
				if (petdetails.getAvilableQty() < qty) {
					System.out.println("invalid quantity");
				} 
				
				else {
					petdetails.setAvilableQty((petdetails.getAvilableQty()) - qty);
					petDao.updatePetAviQty(petdetails);
					CartItems cartItem = new CartItems(petId, customer.getCustomerId(), qty, petdetails.getPetprice(),
							(qty * petdetails.getPetprice()));

					totalPrice += qty * petdetails.getPetprice();
					cartItemsDao.insert(cartItem);
				}
				System.out.println("do you want Continue yes/no");
				choice = scan.nextLine();
			} while (choice.equals("yes"));

			break;
		// show my order items
		case 5:
			List<OrderItems> orderList = new ArrayList<OrderItems>();
			orderItemsDao = new OrderItemsDao();
			orderList = orderItemsDao.showMyOrders(customer);
			for (OrderItems o : orderList) {
				System.out.println(o);
			}
			break;
		// show my cart items
		case 6:
			List<CartItems> cartList = new ArrayList<CartItems>();
			cartItemsDao = new CartItemsDao();
			cartList = cartItemsDao.show(customer);
			for (CartItems c : cartList) {
				System.out.println(c);
			}
			System.out.println("do you want delete item yes/no");
			String deleteChoice = scan.nextLine().toLowerCase();
			while (deleteChoice.equals("yes")) {
				System.out.println("enter the item id for delete");
				int itemId = Integer.parseInt(scan.nextLine());
				cartItemsDao.delete(itemId);
				System.out.println("do you want delete item yes/no");
				deleteChoice = scan.nextLine().toLowerCase();
			}

			break;

		}

	}

}
