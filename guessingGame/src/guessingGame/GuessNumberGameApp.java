package guessingGame;
import guessingGame.Game;
import java.util.Scanner;

public class GuessNumberGameApp {
	// Elements & Storage
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// Elements & Intro
		String playAgain = "y";
		System.out.print(Game.displayWelcomeMessage()); 
		
		// Game Sequence
		while (true) {
			Integer gameCounter = 0;
			Integer activeGuess = 0;
			Integer ranNum = Game.generateNumberToBeGuessed(1, 100);
			System.out.print(Game.displayPleaseGuessMessage()); 
			//System.out.println(ranNum);
			
			// Game Sequence guesses
			while (true) {
				Integer guessNumber = Game.makeGuess(scanner);
				gameCounter ++;
				
				if (Game.isCorrectGuess(guessNumber, ranNum)) {
					// Correct
					System.out.print(Game.displayCorrectGuessMessage(gameCounter));
					break;
				} else {
					// Incorrect
					System.out.print(Game.displayGuessAgainMessage(guessNumber, ranNum, gameCounter, activeGuess));
				}
				
				// Remember last answer
				activeGuess = guessNumber;
				
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

	}

}
