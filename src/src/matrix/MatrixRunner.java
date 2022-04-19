package matrix;
import java.util.*;
public class MatrixRunner {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	MatrixMethod method = new MatrixMethod();
	int dial = sc.nextInt();
	
	switch(dial) {
	case 1:
	{
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] grid = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ;j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(method.sumOfMatrix(N,M,grid));
	}
		break;
		
	case 2:
	{
		int N = sc.nextInt();

		int[][] grid = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ;j++) {
				grid[i][j] = sc.nextInt();
			}
		}
        method.rotate(grid);
	}
		break;	
	case 3:
	{
		int N = sc.nextInt();

		int[][] grid = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ;j++) {
				grid[i][j] = sc.nextInt();
			}
		}
        method.transpose(grid, N);
	}
		break;
	case 4:
	{
		int r = sc.nextInt();
        int c = sc.nextInt();
		int[][] grid = new int[r][c];
		
		for(int i = 0 ; i < r ; i++) {
			for(int j = 0 ; j < c ;j++) {
				grid[i][j] = sc.nextInt();
			}
		}
        
        System.out.println(method.uniqueRow(grid, r, c));
	}
		break;
	case 5:
	{
		int r = sc.nextInt();
        int c = sc.nextInt();
		int[][] grid = new int[r][c];
		
		for(int i = 0 ; i < r ; i++) {
			for(int j = 0 ; j < c ;j++) {
				grid[i][j] = sc.nextInt();
			}
		}
        
        method.maximumOne(grid, r, c);
	}
		break;
	case 6:
	{
		int N = sc.nextInt();
        int M = sc.nextInt();
		int[][] grid = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ;j++) {
				grid[i][j] = sc.nextInt();
			}
		}
        method.setZeroes(grid);
	}
		break;
	case 7:
	{
		int N = sc.nextInt();
  
		int[][] grid = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ;j++) {
				grid[i][j] = sc.nextInt();
			}
		}
        method.matrixSorting(grid);
	}
		break;
	}
	sc.close();
}
}
