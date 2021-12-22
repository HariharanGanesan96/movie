package com.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.PetDao;
import com.model.Customers;
import com.model.PetDetails;

public class TestMain {

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
				if (valdata.charAt(0) == '1') {
					System.out.println("welcome user: " + name);
					Customers customer = new Customers();
					customer = cusDao.customerDetails(username);
					System.out.println(customer);

					System.out.println("1.Update Firstname\n" + "2.update Lastname\n" + "3.update username\n"
							+ "4.update password\n" + "5.update email\n" + "6.update mobilenumber\n"
							+ "7.update bank\n" + "8.update address\n" + "9.update pincode\n" + "10.update city\n"
							+ "11.update image"
							+ "\n 12.add pet details");
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
					// animals add new pet,update pet details,delete pet 
					case 12:
						PetDao animalDao =new PetDao();
						System.out.println("select your options");
						System.out.println("1.Register new pet\n2.update my pet detilas\n3.delete pet");
						int PetOperation=Integer.parseInt(scan.nextLine());
					
						
						
						switch(PetOperation) {
						
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
							String PetGender;
							while (true) {
								System.out.println("male or female");
								PetGender = scan.nextLine().toLowerCase();
								if (PetGender.equals("male") || PetGender.equals("female")) {
									break;
								}
								System.out.println("invalid input");
							}
							// pet Dob
							String petDob;
							SimpleDateFormat dateFormet=new SimpleDateFormat("dd-mm-yyyy");
							System.out.println("enter the Pet dob dd-mm-yyyy");
							petDob=scan.nextLine();
							Date date=dateFormet.parse(petDob);
//							
//							Date today=new Date();
//                            Date currentDate=dateFormet.parse(dateFormet.format(today));
//                            System.out.println(currentDate);
//                            while(true) {
//                            System.out.println("enter the Pet dob");
//                            
//                            int i=petDob.compareTo(currentDate);
//                            if(i==0 || i<=0) {
//                            	break;                     	
//                            }
//                            else {
//                            	System.out.println("invalid date");
//                            }
//                            }
                            
							// input Description
                            String Description;
                           		while (true) {
								System.out.println("enter the Description");
								Description = scan.nextLine();
                 					if(Description.length() <= 30) {
									System.out.println("minmum 30 character");
								}
                           									
							//color
                 				String petColor;							
								while(true) {
								
								System.out.println("enter the color");
								petColor=scan.nextLine();
								if(petColor.matches("[a-zA-z]+")) {
									break;
								}
								else {
									System.out.println("invalid color name");
								}
							}
							
							// pet Qty
							String petQty;
						
								System.out.println("enter the quantity");
								petQty=scan.nextLine();
							//pet price
								
							String petPrice;
							System.out.println("enter the pet price");
							petPrice=scan.nextLine();
								
							//pet Image
							String petImage;
							System.out.println("enter link address of image");
							petImage=scan.nextLine();
							
							
							PetDetails pet=new PetDetails(petType,petName,PetGender,date,
									Integer.parseInt(petQty),Description,petColor,Double.parseDouble(petPrice),
									petImage,customer.getCustomerId(),Integer.parseInt(petQty));
							
							animalDao.insert(pet);
                           		
                            break;
                           		}
                            case 2:
                            	List<PetDetails> petList= new ArrayList<PetDetails>();
                            	petList=animalDao.showMypetdetails(customer.getCustomerId());
                            	for (PetDetails i : petList) {
                    				System.out.println(i);
                    			}
                            	
                            	System.out.println("enter the update operation");
                            	System.out.println("1.Update pettype\n" + "2.update PetName\n" + "3.update petGender\n"
            							+ "4.update Dob\n" + "5.update qty\n" + "6.update price\n"
            							+ "7.update description\n" + "8.update color\n" + "9.update image\n");
                            	int updateOperation=Integer.parseInt(scan.nextLine());
                            	switch(updateOperation) {
                            	case 1:
                            		
                            		break;
                            	case 3:
                            		break;
                            	case 4:
                            		break;
                            	case 5:
                            		break;
                            		
                            	case 6:
                            		break;
                            	case 7:
                            		break;
                            	case 8:
                            		break;
                            	case 9:
                            		break;
                            	
                            	}                            	
                            	break;
                            case 3:
                            	break;
                            	
                            
						}
						
					
						}
					}
				
				// admin user login
				else {
					System.out.println("welcome Admin: " + name);
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
