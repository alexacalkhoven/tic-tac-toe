import java.io.IOException;

/**
 * Facilitates the game setup, including assigning the opponents to each player,
 * and starting the first play.
 * 
 * @author Alexa Calkhoven
 * @since Feb 05 2020
 */
public class Referee {

	Player xPlayer;
	Player oPlayer;
	Board board;

	/**
	 * Sets everything to null by default, to be set through the Game class.
	 */
	Referee() {
		xPlayer = null;
		oPlayer = null;
		board = null;
	}

	/**
	 * Starts the game by setting opponents, displaying the (empty) board, and
	 * prompting the X Player to make the first move.
	 */
	public void runTheGame() throws IOException {
		// calls setOpponent in Player to set opponents
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		// initiates the game by displaying the board
		board.display();
		// Call play method for x-player (first)
		xPlayer.play();
	}

	/**
	 * Sets a Board to the Referee.
	 * 
	 * @param board A Board object to be assigned to the Referee.
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Sets an xPlayer to the Referee.
	 * 
	 * @param xPlayer A Player object that uses the 'X' marks to be assigned to the
	 *                Referee.
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}

	/**
	 * Sets an oPlayer to the Referee.
	 * 
	 * @param oPlayer A Player object that uses the 'O' marks to be assigned to the
	 *                Referee.
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}
}
