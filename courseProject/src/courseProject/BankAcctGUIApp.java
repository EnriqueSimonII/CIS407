package courseProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ButtonGroup;
import javax.swing.SwingUtilities;
import courseProject.BankAcctGUI;

public class BankAcctGUIApp {
	
	// Elements & Variable
	public static ArrayList<Account> accounts_List = new ArrayList<>();
	public static ArrayList<Customer> customers_List = new ArrayList<>();
	
	@SuppressWarnings("static-access")
	public static void addCustomer(BankAcctGUI gui) {
		
		// Get Fields
        String custID = gui.custID_Input.getText().trim();
        String custSSN = gui.custSSN_Input.getText().trim();
        String custLast = gui.custLast_Input.getText().trim();
        String custFirst = gui.custFirst_Input.getText().trim();
        String custStreet = gui.custStreet_input.getText().trim();
        String custCity = gui.custCity_Input.getText().trim();
        String custState = (String) gui.custState_Input.getSelectedItem();
        String custZip = gui.custZip_Input.getText().trim();
        String custPhone = gui.custPhone_Input.getText().trim();

        // Create Customer
        Customer cust = new Customer(custID, custSSN, custLast, custFirst,
                                     custStreet, custCity, custState, custZip, custPhone);
        
        // Add Customer
        if (validateCustomer(cust, gui)) {
        	
        	// Save Valid Customer
        	customers_List.add(cust);
            gui.monitor.append("Customer added: " + custFirst + " " + custLast + "\n");
            System.out.print("Customer added: " + custFirst + " " + custLast + "\n");
            clearCustomerFields(gui);
        }
    }
	
	@SuppressWarnings("static-access")
	public static void addAccount(BankAcctGUI gui) {
		
		// Bad Defaults
		String acctNum = "------";
        String acctType = "";
        Double servFee = 999.00;
        Double intRate = 999.00;
        Double ovDraftFee = 999.00;
        Double bal = 0.00;
        String custFK = "";

		try {
			// Get Fields
	        acctNum = gui.acctNum_Input.getText().trim();
	        acctType = gui.group.getSelection().getActionCommand();
	        servFee = Double.parseDouble(gui.acctFee_Input.getText().trim());
	        intRate = Double.parseDouble(gui.acctRate_Input.getText().trim());
	        ovDraftFee = Double.parseDouble(gui.acctDraftF_Input.getText().trim());
	        bal = Double.parseDouble(gui.acctBal_Input.getText().trim());
	        custFK = gui.acctCustFK_Input.getText().trim();
	        
		} catch (Exception ex) {
			System.out.print("Error with Fields (using bad defaults to trigger validation method)\n");
		}

		// Create Account
        Account acct;
        if ("CHK".equals(acctType)) {
            acct = new CheckingAccount(acctNum, acctType, servFee, intRate, ovDraftFee, bal, custFK);
        } else {
            acct = new SavingsAccount(acctNum, acctType, servFee, intRate, ovDraftFee, bal, custFK);
        }
		
        // Add Account
        if (validateAccount(acct, gui)) {
        	
        	// Save Valid Customer
        	accounts_List.add(acct);
            gui.monitor.append("Account added: " + acctNum + "\n");
            System.out.print("Account added: " + acctNum + "\n");
            clearAccountFields(gui);
        }
    }
	
