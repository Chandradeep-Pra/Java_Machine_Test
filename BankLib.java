package com.nissan.lib;

import java.util.ArrayList;
import java.util.Scanner;

import com.nissan.app.BankApp;
import com.nissan.bean.Customer;

public class BankLib {

	// Declaring collection
	static ArrayList<Customer> arrBankLists = new ArrayList<Customer>();

	// Menu Driven
	public static void manageMenu() {
		System.out.println("1.Add a customer" + "\n2.Update details" + "\n3.Delete a customer"
				+ "\n4.Display specific customer" + "\n5.Display all customers" + "\n6.Money Transfer"
				+ "\n7.Deposit Money" + "\n8.Withdraw Money" + "\n9.Exit");

		// Input from the user
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your choice : ");
		char choice = scanner.next().charAt(0);

		// Switch cases
		switch (choice) {
		case '1':

			// Go to add customer
			addCustomer();
			break;
		case '2':

			// Go to customer details
			updateCustomerDetails();
			break;
		case '3':

			// Go to delete customer
			deleteCustomer();
			break;
		case '4':
			// Go to showSpecCustom
			showSpecCustom();
			break;
		case '5':

			// Go to display customers
			displayCustomers();
			break;
		case '6':

			// Go to money transfer
			moneyTransfer();
			break;
		case '7':

			// Go to money deposit
			moneyDepo();
			break;
		case '8':

			// Go to money withdraw
			moneyWithdraw();
			break;
		case '9':

			// Exit program
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice !!!");
			manageMenu();
		}
	}

	// Method for displaying all the customer details
	private static void displayCustomers() {

		// Using for each loop to display customer infos
		for (Customer customer : arrBankLists) {
			System.out.println(customer);
		}

		// Back to Main menu after doing the operation
		manageMenu();

	}

	// Method to show specific customer details
	private static void showSpecCustom() {

		// Initializing scanner class to take inputs
		Scanner upScanner = new Scanner(System.in);
		System.out.println("Specific Customer Details");
		System.out.println("Enter Account number of the customer :");

		// Declaring variables and taking inputs
		int customerAc = upScanner.nextInt();
		int searchIndex = findCustomerByAcNo(customerAc);

		// Printing result
		System.out.println(arrBankLists.get(searchIndex));

		// Back to Main menu after doing the operation
		manageMenu();

	}

	private static void deleteCustomer() {
		// Initializing scanner
		Scanner delScan = new Scanner(System.in);
		System.out.println("** DELETING CUSTOMER **");
		System.out.println("Enter the A/c number: ");

		// Declare variables
		int delUserAc = delScan.nextInt();
		int delUserInd = findCustomerByAcNo(delUserAc);
		arrBankLists.remove(delUserInd);
		System.out.println("Customer Removed Successfullt !");

		// Back to Main menu after doing the operation
		manageMenu();

	}

	private static void updateCustomerDetails() {
		// Initializing Scanner
		Scanner upScanner = new Scanner(System.in);
		System.out.println("Updating details ");
		System.out.println("Enter Account number of the customer :");

		// Declaring variables and taking inputs
		int customerAc = upScanner.nextInt();

		// Searching index in Array List of the Customer
		int searchIndex = findCustomerByAcNo(customerAc);

		System.out.println("Choose from options below : ");
		System.out.println("1.Update Account Number\n2.Update Mobile Number\n3.Update Email");

		// Switch case and choice for user to do the required operation
		char upChoice = upScanner.next().charAt(0);
		switch (upChoice) {
		case '1':

			/*
			 * Approach for updating account number Step 1 - get method for getting record
			 * using index Step 2 - set method for setting new account number Step 3 -
			 * calling generateAccNo method again to generate a new account number
			 */
			arrBankLists.get(searchIndex).setAcNo(Customer.generateAccNo());
			System.out.println("Account number has been updated");
			System.out.println(arrBankLists.get(searchIndex));
			manageMenu();
			break;
		case '2':

			/*
			 * Approach for updating account number Step 1 - get method for getting record
			 * using index Step 2 - set method for setting new mobile number Step 3 - Asking
			 * user to Enter new mobile number and setting the new number
			 */
			System.out.println("Enter new mobile number : ");
			arrBankLists.get(searchIndex).setMobNum(upScanner.nextLine());
			System.out.println("Mobile Number has been updated");
			manageMenu();
			break;
		case '3':

			/*
			 * Approach for updating account number Step 1 - get method for getting record
			 * using index Step 2 - set method for setting new email id Step 3 - Asking user
			 * to Enter new mobile number and setting the new email id
			 */
			System.out.println("Enter new mobile email id : ");
			arrBankLists.get(searchIndex).setCustEmail(upScanner.nextLine());
			System.out.println("Email id has been updated");
			manageMenu();
			break;
		default:
			System.out.println("Invalid Option");
			manageMenu();
			break;
		}
	}

	// Method to find customer by PAN
	public static int findCustomerByAcNo(int acNo) {

		// Iterating through each record of arrBankList
		// Comparing with A/c No. of each record with passed A/c number as argument
		// If A/c number matches then returning the index
		// Else returning -1
		for (int i = 0; i < arrBankLists.size(); i++) {
			if (arrBankLists.get(i).getAcNo() == acNo) {
				return i;
			}
		}
		return -1;

	}

