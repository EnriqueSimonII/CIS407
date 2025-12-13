package animalCounter;
import javax.swing.*;
import java.awt.*;

public class ForDiscussionPost {
	
	// Instance Variables
	public static JFrame frame;
	public static JTextField textBox;
	public static JButton button;
	public static JRadioButton radioButton;
	public static JCheckBox checkBox;
	public static JLabel label;

	public static void main(String[] args) {
		
		// Components
		frame = new JFrame();
		textBox = new JTextField();
		button = new JButton();
		radioButton = new JRadioButton();
		checkBox = new JCheckBox();
		label = new JLabel("Hello");
		
		// Settings
		frame.setLayout(new FlowLayout());
		frame.setSize(1000, 100);
		frame.setVisible(true);
		
		
		// Add Components
		frame.add(textBox);
		frame.add(button);
		frame.add(radioButton);
		frame.add(checkBox);
		frame.add(label);
		
		

	}

}
