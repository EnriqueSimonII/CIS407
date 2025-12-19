package courseProject;
import javax.swing.*;
import java.awt.*;

public class BankAcctGUI extends JFrame  {
	
	// Customer Declare Variables
	public JTextField custID_Input;
	public static JTextField custSSN_Input;
	public static JTextField custLast_Input;
	public static JTextField custFirst_Input;
	public static JTextField custStreet_input;
	public static JTextField custCity_Input;
	public static JComboBox<String> custState_Input;
	public static JTextField custZip_Input;
	public static JTextField custPhone_Input;
	
	// Customer Labels
	public static JLabel custID_Label;
	public static JLabel custSSN_Label;
	public static JLabel custLast_Label;
	public static JLabel custFirst_Label;
	public static JLabel custStreet_Label;
	public static JLabel custCity_Label;
	public static JLabel custState_Label;
	public static JLabel custZip_Label;
	public static JLabel custPhone_Label;
	
	// Account Declare Variables
	public static JTextField acctNum_Input;
	public static JComboBox<String> acctType_Input;
	public static JTextField acctFee_Input;
	public static JTextField acctRate_Input;
	public static JTextField acctDraftF_Input;
	public static JTextField acctBal_Input;
	public static JTextField acctCustFK_Input;
	public static JRadioButton check_Input;
	public static JRadioButton saving_Input;
	public static ButtonGroup group;
	
	// Accounts Labels
	public static JLabel acctNum_Label;
	public static JLabel acctType_Label;
	public static JLabel acctFee_Label;
	public static JLabel acctRate_Label;
	public static JLabel acctDraftF_Label;
	public static JLabel acctBal_Label;
	public static JLabel acctCustFK_Label;
	public static JLabel check_Label;
	public static JLabel saving_Label;
	
	// Transactions Components
	public static JTextField transSelect_Input;
	public static JTextField transAmt_Input;
	public static JComboBox<String> transType_Input;
	
	// Transactions Labels
	public static JLabel transSelect_Label;
	public static JLabel transAmt_Label;
	public static JLabel transType_Label;
	
	// Events Declare Variables
	public static JTextArea monitor;
	public static JScrollPane scrollPane;
	public static JButton reload;
	public static JButton addCust;
	public static JButton addAcct;
	public static JButton addtrans;
	public static JButton viewCust;
	public static JButton viewAccts;
	public static JButton viewAll;
	
	// Column dimensions (bottom half)
	int colWidth = 400;
	int startX1 = 50;                       // Customer section
	int startX2 = startX1 + colWidth + 50;  // Account section
	int startX3 = startX2 + colWidth + 50;  // Transactions section
	int labelWidth = 180;
	int fieldWidth = 200;
	int rowHeight = 40;
	int startY = 550;
	
	// Helper to add label + field pair
	public static void addLabelFieldPair(Container container, JComponent field, JLabel label, 
			                             Integer x, Integer y, Integer labW, Integer rowH, Integer fieldW) {
		
	    label.setFont(new Font("Arial", Font.BOLD, 14));
	    label.setBounds(x, y, labW, rowH);
	    field.setBounds(x + labW + 10, y, fieldW, rowH);
	    container.add(label);
	    container.add(field);
	}
	
