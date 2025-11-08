package week4Discussion;
import week4Discussion.Conversions;
import java.util.Scanner;

public class ConvertApp {

	public static void main(String[] args) {
		// Elements & Variables
		Scanner scanner = new Scanner(System.in);
		
		// Header & Welcome
		System.out.print("\n-----------------------------------------------------------\n" + 
		                 "||||||||||||||| WELCOM TO THE SPEED CONV APP ||||||||||||||\n" + 
				         "-----------------------------------------------------------");
		
		while (true) {
			// Calculator Settings
			System.out.print("\n\n---------------------------------\nPlease choose your initial metric:\n1) MPH\n2) KPH\n\n");
			System.out.print("Selection -----------------: ");
			Integer initialUnit = scanner.nextInt();
			
			// Convert & Display
			if (initialUnit == 1) {
				System.out.print("\nYou are converting MPH to KPH\n");
				System.out.print("Enter Speed in MPH --------: ");
				Integer initialSpeed = scanner.nextInt();
				Float convSpeed = Conversions.convertSpeed_MPH_KPH((float)initialSpeed);
				System.out.print("\nRESULT -------: " + convSpeed);
			} else if (initialUnit == 2) {
				System.out.print("\nYou are converting KPH to MPH\n");
				System.out.print("Enter Speed in KPH --------: ");
				Integer initialSpeed = scanner.nextInt();
				Float convSpeed = Conversions.convertSpeed_KPH_MPH((float)initialSpeed);
				System.out.print("\nRESULT -------: " + convSpeed);
			}
			
			// Simple exit logic
			scanner.nextLine();
			System.out.print("\nWould you like to continue? (y)");
			String contLoop = scanner.nextLine();
			if (contLoop.equals("y")) {
				break;
			}
			
		}
		

	}

}
