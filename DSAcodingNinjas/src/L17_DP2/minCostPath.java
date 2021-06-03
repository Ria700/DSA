package L17_DP2;

public class minCostPath {

	public static int minCostPathR(int[][] input) {
		//Your code goes here
        return minCostPathR(input, 0, 0);
	}
    
    private static int minCostPathR(int[][] input, int i, int j) {
        int m = input.length;
        int n = input[0].length;
        if(i<0 || j<0 || i > m-1 || j>n-1){
            return Integer.MAX_VALUE;
        }
        if(i == m-1 && j == n-1){
            return input[i][j];
        }
        int op1 = minCostPathR(input, i, j+1);
        int op2 = minCostPathR(input, i+1, j+1);
        int op3 = minCostPathR(input, i+1, j);
        
        return (input[i][j] + Math.min(op1, Math.min(op2, op3)));
    }
    
    public static int minCostPathM(int[][] input) {
    	int m = input.length;
        int n = input[0].length;
    	int[][] storage=new int[m][n];
    	for(int a = 0; a < m; a++) {
    		for(int b = 0; b < n; b++) {
    			storage[a][b]=-1;
    		}
    	}
    	return minCostPathM(input, 0, 0, storage);
    }
    
    private static int minCostPathM(int[][] input, int i, int j, int[][] storage) {
    	int m = input.length;
        int n = input[0].length;
        
    	if(i>=m || j>=n){
            return Integer.MAX_VALUE;
        }
    	
    	if(i == m-1 && j == n-1){
    		storage[i][j] = input[i][j];
            return storage[i][j];
        }
    	
    	if(storage[i][j]!=-1) {
    		return storage[i][j];
    	}
    	
    	int op1 = minCostPathM(input, i, j+1, storage);
        int op2 = minCostPathM(input, i+1, j+1, storage);
        int op3 = minCostPathM(input, i+1, j, storage);
        
        storage[i][j] = input[i][j] + Math.min(op1, Math.min(op2, op3));
        return storage[i][j];
    }
    
    public static int minCostPathDP(int[][] input) {
    	int m = input.length;
        int n = input[0].length;
        int storage[][] = new int[m][n];
        
        storage[m-1][n-1] = input[m-1][n-1];
        
        // Last row
        for(int j = n-2; j >= 0; j--) {
        	storage[m-1][j] = storage[m-1][j+1] + input[m-1][j];
        }
        
        // Last column
        for(int i = m-2; i >=0; i--) {
        	storage[i][n-1] = storage[i+1][n-1] + input[i][n-1];
        }
        
        for(int i = m-2; i>=0; i--) {
         	for(int j = n-2; j >= 0; j--) {
        		storage[i][j] = input[i][j] + Math.min(storage[i][j+1], Math.min(storage[i+1][j+1], storage[i+1][j]));
        	}
        }
        
        return storage[0][0];
    }
    
	public static void main(String[] args) {
		int arr[][] = {{1, 1, 1}, {4, 5, 2}, {7, 8, 9}};
		System.out.println(minCostPathDP(arr));
		System.out.println(minCostPathM(arr));
		System.out.println(minCostPathR(arr));
	}

}