	public static void addLabelGroupPair(Container container, JComponent button1, JComponent button2, JLabel label, 
		            	                 Integer x, Integer y, Integer labW, Integer rowH, Integer fieldW) {
		
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(x, y, labW, rowH);
		button1.setBounds(x + labW + 10, y, fieldW, rowH);
		button2.setBounds(x + labW + 10, y, fieldW, rowH);
		container.add(label);
		container.add(button1);
		container.add(button2);
	}
	
	
	// GUI interface
	public BankAcctGUI() {
		
		// Interface
		JFrame systemGUI = new JFrame("systemGUI");
		systemGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		systemGUI.setTitle("systemGUI");
		systemGUI.setSize(1400, 1080);
		systemGUI.setLayout(null);
		systemGUI.setLocationRelativeTo(null);
		systemGUI.setVisible(true);
		
		// Elements & Storage
		String[] accountTypes = {"--", "CHK", "SAV"};
		String[] stateOptions = {"--", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
				                 "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
				                 "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
				                 "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
				                 "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY", "DC"};
		
		String[] transTypes = {"DEPOSIT", "WITHDRAW", "ACCRUE INTEREST"};
		
		// Customer Components
		custID_Input = new JTextField();
		custSSN_Input = new JTextField();
		custLast_Input = new JTextField();
		custFirst_Input = new JTextField();
		custStreet_input = new JTextField();
		custCity_Input = new JTextField();
		custState_Input = new JComboBox<>(stateOptions);
		custZip_Input = new JTextField();
		custPhone_Input = new JTextField();
		
		// Customer Labels
		custID_Label = new JLabel("Customer ID:");
		custSSN_Label = new JLabel("SSN:");
		custLast_Label = new JLabel("Last Name:");
		custFirst_Label = new JLabel("First Name:");
		custStreet_Label = new JLabel("Street:");
		custCity_Label = new JLabel("City:");
		custState_Label = new JLabel("State:");
		custZip_Label = new JLabel("Zip:");
		custPhone_Label = new JLabel("Phone:");
		
		// Account Components
		acctNum_Input = new JTextField();
		acctType_Input = new JComboBox<>(accountTypes);
		acctFee_Input = new JTextField();
		acctRate_Input = new JTextField();
		acctDraftF_Input = new JTextField();
		acctBal_Input = new JTextField();
		acctCustFK_Input = new JTextField();
		check_Input = new JRadioButton("CHK");
		saving_Input = new JRadioButton("SAV");
		
		// Account Labels
		acctNum_Label = new JLabel("Account Number:");
		acctType_Label = new JLabel("Account Type:");
		acctFee_Label = new JLabel("Account Fee:");
		acctRate_Label = new JLabel("Interest Rate:");
		acctDraftF_Label = new JLabel("Draft Fee:");
		acctBal_Label = new JLabel("Balance:");
		acctCustFK_Label = new JLabel("Customer FK:");
		check_Label = new JLabel("Checking");
		saving_Label = new JLabel("Savings");
		
		 // Group Radio Buttons
        group = new ButtonGroup();
        group.add(check_Input);
        group.add(saving_Input);
		
		// Transactions Components
		transAmt_Input = new JTextField();
		transType_Input = new JComboBox<>(transTypes);
		transSelect_Input = new JTextField();
		
		// Transaction Labels
		transSelect_Label = new JLabel("Select Account:");
		transAmt_Label = new JLabel("Amount:");
		transType_Label = new JLabel("Type:");
		
		
		// Event Components
		monitor = new JTextArea(20, 80);
		scrollPane = new JScrollPane(monitor);
		reload = new JButton("RELOAD");
		addCust = new JButton("ADD CUSTOMER");
		addAcct = new JButton("ADD ACCOUNT");
		addtrans = new JButton("ADD TRANSACTIONS");
		viewCust = new JButton("VIEW CUSTOMERS");
		viewAccts = new JButton("VIEW ACCOUNTS");
		viewAll = new JButton("VIEW ALL");

		// --------------------------------------------------------------
		// CUSTOMER SECTION
		JLabel custHeader = new JLabel("CUSTOMER INFORMATION");
		custHeader.setFont(new Font("Arial", Font.BOLD, 20));
		custHeader.setBounds(startX1, startY - 40, colWidth, 40);
		add(custHeader);

		// Customer Input Fields
		addLabelFieldPair(this, custID_Input, custID_Label, startX1, startY, labelWidth, rowHeight, fieldWidth);
		addLabelFieldPair(this, custSSN_Input, custSSN_Label, startX1, startY + 50, labelWidth, rowHeight, fieldWidth);
		addLabelFieldPair(this, custLast_Input, custLast_Label, startX1, startY + 100, labelWidth, rowHeight, fieldWidth);
		addLabelFieldPair(this, custFirst_Input, custFirst_Label, startX1, startY + 150, labelWidth, rowHeight, fieldWidth);
		addLabelFieldPair(this, custStreet_input, custStreet_Label, startX1, startY + 200, labelWidth, rowHeight, fieldWidth);
		addLabelFieldPair(this, custCity_Input, custCity_Label, startX1, startY + 250, labelWidth, rowHeight, fieldWidth);
		addLabelFieldPair(this, custState_Input, custState_Label, startX1, startY + 300, labelWidth, rowHeight, fieldWidth);
		addLabelFieldPair(this, custZip_Input, custZip_Label, startX1, startY + 350, labelWidth, rowHeight, fieldWidth);
		addLabelFieldPair(this, custPhone_Input, custPhone_Label, startX1, startY + 400, labelWidth, rowHeight, fieldWidth);

		// --------------------------------------------------------------
		// ACCOUNT SECTION
		JLabel acctHeader = new JLabel("ACCOUNT INFORMATION");
		acctHeader.setFont(new Font("Arial", Font.BOLD, 20));
		acctHeader.setBounds(startX2, startY - 40, colWidth, 40);
		add(acctHeader);

		// Account Input Fields
		addLabelFieldPair(this, acctNum_Input, acctNum_Label, startX2, startY, labelWidth, rowHeight, fieldWidth);
		/*addLabelFieldPair(this, acctType_Input, acctType_Label, startX2, startY + 50, labelWidth, rowHeight, fieldWidth);*/
		addLabelFieldPair(this, acctFee_Input, acctFee_Label, startX2, startY + 50, labelWidth, rowHeight, fieldWidth);
		addLabelFieldPair(this, acctRate_Input, acctRate_Label, startX2, startY + 100, labelWidth, rowHeight, fieldWidth);
		addLabelFieldPair(this, acctDraftF_Input, acctDraftF_Label, startX2, startY + 150, labelWidth, rowHeight, fieldWidth);
		addLabelFieldPair(this, acctBal_Input, acctBal_Label, startX2, startY + 200, labelWidth, rowHeight, fieldWidth);
		addLabelFieldPair(this, acctCustFK_Input, acctCustFK_Label, startX2, startY + 250, labelWidth, rowHeight, fieldWidth);


		// --------------------------------------------------------------
		// TRANSACTION SECTION
		JLabel transHeader = new JLabel("TRANSACTIONS");
		transHeader.setFont(new Font("Arial", Font.BOLD, 20));
		transHeader.setBounds(startX3, startY - 40, colWidth, 40);
		add(transHeader);

		// Transaction Input Fields
		addLabelFieldPair(this, transSelect_Input, transSelect_Label, startX3, startY, labelWidth, rowHeight, fieldWidth);
		addLabelFieldPair(this, transAmt_Input, transAmt_Label, startX3, startY + 50, labelWidth, rowHeight, fieldWidth);
		addLabelFieldPair(this, transType_Input, transType_Label, startX3, startY + 100, labelWidth, rowHeight, fieldWidth);

		
		// --------------------------------------------------------------
		// EVENTS SECTION
		// Adding Records
		addCust.setBounds(startX1 + 50, startY - 90, 300, 50);
		addAcct.setBounds(startX2 + 50, startY - 90, 300, 50);
		addtrans.setBounds(startX3 + 50, startY - 90, 300, 50);

		// Buttons
		check_Label.setBounds(startX2, startY + 300, 100, 40);
		saving_Label.setBounds(startX2 + 150, startY + 300, 100, 40);
		check_Label.setFont(new Font("Arial", Font.BOLD, 14));
		saving_Label.setFont(new Font("Arial", Font.BOLD, 14));
		check_Input.setBounds(startX2 + 100, startY + 300, 30, 40);
		saving_Input.setBounds(startX2 + 250, startY + 300, 30, 40);
		check_Input.setActionCommand("CHK");
		saving_Input.setActionCommand("SAV");
		
		// Display
		viewAll.setBounds(startX3 + 50, startY - 140, 300, 50);
		viewCust.setBounds(startX1 + 50, startY - 140, 300, 50);
		viewAccts.setBounds(startX2 + 50, startY - 140, 300, 50);
		monitor.setEditable(false);
		monitor.setFont(new Font("Monospaced", Font.PLAIN, 16));
		monitor.setText("|||||||||||||||| WELCOM TO THE BANKING APP ||||||||||||||||\n\nSystem is ready for use...\n\n");
		scrollPane.setBounds(50, 20, 1300, 375);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		// --------------------------------------------------------------
		// Component Add To Frame
		// Customer Inputs + Labels
		systemGUI.add(custID_Label);
		systemGUI.add(custID_Input);
		systemGUI.add(custSSN_Label);
		systemGUI.add(custSSN_Input);
		systemGUI.add(custLast_Label);
		systemGUI.add(custLast_Input);
		systemGUI.add(custFirst_Label);
		systemGUI.add(custFirst_Input);
		systemGUI.add(custStreet_Label);
		systemGUI.add(custStreet_input);
		systemGUI.add(custCity_Label);
		systemGUI.add(custCity_Input);
		systemGUI.add(custState_Label);
		systemGUI.add(custState_Input);
		systemGUI.add(custZip_Label);
		systemGUI.add(custZip_Input);
		systemGUI.add(custPhone_Label);
		systemGUI.add(custPhone_Input);

		// Account Inputs + Labels
		systemGUI.add(acctNum_Label);
		systemGUI.add(acctNum_Input);
		systemGUI.add(acctType_Label);
		systemGUI.add(acctType_Input);
		systemGUI.add(acctFee_Label);
		systemGUI.add(acctFee_Input);
		systemGUI.add(acctRate_Label);
		systemGUI.add(acctRate_Input);
		systemGUI.add(acctDraftF_Label);
		systemGUI.add(acctDraftF_Input);
		systemGUI.add(acctBal_Label);
		systemGUI.add(acctBal_Input);
		systemGUI.add(acctCustFK_Label);
		systemGUI.add(acctCustFK_Input);
		systemGUI.add(check_Label);
		systemGUI.add(check_Input);
		systemGUI.add(saving_Label);
		systemGUI.add(saving_Input);

		// Transaction Inputs + Labels
		systemGUI.add(transSelect_Label);
		systemGUI.add(transSelect_Input);
		systemGUI.add(transAmt_Label);
		systemGUI.add(transAmt_Input);
		systemGUI.add(transType_Label);
		systemGUI.add(transType_Input);

		// Buttons (already added in your code, but just in case)
		systemGUI.add(reload);
		systemGUI.add(addCust);
		systemGUI.add(addAcct);
		systemGUI.add(addtrans);
		systemGUI.add(viewCust);
		systemGUI.add(viewAccts);
		systemGUI.add(viewAll);
		systemGUI.add(scrollPane);
		
	}
}
