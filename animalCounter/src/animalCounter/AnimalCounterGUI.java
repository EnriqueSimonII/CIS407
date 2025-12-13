package animalCounter;
import javax.swing.*;
import java.awt.*;


public class AnimalCounterGUI {
	
	// Declare Variables
	public static JLabel welcomeLabel;
	public static JLabel alligatorLabel;
    public static JLabel sheepLabel;
    public static JLabel counterAlligator;
    public static JLabel counterSheep;
    public static JButton addAlligator;
    public static JButton addSheep;
    public static JButton displayCNT;
    public static JButton resetCNT;
    public static JButton exitBtn;
    public static JRadioButton radioAlligator;
    public static JRadioButton radioSheep;
	
    // GUI interface
	public static void animalCounterGUI() {
		
		// Frame
		JFrame frame = new JFrame("Animal_App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Animal Game");
		frame.setSize(1000, 1000);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		// Panel
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		// Components
		welcomeLabel = new JLabel("Welcome to the Animal Game");
		alligatorLabel = new JLabel("Alligators");
		sheepLabel = new JLabel("Sheep");
		counterAlligator = new JLabel("-");
		counterSheep = new JLabel("-");
		addAlligator = new JButton("Add Alligator");
		addSheep = new JButton("Add Sheep");
		displayCNT = new JButton("Display");
		resetCNT = new JButton("Reset");
		radioAlligator = new JRadioButton("Alligator");
		radioSheep = new JRadioButton("Sheep");
		exitBtn = new JButton("EXIT");
		
		// Component Sets
		// Welcome Message
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 36));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(100, 50, 800, 80);
		
		// Alligator Counter Label
		alligatorLabel.setFont(new Font("Arial", Font.BOLD, 24));
		alligatorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		alligatorLabel.setBounds(150, 125, 300, 120);
		
		// Sheep Counter Label
		sheepLabel.setFont(new Font("Arial", Font.BOLD, 24));
		sheepLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sheepLabel.setBounds(550, 125, 300, 120);

		// Alligator Counter
		counterAlligator.setFont(new Font("Arial", Font.BOLD, 80));
		counterAlligator.setHorizontalAlignment(SwingConstants.CENTER);
		counterAlligator.setBounds(150, 180, 300, 120);

		// Sheep Counter
		counterSheep.setFont(new Font("Arial", Font.BOLD, 80));
		counterSheep.setHorizontalAlignment(SwingConstants.CENTER);
		counterSheep.setBounds(550, 180, 300, 120);

		// Add Alligator Button
		addAlligator.setFont(new Font("Arial", Font.BOLD, 24));
		addAlligator.setBounds(150, 340, 300, 80);

		// Add Sheep Button
		addSheep.setFont(new Font("Arial", Font.BOLD, 24));
		addSheep.setBounds(550, 340, 300, 80);

		// Display Button
		displayCNT.setFont(new Font("Arial", Font.BOLD, 24));
		displayCNT.setBounds(150, 460, 300, 80);

		// Reset Button
		resetCNT.setFont(new Font("Arial", Font.BOLD, 24));
		resetCNT.setBounds(550, 460, 300, 80);

		// Radio Buttons
		radioAlligator.setFont(new Font("Arial", Font.PLAIN, 24));
		radioAlligator.setBounds(200, 580, 150, 50);

		radioSheep.setFont(new Font("Arial", Font.PLAIN, 24));
		radioSheep.setBounds(600, 580, 150, 50);

		// EXIT Button
		exitBtn.setFont(new Font("Arial", Font.BOLD, 32));
		exitBtn.setHorizontalAlignment(SwingConstants.CENTER);
		exitBtn.setBounds(350, 700, 300, 100);
		
		// Component Add
		frame.add(welcomeLabel);
		frame.add(alligatorLabel);
		frame.add(sheepLabel);
		frame.add(counterAlligator);
		frame.add(counterSheep);
		frame.add(addAlligator);
		frame.add(addSheep);
		frame.add(displayCNT);
		frame.add(resetCNT);
		frame.add(radioAlligator);
		frame.add(radioSheep);
		frame.add(exitBtn);
				
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
