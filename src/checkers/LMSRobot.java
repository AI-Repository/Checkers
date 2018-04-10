package checkers;

public class LMSRobot {
	/*
	 * n black 
	 * n white 
	 * n black kings 
	 * n white kings 
	 * n white threatened by black 
	 * n black threatened by white
	 */
	private static double w0=1, w1, w2, w3, w4, w5, w6;
	private static int x0=1, x1, x2, x3, x4, x5, x6;

	public LMSRobot() { }

	public static void makeNextWhiteMoves() {
		evaluate();
	}

	public static void makeNextBlackMoves() {
		evaluate();
	}

	/*
	 * HEURISTIC
	 */
	private static double evaluate() {
		x1ToX4();
		x5();
		x6();

		return LMSRobot.w0 * LMSRobot.x0 + LMSRobot.w1 * LMSRobot.x1 + LMSRobot.w2 * LMSRobot.x2 + LMSRobot.w3 * LMSRobot.x3 + LMSRobot.w4 * LMSRobot.x4 + LMSRobot.w5 * LMSRobot.x5 + LMSRobot.w6 * LMSRobot.x6;
	}

	private static void x1ToX4() {
		int result1 = 0, result2 = 0, result3 = 0, result4 = 0;
		CellEntry[][] pieces = Game.board.cell;

		for (int i = 0; i < Game.board.cols; i++) {
			for (int j = 0; j < Game.board.rows; j++) {
				if (pieces[i][j].equals(CellEntry.black)) {
					result1++;
				} else if (pieces[i][j].equals(CellEntry.white)) {
					result2++;
				} else if (pieces[i][j].equals(CellEntry.blackKing)) {
					result3++;
				} else if (pieces[i][j].equals(CellEntry.whiteKing)) {
					result4++;
				}
			}
		}

		LMSRobot.x1 = result1;
		LMSRobot.x2 = result2;
		LMSRobot.x3 = result3;
		LMSRobot.x4 = result4;
	}

	//n white threatened by black 
	private static void x5() {
		int result=0;
		CellEntry[][] pieces = Game.board.cell;
		
		for (int i = 0; i < Game.board.cols; i++) {
			for (int j = 0; j < Game.board.rows; j++) {
				if(pieces[i][j].equals(CellEntry.black)) {
					//nort left
					try {
						if(pieces[i+1][j-1].equals(CellEntry.white) && pieces[i+2][j-2].equals(CellEntry.empty)) {
							result++;
						}
					} catch (Exception e) { }
					
					//nort right
					try {
						if(pieces[i+1][j+1].equals(CellEntry.white) && pieces[i+2][j+2].equals(CellEntry.empty)) {
							result++;
						}
					} catch (Exception e) { }
					
					//south right
					try {
						if(pieces[i-1][j+1].equals(CellEntry.white) && pieces[i-2][j+2].equals(CellEntry.empty)) {
							result++;
						}
					} catch (Exception e) { }
					
					//south left
					try {
						if(pieces[i-1][j-1].equals(CellEntry.white) && pieces[i-2][j-2].equals(CellEntry.empty)) {
							result++;
						}
					} catch (Exception e) { }
				}
			}
		}
		
		LMSRobot.x5 = result;
	}

	//n black threatened by white 
	private static void x6() {
		int result=0;
		CellEntry[][] pieces = Game.board.cell;
		
		for (int i = 0; i < Game.board.cols; i++) {
			for (int j = 0; j < Game.board.rows; j++) {
				if(pieces[i][j].equals(CellEntry.white)) {
					//nort left
					try {
						if(pieces[i+1][j-1].equals(CellEntry.black) && pieces[i+2][j-2].equals(CellEntry.empty)) {
							result++;
						}
					} catch (Exception e) { }
					
					//nort right
					try {
						if(pieces[i+1][j+1].equals(CellEntry.black) && pieces[i+2][j+2].equals(CellEntry.empty)) {
							result++;
						}
					} catch (Exception e) { }
					
					//south right
					try {
						if(pieces[i-1][j+1].equals(CellEntry.black) && pieces[i-2][j+2].equals(CellEntry.empty)) {
							result++;
						}
					} catch (Exception e) { }
					
					//south left
					try {
						if(pieces[i-1][j-1].equals(CellEntry.black) && pieces[i-2][j-2].equals(CellEntry.empty)) {
							result++;
						}
					} catch (Exception e) { }
				}
			}
		}
		
		LMSRobot.x6 = result;
	}
}