	@SuppressWarnings("static-access")
	public static void addTransaction(BankAcctGUI gui) {

		// Elements & Storage
		String errors_Found = "ERRORS:\n";
		Boolean validated = true;
		Boolean acctFound = false;
		Account transAccount = null;
		
		// Bad Defaults
		String transAcct = "------";
		Double transAmount = 999.00;
		String transType = "SELECT";
		
		
		try {
			// Get Fields
			transAmount = Double.parseDouble(gui.transAmt_Input.getText().trim());
			transAcct = gui.transSelect_Input.getText().trim();
			transType = (String) gui.transType_Input.getSelectedItem();
			
		} catch (Exception ex) {
			System.out.print("Error with Fields (using bad defaults to trigger validation method)\n");
			
		}
		
		// Validate Data: TRANS ACCOUNT EXISTS
		for (Account acctSearch : accounts_List) {
			if (acctSearch.acctNumber.equals(transAcct)) {
				transAccount = acctSearch;
				acctFound = true;
				
			} else {
				errors_Found += String.format("ACCOUNT NUM -------: No Match for account (" + transAcct + ")\n");
			}
		}
		
		// Validate Data: TRANS ACCOUNT NUMBER
		if (!DataEntry.checkStringLength(transAcct, 1, 5)) {
			errors_Found += "ACCOUNT NUM -------: Max 5 Characters\n";
			errors_Found += "TRANS AMMOUNT -----: Only Decimal\n";
			validated = false;
		}
		
		/// Validate Data: TRANS TYPE
		if (!DataEntry.checkStringOptions(Arrays.asList("DEPOSIT", "WITHDRAW", "ACCRUE INTEREST"), transType)) {
			errors_Found += "ACCOUNT TYPE ------: Only DEPOSIT, WITHDRAW, ACCRUE INTEREST\n";
			validated = false;
		}
			
		// Add Valid Transactions
		if (validated && acctFound) {
			
			// Deposit
			if (transType.equals("DEPOSIT")) {
				transAccount.deposit(transAmount);
				gui.monitor.setText("SUCCESS:\n" + transAccount);
				clearTransFields(gui);
				
			// Withdraw
			} else if (transType.equals("WITHDRAW")) {
				
				// Valid Savings
				if (transAccount.acctType.equals("SAV") && transAccount.balance(transAmount)) {
					transAccount.withdrawal(transAmount);
					gui.monitor.setText("SUCCESS:\n" + transAccount);
					clearTransFields(gui);
					
				// Invalid Savings
				} else if (transAccount.acctType.equals("SAV") && !transAccount.balance(transAmount)) {
					errors_Found += "ACCOUNT BALANCE ---: Insufficient Fund Available Balance: $" + transAccount.acctBal + "\n";
					validated = false;

				// Checking
				} else {
					transAccount.withdrawal(transAmount);
					gui.monitor.setText("SUCCESS:\n" + transAccount);
					clearTransFields(gui);
				}
				
			// Accrue Interest
			} else if (transType.equals("ACCRUE INTEREST")) {
				transAccount.accrueInterest();
				gui.monitor.setText("SUCCESS:\n" + transAccount);
				clearTransFields(gui);
			}
		}
		
		// Display Errors
		if (validated == false) {
			gui.monitor.setText(errors_Found);
			System.out.print(errors_Found);
		}
	}
	
	@SuppressWarnings("static-access")
	public static boolean validateCustomer(Customer cust, BankAcctGUI gui) {
		
		// Elements & Storage
		String errors_Found = "ERRORS:\n";
		Boolean validated = true;
		
		// Validate Data: CUSTOMER ID
		if (DataEntry.checkStringLength(cust.customerID, 1, 5) == false) {
			errors_Found += "CUSTOMER ID -------: Max 5 Characters\n";
			validated = false;
		}
		
		// Validate Data: CUSTOMER SSN
		if (!DataEntry.checkStringLength(cust.customerSSN, 9, 9) || !DataEntry.checkStringNumbers(cust.customerSSN)) {
			errors_Found += "CUSTOMEER SSN -----: Only 9 Characters\n";
			validated = false;
		}
		
		// Validate Data: CUSTOMER LAST
		if (!DataEntry.checkStringLength(cust.customerLast, 1, 20)) {
			errors_Found += "CUSTOMER LAST -----: Max 20 Characters\n";
			validated = false;
		}
		
		// Validate Data: CUSTOMER FIRST
		if (!DataEntry.checkStringLength(cust.customerFirst, 1, 15)) {
			errors_Found += "CUSTOMER FIRST ----: Max 15 Characters\n";
			validated = false;
		}
		
		// Validate Data: CUSTOMER STREET
		if (!DataEntry.checkStringLength(cust.customerStreet, 1, 20)) {
			errors_Found += "CUSTOMER STREET ---: Max 20 Characters\n";
			validated = false;
		}
		
		// Validate Data: CUSTOMER CITY
		if (!DataEntry.checkStringLength(cust.customerCity, 1, 20)) {
			errors_Found += "CUSTOMER CITY -----: Max 20 Characters\n";
			validated = false;
		}
		
		// Validate Data: CUSTOMER STATE
		if (!DataEntry.checkStringLength(cust.customerState, 2, 2)) {
			errors_Found += "CUSTOMER STATE ----: Only 2 Characters\n";
			validated = false;
		}
		
		// Validate Data: CUSTOMER ZIP
		if (!DataEntry.checkStringLength(cust.customerZip, 5, 5) || !DataEntry.checkStringNumbers(cust.customerZip)) {
			errors_Found += "CUSTOMER ZIP ------: Only 5 Characters\n";
			validated = false;
		}
		
		// Validate Data: CUSTOMER PHONE
		if (!DataEntry.checkStringLength(cust.customerPhone, 10, 10) || !DataEntry.checkStringNumbers(cust.customerPhone)) {
			errors_Found += "CUSTOMER PHONE ----: Only 10 Characters\n";
			validated = false;
		}
		
		// Display Errors
		if (validated == false) {
			gui.monitor.setText(errors_Found);
		}
		
		// Return Approval Boolean
		return validated;
	}
	
