package matrix;

import java.util.ArrayList;

public class StringGrid {

	static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public int[][] searchWord(char[][] grid, String word) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (search(grid, row, col, word)) {
					ArrayList<Integer> num = new ArrayList<>();
					num.add(row);
					num.add(col);
					list.add(num);
				}
			}
		}

		int[][] result = new int[list.size()][2];

		for (int i = 0; i < result.length; i++) {
			result[i][0] = list.get(i).get(0);
			result[i][1] = list.get(i).get(1);
		}

		return result;

	}

	static boolean search(char[][] grid, int row, int col, String word) {

		if (grid[row][col] != word.charAt(0)) {
			return false;
		}

		for (int dir = 0; dir < 8; dir++) {
			int k, rd = row + x[dir], cd = col + y[dir];

			int wordLen = word.length();

			for (k = 1; k < wordLen; k++) {

				if (rd >= grid.length || rd < 0 || cd >= grid[0].length || cd < 0) {
					break;
				}

				if (grid[rd][cd] != word.charAt(k)) {
					break;
				}
				rd += x[dir];
				cd += y[dir];
			}

			if (k == wordLen) {
				return true;
			}
		}

		return false;
	}

}
