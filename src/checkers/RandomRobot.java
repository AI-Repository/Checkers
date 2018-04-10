package checkers;

import java.util.Random;
import java.util.Vector;

public class RandomRobot {

	private static Random random = new Random();

	/*
	 * MOVE
	 */
	public static void makeNextWhiteMoves() {
		// see next moves
		Vector<Vector<Move>> movs = Robot.expandMoves(Game.board, Player.white);

		// get random movement
		int index = random.nextInt(movs.size());
		Vector<Move> resultantMoveSeq = movs.get(index);

		// Apply the move to the game board.
		for (Move m : resultantMoveSeq) {
			Game.board.genericMakeWhiteMove(m);
		}

		System.out.print("Random Robot's Move was ");
		UserInteractions.DisplayMoveSeq(resultantMoveSeq);
		System.out.println();

		check();
	}

	public static void makeNextBlackMoves() {
		Vector<Vector<Move>> movs = Robot.expandMoves(Game.board, Player.black);

		// get random movement
		int index = random.nextInt(movs.size());
		Vector<Move> resultantMoveSeq = movs.get(index);

		// Apply the move to the game board.
		for (Move m : resultantMoveSeq) {
			Game.board.genericMakeWhiteMove(m);
		}

		System.out.print("Random Robot's Move was ");
		UserInteractions.DisplayMoveSeq(resultantMoveSeq);
		System.out.println();
	}

	private static void check() {
		CellEntry[][] pieces = Game.board.cell;

		for (int i = 0; i < Game.board.cols; i++) {
			for (int j = 0; j < Game.board.rows; j++) {
				if(pieces[i][j].equals(CellEntry.black)) {
					
				}
			}
		}
	}
}
