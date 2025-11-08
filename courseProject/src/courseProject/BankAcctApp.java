package courseProject;
import courseProject.Customer;
import courseProject.DataEntry;
import java.util.Scanner;

public class BankAcctApp {
	
	// Elements & Variables
	public static Scanner scanner = new Scanner(System.in);

	// Main App
	public static void main(String[] args) {
		
		// Elements & Variable
		String entryPermission;
		
		// header & Welcome
		System.out.print("-----------------------------------------------------------\n" + 
		                 "|||||||||||||||| WELCOM TO THE BANKING APP ||||||||||||||||\n" + 
				         "-----------------------------------------------------------\n\n");
		System.out.print("Please follow instructions to Entry Customer Data\n");
		
		// Confirm Entry to System
		while (true) {
			System.out.print("Would you like to entry the bank system? (y/n): ");
			String enterSystem = scanner.nextLine();
			
			if (enterSystem.toLowerCase().equals("y") || enterSystem.toLowerCase().equals("n")) {
				entryPermission = enterSystem.toLowerCase();
				break;
			} else {
				System.out.print("ERROR -------: Incorrect input try again !!\n\n");
			}
		}
		
		// Banking System Customer Entry
		if (entryPermission.equals("y")) {
			
			// Collect Data: CUSTOMER ID
			System.out.print("\n-----------------------------------------------------------\n" + 
                             "CUSTOMER ID (max 5 char) ---------: ");
			String cust_ID = scanner.nextLine().trim();
			
			// Validate Data: CUSTOMER ID
			while (!DataEntry.checkStringLength(cust_ID, 1, 5)) {
				System.out.print("ERROR --------------: INCORRENT FORMAT\n\n");
				System.out.print("CUSTOMER ID (max 5 char) ---------: ");
				cust_ID = scanner.nextLine().trim();
			}
			
			// Collect Data: CUSTOMER SSN
			System.out.print("CUSTOMER SSN (9 char only) -------: ");
			String cust_SSN = scanner.nextLine();

			// Validate Data: CUSTOMER SSN
			while (!DataEntry.checkStringLength(cust_SSN, 9, 9) || !DataEntry.checkStringNumbers(cust_SSN)) {
				System.out.print("ERROR --------------: INCORRENT FORMAT\n\n");
				System.out.print("CUSTOMER SSN (9 char only) -------: ");
				cust_SSN = scanner.nextLine();
			}
			
			// Collect Data: CUSTOMER LAST
			System.out.print("CUSTOMER LAST (max 20 char) ------: ");
			String cust_LAST = scanner.nextLine().trim();
			
			// Validate Data: CUSTOMER LAST
			while (!DataEntry.checkStringLength(cust_LAST, 1, 20)) {
				System.out.print("ERROR --------------: INCORRENT FORMAT\n\n");
				System.out.print("CUSTOMER LAST (max 20 char) ------: ");
				cust_LAST = scanner.nextLine().trim();
			}
			
			// Collect Data: CUSTOMER FIRST
			System.out.print("CUSTOMER FIRST (max 15 char) -----: ");
			String cust_FIRST = scanner.nextLine().trim();
			
			// Validate Data: CUSTOMER FIRST
			while (!DataEntry.checkStringLength(cust_FIRST, 1, 15)) {
				System.out.print("ERROR --------------: INCORRENT FORMAT\n\n");
				System.out.print("CUSTOMER FIRST (max 15 char) -----: ");
				cust_FIRST = scanner.nextLine().trim();
			}
			
			// Collect Data: CUSTOMER STREET
			System.out.print("CUSTOMER STREET (max 20 char) ----: ");
			String cust_STREET = scanner.nextLine().trim();
			
			// Validate Data: CUSTOMER STREET
			while (!DataEntry.checkStringLength(cust_STREET, 1, 20)) {
				System.out.print("ERROR --------------: INCORRENT FORMAT\n\n");
				System.out.print("CUSTOMER STREET (max 20 char) ----: ");
				cust_STREET = scanner.nextLine().trim();
			}
			
			// Collect Data: CUSTOMER CITY
			System.out.print("CUSTOMER CITY (max 20 char) ------: ");
			String cust_CITY = scanner.nextLine().trim();
			
			// Validate Data: CUSTOMER CITY
			while (!DataEntry.checkStringLength(cust_CITY, 1, 20)) {
				System.out.print("ERROR --------------: INCORRENT FORMAT\n\n");
				System.out.print("CUSTOMER CITY (max 20 char) ------: ");
				cust_CITY = scanner.nextLine().trim();
			}
			
			// Collect Data: CUSTOMER STATE
			System.out.print("CUSTOMER STATE (2 char only) -----: ");
			String cust_STATE = scanner.nextLine().trim();
			
			// Validate Data: CUSTOMER STATE
			while (!DataEntry.checkStringLength(cust_STATE, 2, 2)) {
				System.out.print("ERROR --------------: INCORRENT FORMAT\n\n");
				System.out.print("CUSTOMER STATE (2 char only) -----: ");
				cust_STATE = scanner.nextLine().trim();
			}
			
			// Collect Data: CUSTOMER ZIP
			System.out.print("CUSTOMER ZIP (5 char only) -------: ");
			String cust_ZIP = scanner.nextLine().trim();
			
			// Validate Data: CUSTOMER ZIP
			while (!DataEntry.checkStringLength(cust_ZIP, 5, 5) || !DataEntry.checkStringNumbers(cust_ZIP)) {
				System.out.print("ERROR --------------: INCORRENT FORMAT\n\n");
				System.out.print("CUSTOMER ZIP (5 char only) -------: ");
				cust_ZIP = scanner.nextLine().trim();
			}
			
			// Collect Data: CUSTOMER PHONE
			System.out.print("CUSTOMER PHONE (10 char only) ----: ");
			String cust_PHONE = scanner.nextLine().trim();
			
			// Validate Data: CUSTOMER PHONE
			while (!DataEntry.checkStringLength(cust_PHONE, 10, 10) || !DataEntry.checkStringNumbers(cust_PHONE)) {
				System.out.print("ERROR --------------: INCORRENT FORMAT\n\n");
				System.out.print("CUSTOMER PHONE (10 char only) ----: ");
				cust_PHONE = scanner.nextLine().trim();
			}
			
			// Close Scanner
			scanner.close();
			
			// Customer: instantiate
			Customer cust1 = new Customer(cust_ID, cust_SSN, cust_LAST, 
					                      cust_FIRST, cust_STREET, cust_CITY, 
					                      cust_STATE, cust_ZIP, cust_PHONE);
			
			// Display Customer Data
			System.out.print("-----------------------------------------------------------\n\nCONFIRMATION\n\n" + cust1);
			
			
		} else {
			System.out.print("-----------------------------------------------------------\n" + 
		                     "Entry Denied\nBYE!!");
		}
		
	}

}
