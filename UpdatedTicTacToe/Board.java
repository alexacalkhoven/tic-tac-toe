//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/**
 * Manages an array which represents the game board. Displays Xs and Os
 * appropriately based on what has been played.
 */
public class Board implements Constants {
	private char theBoard[][];
	private int markCount;

	/**
	 * Constructs a 3 by 3 array of chars to keep track of the Xs and Os placed.
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
	
	public char[][] getTheBoard() {
		return theBoard;
	}

	/**
	 * Returns the token (an X, an O, or a blank space) at the requested location.
	 * 
	 * @param row Number of row you want to access in the array.
	 * @param col Number of col you want to access in the array.
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * Returns true if the board is full, returns false if there are still open
	 * spaces.
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * Returns true if the X has 3 in a row in the array.
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Returns true if the O has 3 in a row in the array.
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Diplays the current array contents in a 3x3 grid.
	 */
	public void display() {
		System.out.print("\n");
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
	 * Adds a player's token to the board at a certain place.
	 * 
	 * @param row  The number of row you want to place the mark.
	 * @param col  The number of col you want to place the mark.
	 * @param mark Will be either an 'X' or an 'O' depending on which mark you want
	 *             to place.
	 */
	public boolean addMark(int row, int col, char mark) {
		if (theBoard[row][col] == SPACE_CHAR) {
			theBoard[row][col] = mark;
			markCount++;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Clears all tokens in the board, fills the array with spaces.
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * Checks for 3 in a row for a given mark (X or O).
	 * 
	 * @param mark Checks for either an X or O winner based on this input.
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
	 * Sets up the column headers for the board when being displayed on the console.
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * Sets up the rows and columns for the board when being displayed on the
	 * console.
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * Sets up the rows and columns for the board when being displayed on the
	 * console.
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
