package Server;

/**
 * Class assigns players and their opponents. Takes mark from the player,
 * handles the movements of players in the game.
 * 
 * @author Neha Singh, Sanyam
 *
 */
public class Player {
		
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
