import java.io.*;

/**
 * Class Game implements the main framework for the game 'Tic-Tac-Toe'.
 * 
 * It contains the main function for the game. It constructs the players,
 * referee, and the board for playing the game. It uses the interface
 * 'Constants'.
 * 
 * @author Sanyam
 * @since September 26, 2020
 *
 */

public class Game implements Constants {

	/**
	 * Declaring an object of class Board
	 */
	private Board theBoard;

	/*
	 * Declaring an object of class Referee
	 */
	private Referee theRef;

	/**
	 * Constructs the constructor of the class 'Game'. In the constructor, an object
	 * of the class Board is created.
	 * 
	 */
	public Game() {
		theBoard = new Board();
	}

	/**
	 * appointReferee(Referee r) takes the referee as the parameter and calls the
	 * function 'runTheGame()' of class Referee.
	 *
	 * @param r is object of class 'Referee'
	 * @throws IOException
	 */
	public void appointReferee(Referee r) throws IOException {

		theRef = r;
		theRef.runTheGame();
	}

	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);

		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);

		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
		
		theGame.appointReferee(theRef);
	}

}
