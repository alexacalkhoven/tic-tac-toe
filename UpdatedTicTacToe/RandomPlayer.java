import java.io.IOException;

public class RandomPlayer extends Player{
		
	RandomPlayer(String name, char mark){
		super(name, mark);
	}

	@Override
	public void makeMove() throws IOException {
		RandomGenerator ran = new RandomGenerator();
		while (!board.addMark(ran.discrete(0,2), ran.discrete(0,2), mark)) {
		}
	}
}
