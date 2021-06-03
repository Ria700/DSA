package L16_DP;

public class factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 44;
		System.out.println(factDP(n));
		System.out.println(factM(n));
		System.out.println(fact(n));
	}
	
	public static int fact(int n) {
		if(n==0 || n==1) {
			return n;
		}
		
		return fact(n-1)+fact(n-2);
	}
	
	
	// M for memorization: Memorize your results
	// Top-Down
	public static int factM(int n) {
		int[] storage = new int[n+1];
		for(int i = 0; i < storage.length; i++) {
			storage[i] = -1;
		}
		return factMHelper(n, storage);
	}
	
	public static int factMHelper(int n, int[] storage) {
		if(n==0 || n==1) {
			storage[n] = n;
			return storage[n];
		}
		
		if(storage[n]!=-1) {
			return storage[n];
		}
		
		storage[n] = factMHelper(n-1, storage) + factMHelper(n-2, storage);
		return storage[n];
	}

	
	// DP: DP says if you can remove recursion, remove it
	// Bottom-up
	public static int factDP(int n) {
		int[] storage = new int[n+1];
		storage[0]=0;
		storage[1]=1;
		
		for(int i=2; i<=n; i++) {
			storage[i] = storage[i-1] + storage[i-2];
		}
		return storage[n];
	}
}
