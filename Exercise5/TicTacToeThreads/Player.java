import java.util.Scanner;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * Class assigns players and their opponents. Takes mark from the player,
 * handles the movements of players in the game.
 * 
 * @author Neha Singh
 *
 */
public class Player {

//	/**
//	 * The name of the player
//	 */
//	private String name;
//
//	/**
//	 * The board of the game.
//	 */
//	private Board board;
//
//	/**
//	 * The opponent player.
//	 */
//	private Player opponent;
//
//	/**
//	 * The variable for mark X and O.
//	 */
//	private char mark;
//
//	/**
//	 * Constructs a Player object with the specified values for name and mark m.
//	 * 
//	 * @param name is the Player's name.
//	 * @param m    is the Player's mark X or O.
//	 */
//	public Player(String name, char m) {
//
//		this.name = name;
//		this.mark = m;
//
//	}
//
//	/**
//	 * Method connects the other player to this player
//	 * 
//	 * @param p player set as opponent
//	 */
//	public void setOpponent(Player p) {
//		this.opponent = p;
//	}
//
//	/**
//	 * Method sets the board.
//	 * 
//	 * @param theBoard
//	 */
//	public void setBoard(Board theBoard) {
//
//		this.board = theBoard;
//	}
//
//	/**
//	 * Method calls method makeMove() and checks for the possible scenarios: If X
//	 * wins or O wins, method displays the name of the winner and exits the program.
//	 * If board is full i.e. mark count=9, method ends the game in a tie and exits
//	 * the game.
//	 *
//	 */
//	public void play() {
//
//		makeMove();
//		this.board.display();
//		if (this.board.xWins()) {
//			System.out.println("Game Over!, " + this.name + " is the winner!");
//			System.exit(0);
//		} else if (this.board.oWins()) {
//			System.out.println("Game Over!, " + this.name + " is the winner!");
//			System.exit(0);
//		} else if (this.board.isFull()) {
//			System.out.println("Game ends in Tie");
//			System.exit(0);
//		}
//	}
//
//	/**
//	 * Method asks the player to make a move by entering the row and column numbers.
//	 * Marks either an X or an O in the position indicated by the player by calling
//	 * method addMark in class Board.
//	 */
//	public void makeMove() {
//
//		int row = checkScannedInput("row");
//		int column = checkScannedInput("column");
//
//		if (!(board.getMark(row, column) == 'X' || board.getMark(row, column) == 'O')) {
//			board.addMark(row, column, this.mark);
//		} else {
//			System.out.println("Already marked!");
//			makeMove();
//		}
//
//	}
//
//	/**
//	 * Method validates if the input by player is an integer.
//	 * 
//	 * @param message for row or column
//	 * @return value of row and column
//	 */
//	private int checkScannedInput(String message) {
//
//		int num = 0;
//		Scanner input = new Scanner(System.in);
//
//		do {
//			System.out.println(this.name + ", What " + message + " should your next " + this.mark + " be placed in?");
//
//			// Checks if input is an integer and nothing else.
//			while (!input.hasNextInt()) {
//				System.out.printf("Input should be an integer. Try again.\n");
//				input.next();
//			}
//
//			// Set the number.
//			num = input.nextInt();
//
//			// If the number is outside range print an error message.
//			if (num < 0 || num > 2)
//				System.out.printf("Input should be in range 0-2. Try again.\n");
//
//		} while (num < 0 || num > 2);
//
//		return num;
//	}
	
	
	
	
	// private String name;
		private char mark;
		private String name;

		/**
		 * Constructor
		 * @param mark
		 * @param name
		 */
		public Player(char mark,String name) {
			this.mark = mark;
			this.name = name;
		}

		/**
		 * Getter for mark
		 * @return
		 */
		public char getMark() {
			return mark;
		}

		/**
		 * setter for mark
		 * @param mark
		 */
		public void setMark(char mark) {
			this.mark = mark;
		}

		/**
		 * Getter for name
		 * @return
		 */
		public String getName() {
			return name;
		}

		/**
		 * Setter for name
		 * @param name
		 */
		public void setName(String name) {
			this.name = name;
		}
	

}
