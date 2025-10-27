package ticTacToe;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {
	
	// Global Elements
	public static Scanner scanner = new Scanner(System.in);
	
	// Welcome Message
	public static String displayWelcomeMessage() {
		return "********** WELCOME TO THE TIC TAC TOE GAME **********\n\n____________________________________________________\n\n";
	}
	
	// Display Grid
	public static String displayGrid(String[][] gameArray) {
		
		// Elements and Storage
		String gamePrintOut = "";
		Integer rowActive = 0;
		Integer colActive = 0;
		List<String> gameTemp = new ArrayList<>(Arrays.asList("\n+---+---+---+\n", "| ", "H", " ", "| ", "H", " ", "| ", "H", " |\n"
															 ,"+---+---+---+\n", "| ", "H", " ", "| ", "H", " ", "| ", "H", " |\n"
															 ,"+---+---+---+\n", "| ", "H", " ", "| ", "H", " ", "| ", "H", " |\n"
															 ,"+---+---+---+\n\n"));
		// Print Display
		for (int gameIndex = 0; gameIndex < gameTemp.size(); gameIndex++) {
			if (gameTemp.get(gameIndex) == "H") {
				
				// Print Player Marker
				gamePrintOut += gameArray[rowActive][colActive];
				
				// Advance Coordinates
				if (colActive == 2) {
					rowActive += 1;
					colActive = 0;
				} else {
					colActive += 1;
				}
				
			} else {
				// Add Fillers
				gamePrintOut += gameTemp.get(gameIndex);
			}
		}
		
		// Return Printable Game Display
		return gamePrintOut;
	}
	
	// Take & Validate Turn
	public static String[][] takeTurn(Scanner scanner, String[][] gameArray, String marker) {
		
		while (true) {
			// Elements and Storage
			Integer rowNumber = 0;
			Integer colNumber = 0;
			String markSelected = marker;
			
			// Validate Row Entry
			while (true) {
				System.out.print("Pick a Row: ");
				rowNumber = scanner.nextInt();
				scanner.nextLine();
				
				if (rowNumber >= 1 && rowNumber <= 3) {
					break;
				} else {
					System.out.print("Incorrect value must be between 1 & 3 !!\n");
				}
			}
			
			// Validate Col Entry
			while (true) {
				System.out.print("Pick a Col: ");
				colNumber = scanner.nextInt();
				scanner.nextLine();
				
				if (colNumber >= 1 && colNumber <= 3) {
					break;
				} else {
					System.out.print("Incorrect value must be between 1 & 3 !!\n");
				}
			}
			
			// Check Position Eligible
			if (gameArray[rowNumber - 1][colNumber - 1] == " ") {
				gameArray[rowNumber - 1][colNumber - 1] = markSelected;
				break;
			} else {
				System.out.print("\nPosition taken try again !!\n\n");
			}	
		}
		
		return gameArray;
	}
	
	// Check Winner
	public static String checkWinner(String[][] gameArray) {
		// Check rows
        for (int row = 0; row < 3; row++) {
            if (gameArray[row][0] == gameArray[row][1] && gameArray[row][1] == gameArray[row][2] && gameArray[row][0] != " ") {
                return gameArray[row][0];
            }
        }
        
        // Check columns
        for (int col = 0; col < 3; col++) {
            if (gameArray[0][col] == gameArray[1][col] && gameArray[1][col] == gameArray[2][col] && gameArray[0][col] != " ") {
                return gameArray[0][col];
            }
        }
        
        // Check diagonals
        if (gameArray[0][0] == gameArray[1][1] && gameArray[1][1] == gameArray[2][2] && gameArray[0][0] != " ") {
            return gameArray[0][0];
        }
        if (gameArray[0][2] == gameArray[1][1] && gameArray[1][1] == gameArray[2][0] && gameArray[0][2] != " ") {
            return gameArray[0][2];
        }
        
     // Check for draw
        boolean isFull = true;
        for (int rows = 0; rows < 3; rows++) {
            for (int cols = 0; cols < 3; cols++) {
                if (gameArray[rows][cols] == " ") {
                    isFull = false;
                    break;
                }
            }
            if (!isFull) break;
        }
        if (isFull) {
            return "DRAW";
        }
        
        return " ";
	}
	
	public static void startGame() {
		// Elements and Storage
		String[][] gameBoard = new String[3][3];
		String activePlayer = "X";
		gameBoard[0][0] = " ";
		gameBoard[0][1] = " ";
		gameBoard[0][2] = " ";
		gameBoard[1][0] = " ";
		gameBoard[1][1] = " ";
		gameBoard[1][2] = " ";
		gameBoard[2][0] = " ";
		gameBoard[2][1] = " ";
		gameBoard[2][2] = " ";
		
		// Header & Welcome
		System.out.print(displayWelcomeMessage());
		
		// Game Sequence
		while (true) {
			// Take Turn
			System.out.print(displayGrid(gameBoard));
			System.out.print(activePlayer + "'s Turn\n");
			takeTurn(scanner, gameBoard, activePlayer);
			
			// Check Winner & Exit
			String winner = checkWinner(gameBoard);
			if (winner == "X" || winner == "O" || winner == "DRAW") {
				System.out.print("\n____________________________________________________\n\nThe Winner is: " + winner);
				System.out.print(displayGrid(gameBoard));
				break;
				}
			
			// Switch Players
			if (activePlayer == "X") {
				activePlayer = "O"; 
			} else {
				activePlayer = "X"; 
			}
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startGame();
	}

}
