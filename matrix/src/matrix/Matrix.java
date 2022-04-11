package matrix;

public class Matrix {
	   int sumOfMatrix(int N, int M, int[][] Grid) {
		     int out=0;
		      for(int i=0;i<N;i++)
		      {
		          for(int j=0;j<M;j++)
		          {
		             out+=Grid[i][j];
		          }
		      }
		      return out;
		    }

}
