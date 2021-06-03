package L_Backtracking;

import java.util.Scanner;

public class RatInAMazeProblem {

	public static boolean ratInAMaze(int maze[][]){
		int n = maze.length;
        int[][] path = new int[n][n];
        printAllPaths(maze, 0, 0, path);
        return solveMaze(maze, 0, 0, path);
        
	}
    
    public static boolean solveMaze(int maze[][], int i, int j, int path[][]){
        int n = maze.length;
        if(i < 0 || i >= n || j < 0 || j >=n || maze[i][j]==0 || path[i][j]==1){
            return false;
        }
        path[i][j] = 1;
        if(i == n-1 && j == n-1){
            return true;
        }
        if(solveMaze(maze, i-1, j, path)){
            return true;
        }
        if(solveMaze(maze, i, j+1, path)){
            return true;
        }
        if(solveMaze(maze, i+1, j, path)){
            return true;
        }
        if(solveMaze(maze, i, j-1, path)){
            return true;
        }
        return false;
    }
	
    public static void printAllPaths(int maze[][], int i, int j, int path[][]){
    	int n = maze.length;
        if(i < 0 || i >= n || j < 0 || j >=n || maze[i][j]==0 || path[i][j]==1){
            return;
        }
        path[i][j] = 1;
        if(i == n-1 && j == n-1){
            for(int r = 0; r < n ; r++){
                for(int c = 0; c < n; c++){
                    System.out.print(path[r][c] + " ");
                }
            }
            path[i][j]=0;
            System.out.println();
            return;
        }
        printAllPaths(maze, i-1, j, path);
        printAllPaths(maze, i, j+1, path);
        printAllPaths(maze, i+1, j, path);
        printAllPaths(maze, i, j-1, path);
		path[i][j]=0;
    }
    
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int maze[][] = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				maze[i][j] = s.nextInt();
			}
		}
		System.out.println(ratInAMaze(maze));	

	}
	
	

}
