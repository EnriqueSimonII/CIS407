// Enrique J Simon II CIS407 Lab 2 Guessing Game

package guessingGame;
import java.util.Random;
import java.util.Scanner;

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
	public static String displayGuessAgainMessage(Integer playerGuess, Integer randomNum) {
		String hint = "";
		Integer delta = playerGuess - randomNum;
		
		if (delta > 10) {
			hint = "Way too high!";
		} else if (delta <= 10 && delta > 0) {
			hint = "Too high!";
		} else if (delta < -10) {
			hint = "Way too low!";
		} else if (delta >= -10 && delta < 0) {
			hint = "Too low!";
		}
		
		return "YOUR ANSWER WAS: INCORRECT (hint = " + hint + ")\n\n";
	}
	
	// Game Script
	public static void main(String[] args) {
		// Elements & Intro
		String playAgain = "y";
		System.out.print(displayWelcomeMessage()); 
		
		// Game Sequence
		while (true) {
			Integer gameCounter = 0;
			Integer ranNum = generateNumberToBeGuessed(1, 100);
			System.out.print(displayPleaseGuessMessage()); 
			System.out.println(ranNum);
			
			// Game Sequence guesses
			while (true) {
				Integer guessNumber = makeGuess(scanner);
				gameCounter ++;
				
				if (isCorrectGuess(guessNumber, ranNum)) {
					// Correct
					System.out.print(displayCorrectGuessMessage(gameCounter));
					break;
				} else {
					// Incorrect
					System.out.print(displayGuessAgainMessage(guessNumber, ranNum));
				}
			}
			
			// Exit Logic
			System.out.print("Would you like to play again? (y/n) ——————————: ");
			scanner.nextLine();
			playAgain = scanner.nextLine();
			if (playAgain.toLowerCase().equals("y")) {
				continue;
			} else if (playAgain.toLowerCase().equals("n")) {
				System.out.print("\n____________________________________________________\n\n********** THANKS FOR PLAYING BYE!! **********\n\n");
				break;
			}
		}
		
		/*
		Integer ranNum = generateNumberToBeGuessed(0, 100);
		Integer guessNum = makeGuess(scanner);
		System.out.println(ranNum);
		*/
	}

}