	private static void addCustomer() {

		// Declaring variable for if user wants to repeat task
		char userChoice = 'n';

		do {
			System.out.println("------- Customer Registration -------");

			// Creating an object
			Customer customer = new Customer();

			// Scanner class to take input from user
			Scanner scanner = new Scanner(System.in);

			// Auto generating account number
			customer.setAcNo(customer.generateAccNo());

			// Taking inputs from user and setting details to appropriate field
			// Customer Name
			System.out.println("Enter Customer Name : ");
			customer.setCustomerName(scanner.nextLine());

			// Account Type
			System.out.println("Choose Account Type :");
			customer.setAccType(scanner.nextLine());

			// PAN details
			System.out.println("Enter PAN : ");
			customer.setPan(scanner.nextLine());

			// Min Balance
			System.out.println("Enter minimun balance :");
			customer.setMinBalance(scanner.nextFloat());

			// Mobile number
			System.out.println("Enter mobile number : ");
			customer.setMobNum(scanner.next());

			// Email id
			System.out.println("Enter email id : ");
			customer.setCustEmail(scanner.next());

			// ATM pin
			customer.setAtmPin(customer.generateATMPin());

			arrBankLists.add(customer);
			System.out.println("Account has been created");

			System.out.print("Do you want to continue ? (y/n) :");
			userChoice = scanner.next().charAt(0);

		} while (userChoice == 'y' || userChoice == 'Y');

		manageMenu();


	}
	
	//Method to withdraw money
	private static void moneyWithdraw() {
		
		//Initalizing scanner class to take inputs
		Scanner wthScan = new Scanner(System.in);
		System.out.print("Enter Account Number : ");
		
		//Declaring variables
		int userInd = findCustomerByAcNo(wthScan.nextInt());
		System.out.print("Enter Amount : ");
		int wthAmt = wthScan.nextInt();
		
		/*
		 * Logic :
		 * Comparing withdrawl amount with user's available balance
		 * If Condition amount is greater than withdraw amount 
		 * Commit transaction otherwise not commit transaction
		 */
		if (wthAmt < arrBankLists.get(userInd).getBalance()) {

			// Commit Transaction
			float newAmt = arrBankLists.get(userInd).getBalance() - wthAmt;
			arrBankLists.get(userInd).setBalance(newAmt);

			System.out.println("Transaction successfull");
		} else {
			System.out.println("Insufficient funds !! \n Going back to main menu");
			manageMenu();
		}
		
		// Back to main menu after performing operation
		manageMenu();
	}

	//Method to deposit money
	private static void moneyDepo() {
		// Initializing scanner and Declaring variables
		Scanner depScan = new Scanner(System.in);
		System.out.print("Enter Account Number : ");
		
		//Declaring variables
		int userInd = findCustomerByAcNo(depScan.nextInt());
		System.out.print("Enter Amount : ");
		int depAmt = depScan.nextInt();
		
		/*
		 * Logic 
		 * Checking if users's amount to be deposited is grater that 50000
		 * if it is greater than 50000 then asking for PAN and verifying and performing operations
		 * Otherwise performing operations without asking pan
		 */
		if (depAmt > 50000) {
			System.out.print("Enter your PAN: ");
			if (arrBankLists.get(userInd).getPan().equalsIgnoreCase(depScan.nextLine())) {
				
				// Commit Transaction
				float newAmt = arrBankLists.get(userInd).getBalance() + depAmt;
				arrBankLists.get(userInd).setBalance(newAmt);

				System.out.println("Transfer successfull");
			} else {
				System.out.println("Wrong PAN !! \n Going back to main menu");
				manageMenu();
			}
		} else {
			float newAmt = arrBankLists.get(userInd).getBalance() + depAmt;
			arrBankLists.get(userInd).setBalance(newAmt);
		}
		
		//Going back to main menu
		manageMenu();

	}

	private static void moneyTransfer() {
		// Initialising Scanner and declaring variables
		Scanner sendScan = new Scanner(System.in);

		// Sender Side Details(Variables)
		System.out.println("Enter the account number from which you want to transfer: ");
		int sendAc = sendScan.nextInt();
		int sendInd = findCustomerByAcNo(sendAc);

		// Receiver details(Variables)
		int recAc = sendScan.nextInt();
		int recInd = findCustomerByAcNo(recAc);

		System.out.println("Enter Amount");
		int sendAmt = sendScan.nextInt();
		
		/*
		 * Logic
		 * Checking if amount that needs to be send is less than sender's balance or not
		 * If it is less than commit transaction 
		 * otherwise don't commint transaction
		 */
		if (sendAmt < arrBankLists.get(sendInd).getBalance()) {
			if (sendAmt > 500000) {
				System.out.print("Enter your PAN: ");
				if (arrBankLists.get(sendInd).getPan().equalsIgnoreCase(sendScan.nextLine())) {
					// Commit Transaction
					float newRecAmt = arrBankLists.get(recInd).getBalance() + sendAmt;
					float newSenAmt = arrBankLists.get(sendInd).getBalance() - sendAmt;
					
					//Setting receiver's balance after updating
					arrBankLists.get(recInd).setBalance(newRecAmt);
					
					//Setting sender's balance after updating
					arrBankLists.get(sendInd).setBalance(newSenAmt);
					System.out.println("Transfer successfull");
				} else {
					System.out.println("Wrong PAN !! \n Going back to main menu");
					manageMenu();
				}
			} else {
				float newRecAmt = arrBankLists.get(recInd).getBalance() + sendAmt;
				float newSenAmt = arrBankLists.get(sendInd).getBalance() - sendAmt;
				arrBankLists.get(recInd).setBalance(newRecAmt);
				arrBankLists.get(sendInd).setBalance(newSenAmt);
				System.out.println("Transfer successfull");
			}

		} else {
			System.out.println("Insufficient Funds !! \n Transaction could not complete");
		}
		manageMenu();
	}
}
