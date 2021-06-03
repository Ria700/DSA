package L17_DP2;

public class LCS {
	
	public static int LCS_R(String s, String t) {
		if(s.length()==0 || t.length()==0) {
			return 0;
		}
		
		if(s.charAt(0)==t.charAt(0)) {
			return 1 + LCS_R(s.substring(1), t.substring(1));
		}else {
			int op1 = LCS_R(s, t.substring(1));
			int op2 = LCS_R(s.substring(1), t);
//			int op3 = LCS_R(s.substring(1), t.substring(1));
			return Math.max(op1, op2);
		}
	}
	
	
	public static int LCS_M(String s, String t) {
		int[][] storage = new int[s.length()+1][t.length()+1];
		for(int i = 0; i < storage.length; i++) {
			for(int j = 0; j < storage[0].length; j++) {
				storage[i][j] = -1;
			}
		}
		return LCS_M(s,t, storage);
	}
	
	private static int LCS_M(String s, String t, int[][] storage) {
		int m = s.length();
		int n = t.length();
		
		if(storage[m][n]!=-1) {
			return storage[m][n];
		}
		if(m==0 || n==0) {
			storage[m][n] = 0;
			return storage[m][n];
		}
		
		if(s.charAt(0)==t.charAt(0)) {
			storage[m][n] = 1 + LCS_M(s.substring(1), t.substring(1), storage);
			return storage[m][n];
		}else {
			int op1 = LCS_M(s, t.substring(1), storage);
			int op2 = LCS_M(s.substring(1), t, storage);
			storage[m][n] = Math.max(op1, op2);
			return storage[m][n];
		}
		
	}
	
	public static int LCS_DP(String s, String t) {
		int m = s.length();
		int n = t.length();
		int[][] storage = new int[m+1][n+1];
		
		for(int i = 0; i <= m; i++) {
			storage[0][i] = 0;
		}
		
		for(int i = 0; i <= n; i++) {
			storage[i][0] = 0;
		}
		
		for(int i = 1; i<=m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s.charAt(m-i) == t.charAt(n-j)) {
					storage[i][j] = 1 + storage[i-1][j-1];
				}else {
					storage[i][j] = Math.max(storage[i][j-1], storage[i-1][j]);
				}
			}
		}
		return storage[m][n];
	}
	
	public static void main(String[] args) {
		String s = "dgei";
		String t = "begi";
		System.out.println(LCS_DP(s, t));
		System.out.println(LCS_M(s, t));
		System.out.println(LCS_R(s, t));
	}
	
	

}
