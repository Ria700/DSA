package L03_Recursion;

public class findSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "xy";
//		String a[] = findSubsq(s);
//		for(int i = 0; i < a.length; i++) {
//			System.out.println(a[i]);
//		}
//		printSubsq(s, "");
//		printKeypad(234);
//		
//		int input[] = {15 ,20, 12};
//		int ans[][] = subsets(input);
//		for (int i = 0; i < ans.length; i++) {
//            for (int j = 0; j < ans[i].length; j++){
//               System.out.print(ans[i][j] + " ");
//            }
//            System.out.println();
//        }
		int input[] = {17, 18, 6, 11, 2, 4};
		int ans[][] = subsetsSumK(input, 6);
		for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++){
               System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
		
	}
	
	public static String[] findSubsq(String s) {
		if(s.length() == 0) {
			String a[] = {""};
			return a;
		}
		String smallAns[] = findSubsq(s.substring(1));
		String ans[] = new String[2*smallAns.length];
		for(int i = 0; i < smallAns.length; i++) {
			ans[i] = smallAns[i];
		}
		for(int i = 0; i < smallAns.length; i++) {
			ans[i + smallAns.length] = s.charAt(0) + smallAns[i] ;
		}
		return ans;
	}
	
	public static void printSubsq(String input, String outputSoFar){
		if(input.length() == 0) {
			System.out.println(outputSoFar); 
			return;
		}
		printSubsq(input.substring(1), outputSoFar);
		printSubsq(input.substring(1), outputSoFar + input.charAt(0));
	}
	public static void printKeypad(int input){
		// Write your code here
        printKeypad(input, "");
    }
    
	public static void printKeypad(int n, String out){
		// Write your code here
		
        if(n/10 == 0){
            String s = ref(n%10);
            for(int j = 0; j < s.length(); j++){     
                System.out.println(s.charAt(j) + out);
            }
            return;
        }

        String s = ref(n%10);
        for(int j = 0; j < s.length(); j++){     
            printKeypad(n/10, s.charAt(j) + out);
        }
    }
    
    public static String ref(int n){
        switch(n){
            case 2: return "abc";
            case 3: return "def";
            case 4: return "ghi";
            case 5: return "jkl";
            case 6: return "mno";
            case 7: return "pqrs";
            case 8: return "tuv";
            case 9: return "wxyz";
            default: return "";
        }
    }
    
    public static int staircase(int n){
		
    	/* Your class should be named Solution.
    	 * Don't write main() function.
    	 * Don't read input, it is passed as function argument.
    	 * Return output and don't print it.
    	 * Taking input and printing output is handled automatically.
    	 */
             int x = 0, y = 0, z = 0;
             if(n == -1){
                 return 0;
             }
            
            x = staircase(n-1);
            y = staircase(n-2);
            z = staircase(n-3);
            
             
             return (x+y+z+3);

    	}
    
    public static int[][] subsets2(int input[]) {
		// Write your code here
        if(input.length == 0) {
            int[][] ans = new int[1][1]; 
            return ans;
        }
        
        int[] smallInput = new int[input.length-1];
        for (int i = 0; i < input.length-1; i++){
            smallInput[i] = input[i+1];
        }
        int[][] smallAns = subsets2(smallInput);
        
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
    
    
    public static int[][] subsets(int input[]) {
		// Write your code here
        int ans[][] = subsets2(input);
        int[][] ans2 = new int[ans.length-1][];
        for (int i = 1; i < ans.length; i++){
        	ans2[i-1] = new int[ans[i].length];
            for (int j = 0; j < ans[i].length; j++){
                ans2[i-1][j] = ans[i][j];
            }
        }
        return ans2;
    }
//	public static int[][] subsets2(int input[]) {
//		// Write your code here
//        if(input.length == 0) {
//            int[][] ans = new int[1][1]; 
//            return ans;
//        }
//        
//        int[] smallInput = new int[input.length-1];
//        for (int i = 0; i < input.length-1; i++){
//            smallInput[i] = input[i+1];
//        }
//        int[][] smallAns = subsets(smallInput);
//        
//        int[][] ans = new int[2*smallAns.length][];
//        int i = 0;
//        
//        if(smallAns.length > 1) {
//	        for (i = 1; i < smallAns.length; i++) {
//	        	ans[i] = new int[smallAns[i].length];
//	            for (int j = 0; j < smallAns[i].length; j++){
//	                ans[i][j] = smallAns[i][j];
//	            }
//	        }
//        }
//
//        ans[smallAns.length] = new int[1];
//        ans[smallAns.length][0] = input[0]; 
//        i = 1;
//        for (; i < smallAns.length; i++){
//        	ans[smallAns.length+i] = new int[smallAns[i].length+1];
//        	ans[smallAns.length+i][0] = input[0]; 
//            for (int j = 1; j < smallAns[i].length + 1; j++){
//                ans[smallAns.length+i][j] = smallAns[i][j-1];
//            }
//        }
//		return ans;
//	}
    
    public static int[][] subsetsSumK(int input[], int k) {
		// Write your code here
        int ans[][] = subsets2(input);
        int p = 0;
        int[][] ans2 = new int[ans.length][];
        
        for (int i = 1; i < ans.length; i++){
            int sum = 0;
        	for (int j = 0; j < ans[i].length; j++){
                sum += ans[i][j];
            }
            if(sum == k){
               	ans2[p] = new int[ans[i].length];
                for (int j = 0; j < ans[i].length; j++){
                     ans2[p][j] = 
                         ans[i][j];
                }
                p++;
            }
        }
        return ans2;
    }

	

}
