package L03_Recursion;

public class stringPermutation {

	public static void main(String[] args) {
		String s = "abc"; 
		printPermutationOfString(s, "");
//		String output[] = permutationOfString(s);
//		for(int i = 0; i < output.length; i++) {
//			System.out.println(output[i]);
//		}
//		System.out.println("1 "+s.substring(0,0));
//		System.out.println("2 "+s.substring(0));
//		System.out.println("3 "+s.substring(0,1));
//		System.out.println("4 "+s.substring(2));
	}
	
	
//	M-1
//	public static String[] permutationOfString(String input){
//		// Write your code here
//		if(input.length() == 1){
//            String[] ans = {input.charAt(0)+""};
//            return ans;
//        }
//        String[] ans = permutationOfString(input.substring(1));
//        String[] output = new String[input.length()*ans.length];
//        int k =0;
//        for(int i = 0; i<ans.length ; i++){
//            for(int j  = 0; j < ans[i].length()+1; j++){
//                output[k] = ans[i].substring(0,j)+
//                		input.charAt(0)+ans[i].substring(j);
//                k++;
//            }
//        }
//        for(int i = 0; i < output.length; i++) {
//			System.out.println(output[i]);
//		}
//       return output; 
//	}
	
	
//	M-2
//	public static String[] permutationOfString(String input){
//		// Write your code here
//		if(input.length() == 1){
//            String[] ans = {""+input.charAt(0)};
//            return ans;
//        }
//		if(input.length() == 0) {
//			String[] ans = {""};
//            return ans;
//		}
//        
//        String output[] = new String[factorial(input.length())]; 
//        int k = 0;
//        for(int i = 0; i<input.length() ; i++){
//            String s = input.substring(0,i)+input.substring(i+1);
//            String[] ans = permutationOfString(s);
//            for(int j = 0; j<ans.length ; j++){ 
//            	output[k] = input.charAt(i) +ans[j];
//                k++;
//            } 
//        }
//        return output;
//	}
	public static int factorial(int n) {
		int k = 1;
		for(int i = 2; i<=n; i++) {
			k *= i;
		}
		return k;
	}
	
	// Print all permutations
	public static void printPermutationOfString(String str, String ans){ 
	  
	        // If string is empty 
	        if (str.length() == 0) { 
	            System.out.println(ans); 
	            return; 
	        } 
	  
	        for (int i = 0; i < str.length(); i++) { 
	  
	            // ith character of str 
	            char ch = str.charAt(i); 
	  
	            // Rest of the string after excluding  
	            // the ith character 
	            String ros = str.substring(0, i) +  
	                         str.substring(i + 1); 
	  
	            // Recurvise call 
	            printPermutationOfString(ros, ans + ch); 
	        } 
	    } 
	
	
}
