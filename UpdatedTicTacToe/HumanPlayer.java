import java.io.IOException;

public class HumanPlayer extends Player{

	HumanPlayer(String name, char mark){
		super(name, mark);
	}

	@Override
	public void makeMove() throws IOException {
		// TODO Auto-generated method stub
		while (!board.addMark(requestNum("row"), requestNum("col"), mark)) {
			System.out.println("\nPick a location that isn't taken!");
		}
	}
}
