package L20_GraphsII;

import java.util.Scanner;

public class PrimsAlgo {
	
/*
 * Current Time complexity: 2 V^2
 * 
 * Prim's Algo can be made better using 
 * 1. Adjacency list in place of adjacency matrix
 * 2. Priority queue for finding minimum vertex
 * Time Complexity: (V+E) logV
 *  
 */


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();

        int[][] edges = new int[v][v];
        // for(int i =0; i<v; i++){
        //     for(int j =0; j<v; j++)
        //     edges[i][j] = -1;
        // }
        for(int i = 0; i<e; i++) {
            int sv = s.nextInt();
			int ev = s.nextInt();
            int weight = s.nextInt();
        	edges[sv][ev] = weight;
            edges[ev][sv] = weight;
        }
        prims(edges, v);
        
	}
    
    public static void prims(int[][] edges, int n) {
        boolean[] visited = new boolean[n];
        int[] weight = new int[n];
        int[] parent = new int[n];
        
        for(int i = 0; i<n; i++){
            weight[i] = Integer.MAX_VALUE;
        }
        
        weight[0] = 0;
        parent[0] = -1;
        
        for(int i = 0; i<n; i++){
            int min = minWeight(weight, visited);
            visited[min] = true;
            for(int j = 0; j<n; j++){
                if(edges[min][j] != 0 && !visited[j]) {
                    if(weight[j]>edges[min][j]){
                        weight[j] = edges[min][j];
                        parent[j] = min;
                    }
                }
            }
        }
        
        for(int j = 1; j<n; j++) {
			if(j<parent[j]) {
				System.out.println(j + " " + parent[j] + " " + weight[j]);
			}else {
				System.out.println(parent[j] + " " + j + " " + weight[j]);
			}
		}
    }
    
    public static int minWeight(int[] weight, boolean[] visited) {
        int minVertex = -1;
        for(int i = 0; i<weight.length; i++){
            if(!visited[i] && (minVertex==-1 || weight[i]<weight[minVertex])){
                minVertex = i;
            }
        }
        return minVertex;
    }
}
