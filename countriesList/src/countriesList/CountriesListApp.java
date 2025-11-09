package countriesList;
import countriesList.CountriesList;
import java.util.Scanner;

public class CountriesListApp {

	public static void main(String[] args) {
		// Elements & Variable
		Scanner scanner = new Scanner(System.in);
		
		// Header & Welcome
		System.out.print(CountriesList.displayWelcomeMessage());
		
		// Display Menu
		System.out.print(CountriesList.displayMenu());
		
		while (true) {
			
			// Menu Selection
			String menuChoice = CountriesList.getMenuOption(scanner);
			
			// RUN MENU FUNCTION
			if (Integer.valueOf(menuChoice) == 1) {
				
				// List Countries
				System.out.print(CountriesList.listCountries());
				
			} else if (Integer.valueOf(menuChoice) == 2) {
				
				//Add Country
				System.out.print(CountriesList.addCountry(scanner));
				
			} else if (Integer.valueOf(menuChoice) == 3) {
				
				// Exit Loop
				System.out.print("\n-----------------------------------------------------------\n" + 
				                 "BYE !!");
				break;
			}
			
		}
		
	}
	
}
