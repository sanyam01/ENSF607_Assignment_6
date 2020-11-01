/**
 * 'Constants' interface defines the constants for the marks to be displayed on
 * the board.
 * 
 * It is used by the class 'Game' and 'Board'. LETTER_O and LETTER_X represents
 * the marks for two different players.
 * 
 * @author Sanyam
 * @since September 26, 2020
 *
 */
public interface Constants {

	/**
	 * empty String for initialization of the Board with empty grids
	 */
	static final char SPACE_CHAR = ' ';

	/**
	 * 'LETTER_O' represents the mark for first player
	 */
	static final char LETTER_O = 'O';
	/**
	 * 'LETTER_X' represents the mark for second player
	 */
	static final char LETTER_X = 'X';
}
