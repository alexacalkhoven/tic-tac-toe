import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Manages each of the two players, prompting them to make their moves and
 * checking if the game is over.
 * 
 * @author Alexa Calkhoven
 * @since Feb 05 2020
 */
abstract public class Player {

	//protected - almost like private except child classes can access
	protected String name;
	protected Board board;
	protected Player opponent;
	protected char mark;

	/**
	 * Assigns a name and either the X or O to the Player.
	 * 
	 * @param name The name to be assigned to the Player.
	 * @param mark Either an 'X' or an 'O' to be assigned to the Player.
	 */
	Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}

	/**
	 * If the game has not ended, the player is prompted to make their move, and the
	 * board is then displayed based on the move.
	 */
	public void play() throws IOException {
		// calls makeMove as long as xWin, oWin and isFull returns false
		if (toContinue()) {
			makeMove();
			board.display();
			opponent.play();
		} else
			gameOver();
	}

	/**
	 * Requests the row and column value for where the player wants to place their
	 * mark.
	 */
	abstract public void makeMove() throws IOException;
		/*
		// asks player which row and column number
		// puts X or O on the board by calling addMark
		while (!board.addMark(requestNum("row"), requestNum("col"), mark)) {

		}
		*/

	/**
	 * Assigns an opponent Player to the Player
	 * 
	 * @param opp The opposing player.
	 */
	public void setOpponent(Player opp) {
		// connects the other player to this player
		opponent = opp;
	}

	/**
	 * Sets a Board to the Player
	 * 
	 * @param theBoard The board to be used for the game.
	 */
	public void setBoard(Board theBoard) {
		board = theBoard;
	}

	/**
	 * Tests for a winner or if the board is full, returns true if the game should
	 * continue.
	 */
	private boolean toContinue() {
		if (board.xWins() == true || board.oWins() == true || board.isFull() == true)
			return false;
		return true;
	}

	/**
	 * Executes the gameover messages.
	 */
	public void gameOver() {
		if (board.xWins() == true || board.oWins() == true)
			System.out.println("\nGameover. " + opponent.name + " wins!");
		else
			System.out.println("\nGameover. It's a tie!");
		board.clear();
		System.out.println("Exiting now. Play again! ☺");
		System.exit(0);
	}

	/**
	 * Asks the user for the row and column values for their next token to go.
	 * 
	 * @param label Displays either "row" or "col" depending on what value is
	 *              desired.
	 */
	public int requestNum(String label) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\n" + name + ", what " + label + " should your next " + mark + " be placed in? ");
		int num = Integer.parseInt(stdin.readLine());
		while (num != 0 && num != 1 && num != 2) {
			System.out.print("The only options are 0, 1 and 2! Try again: ");
			num = Integer.parseInt(stdin.readLine());
		}
		return num;
	}
}
