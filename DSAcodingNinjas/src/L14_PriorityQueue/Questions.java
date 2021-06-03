package L14_PriorityQueue;

import java.util.PriorityQueue;

public class Questions {
	
	public static boolean checkMaxHeap(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			int parent = arr[i];
			int leftChild = arr[2*i+1];
			int rightChild = arr[2*i+2];
			if(leftChild<arr.length && leftChild>parent) {
				return false;
			}
			if(rightChild<arr.length && rightChild>parent) {
				return false;
			}
		}
		return true;
	}
	
	//Collections.reverseOrder();
	
	public static int kthLargest(int n, int[] input, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int i = 0;
		for(; i < k; i++) {
			pq.add(input[i]);
		}
		for(;i < input.length; i++) {
			if(input[i]>pq.peek()) {
				pq.remove();
				pq.add(input[i]);
			}
		}
		for(i = 0; i < k-1; i++) {
			pq.remove();
		}
		return pq.peek();
		
	}
	
	

}
