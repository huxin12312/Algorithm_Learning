package sokdu;

import java.util.Random;;

public class Sudoku {

	public void init(int[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = 0;
			}
		}
	}

	public int modelchoicec(int NUM) {
		if (NUM > 3 || NUM < 1)
			return 0;
		else
			return NUM;
	}

	public void initrow(int[][] board, int row) {

		for (int i = 0; i < 9; i++) {
			board[row][i] = 0;
		}
	}

	public int[][] start() {

		int board[][] = new int[9][9];
		for (int i = 0; i < 9; i++) {
			if (i == 0) {
				board[i] = SetNumber();
			}

			else {
				int[] temp = SetNumber();

				for (int j = 0; j < 9; j++) {
					if (sudokuset(board, temp, i, j) == false) {

						initrow(board, i);
						i -= 1;
						j = 8;
						temp = SetNumber();

					}
				}
			}
		}
		return board;
	}

	public boolean sudokuset(int[][] board, int[] randomarray, int row, int col) {
		for (int i = 0; i < randomarray.length; i++) {

			board[row][col] = randomarray[i];
			if (sudokuchecker(board, row, col))
				return true;
		}

		return false;
	}

	public boolean sudokuchecker(int[][] board, int row, int col) {
		return (rowchecker(board, row, col) && colchecker(board, row, col) && blockchecker(board, row, col));

	}

	public boolean rowchecker(int[][] board, int row, int col) {
		int temp = board[row][col];
		for (int i = 0; i < col; i++) {
			if (temp == board[row][i]) {
				return false;
			}
		}

		return true;
	}

	public boolean colchecker(int[][] board, int row, int col) {
		int temp = board[row][col];
		for (int i = 0; i < row; i++) {
			if (temp == board[i][col]) {
				return false;
			}
		}
		return true;
	}

	public boolean blockchecker(int[][] board, int row, int col) {
		// first thing is target the starting point of block
		int startrow = row / 3 * 3;
		int startcol = col / 3 * 3;
		int counter = 0;
		int temp = board[row][col];

		for (int i = startrow; i < startrow + 3; i++) {

			for (int j = startcol; j < startcol + 3; j++) {
				if (board[i][j] == 0)
					continue;
				if (temp == board[i][j])
					counter++;
				if (counter > 1)
					return false;
			}
		}

		/*
		 * for (int i = 0; i < 8; i++) { if (board[startrow + i / 3][startcol +
		 * i % 3] == 0) continue; for (int j = i + 1; j < 9; j++) { if
		 * (board[startrow + j / 3][startcol + j % 3] == board[startrow + i /
		 * 3][startcol + i % 3]) return false; } }
		 */

		return true;
	}

	private Random r = new Random();

	public int[] SetNumber() {

		int[] seeds = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int randomindex = 0;
		for (int i = 0; i < 30; i++) {
			randomindex = r.nextInt(8) + 1;
			int temp = seeds[randomindex];
			seeds[randomindex] = seeds[0];
			seeds[0] = temp;
		}

		return seeds;

	}

}
