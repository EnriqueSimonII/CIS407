package courseProject;
import courseProject.Customer;
import courseProject.DataEntry;

import java.util.Arrays;
import java.util.Scanner;

public class BankAcctApp {
	
	// Elements & Variables
	public static Scanner scanner = new Scanner(System.in);

	// Main App
	public static void main(String[] args) {
		
		// Elements & Variable
		String entryPermission;
		String cust_ID;
		String cust_SSN;
		String cust_LAST;
		String cust_FIRST;
		String cust_STREET;
		String cust_CITY;
		String cust_STATE;
		String cust_ZIP;
		String cust_PHONE;
		String acct_NUM;
		String acct_TYPE;
		Double serv_FEE;
		Double int_RATE;
		Double ovDraft_FEE;
		Double acct_BAL = 0.00;

		
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
			
			// Header & Banner
			System.out.print("\n-----------------------------------------------------------\n");
			
			// CUSTOMER ID
			while (true) {
				try {
			
					// Collect Data: CUSTOMER ID
					System.out.print("CUSTOMER ID (max 5 char) ---------: ");
					cust_ID = scanner.nextLine().trim();
					
					// Validate Data: CUSTOMER ID
					if (DataEntry.checkStringLength(cust_ID, 1, 5) == false) {
						throw new IllegalArgumentException("ERROR --------------: INCORRENT FORMAT\n\n");
					} else {
						break;
					}
					
				} catch (IllegalArgumentException ex) {
					System.out.print(ex.getMessage());
				} catch (Exception ex) {
					System.out.print("ERROR --------------: INCORRENT FORMAT --> " + ex + "\n\n");
				}
			}
			
			// CUSTOMER SSN
			while (true) {
				try {
					
					// Collect Data: CUSTOMER SSN
					System.out.print("CUSTOMER SSN (9 char only) -------: ");
					cust_SSN = scanner.nextLine().trim();
					
					// Validate Data: CUSTOMER SSN
					if (!DataEntry.checkStringLength(cust_SSN, 9, 9) || !DataEntry.checkStringNumbers(cust_SSN)) {
						throw new IllegalArgumentException("ERROR --------------: INCORRENT FORMAT\n\n");
					} else {
						break;
					}
					
				} catch (IllegalArgumentException ex) {
					System.out.print(ex.getMessage());
				} catch (Exception ex) {
					System.out.print("ERROR --------------: INCORRENT FORMAT --> " + ex + "\n\n");
				}
			}
			
			// CUSTOMER LAST
			while (true) {			
				try {
					
					// Collect Data: CUSTOMER LAST
					System.out.print("CUSTOMER LAST (max 20 char) ------: ");
					cust_LAST = scanner.nextLine().trim();
					
					// Validate Data: CUSTOMER LAST
					if (!DataEntry.checkStringLength(cust_LAST, 1, 20)) {
						throw new IllegalArgumentException("ERROR --------------: INCORRENT FORMAT\n\n");
					} else {
						break;
					}
					
				} catch (IllegalArgumentException ex) {
					System.out.print(ex.getMessage());
				} catch (Exception ex) {
					System.out.print("ERROR --------------: INCORRENT FORMAT --> " + ex + "\n\n");
				}
			}
			
			// CUSTOMER FIRST
			while (true) {
				try {
					
					// Collect Data: CUSTOMER FIRST
					System.out.print("CUSTOMER FIRST (max 15 char) -----: ");
					cust_FIRST = scanner.nextLine().trim();
					
					// Validate Data: CUSTOMER FIRST
					if (!DataEntry.checkStringLength(cust_FIRST, 1, 15)) {
						throw new IllegalArgumentException("ERROR --------------: INCORRENT FORMAT\n\n");
					} else {
						break;
					}
					
				} catch (IllegalArgumentException ex) {
					System.out.print(ex.getMessage());
				} catch (Exception ex) {
					System.out.print("ERROR --------------: INCORRENT FORMAT --> " + ex + "\n\n");
				}
			}
			
			// CUSTOMER STREET
			while (true) {
				try {
					
					// Collect Data: CUSTOMER STREET
					System.out.print("CUSTOMER STREET (max 20 char) ----: ");
					cust_STREET = scanner.nextLine().trim();
					
					// Validate Data: CUSTOMER STREET
					if (!DataEntry.checkStringLength(cust_STREET, 1, 20)) {
						throw new IllegalArgumentException("ERROR --------------: INCORRENT FORMAT\n\n");
					} else {
						break;
					}
					
				} catch (IllegalArgumentException ex) {
					System.out.print(ex.getMessage());
				} catch (Exception ex) {
					System.out.print("ERROR --------------: INCORRENT FORMAT --> " + ex + "\n\n");
				}
			}
			
			// CUSTOMER CITY
			while (true) {
				try {
					
					// Collect Data: CUSTOMER CITY
					System.out.print("CUSTOMER CITY (max 20 char) ------: ");
					cust_CITY = scanner.nextLine().trim();
					
					// Validate Data: CUSTOMER CITY
					if (!DataEntry.checkStringLength(cust_CITY, 1, 20)) {
						throw new IllegalArgumentException("ERROR --------------: INCORRENT FORMAT\n\n");
					} else {
						break;
					}
					
				} catch (IllegalArgumentException ex) {
					System.out.print(ex.getMessage());
				} catch (Exception ex) {
					System.out.print("ERROR --------------: INCORRENT FORMAT --> " + ex + "\n\n");
				}
			}
			
			// CUSTOMER STATE
			while (true) {
				try {
					
					// Collect Data: CUSTOMER STATE
					System.out.print("CUSTOMER STATE (2 char only) -----: ");
					cust_STATE = scanner.nextLine().trim();
					
					// Validate Data: CUSTOMER STATE
					if (!DataEntry.checkStringLength(cust_STATE, 2, 2)) {
						throw new IllegalArgumentException("ERROR --------------: INCORRENT FORMAT\n\n");
					} else {
						break;
					}
					
				} catch (IllegalArgumentException ex) {
					System.out.print(ex.getMessage());
				} catch (Exception ex) {
					System.out.print("ERROR --------------: INCORRENT FORMAT --> " + ex + "\n\n");
				}
			}
			
			// CUSTOMER ZIP
			while (true) {
				try {
					
					// Collect Data: CUSTOMER ZIP
					System.out.print("CUSTOMER ZIP (5 char only) -------: ");
					cust_ZIP = scanner.nextLine().trim();
					
					// Validate Data: CUSTOMER ZIP
					if (!DataEntry.checkStringLength(cust_ZIP, 5, 5) || !DataEntry.checkStringNumbers(cust_ZIP)) {
						throw new IllegalArgumentException("ERROR --------------: INCORRENT FORMAT\n\n");
					} else {
						break;
					}
					
				} catch (IllegalArgumentException ex) {
					System.out.print(ex.getMessage());
				} catch (Exception ex) {
					System.out.print("ERROR --------------: INCORRENT FORMAT --> " + ex + "\n\n");
				}
			}
			
			// CUSTOMER PHONE
			while (true) {
				try {
					
					// Collect Data: CUSTOMER PHONE
					System.out.print("CUSTOMER PHONE (10 char only) ----: ");
					cust_PHONE = scanner.nextLine().trim();
					
					// Validate Data: CUSTOMER PHONE
					if (!DataEntry.checkStringLength(cust_PHONE, 10, 10) || !DataEntry.checkStringNumbers(cust_PHONE)) {
						throw new IllegalArgumentException("ERROR --------------: INCORRENT FORMAT\n\n");
					} else {
						break;
					}
					
				} catch (IllegalArgumentException ex) {
					System.out.print(ex.getMessage());
				} catch (Exception ex) {
					System.out.print("ERROR --------------: INCORRENT FORMAT --> " + ex + "\n\n");
				}
			}
			
			// 	ACCOUNT NUMBER
			while (true) {
				try {
					
					// Collect Data: ACCOUNT NUMBER
					System.out.print("ACCOUNT NUMBER (5 char max) ------: ");
					acct_NUM = scanner.nextLine().trim();
					
					// Validate Data: ACCOUNT NUMBER
					if (!DataEntry.checkStringLength(acct_NUM, 1, 5)) {
						throw new IllegalArgumentException("ERROR --------------: INCORRENT FORMAT\n\n");
					} else {
						break;
					}
					
				} catch (IllegalArgumentException ex) {
					System.out.print(ex.getMessage());
				} catch (Exception ex) {
					System.out.print("ERROR --------------: INCORRENT FORMAT --> " + ex + "\n\n");
				}
			}
			
			// 	ACCOUNT TYPE
			while (true) {
				try {
					
					// Collect Data: ACCOUNT TYPE
					System.out.print("ACCOUNT TYPE (CHK or SAV) --------: ");
					acct_TYPE = scanner.nextLine().trim();
					
					// Validate Data: ACCOUNT TYPE
					if (!DataEntry.checkStringOptions(Arrays.asList("CHK", "SAV"), acct_TYPE)) {
						throw new IllegalArgumentException("ERROR --------------: INCORRENT FORMAT\n\n");
					} else {
						break;
					}
					
				} catch (IllegalArgumentException ex) {
					System.out.print(ex.getMessage());
				} catch (Exception ex) {
					System.out.print("ERROR --------------: INCORRENT FORMAT --> " + ex + "\n\n");
				}
			}
			
			// 	SERVICE FEE
			while (true) {
				try {
					
					// Collect Data: SERVICE FEE
					System.out.print("SERVICE FEE (0 thru 10) ----------: ");
					serv_FEE = scanner.nextDouble();
					
					// Validate Data: SERVICE FEE
					if (!DataEntry.checkDoubleRange(serv_FEE, 0.00, 10.00)) {
						throw new IllegalArgumentException("ERROR --------------: INCORRENT FORMAT\n\n");
					} else {
						break;
					}
					
				} catch (IllegalArgumentException ex) {
					System.out.print(ex.getMessage());
				} catch (Exception ex) {
					System.out.print("ERROR --------------: INCORRENT FORMAT --> " + ex + "\n\n");
					scanner.nextLine();
				}
			}
			
			// 	INTEREST RATE
			while (true) {
				try {
					
					// Collect Data: INTEREST RATE
					System.out.print("INTEREST RATE (0 thru 10) --------: ");
					int_RATE = scanner.nextDouble();
					
					// Validate Data: INTEREST RATE
					if (!DataEntry.checkDoubleRange(int_RATE, 0.00, 10.00)) {
						throw new IllegalArgumentException("ERROR --------------: INCORRENT FORMAT\n\n");
					} else {
						break;
					}
					
				} catch (IllegalArgumentException ex) {
					System.out.print(ex.getMessage());
				} catch (Exception ex) {
					System.out.print("ERROR --------------: INCORRENT FORMAT --> " + ex + "\n\n");
					scanner.nextLine();
				}
			}
			
			// 	OVERDRAFT FEE
			while (true) {
				try {
					
					// Collect Data: OVERDRAFT FEE
					System.out.print("OVERDRAFT FEE (Decimal value) ----: ");
					ovDraft_FEE = scanner.nextDouble();
					
					// Validate Data: OVERDRAFT FEE
					if (!DataEntry.checkDouble(ovDraft_FEE)) {
						throw new IllegalArgumentException("ERROR --------------: INCORRENT FORMAT\n\n");
					} else {
						break;
					}
					
				} catch (IllegalArgumentException ex) {
					System.out.print(ex.getMessage());
				} catch (Exception ex) {
					System.out.print("ERROR --------------: INCORRENT FORMAT --> " + ex + "\n\n");
					scanner.nextLine();
				}
			}
			
			// 	ACCOUNT BALANCE
			while (true) {
				try {
					
					// Collect Data: ACCOUNT BALANCE
					System.out.print("ACCOUNT BALANCE (Decimal value) --: ");
					acct_BAL = scanner.nextDouble();
					
					// Validate Data: ACCOUNT BALANCE
					if (!DataEntry.checkDouble(acct_BAL)) {
						throw new IllegalArgumentException("ERROR --------------: INCORRENT FORMAT\n\n");
					} else {
						break;
					}
					
				} catch (IllegalArgumentException ex) {
					System.out.print(ex.getMessage());
				} catch (Exception ex) {
					System.out.print("ERROR --------------: INCORRENT FORMAT --> " + ex + "\n\n");
					scanner.nextLine();
				}
			}
			
			// Close Scanner
			scanner.close();
			
			// Customer: instantiate
			Customer cust1 = new Customer(cust_ID, cust_SSN, cust_LAST, 
					                      cust_FIRST, cust_STREET, cust_CITY, 
					                      cust_STATE, cust_ZIP, cust_PHONE);
			
			// Account: instantiate
			Account acct1 = new Account(acct_NUM, acct_TYPE, serv_FEE,
					                    int_RATE, ovDraft_FEE, acct_BAL);
			
			// Display Customer Data
			System.out.print("-----------------------------------------------------------" + 
			                 "\n\nCUSTOMER CONFIRMATION\n\n" + cust1 + 
					         "\n\nACCOUNT CONFIRMATION\n\n" + acct1);
			
			
		} else {
			System.out.print("-----------------------------------------------------------\n" + 
		                     "Entry Denied\nBYE!!");
		}
		
	}

}
