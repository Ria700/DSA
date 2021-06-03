package L19_Graphs;

import java.util.*;

public class Graph {
	
	public static void main(String[] args) {
		int n;
		int e;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		e = s.nextInt();
		int edges[][] = new int[n][n];
		for (int i = 0; i < e; i++) {
			int fv = s.nextInt();
			int sv = s.nextInt();
			edges[fv][sv] = 1;
			edges[sv][fv] = 1;
		}
		printDFS(edges);
		printBFS(edges);
	}
	
	public static void printDFS(int edges[][]) {
		boolean[] visited = new boolean[edges.length];
		for(int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				printhelperDFS(edges, i, visited);
			}
		}
		System.out.println();
	}

	private static void printhelperDFS(int[][] edges, int sv, boolean[] visited) {
		System.out.print(sv+" ");
		visited[sv] = true;
		int n = edges.length;
		for(int i = 0; i < n; i++) {
			if(edges[sv][i]==1 && !visited[i]) {
				printhelperDFS(edges, i, visited);
			}
		}
	}
	
	public static void printBFS (int edges[][]) {
		boolean[] visited = new boolean[edges.length];
		for(int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				printhelperBFS(edges, i, visited);
			}
		}
		System.out.println();
	}

	private static void printhelperBFS(int[][] edges, int sv, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
		int n = edges.length;
		
        while(!q.isEmpty()) {
            int frontNode = q.remove();
            System.out.print(frontNode+" ");
            visited[frontNode] = true;
            for(int i = 0; i < n; i++) {
                if(edges[frontNode][i]==1 && !visited[i] && !q.contains(i)) {
                    q.add(i);
                }
			}
        }
	}
	
	public static boolean hasPathDFS(int[][] edges, int stv, int env, boolean visited[]) {
        int n = edges.length;
        if(stv<0 || env>=n || stv>=n || env<0) return false;
        
        if(edges[stv][env]==1) return true;
        
        
        visited[stv] = true;
		for(int i = 0; i < n; i++) {
			if(edges[stv][i]==1 && !visited[i]) {
				return hasPathDFS(edges, i, env, visited);
			}
		}
        return false;
    }
	
	public static boolean hasPathBFS(int[][] edges, int stv, int env, boolean visited[]) {
		int n = edges.length;
        if(stv<0 || env>=n || stv>=n || env<0) return false;
        
        if(edges[stv][env]==1) return true;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(stv);
		
        while(!q.isEmpty()) {
            int frontNode = q.remove();
            
            visited[frontNode] = true;
            for(int i = 0; i < n; i++) {
                if(edges[frontNode][i]==1 && !visited[i] && !q.contains(i)) {
                    if(i==env) return true;
                    q.add(i);
                }
			}
        }
		return false;
    }

	
	public static ArrayList<Integer> getPathDFS(int[][] edges, int stv, int env, boolean visited[]) {
        int n = edges.length;
       if(stv<0 || env>=n || stv>=n || env<0) return null;
        
        ArrayList<Integer> ans = new ArrayList<>();
        if(stv==env){
            ans.add(env);
            return ans;
        }
        
        visited[stv] = true;
		for(int i = 0; i < n; i++) {
			if(edges[stv][i]==1 && !visited[i]) {
				ans = getPathDFS(edges, stv, env, visited);
                if(ans!=null){
                    ans.add(0, stv);
                    return ans; // to print the first path encountered
                }
			}
		}
        return ans; 
    }
	
	public static void getPathBFS(int[][] edges, int stv, int env, boolean visited[]) {
    	int n = edges.length;
       	if(stv<0 || env>=n || stv>=n || env<0) return;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        Queue<Integer> q = new LinkedList<>();
        q.add(stv);
		
        while(!q.isEmpty()) {
            int frontNode = q.remove();
            
            visited[frontNode] = true;
            for(int i = 0; i < n; i++) {
                if(edges[frontNode][i]==1 && !visited[i] && !q.contains(i)) {
                    map.put(i, frontNode);
                    if(i==env){
                        printPathBFS(map, stv, i);
                        System.out.println(stv);
                    }
                    q.add(i);
                }
			}
        }
	}
    
    public static void printPathBFS(HashMap<Integer, Integer> map, int stv, int env) {
        System.out.print(env+" ");
        int parent = map.get(env);
        if(parent!=stv) {
            printPathBFS(map, stv, parent);
        }
    }
	
    public static ArrayList<ArrayList<Integer>> connectedCompDFS(int edges[][]) {
		boolean[] visited = new boolean[edges.length];
        ArrayList<ArrayList<Integer>> compAll = new ArrayList<>();
        
		for(int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
				connectedCompHelperDFS(edges, i, visited, comp);
                compAll.add(comp);
			}
		}
		return compAll;
	}

	private static void connectedCompHelperDFS(int[][] edges, int sv, boolean[] visited, ArrayList<Integer> comp) {
		comp.add(sv);
        visited[sv] = true;
		int n = edges.length;
		for(int i = 0; i < n; i++) {
			if(edges[sv][i]==1 && !visited[i]) {
				connectedCompHelperDFS(edges, i, visited, comp);
			}
		}
        
	}	

}
