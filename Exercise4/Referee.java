/**
 * Class Referee implements the role of the referee in the game. It implements
 * the functions for setting the players and the board.
 * 
 * It calls the function to start the game, once the players are set.
 * 
 * @author Sanyam
 * @since September 26, 2020
 */
public class Referee {

	/**
	 * instantiates an object of class Board
	 */
	private Board board;

	/**
	 * instantiates the players
	 */
	private Player oPlayer, xPlayer;

	/**
	 * Constructs the constructor of class Referee
	 */
	public void Refree() {

	}

	/**
	 * runTheGame() sets the opponents for each of the players and then calls the
	 * play() method of class Player, after which game is actually started.
	 */
	public void runTheGame() {

		oPlayer.setOpponent(xPlayer);
		xPlayer.setOpponent(oPlayer);
		board.display();
		xPlayer.play();

	}

	/**
	 * setBoard(Board board) sets the board to the object passed as a parameter
	 * 
	 * @param theBoard represents the board to be used in the game
	 */
	public void setBoard(Board board) {
		this.board = board;

	}

	/**
	 * 'setoPlayer' sets the first player to the player passed as parameter
	 * 
	 * @param oPlayer represents first player
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;

	}

	/**
	 * 'setxPlayer' sets the second player to the player passed as parameter
	 * 
	 * @param xPlayer represents second player
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;

	}

}
