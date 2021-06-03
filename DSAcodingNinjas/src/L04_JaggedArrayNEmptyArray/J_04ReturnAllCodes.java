package L04_JaggedArrayNEmptyArray;

public class J_04ReturnAllCodes {

	public static void main(String[] args) {
		String input = "1123";
		String output[] = getCode(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
	
	// Return a string array that contains all possible codes
	public static String[] getCode(String input){
		// Write your code here
        if(input.length() == 1){
    		char k = convertChar(input.charAt(0));
            String[] ans = {""+k};
            return ans;
        }
        if(input.length() == 0){
            String[] ans = {""};
            return ans;
        }
        
		String[] String1 = getCode(input.substring(1));
        char k1 = convertChar(input.charAt(0));
        for(int i = 0; i < String1.length; i++){
            String1[i] = k1+String1[i];
        }
        int p = (int)(input.charAt(0)-'0');
        int p2 = (int)(input.charAt(1)-'0');
        p = p*10+p2;
        char k2 = (char)('a'+p-1);
        String String2[] = new String[0];
        if(p >= 10 && p<=26){
            String2 = getCode(input.substring(2));
            for(int i = 0; i < String2.length; i++){
                String2[i] = k2+String2[i];
            }
        }
        int k = 0;
        String[] s = new String[String1.length+String2.length];
        for(int i = 0; i < String1.length; i++){
            s[k] = String1[i];
            k++;
        }
        for(int i = 0; i < String2.length; i++){
            s[k] = String2[i];
            k++;
        }
        return s;
	}
    
    public static char convertChar(char i){
        int p = (int)(i-'0');
		char k = (char)('a'+p-1);
        return k;
        
    }

}