	@SuppressWarnings("static-access")
	public static boolean validateAccount(Account acct, BankAcctGUI gui) {
		
		// Elements & Storage
		String errors_Found = "ERRORS:\n";
		Boolean validated = true;
		
		// Validate Data: ACCOUNT NUMBER
		if (!DataEntry.checkStringLength(acct.acctNumber, 1, 5)) {
			errors_Found += "ACCOUNT NUM -------: Max 5 Characters\n";
			validated = false;
		}
		
		// Validate Data: ACCOUNT TYPE
		if (!DataEntry.checkStringOptions(Arrays.asList("CHK", "SAV"), acct.acctType)) {
			errors_Found += "ACCOUNT TYPE ------: Only CHK or SAV\n";
			validated = false;
		}
		
		// Validate Data: SERVICE FEE
		if (!DataEntry.checkDoubleRange(acct.serviceFee, 0.00, 10.00)) {
			errors_Found += "ACCOUNT FEE -------: Decimal 0 thru 10\n";
			validated = false;
		}
		
		// Validate Data: INTEREST RATE
		if (!DataEntry.checkDoubleRange(acct.intRate, 0.00, 10.00)) {
			errors_Found += "ACCOUNT RATE ------: Decimal 0 thru 10\n";
			validated = false;
		}
		
		// Validate Data: OVERDRAFT FEE
		if (!DataEntry.checkDouble(acct.ovDraftFee)) {
			errors_Found += "ACCOUNT OVD FEE ---: Only Decimal\n";
			validated = false;
		}
		
		// Validate Data: ACCOUNT BALANCE
		if (!DataEntry.checkDouble(acct.acctBal)) {
			errors_Found += "ACCOUNT BALANCE ---: Only Decimal\n";
			validated = false;
		}
		
		// Validate Data: CUSTOMER ID
		if (DataEntry.checkStringLength(acct.acctCustomerID, 1, 5) == false) {
			errors_Found += "ACCOUNT CUST FK ---: Max 5 Characters\n";
			validated = false;
		}
		
		// Display Errors
		if (validated == false) {
			gui.monitor.setText(errors_Found);
		}
		
				
		// Return Approval Boolean
		return validated;
	}
	
	@SuppressWarnings("static-access")
	public static void clearCustomerFields(BankAcctGUI gui) {
       
		// Clear All Fields
		gui.custID_Input.setText("");
        gui.custSSN_Input.setText("");
        gui.custLast_Input.setText("");
        gui.custFirst_Input.setText("");
        gui.custStreet_input.setText("");
        gui.custCity_Input.setText("");
        gui.custState_Input.setSelectedIndex(0);;
        gui.custZip_Input.setText("");
        gui.custPhone_Input.setText("");  
    }

	@SuppressWarnings("static-access")
	public static void clearAccountFields(BankAcctGUI gui) {
    	
    	// Clear All Fields
        gui.acctNum_Input.setText("");
        gui.acctType_Input.setSelectedIndex(0);
        gui.acctFee_Input.setText("");
        gui.acctRate_Input.setText("");
        gui.acctDraftF_Input.setText("");
        gui.acctBal_Input.setText("");
        gui.acctCustFK_Input.setText("");
        gui.check_Input.setSelected(false);
        gui.saving_Input.setSelected(false);
    }
	
	@SuppressWarnings("static-access")
	public static void clearTransFields(BankAcctGUI gui) {
		
		// Clear All Fields
		gui.transSelect_Input.setText("");
		gui.transAmt_Input.setText("");
		gui.transType_Input.setSelectedIndex(0);
	}

