package courseProject;

public class SavingsAccount extends Account {
	
	// Instance Variables
	public String valid_Date;
	public String tranType;
	public Double amount;
	
	// Super Class Instantiation
	public SavingsAccount(String acct_NUM, String acct_TYPE, Double serv_FEE, 
		                   Double int_RATE, Double ovDraft_FEE, Double acct_BAL, 
		                   String acctCust_ID) {
		
		// Super Account
		super(acct_NUM, acct_TYPE, serv_FEE, int_RATE, ovDraft_FEE, acct_BAL, acctCust_ID);
		
	}
	
	
	@Override
	public void withdrawal(Double inputAmount) {
		
		// Withdraw & Charge Fees
		acctBal -= (inputAmount + serviceFee);
	}
	
	@Override
	public void deposit(Double inputAmount) {
		
		// Deposit & Charge Fees
		acctBal += (inputAmount - serviceFee);
	}
	
	@Override
	public void accrueInterest() {
		
		// Credit Interest to Balance
		if (acctBal > 0) {
			acctBal = (acctBal * (1 + intRate));
		}
	}
	
	@Override
	public boolean balance(Double inputAmount) {
		
		// Check Funds Sufficient
		if ((acctBal - (inputAmount + serviceFee)) > 0) {
			return true;
		} else {
			return false;
		}
	}

		
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
