package L04_JaggedArrayNEmptyArray;

public class J_01ReturnSubset {
	
	public static void main(String[] args) {
		int input[] = {15, 20, 12};
		int output[][] = subsets(input);
		for(int i = 1; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// Return a 2D array that contains all the subsets
	public static int[][] subsets(int input[]) {
		// Write your code here
		if(input.length == 0) {
            int[][] ans = new int[1][0]; 
            return ans;
        }
        
        int[] smallInput = new int[input.length-1];
        for (int i = 0; i < input.length-1; i++){
            smallInput[i] = input[i+1];
        }
        int[][] smallAns = subsets(smallInput);
        
        int[][] ans = new int[2*smallAns.length][];
        int i = 0;
        if(smallAns.length > 1) {
        
	        for (i = 1; i < smallAns.length; i++) {
	        	ans[i] = new int[smallAns[i].length];
	            for (int j = 0; j < smallAns[i].length; j++){
	                ans[i][j] = smallAns[i][j];
	            }
	        }
        }

        ans[smallAns.length] = new int[1];
        ans[smallAns.length][0] = input[0]; 
        i = 1;
        for (; i < smallAns.length; i++){
        	ans[smallAns.length+i] = new int[smallAns[i].length+1];
        	ans[smallAns.length+i][0] = input[0]; 
            for (int j = 1; j < smallAns[i].length + 1; j++){
                ans[smallAns.length+i][j] = smallAns[i][j-1];
            }
        }
        return ans;
	}

}