	@SuppressWarnings("static-access")
    public static void viewCustomers(BankAcctGUI gui) {
        
    	// Elements & Storage
    	String displayText = ""; 
        
    	// Print out Customer
    	for (Customer cust: customers_List) {
    		displayText += ("CUSTOMER ID --------: " + cust.customerID + 
				           "\nCUSTOMER SSN -------: " + cust.customerSSN +
				           "\nCUSTOMER LAST ------: " + cust.customerLast +
				           "\nCUSTOMER FIRST -----: " + cust.customerFirst +
				           "\nCUSTOMER STREET ----: " + cust.customerStreet +
				           "\nCUSTOMER CITY ------: " + cust.customerCity +
				           "\nCUSTOMER STATE -----: " + cust.customerState +
				           "\nCUSTOMER ZIP -------: " + cust.customerZip +
				           "\nCUSTOMER PHONE -----: " + cust.customerPhone +
				           "\n---------------------------------------------\n\n");
    	}
    	
    	// Display Monitor
    	gui.monitor.setText(displayText);
    	System.out.print(displayText);
    	
    }
    
	@SuppressWarnings("static-access")
    public static void viewAccounts(BankAcctGUI gui) {
    	
		// Elements & Storage
    	String displayText = ""; 
    	
    	// Print out Accounts
    	for (Account acct : accounts_List) {
    		displayText += ("ACCOUNT NUMBER -----: " + acct.acctNumber + 
				            "\nACCOUNT TYPE -------: " + acct.acctType +
				            "\nSERVICE FEES -------: " + acct.serviceFee +
				            "\nINTEREST RATE ------: " + acct.intRate +
				            "\nOVER DRAFT FEE -----: " + acct.ovDraftFee +
				            "\nACCOUNT BALANCE ----: " + acct.acctBal +
				            "\nCUSTOMER ID --------: " + acct.acctCustomerID +
    				        "\n---------------------------------------------\n\n");
    	}
    	
    	// Display Monitor
    	gui.monitor.setText(displayText);
    	System.out.print(displayText);
    	
    }
    
    public static void viewAll(BankAcctGUI gui) {
    	
    	// Elements & Storage
    	Integer cnt_Acct = 0;
    	String displayText = ""; 
    	String matchCustomer = "No Customer";
    	
    	// Match Customer to Account
    	for (Account acct : accounts_List) {
    		for (Customer cust : customers_List) {
    			if (acct.acctCustomerID.equals(cust.customerID)) {
    				matchCustomer = cust.customerFirst + " " + cust.customerLast; 
    			}
    		}
    		
    		// Display all unique accounts
			displayText += ("\n" + (cnt_Acct + 1) + ") NAME ---: " + matchCustomer +
					                                " | ACCT# --: " + acct.acctNumber +
					                                " | TYPE ---: " + acct.acctType + 
					                                " | BAL ----: " + acct.acctBal);
			
			// Display Monitor
			gui.monitor.setText(displayText);
			System.out.print(displayText);
    	}
    }
    
	public static void main(String[] args) {
		
		// GUI Interface
		SwingUtilities.invokeLater(() -> {
			
			// Instantiate the GUI
			BankAcctGUI appGUI = new BankAcctGUI();
			
			class ButtonHandler implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent event) {
                    String cmd = event.getActionCommand();

                    if ("ADD CUSTOMER".equals(cmd)) {
                        addCustomer(appGUI);
                        
                    } else if ("ADD ACCOUNT".equals(cmd)) {
                        addAccount(appGUI);
                        
                    } else if ("VIEW CUSTOMERS".equals(cmd)) {
                        viewCustomers(appGUI);
                        
                    } else if ("VIEW ACCOUNTS".equals(cmd)) {
                    	 viewAccounts(appGUI);
                    	 
                    } else if ("VIEW ALL".equals(cmd)) {
                    	 viewAll(appGUI);
                    	 
                    } else if ("ADD TRANSACTIONS".equals(cmd)) {
                    	addTransaction(appGUI);
                    }
                }
            }

            ButtonHandler handler = new ButtonHandler();
            appGUI.addCust.addActionListener(handler);
            appGUI.addAcct.addActionListener(handler);
            appGUI.addtrans.addActionListener(handler);
            appGUI.viewCust.addActionListener(handler);
            appGUI.viewAccts.addActionListener(handler);
            appGUI.viewAll.addActionListener(handler);
            appGUI.reload.addActionListener(handler);
        });
	}
}
