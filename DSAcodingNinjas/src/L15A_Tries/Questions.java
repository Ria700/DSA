package L15A_Tries;

import java.util.*;

public class Questions {
	
//	public static boolean patternMatching(ArrayList<String> vect, String pattern) {
//		Trie t = new Trie();
//		for(String i: vect) {
//			for(int j = 0; j < i.length(); j++) {
//				t.add(i.substring(j));
//			}
//		}
//		return t.search(pattern);
//	}
//	
//	
//	public static boolean isPalindromePair(ArrayList<String> words) {
//		for(int i = 0; i < words.size(); i++) {
//			for(int j = i+1; j < words.size(); i++) {
//				String charCheck = ""+words.get(i)+words.get(j);
//				if(isPalindrome(charCheck)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//	
//	public static boolean isPalindrome(String str)
//    {
//        int len = str.length();
//      
//        // compare each character from starting
//        // with its corresponding character from last
//        for (int i = 0; i < len/2; i++ )
//            if (str.charAt(i) != str.charAt(len-i-1))
//                return false;
//      
//        return true;
//    }
	
	
	
	static long binaryOnesSimilarPairs(ArrayList<Integer> a) {
//	    int[] b = new int[a.size()];
//	    for(int i=0; i<a.size(); i++)
//	    {
//	        b[i]=calculate1s(decimalToBinary(a.get(i)));
//
//	    }
//	    return
		int Pcount = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<a.size(); i++)
	    {
	        int p = calculate1s(decimalToBinary(a.get(i)));
	        if(map.containsKey(p)) {
	        	int value = map.get(p);
	        	map.put(p, value+1);
	        }else {
	        	map.put(p, 1);
	        }
	    }
		
		Set<Integer> s = map.keySet();
		
		for(Integer j : s) {
			if(j!=1) {
				Pcount+=facto(j);
			}
		}
		
		return Pcount;
//		for(int i = 0; i < s.size(); i++) {
//			if(s)
//		}
		
		
	}
	
	public static long facto(int n) {
		long f = 1;
		for(int i = 2; i <= n; i++) {
			f*=i;
		}
		return f;
	}
	
	public static int calculate1s(long n) {
		int count = 0;
		while(n>0) {
			if(n%10 == 1) {
				count++;
			}
			n/=10;
		}
		return count;
	}
	
	public static long decimalToBinary(int N) 
	{ 

	    // To store the binary number 
	    long B_Number = 0; 
	    int cnt = 0; 
	    while (N != 0) { 
	        int rem = N % 2; 
	        double c = Math.pow(10, cnt); 
	        B_Number += rem * c; 
	        N /= 2; 

	        // Count used to store exponent value 
	        cnt++; 
	    } 

	    return B_Number; 
	}
	
	public static void main(String[] args) {
		System.out.println(facto(3));
	
	}
}
