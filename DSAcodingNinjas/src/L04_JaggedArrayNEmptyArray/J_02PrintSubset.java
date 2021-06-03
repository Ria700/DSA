package L04_JaggedArrayNEmptyArray;

public class J_02PrintSubset {
// return statement is veryyy important PRINT questions
	public static void main(String[] args) {
		int input[] = {1, 2, 3};
		printSubsets(input);
	}
	
	public static void printSubsets(int input[]) {
		// Write your code here
        int output[] = {}; 
        printSubsets(input, output);
	}
    
    public static void printSubsets(int input[], int output[]) {
        if(input.length == 0){
            for (int i = 0; i < output.length; i++){
                System.out.print(output[i]+" ");
            }
        	System.out.println();
            return;
        }
        int smallInput[] = new int[input.length-1];
        int i = 0;
        for(i = 0; i < smallInput.length; i++){
            smallInput[i] = input[i+1];
        }
        printSubsets(smallInput, output);
        int[] out =  new int[output.length+1];
        for(i = 0; i < output.length; i++){
            out[i] = output[i];
        }
        out[i] = input[0];
       	printSubsets(smallInput, out);
    }

}
