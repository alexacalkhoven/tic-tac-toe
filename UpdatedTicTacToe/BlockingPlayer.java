import java.io.IOException;

public class BlockingPlayer extends RandomPlayer implements Constants {

	BlockingPlayer(String name, char mark) {
		super(name, mark);
	}

	@Override
	public void makeMove() throws IOException {
		// check each element of the 2D array for blocking possibility
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (testForBlocking(row, col) == true) {
					while (!board.addMark(row, col, mark)) {
					}
					return;
				}
			}
		}
		// if no blocking, goto random
		super.makeMove();
	}

	private boolean testForBlocking(int row, int col) {
		// ASSUMES A 3x3 BOARD
		// Check each row, each col then both diagonals
		char oMark = opponent.mark; // checking for the opponent's marks

		// has to be an open space if you want to block anything
		if (board.getTheBoard()[row][col] != SPACE_CHAR)
			return false;

		// Check horizontally
		int countH = 0;
		for (int c = 0; c < 3; c++) {
			if (c != col) {
				if (board.getTheBoard()[row][c] == oMark)
					countH++;
			}
		}
		if (countH == 2)
			return true;

		// Check vertically
		int countV = 0;
		for (int r = 0; r < 3; r++) {
			if (r != row) {
				if (board.getTheBoard()[r][col] == oMark)
					countV++;
			}
		}
		if (countV == 2)
			return true;

		// check diagonals
		if (diag1Available(row, col) == true) {
			int countD1 = 0;
			for (int r = 0, c = 0; r < 3 && c < 3; r++, c++) {
				if (r != row && c != col) {
					if (board.getTheBoard()[r][c] == oMark)
						countD1++;
				}
			}
			if (countD1 == 2)
				return true;
		}

		if (diag2Available(row, col) == true) {
			int countD2 = 0;
			for (int r = 2, c = 0; r < 3 && c < 3; r--, c++) {
				if (r != row && c != col) {
					if (board.getTheBoard()[r][c] == oMark)
						countD2++;
				}
			}
			if (countD2 == 2)
				return true;
		}

		return false;
	}

	private boolean diag1Available(int r, int c) {
		if ((r == 0 && c == 0) || (r == 2 && c == 2) || (r == 1 && c == 1))
			return true;
		return false;
	}

	private boolean diag2Available(int r, int c) {
		if ((r == 0 && c == 2) || (r == 2 && c == 0) || (r == 1 && c == 1))
			return true;
		return false;
	}
}
