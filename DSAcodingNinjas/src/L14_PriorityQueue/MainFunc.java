package L14_PriorityQueue;

import java.util.PriorityQueue;

public class MainFunc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(2);
		pq.add(4);
		pq.add(1);
		pq.add(3);
		System.out.println(pq.poll());
		System.out.println(pq.remove());
		System.out.println(pq.peek());
		System.out.println(pq.element());
	}

}
