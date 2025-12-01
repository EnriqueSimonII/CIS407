package courseProject;

public class Customer {
	
	// Instance Variables
	protected String customerID;
	protected String customerSSN;
	protected String customerLast;
	protected String customerFirst;
	protected String customerStreet;
	protected String customerCity;
	protected String customerState;
	protected String customerZip;
	protected String customerPhone;
	
	// Customer Creation
	public Customer(String cust_ID, String cust_SSN, String cust_LAST, 
			        String cust_FIRST, String cust_STREET, String cust_CITY, 
			        String cust_STATE, String cust_ZIP, String cust_PHONE) {
		
		// Initialize variables
		customerID = cust_ID;
		customerSSN = cust_SSN;
		customerLast = cust_LAST;
		customerFirst = cust_FIRST;
		customerStreet = cust_STREET;
		customerCity = cust_CITY;
		customerState = cust_STATE;
		customerZip = cust_ZIP;
		customerPhone = cust_PHONE;
		
	}

	// Return ALL Data
	public String toString() {
		return "CUSTOMER ID --------: " + customerID + 
				"\nCUSTOMER SSN -------: " + customerSSN +
				"\nCUSTOMER LAST ------: " + customerLast +
				"\nCUSTOMER FIRST -----: " + customerFirst +
				"\nCUSTOMER STREET ----: " + customerStreet +
				"\nCUSTOMER CITY ------: " + customerCity +
				"\nCUSTOMER STATE -----: " + customerState +
				"\nCUSTOMER ZIP -------: " + customerZip +
				"\nCUSTOMER PHONE -----: " + customerPhone
				;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
