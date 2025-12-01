package courseProject;

public class CheckingAccount extends Account{
	
	// Instance Variables
	public String valid_Date;
	public String tranType;
	public Double amount;
	
	// Super Class Instantiation
	public CheckingAccount(String acct_NUM, String acct_TYPE, Double serv_FEE, 
		                   Double int_RATE, Double ovDraft_FEE, Double acct_BAL) {
		
		// Super Account
		super(acct_NUM, acct_TYPE, serv_FEE, int_RATE, ovDraft_FEE, acct_BAL);
		
	}
	
	
	@Override
	public void withdrawal() {
		
	}
	
	@Override
	public void deposit() {
		
	}
	
	@Override
	public void balance() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
