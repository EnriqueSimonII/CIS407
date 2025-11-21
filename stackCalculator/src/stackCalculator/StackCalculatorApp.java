package stackCalculator;
import stackCalculator.StackCalculator;

public class StackCalculatorApp {

	public static void main(String[] args) {
		// Elements & Storage
		StackCalculator calc = new StackCalculator();
		
		// Header & Welcome
		System.out.print(calc.displayWelcomeMessage());
		System.out.print(calc.displayCommands());
		
		// App Function
		while (true) {
			
			// Collect User Command
			String command = calc.getValues();
			if (command.contains("push")) {
				
				// Push
				Float inputValue = Float.parseFloat(command.replace("push", "").trim());
				calc.push(inputValue);
				
				// List Stack
				System.out.print(calc.listStack());
				
			} else if (command.equals("add")) {
				try {
					
					// Addition
					Float value1 = calc.calculator.peek();
					calc.pop();
					Float value2 = calc.calculator.peek();
					calc.pop();
					calc.push(value1 + value2);
					
					// List Stack
					System.out.print(calc.listStack());
					
				} catch (Exception ex) {
					System.out.print("ERROR: EMPTY STACK\n");
				}
				
				
			} else if (command.equals("sub")) {
				try {
					// Subtraction
					Float value1 = calc.calculator.peek();
					calc.pop();
					Float value2 = calc.calculator.peek();
					calc.pop();
					calc.push(value1 - value2);
					
					// List Stack
					System.out.print(calc.listStack());
					
				} catch (Exception ex) {
					System.out.print("ERROR: EMPTY STACK\n");
				}
				
			} else if (command.equals("mult")) {
				try {
					// Multiplication
					Float value1 = calc.calculator.peek();
					calc.pop();
					Float value2 = calc.calculator.peek();
					calc.pop();
					calc.push(value1 * value2);
					
					// List Stack
					System.out.print(calc.listStack());
					
				} catch (Exception ex) {
					System.out.print("ERROR: EMPTY STACK\n");
				}
				
			} else if (command.equals("div")) {
				try {
					// Division
					Float value1 = calc.calculator.peek();
					calc.pop();
					Float value2 = calc.calculator.peek();
					calc.pop();
					calc.push(value2 / value1);
					
					// List Stack
					System.out.print(calc.listStack());
					
				} catch (Exception ex) {
					System.out.print("ERROR: EMPTY STACK\n");
				}
				
			} else if (command.equals("list")) {
				
				// List Stack
				System.out.print(calc.listStack());
				
			} else if (command.equals("clear")) {
				
				// Clear Stack
				calc.clear();
				
				// List Stack
				System.out.print(calc.listStack());
				
			} else if (command.equals("quit")) {
				System.out.print("\n\n-------------------------------------------\nBye!!");
				break;
			}
		}
		

	}

}
