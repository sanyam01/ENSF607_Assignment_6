import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class Player represents the player for the game. It tells about the player
 * name, opponent, and its mark.
 * 
 * It also includes the functions that tells the player to make the next move.
 * 
 * @author Sanyam
 * @since September 26, 2020
 *
 */

public class Player {
	/**
	 * name of the player
	 */
	private String name;

	/*
	 * mark for the player
	 */
	private char mark;

	/**
	 * opponent of the player
	 */
	private Player opponent;

	/**
	 * Board used for playing the game
	 */
	private Board board;

	/**
	 * Constructs an object of class Player. It assigns the name and the mark to the
	 * player, which are passed as parameter.
	 * 
	 * @param name of the player
	 * @param mark of the player
	 */
	public Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}

	/**
	 * sets the board for the game as the 'theBoard', which is passed as parameter
	 * 
	 * @param theBoard object of class Board
	 */
	public void setBoard(Board theBoard) {
		this.board = theBoard;
	}

	/**
	 * sets the opponent of the player to the player passed as parameter
	 * 
	 * @param opp object of type 'Player'
	 */
	public void setOpponent(Player opp) {
		this.opponent = opp;
	}

	/**
	 * play() actually implements the dynamic function of the game. It calls the
	 * player to make a move until the game is over.
	 */
	public void play() {
		Player p = this;
		while (board.xWins() == false && board.oWins() == false && board.isFull() == false) {
			p.makeMove();
			board.display();
			p = p.opponent;
		}
		this.gameOver();
	}

	/**
	 * makeMove() gets the row index and the column index, and calls the function
	 * addMark, to add the mark in corresponding grid.
	 * 
	 * It passes the row index, column index, and mark to the function 'addMark' as
	 * arguments
	 */
	public void makeMove() {
		int row, col;
		System.out.print("\n" + this.name + ", what row should your next " + this.mark + " be placed in? ");
		row = getNum();
		System.out.print("\n" + this.name + ", what column should your next " + this.mark + " be placed in? ");
		col = getNum();
		char check = board.getMark(row, col);
		if (check == ' ')
			board.addMark(row, col, this.mark);
		else {
			System.out.println("The grid is already marked. Please choose other grid");
			makeMove();
		}

	}

	/**
	 * gameOver() is called when either one of the player has won or the game is
	 * tied.
	 * 
	 * It checks for the winner/tie and displays the same as output.
	 */
	public void gameOver() {
		System.out.print("THE GAME IS OVER:");
		if (board.xWins())
			System.out.println(this.name + " is the winner!");
		else if (board.oWins())
			System.out.println(this.opponent.name + " is the winner!");
		else
			System.out.println("The game ended in a ‘tie’");
		System.out.println("Game Ended ...");
	}

	/**
	 * getNum() reads the number entered by the user
	 * 
	 * It gets the index of the column or row when called
	 * 
	 * @return index of row or column entered by user
	 */
	public int getNum() {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String name;
		int num = -1;
		try {
			name = stdin.readLine();

			while (name == null) {
				System.out.print("Please try again: ");
				name = stdin.readLine();
			}

			num = Integer.parseInt(name);
			if (num < 0 || num > 2) {
				System.out.print("Please enter num from 0 to 2 : ");
				num = getNum();
			}
			return num;
		} catch (Exception e) {
			System.out.print("Please enter Integer number between 0 and 2 : ");
			num = getNum();
		}
		return num;

	}

}
