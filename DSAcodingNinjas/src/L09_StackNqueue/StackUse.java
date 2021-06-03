package L09_StackNqueue;

public class StackUse {

	public static void main(String[] args) throws StackFullException {
//		StackUsingArray stack = new StackUsingArray();
//		for(int i = 1; i <= 5; i++) {
//			stack.push(i);
//		}
//		while(!stack.isEmpty()) {
//			try {
//				System.out.println(stack.pop());
//			} catch (StackEmptyException e) {
//				// Never reach here
//				
//			}
//		}
		
		StackZDoubleCapacity stackBetter = new StackZDoubleCapacity();
		for(int i = 1; i <= 20; i++) {
			stackBetter.push(i);
		}
		while(!stackBetter.isEmpty()) {
			try {
				System.out.println(stackBetter.pop());
			} catch (StackEmptyException e) {
				// Never reach here
				
			}
		}
	}

}
