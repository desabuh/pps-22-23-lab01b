package e1;

import java.util.*;
import java.util.stream.Stream;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final Random random = new Random();
	private final int size;


	private Movement<Pair<Integer, Integer>> movement;

	 
    public LogicsImpl(int size){
		this(size, () -> Stream.generate(() -> new Pair<>(new Random().nextInt(size), new Random().nextInt(size)) ).iterator());
    }

	public LogicsImpl(final int size, PositionsGenerationStrategy<Pair<Integer,Integer>> strategy) {
		this(size, strategy.getPositionIterator().next(), strategy.getPositionIterator().next());
	}

	public LogicsImpl(final int size, final Pair<Integer,Integer> knightPosition,final Pair<Integer, Integer> pawnPosition) {
		this.size = size;
		this.knight = knightPosition;
		this.pawn = pawnPosition;
	}

	@Override
	public boolean hit(int row, int col) {

		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight
		int x = row-this.knight.getX();
		int y = col-this.knight.getY();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			this.knight = new Pair<>(row,col);
			return this.pawn.equals(this.knight);
		}
		return false;

		/*
		Optional<Pair<Integer,Integer>> destination = this.movement.move(new Pair<>(row, col));
		if(destination.isPresent()) {
			this.knight = destination.get();
		}
		return destination.isPresent();

		 */

	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}

}
