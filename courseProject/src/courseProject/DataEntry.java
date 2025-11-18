package courseProject;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataEntry {
	
	// Check String NO Length Requirement
	public static boolean checkString(String inputString) {
		boolean validEntry;
		
		if (inputString instanceof String) {
			validEntry = true;
		} else {
			validEntry = false;
		}
		
		return validEntry;
	}
	
	// Check String WITH Length Requirement
	public static boolean checkStringLength(String inputString, Integer minLength, Integer maxLength) {
		boolean validEntry;
		
		if (inputString instanceof String && inputString.length() >= minLength && inputString.length() <= maxLength && !inputString.trim().isBlank()) {
			validEntry = true;
		} else {
			validEntry = false;
		}
		
		return validEntry;
	}
	
	// Check String Strict Options Requirement
		public static boolean checkStringOptions(List<String> optionsList, String inputString) {
			boolean validEntry; 
			
			if (optionsList.contains(inputString)) {
				validEntry = true;
			} else {
				validEntry = false;
			}
			
			return validEntry;
		}
	
	// Check String ONLY Numerical Char
	public static boolean checkStringNumbers(String inputString) {
		boolean validEntry;
		
		try {
			Integer testInt = Integer.valueOf(inputString);
			validEntry = true;
		} catch (Exception ex) {
			System.out.print("\nERROR --------------: " + ex);
			validEntry = false;
		}
		
		return validEntry;
	}
	
	// Check Integer NO Range Requirement
	public static boolean checkInteger(Integer inputInteger) {
		boolean validEntry;
		
		if (inputInteger instanceof Integer) {
			validEntry = true;
		} else {
			validEntry = false;
		}
		
		return validEntry;
	}
	
	// Check Integer WITH Range Requirements
	public static boolean checkIntegerRange(Integer inputInteger, Integer minRange, Integer maxRange) {
		boolean validEntry;
		
		if (inputInteger >= minRange && inputInteger <= maxRange) {
			validEntry = true;
		} else {
			validEntry = false;
		}
		
		return validEntry;
	}

	// Check Float NO Range Requirement
	public static boolean checkFloat(Float inputFloat) {
		boolean validEntry;
		
		if (inputFloat instanceof Float) {
			validEntry = true;
		} else {
			validEntry = false;
		}
		
		return validEntry;
	}
	
	// Check Float WITH Range Requirements
	public static boolean checkFloatRange(Float inputFloat, Float minRange, Float maxRange) {
		boolean validEntry;
		
		if (inputFloat >= minRange && inputFloat <= maxRange) {
			validEntry = true;
		} else {
			validEntry = false;
		}
		
		return validEntry;
	}
	
	// Check Double NO Range Requirement
		public static boolean checkDouble(Double inputDouble) {
			boolean validEntry;
			
			if (inputDouble instanceof Double) {
				validEntry = true;
			} else {
				validEntry = false;
			}
			
			return validEntry;
		}
		
		// Check Double WITH Range Requirements
		public static boolean checkDoubleRange(Double inputDouble, Double minRange, Double maxRange) {
			boolean validEntry;
			
			if (inputDouble >= minRange && inputDouble <= maxRange) {
				validEntry = true;
			} else {
				validEntry = false;
			}
			
			return validEntry;
		}
	
	// Check Date 
	public static boolean checkDate(String inputDate) {
		boolean validEntry;
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/DD/YYYY");
		
		try {
			LocalDate testDate = LocalDate.parse(inputDate, dateFormat); 
			validEntry = true;
		} catch (Exception ex) {
			System.out.print("\nERROR --------------: " + ex);
			validEntry = false;
		}
		
		return validEntry;
	}
		
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
