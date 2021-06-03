package L04_JaggedArrayNEmptyArray;

public class J_05PrintAllCodes {
	// return statement is veryyy important PRINT questions
	public static void main(String[] args) {
		String input = "1123";
		printAllPossibleCodes(input);

	}
	
	public static void printAllPossibleCodes(String input) {
		// Write your code here
		printAllPossibleCodes(input, input.length()-1,"");
	}
    public static void printAllPossibleCodes(String input, int en, String out) {
        if(input.length() == 1){
            char k = convertChar(input.charAt(0));
            System.out.println(k+out);
            return; // return statement is veryyy important PRINT questions
        }
        if(input.length() == 0){
            System.out.println(out);
            return;
        }
        
        char s1 = convertChar(input.charAt(en));
        printAllPossibleCodes(input.substring(0, en), en-1, s1+out);
        int p = (int)(input.charAt(en-1)-'0');
        int p2 = (int)(input.charAt(en)-'0');
        p = p*10+p2;
        if(p>=10 && p<=26){
            char s2 = (char)('a'+p-1);
        	printAllPossibleCodes(input.substring(0, en-1), en-2, s2+out);
        }
	}
    
    public static char convertChar(char i){
        int p = (int)(i-'0');
		char k = (char)('a'+p-1);
        return k;
    }
}



