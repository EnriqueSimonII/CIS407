// Enrique J Simon II CIS407 Lab 2 Guessing Game

package guessingGame;
import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.abs;

public class Game {
	// Elements Global
	public static final Random random = new Random();
	public static final Scanner scanner = new Scanner(System.in);

	// Generate Random Number
	public static Integer generateNumberToBeGuessed(Integer start, Integer end) {
		Integer randomNum = random.nextInt(start, end + 1);
		return randomNum;
	}
	
	// Make Guess
	public static Integer makeGuess(Scanner scanner) {
		while (true) {
			System.out.print("Please make a guess between 1 and 100 ————————: ");
			Integer playerGuess = scanner.nextInt();
			
			if (playerGuess >= Integer.MIN_VALUE || playerGuess <= Integer.MAX_VALUE) {
				return playerGuess;
			} else {
				System.out.println("Incorrect Entry, please try again");
			}
		}
	}
	
	// Win Logic
	public static boolean isCorrectGuess(Integer playerGuess, Integer randomNum) {
		return playerGuess == randomNum;
	}
	
	// Welcome Message
	public static String displayWelcomeMessage() {
		return "********** WELCOME TO THE GUESSING GAME **********\n\n__________________________________________________\n";
	}
	
	// Please Guess Message
	public static String displayPleaseGuessMessage() {
		return "\nI'm Thinking of a number between 1 & 100\nTry to guess it\n\n";
	}
	
	// Correct Guess Message
	public static String displayCorrectGuessMessage(Integer counter) {
		String score = "";
		
		if (counter <= 3) {
			score = "\nGreat Work! You are a mathematical wizard";
		} else if (counter >= 4 && counter <= 7) {
			score = "\nNot too bad! You've got some potential";
		} else if (counter > 7) {
			score = "\nWhat took you so long";
		}
		
		return "YOUR ANSWER WAS: CORRECT\nYou got it in " + counter + " tries " + score + "\n\n";
	}
	
	// Guess Again Message
	public static String displayGuessAgainMessage(Integer playerGuess, Integer randomNum, Integer gameCount, Integer prevGuess) {
		String hint = "";
		Integer delta = playerGuess - randomNum;
		Integer prevDelta = prevGuess - randomNum;
		String hotColdHint = "";
		
		// Hot Cold Logic
		if (gameCount > 1) {
			if (abs(delta) < abs(prevDelta)) {
				hotColdHint = "Warmer";
			} else if (abs(delta) == abs(prevDelta)) {
				hotColdHint = "Stale";
			} else {
				hotColdHint = "Colder";
			}
		}
		
		
		// Too High or Too Low
		if (delta > 10) {
			hint = "Way too high!";
		} else if (delta <= 10 && delta > 0) {
			hint = "Too high!";
		} else if (delta < -10) {
			hint = "Way too low!";
		} else if (delta >= -10 && delta < 0) {
			hint = "Too low!";
		}
		
		return "YOUR ANSWER WAS: INCORRECT (hint = " + hotColdHint + " & " + hint + ")\n\n";
	}
	
	// Game Script
	public static void main(String[] args) {
		
	}

}
