package courseProject;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAcctApp {
	
	// Elements & Variables
	public static Scanner scanner = new Scanner(System.in);

	// Main Application
	public static void main(String[] args) {
		
		// Elements & Variable
		String entryPermission;
		String summaryPermission;
		Integer menuOption;
		String matchCustomer = "No Customer";
		Integer accountSelection;
		Account activeAccount;
		Integer accountAction;
		Double transAmount;
		Boolean transApproved = false;
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
		String acctCust_ID;
		ArrayList<Account> accounts_List = new ArrayList<>();
		ArrayList<Customer> customers_List = new ArrayList<>();

		
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
		
		// Banking System Data Entry
		while (true) {
			if (entryPermission.equals("y")) {
				
				// Header & Banner
				System.out.print("\n-----------------------------------------------------------\nPLEASE CHOOSE AN OPTION:\n");
				System.out.print("1) CREATE CUSTOMER\n2) CREATE ACCOUNT\n3) TRANSACTIONS\n");
				
				// Menu Selection
				while (true) {
					try {
						
						// Collect Data: Menu Option
						System.out.print("\nSELECTION: ");
						menuOption = scanner.nextInt();
						
						if (DataEntry.checkIntegerRange(menuOption, 1, 3) == false) {
							throw new IllegalArgumentException("error try again\n");
						} else {
							System.out.print("\n");
							break;
						}
					} catch (IllegalArgumentException ex) {
						System.out.print(ex.getMessage());
					} catch (Exception ex) {
						System.out.print("error try again " + ex.getMessage() + "\n");
						scanner.nextLine();
					}
				}
			
				// MENU OPTION: Create Customer
				if (menuOption == 1) {
					
					// Clear Buffer
					scanner.nextLine();
					
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
					
					// Customer: instantiate
					Customer cust_OBJ = new Customer(cust_ID, cust_SSN, cust_LAST, 
							                         cust_FIRST, cust_STREET, cust_CITY, 
							                         cust_STATE, cust_ZIP, cust_PHONE);
					
					// Save to Customers
					customers_List.add(cust_OBJ);

				// MENU OPTION:  Create Account
				} else if (menuOption == 2) {
					
					// Clear Buffer
					scanner.nextLine();
					
					// ACCOUNT NUMBER
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
					
					// ACCT CUSTOMER ID
					while (true) {
						try {
							
							// Clear Buffer
							scanner.nextLine();
							
							// Collect Data: CUSTOMER ID
							System.out.print("CUSTOMER ID FK (max 5 char) ------: ");
							acctCust_ID = scanner.nextLine().trim();
							
							// Validate Data: CUSTOMER ID
							if (DataEntry.checkStringLength(acctCust_ID, 1, 5) == false) {
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
					
					// Account: instantiate
					if (acct_TYPE.equals("CHK")) {
						
						// Add: Checking Account
						Account acct_OBJ = new CheckingAccount(acct_NUM, acct_TYPE, serv_FEE,
	                                                           int_RATE, ovDraft_FEE, acct_BAL, 
	                                                           acctCust_ID);
						// Save to Accounts
						accounts_List.add(acct_OBJ);
						
					} else if (acct_TYPE.equals("SAV")) {
						
						// Add: Savings Account
						Account acct_OBJ = new SavingsAccount(acct_NUM, acct_TYPE, serv_FEE,
                                                              int_RATE, ovDraft_FEE, acct_BAL, 
                                                              acctCust_ID);
						// Save to Accounts
						accounts_List.add(acct_OBJ);
					}
					
				
				// MENU OPTION: Transactions
				} else if (menuOption == 3) {
					
					transApproved = false;
					System.out.print("SELECT ACCOUNT BELOW: ");
					
					// Build Account Selections
					for (Integer cnt_Acct = 0; cnt_Acct < accounts_List.size(); cnt_Acct++) {
						
						// Match Customer to Account
						for (Integer cnt_Cust = 0; cnt_Cust < customers_List.size(); cnt_Cust++) {
							if (accounts_List.get(cnt_Acct).acctCustomerID.equals(customers_List.get(cnt_Cust).customerID)) {
								matchCustomer = customers_List.get(cnt_Cust).customerFirst + " " + customers_List.get(cnt_Cust).customerLast;
								break;
							}
						}
						
						// Display all unique accounts
						System.out.print("\n" + (cnt_Acct + 1) + ") NAME ---: " + matchCustomer +
								                                " | ACCT# --: " + accounts_List.get(cnt_Acct).acctNumber +
								                                " | TYPE ---: " + accounts_List.get(cnt_Acct).acctType);
					}
					
					// Take Account Selection
					while (true) {
						try {
							
							// Collect Data: Menu Option
							System.out.print("\n\nSELECTION: ");
							accountSelection = scanner.nextInt();
							
							if (DataEntry.checkIntegerRange(accountSelection, 1, accounts_List.size()) == false) {
								throw new IllegalArgumentException("error try again\n");
							} else {
								System.out.print("\n");
								break;
							}
						} catch (IllegalArgumentException ex) {
							System.out.print(ex.getMessage());
						} catch (Exception ex) {
							System.out.print("error try again " + ex.getMessage() + "\n");
							scanner.nextLine();
						}
					}
					
					// Assign Active Account
					activeAccount = accounts_List.get(accountSelection - 1);
					
					// Account Menu Options
					System.out.print("\n-----------------------------------------------------------\nPLEASE CHOOSE AN OPTION:\n");
					System.out.print("1) WITHDRAW\n2) DEPOSIT\n");
					
					// Account Menu Selection
					while (true) {
						try {
							
							// Collect Data: Menu Option
							System.out.print("\nSELECTION: ");
							accountAction = scanner.nextInt();
							
							if (DataEntry.checkIntegerRange(accountAction, 1, 2) == false) {
								throw new IllegalArgumentException("error try again\n");
							} else {
								System.out.print("\n");
								break;
							}
						} catch (IllegalArgumentException ex) {
							System.out.print(ex.getMessage());
						} catch (Exception ex) {
							System.out.print("error try again " + ex.getMessage() + "\n");
							scanner.nextLine();
						}
					}
					
					// Transaction Amount
					while (true) {
						try {
							
							// Collect Data: TRANSACTION AMOUNT
							System.out.print("\nENTER TRANSACTION AMOUNT: ");
							transAmount = scanner.nextDouble();
							
							// Validate Data: SUFFICIENT FUNDS
							if (activeAccount.acctType.equals("SAV") && accountAction == 1 && activeAccount.acctBal <=0) {
								System.out.print("Insufficient Funds for withdraw\nACCT BALANCE: EMPTY\n");
								break;
								
							} else if (activeAccount.acctType.equals("SAV") && accountAction == 1 && !activeAccount.balance(transAmount)) {
								throw new IllegalArgumentException("Insufficient Funds for withdraw\nACCT BALANCE: " + activeAccount.acctBal);
								
							} else if (!DataEntry.checkDouble(transAmount)) {
								throw new IllegalArgumentException("ERROR --------------: INCORRENT FORMAT\n\n");
								
							} else {
								transApproved = true;
								break;
							}
							
						} catch (IllegalArgumentException ex) {
							System.out.print(ex.getMessage());
						} catch (Exception ex) {
							System.out.print("ERROR --------------: INCORRENT FORMAT --> " + ex + "\n\n");
							scanner.nextLine();
						}
					}
					
					// Perform Transaction
					if (accountAction == 1 && transApproved == true) {
						
						activeAccount.withdrawal(transAmount);
						activeAccount.accrueInterest();
						
					} else if (accountAction == 2 && transApproved == true) {
						activeAccount.deposit(transAmount);
						activeAccount.accrueInterest();
					}
					
					// Commit Transaction
					accounts_List.set(accountSelection - 1, activeAccount);
					
					// Clear Buffer
					scanner.nextLine();
				}
				
				// Confirm Print Summary
				while (true) {
					
					System.out.print("\nWould you like a summary? (y/n): ");
					String printSummary = scanner.nextLine();
					
					if (printSummary.toLowerCase().equals("y") || printSummary.toLowerCase().equals("n")) {
						summaryPermission = printSummary.toLowerCase();
						break;
					} else {
						System.out.print("ERROR -------: Incorrect input try again !!\n\n");
					}
				}
				
				if (summaryPermission.equals("y")) {
					// Display Customer Data
					if (customers_List.size() > 0) {
						
						for (Integer cnt = 0; cnt < customers_List.size(); cnt++) {
							System.out.print("\n\n-----------------------------------------------------------" + 
					                 "\nCUSTOMER CONFIRMATION\n" + customers_List.get(cnt) + "\n\n");
						}
					}
					
					// Display Account Data
					if (accounts_List.size() > 0) {
						
						for (Integer cnt = 0; cnt < accounts_List.size(); cnt++) {
							System.out.print("\n\n-----------------------------------------------------------" + 
					                 "\nACCOUNT CONFIRMATION\n" + accounts_List.get(cnt) + "\n\n");
						}
					}
				}
				
				// Confirm Entry to System
				while (true) {
					System.out.print("Would you like to continue? (y/n): ");
					String enterSystem = scanner.nextLine();
					
					if (enterSystem.toLowerCase().equals("y") || enterSystem.toLowerCase().equals("n")) {
						entryPermission = enterSystem.toLowerCase();
						break;
					} else {
						System.out.print("ERROR -------: Incorrect input try again !!\n\n");
					}
				}
				
			} else {
				System.out.print("\n-----------------------------------------------------------\n" + 
			                     "Entry Denied\nBYE!!");
				
				// Exit Loop
				break;
			}
		}
		
		// Confirm Print Summary
		while (true) {
			System.out.print("\n\nWould you like a summary? (y/n): ");
			String printSummary = scanner.nextLine();
			
			if (printSummary.toLowerCase().equals("y") || printSummary.toLowerCase().equals("n")) {
				summaryPermission = printSummary.toLowerCase();
				break;
			} else {
				System.out.print("ERROR -------: Incorrect input try again !!\n\n");
			}
		}
		
		if (summaryPermission.equals("y")) {
			// Display Customer Data
			if (customers_List.size() > 0) {
				
				for (Integer cnt = 0; cnt < customers_List.size(); cnt++) {
					System.out.print("\n\n-----------------------------------------------------------" + 
			                 "\nCUSTOMER CONFIRMATION\n" + customers_List.get(cnt));
				}
			}
			
			// Display Account Data
			if (accounts_List.size() > 0) {
				
				for (Integer cnt = 0; cnt < accounts_List.size(); cnt++) {
					System.out.print("\n\n-----------------------------------------------------------" + 
			                 "\nACCOUNT CONFIRMATION\n" + accounts_List.get(cnt));
				}
			}
		}
		
		// Close Scanner
		scanner.close();
	}
}
