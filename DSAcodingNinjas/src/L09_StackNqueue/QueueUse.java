package L09_StackNqueue;

public class QueueUse {

	public static void main(String[] args) throws Exception {
//		QueueUsingArray queue = new QueueUsingArray();
//		for(int i = 0; i <= 5; i++) {
//			try {
//				queue.enqueue(i+100);
//			} catch (QueueFullException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		while(!queue.isEmpty()) {
//			try {
//				System.out.println(queue.dequeue());
//			} catch (QueueEmptyException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		queue.enqueue(5);
//		queue.enqueue(10);
//		queue.enqueue(15);
//		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
//		queue.enqueue(20);
//		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
		
		QueueZDoubleCapacity queue2 = new QueueZDoubleCapacity(3);
		for(int i = 0; i <= 7; i++) {
			try {
				queue2.enqueue(i);
			} catch (QueueFullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		while(!queue2.isEmpty()) {
			try {
				System.out.println(queue2.dequeue());
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
