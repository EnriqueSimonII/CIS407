package stackCalculator;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StackCalculator {
	
	// Elements & Storage
	static String command;
	static Stack<Float> calculator = new Stack<>();
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<String> commands = new ArrayList<>(Arrays.asList("push n", "add", "sub", "mult", "div", "list", "clear", "quit"));
	
	
	// Display: Welcome Message
	public static String displayWelcomeMessage() {
		return "-------------------------------------------\n" + 
	           "||||||| WELCOME TO STACK CALCULATOR |||||||\n" + 
			   "-------------------------------------------";
	}
	
	// Display: Commands
	public static String displayCommands() {
		
		String commandsPrint = "\n\nCommands:\n";
		for (Integer cnt = 0; cnt < commands.size(); cnt++) {
			commandsPrint += "- " + commands.get(cnt) + "\n";
		}
		
		return commandsPrint;
	}
	
	// Stack: Push 
	public static void push(Float inputValue) {
		calculator.push(inputValue);
	}
	
	// Stack: Pop
	public static void pop() {
		calculator.pop();
	}
	
	// Stack: Size
	public static Integer size() {
		return calculator.size();
	}
	
	// Stack: Clear
	public static void clear() {
		calculator.clear();
	}
	
	// Stack: List Stack
	public static String listStack() {
		
		String valuesPrint = "";
		
		if (calculator.size() < 1) {
			valuesPrint = "empty\n";
		} else {
			for (Float value: calculator) {
				valuesPrint += value + "\n";
			}
		}
		
		return valuesPrint;
	}
	
	// Command: Get Values
	public static String getValues() {
		
		while (true) {
			System.out.print("\nStack> ");
			String inputString = scanner.nextLine();
			
			if (commands.contains(inputString)) {
				command = inputString;
				return inputString;
			} else if (inputString.contains("push")) {
				command = inputString;
				return inputString;
			} else {
				System.out.print("Unrecognized Command\n");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
