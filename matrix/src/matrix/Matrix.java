package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Matrix {
	int sumOfMatrix(int N, int M, int[][] Grid) {
		int out = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				out += Grid[i][j];
			}
		}
		return out;
	}

	void matrixSort(int[][] Grid, int N) {
		int[] out = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					out[i] = Grid[i][j];
				}
			}
		}
		Arrays.sort(out);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					Grid[i][j] = out[i];
				}
			}
		}
		System.out.println(Arrays.deepToString(Grid));
	}

	public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][], int r, int c) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				tempList.add(a[i][j]);
			}
			ArrayList<Integer> tempList1 = new ArrayList<Integer>();
			tempList1.addAll(tempList);
			if (!list.contains(tempList1)) {
				list.add(tempList1);
			}
			tempList.clear();
		}
		return list;
	}

	static int[][] transpose(int matrix[][], int n) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		return matrix;
	}

	public void setZeroes(int[][] matrix) {
		int temp = 0;
		int temp1 = 0;
		int n = matrix.length;
		int m = matrix[0].length;
		System.out.println("The length is " + n);
		int[][] matrix1 = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix1[i][j] = matrix[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0) {
					temp = i;
					temp1 = j;
					tempMethod(matrix1, temp, temp1);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = matrix1[i][j];
			}
		}
		System.out.println(Arrays.deepToString(matrix));
	}

	public void tempMethod(int[][] matrix, int temp, int temp1) {
		int j = 0;
		for (int i = temp; j < matrix[0].length;) {
			for (j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = 0;

			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (j = temp1; i < matrix.length;) {
				matrix[i][j] = 0;
				break;

			}
		}
	}

	static int isSuperSimilar(int n, int m, int mat[][], int x) {
		int temp = 1;
		int count = 0;
		int[][] matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = mat[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			int[] temp2 = mat[n - 1];
			for (int j = n - 1; j > 0; j--) {
				mat[j] = mat[j - 1];
			}
			mat[i] = temp2;
			temp++;
			if (x == temp + 1) {
				break;
			}
		}
		if (Arrays.deepEquals(matrix, mat)) {
			return 1;
		}
		return 0;
	}

	static void rotate(int matrix[][]) {

		int n = matrix.length;
		int temp[][] = new int[n][n];
		int k = 0;
		for (int j = n - 1; j >= 0; j--, k++) {
			for (int i = 0; i < n; i++) {
				temp[k][i] = matrix[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = temp[i][j];
			}
		}
	}

	public int maximalRectangle(char[][] matrix) {
		int count = 0;
		int max = 0;
		int h = 0;
		int l = 0;
		while (matrix.length == 1 && l < matrix[0].length) {
			if (matrix[h][l] == '1') {
				count++;
			}
			if (l == matrix[0].length - 1) {
				return count;
			}
			l++;
		}
		while (matrix.length == 2 && l < matrix[0].length && h < matrix.length) {
			if (matrix[h][l] == '1') {
				count++;
			}
			if (l == matrix[0].length - 1 && h != matrix.length - 1) {
				h++;
				l = 0;
				continue;
			}
			if (l == matrix[0].length - 1 && h == matrix.length - 1) {
				return count;
			}
			l++;
		}

		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				count = 0;
				while (j < matrix[0].length && matrix[i][j] == '1' && matrix[i + 1][j] == '1') {
					count++;
					j++;
				}
				if (count > max) {
					max = count;
				}
			}
		}
		return 2 * max;
	}

	public int maximumOnes(int[][] matrix) {
		int min = Integer.MIN_VALUE;
		int count = 0;
		int temp=0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					count++;
				}
			}
			if(count>min)
			{
				temp=i;
				min=count;
			}
			//min = Math.max(count, min);
			count = 0;
		}
		return temp;
	}

	public static void main(String[] args) {
		Matrix mObj = new Matrix();
		Scanner scan = new Scanner(System.in);
		int val = scan.nextInt();
		switch (val) {
		case 1: {
			int[][] Grid = { { 5, 2, 0, 7, 1 }, { 3, 4, 2, 9, 14 }, { 5, 1, 3, 5, 2 }, { 4, 2, 6, 2, 1 },
					{ 0, 6, 3, 5, 1 } };
			mObj.matrixSort(Grid, 5);
			break;
		}
		case 2: {
			int[][] temp = { { 1, 1, 0, 1 }, { 1, 0, 0, 1 }, { 1, 1, 0, 1 } };
			System.out.println(uniqueRow(temp, 3, 4));
			break;
		}
		case 3: {
			int[][] Grid = { { 5, 2, 0, 7, 1 }, { 3, 4, 2, 9, 14 }, { 5, 1, 3, 5, 2 }, { 4, 2, 6, 2, 1 },
					{ 0, 6, 3, 5, 1 } };
			System.out.print(mObj.sumOfMatrix(5, 5, Grid));
			break;
		}
		case 4: {
			int mat[][] = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 } };
			System.out.println(Arrays.deepToString(transpose(mat, mat.length)));
			break;
		}
		case 5: {
			int mat[][] = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 } };
			System.out.println(mObj.maximumOnes(mat));
			break;
		}
		case 6: {
			int mat[][] = { { 0, 1 } };
			mObj.setZeroes(mat);
			break;
		}
		case 7: {
			int mat[][] = { { 1, 2, 1, 2 }, { 2, 1, 2, 1 } };
			System.out.println(isSuperSimilar(mat.length, mat[0].length, mat, 2));
			break;
		}

		case 8: {
			char mat[][] = { { '0', '1' }, { '1', '0' } };
			System.out.println(mObj.maximalRectangle(mat));
			break;
		}

		default:
			break;
		}

	}

}
