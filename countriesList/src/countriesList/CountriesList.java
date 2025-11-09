package countriesList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class CountriesList {
	
	// Elements & Variable
	public static ArrayList<String> countries = new ArrayList<>();
	public static ArrayList<String> menuOption = new ArrayList<>(Arrays.asList("Display Countries", "Add Country", "Exit"));
	
	// Display Welcome
	public static String displayWelcomeMessage() {
		return "-----------------------------------------------------------\n" +
	           "||||||||||||||| WELCOME TO THE COUNTRIES APP ||||||||||||||\n" + 
			   "-----------------------------------------------------------\n\n";
	}
	
	// Display Menu
	public static String displayMenu() {
		// Menu Temp
		String menuPrint = "COMMAND MENU:\n";
		
		// Write the Menu
		for (Integer cnt = 0; cnt < menuOption.size(); cnt++) {
			menuPrint += (cnt + 1) + ") " + menuOption.get(cnt) + "\n";
		}
		
		return menuPrint;
	}

	// Menu Selector
	public static String getMenuOption(Scanner scannerOBJ) {
		System.out.print("\nEnter Menu Number ------: ");
		String selection = scannerOBJ.nextLine();
		while (true) {
			try {
				if (Integer.valueOf(selection) >= 1 && Integer.valueOf(selection) <= menuOption.size()) {
					return selection;
				} else {
					System.out.print("Error: Invalid Selection must be " + 1 + " thru " + menuOption.size());
					System.out.print("\n\nEnter Menu Number ------: ");
					selection = scannerOBJ.nextLine();
				}
			} catch (Exception ex) {
				System.out.print("Error: Invalid Selection must be " + 1 + " thru " + menuOption.size());
				System.out.print("\n\nEnter Menu Number ------: ");
				selection = scannerOBJ.nextLine();
			}
			
		}
	}
	
	// List Countries
	public static String listCountries() {
		String countryPrint = "\n----------------------------\nCOUNTRIES IN LIST:\n";
		
		if (countries.size() == 0) {
			return "Error: No Countries to display\n";
		} else {
			// Sort List
			Collections.sort(menuOption);
			
			// Build Display
			for (Integer cnt = 0; cnt < countries.size(); cnt++) {
				countryPrint += "* " + countries.get(cnt) + "\n";
			}
			
			// Return Country Print
			return countryPrint;
		}
	}
	
	// Check For Counties
	public static boolean checkForCountry(String inputCountry) {
		boolean exists = countries.contains(inputCountry);
		return exists;
	}
	
	// Add Counties
	public static String addCountry(Scanner scannerOBJ) {
		System.out.print("Enter Country Name -----: ");
		String countryInput = scannerOBJ.nextLine();
		
		if (checkForCountry(countryInput)) {
			return "Error: Country already exists\n";
		} else {
			countries.add(countryInput);
			return "Success: " + countryInput + " has been added\n";
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
