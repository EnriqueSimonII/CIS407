package courseProject;

abstract class Account {
	
	// Instance Variables
	protected String acctNumber;
	protected String acctType;
	protected Double serviceFee;
	protected Double intRate;
	protected Double ovDraftFee;
	protected Double acctBal;
	protected String acctCustomerID;
	
	// Customer Creation
	public Account(String acct_NUM, String acct_TYPE, Double serv_FEE, 
			       Double int_RATE, Double ovDraft_FEE, Double acct_BAL, 
			       String acctCust_ID) {
		
		// Initialize variables
		acctNumber = acct_NUM;
		acctType = acct_TYPE;
		serviceFee = serv_FEE;
		intRate = int_RATE;
		ovDraftFee = ovDraft_FEE;
		acctBal = acct_BAL;
		acctCustomerID = acctCust_ID;
		
	}
	
	// Abstract Methods
	public abstract void withdrawal(double inputAmount);
	public abstract void deposit(double inputAmount);
	public abstract void accrueInterest();
	public abstract boolean balance(double inputAmount);

	// Return ALL Data
	public String toString() {
		return "ACCOUNT NUMBER -----: " + acctNumber + 
				"\nACCOUNT TYPE -------: " + acctType +
				"\nSERVICE FEES -------: " + serviceFee +
				"\nINTEREST RATE ------: " + intRate +
				"\nOVER DRAFT FEE -----: " + ovDraftFee +
				"\nACCOUNT BALANCE ----: " + acctBal +
				"\nCUSTOMER ID --------: " + acctCustomerID;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
