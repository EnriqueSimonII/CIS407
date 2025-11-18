package courseProject;

public class Account {
	
	// Instance Variables
	private String acctNumber;
	private String acctType;
	private Double serviceFee;
	private Double intRate;
	private Double ovDraftFee;
	private Double acctBal;
	
	// Customer Creation
	public Account(String acct_NUM, String acct_TYPE, Double serv_FEE, 
			       Double int_RATE, Double ovDraft_FEE, Double acct_BAL) {
		
		// Initialize variables
		acctNumber = acct_NUM;
		acctType = acct_TYPE;
		serviceFee = serv_FEE;
		intRate = int_RATE;
		ovDraftFee = ovDraft_FEE;
		acctBal = acct_BAL;
		
	}

	// Return ALL Data
	public String toString() {
		return "ACCOUNT NUMBER -----: " + acctNumber + 
				"\nACCOUNT TYPE -------: " + acctType +
				"\nSERVICE FEES -------: " + serviceFee +
				"\nINTEREST RATE ------: " + intRate +
				"\nOVER DRAFT FEE -----: " + ovDraftFee +
				"\nACCOUNT BALANCE ----: " + acctBal;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
