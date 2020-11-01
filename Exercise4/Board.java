/**
 * Class Board implements the board for playing the game 'Tic-Tac-Toe'. It
 * implements all the functions required to play the game.
 * 
 * It implements the interface 'Constants'. It includes the methods to display
 * the board, marks, and to check which player has won
 * 
 * @author Sanyam
 * @since 26 September, 2020
 *
 */

public class Board implements Constants {

	/**
	 * theBoard is a two-dimensional array, which tells the dimensionality of the
	 * board
	 */
	private char theBoard[][];

	/**
	 * markCount keeps the count of the total number of turns played by both the
	 * players
	 */
	private int markCount;

	/**
	 * Constructs the constructor of class Board. It initializes the board with
	 * empty characters
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/**
	 * getMark(Integer row, Integer col) returns the mark of the grid, formed by the
	 * row and column passed as the parameters.
	 * 
	 * @param row represents the row dimension of the grid
	 * @param col represents the column dimension of the grid
	 * @return the mark in the grid formed the passed row and column as parameters
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * isFull() checks if all the grids on the board have been marked or not
	 * 
	 * @return True or False based on if all all the grids have been marked
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * xWins() checks if the player X has won or not
	 * 
	 * @return True if the player has won
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * oWins() checks if the player 'o' has won or not
	 * 
	 * @return True if the player has won
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * display() prints the board as an output along with the marks (i.e. 'o' and
	 * 'x')
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * addMark adds the mar to the board, at the location formed by the passed row
	 * and column index
	 * 
	 * @param row  index of the row
	 * @param col  index of the column
	 * @param mark represents the mark to be added on the board at position formed
	 *             by given index row and column. It is either 'o' or 'x'
	 */
	public void addMark(int row, int col, char mark) {

		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * clear() deletes all the marks from the board
	 * 
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * checkWinner(char mark) checks if the player with the mark passed as parameter
	 * has won the game or not
	 * 
	 * This class actually implements the logic for checking if the player has won
	 * or not
	 * 
	 * @param mark either 'o' or 'x' representing one of the two players
	 * @return 1 if the player with the passed mark has won, else return 0
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * displayColumnHeaders() outputs the column headers of the Board
	 * 
	 * Column headers are col 0, col 1, and col 2.
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * addHyphens() prints the boundaries of grids on the board
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * addSpaces() adds the necessary spaces to the board
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
