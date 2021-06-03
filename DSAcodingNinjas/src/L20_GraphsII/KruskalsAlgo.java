/*
 *Kruskal's Algorithm: Can be implemented on connected, undirected, weighted graphs.
 * Spanning Tree: V=n, E=n-1
 * MST: Tree with min. weight.
 * 
 * To find MST:
 * 1. Select n vertices.
 * 2. Selected n-1 edges in the order of increasing weight.
 * 3. Cycle detection:
 * a) By checking on vertices: Nah. Fail.
 * b) Path checking: Time Complexity: O(V+E)
 * c) Union Finding: based on Connected Components.
 * 	  Time Complexity: O(V)
 * 
 * STEPS FOR KRUSKAL'S ALGORITHM
 * 1. Take Input.
 * 2. Sort the input array-ascending order.
 * 3. count = 0
 * 	  while(count!=n-1){
 * 		check currentE
 * 		cycle detection
 * 
 * Time Complexity: e loge(sorting algo) + ev(parent & cycle detection)
 * 
 * Union by rank & path compression
 */

package L20_GraphsII;

import java.util.Arrays;
import java.util.Scanner;

public class KruskalsAlgo {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int e = s.nextInt();
		edge input[] = new edge[e];
		for(int i = 0; i<e; i++) {
			input[i] = new edge();
			input[i].sv = s.nextInt();
			input[i].ev = s.nextInt();
			input[i].weight = s.nextInt();
		}
		kruskals(input,n);
	}
	
	public static void kruskals(edge[] input, int n) {
		Arrays.sort(input);
		edge output[] = new edge[n-1];
		int count=0;
		int i = 0;
		int[] parent = new int[n];
		for(int j = 0; j<n; j++) {
			parent[j] = j;
		}
		
		while(count!=n-1) {
			edge currentEdge = input[i];
			
			int sourceParent = findParent(currentEdge.sv, parent);
			int destParent = findParent(currentEdge.ev, parent);
			
			if(sourceParent != destParent) {
				output[count] = currentEdge;
				count++;
				parent[sourceParent] = destParent;
			}
			i++;
		}
		
		for(int j = 0; j<n-1; j++) {
			if(output[j].sv<output[j].ev) {
				System.out.println(output[j].sv + " "+output[j].ev + " " + output[j].weight);
			}else {
				System.out.println(output[j].ev + " "+output[j].sv + " " + output[j].weight);
			}
		}
	}
	
	private static int findParent(int v, int[] parent) {
		if(parent[v]==v) return v;
		return findParent(parent[v], parent);
	}

	static class edge implements Comparable<edge>{
        int sv;
        int ev;
        int weight;
		@Override
		public int compareTo(edge o) {
			return this.weight-o.weight;
		}
    }

}
