package L04_JaggedArrayNEmptyArray;

public class J_03ReturnSubsetSumToK {

	public static void main(String[] args) {
		int input[] = {17, 18, 6, 11, 2, 4};
		int k = 6;
		int output[][] = subsetsSumK(input, k);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}
	// Return a 2D array that contains all the subsets which sum to k
	public static int[][] subsetsSumK(int input[], int k) {
		// Write your code here
        // JUST REMEMBER THE LEAPPPP OF FAITHHHHHHHH
        return subsetsSumK(input, k, 0);
    }
    
    public static int[][] subsetsSumK(int input[], int k, int si) {
        if(si == input.length){
            if(k==0){
                int ans[][] = new int[1][0];
                return ans;
            }else{
               	int ans[][] = new int[0][0];
            	return ans;
            }  
        }
        
        int[][] output2 = subsetsSumK( input, k, si+1);
		int[][] output1 = subsetsSumK( input, k-input[si], si+1);
        
        int output[][] = new int[output1.length+output2.length][];
        int p = 0;
        for(int i = 0; i < output1.length; i++){
            output[p] = new int[output1[i].length + 1];
            output[p][0] = input[si];
            for(int j = 1; j < output1[i].length+1; j++){
                output[p][j] = output1[i][j-1];
            }
            p++;
        }
        for(int i = 0; i < output2.length; i++){
            output[p] = new int[output2[i].length];
            for(int j = 0; j < output2[i].length; j++){
                output[p][j] = output2[i][j];
            }
            p++;
        }

        return output;
    }
}
