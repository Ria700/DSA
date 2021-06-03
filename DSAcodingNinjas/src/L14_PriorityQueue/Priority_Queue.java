package L14_PriorityQueue;

import java.util.ArrayList;

public class Priority_Queue {
	
	private  ArrayList<Integer> heap;
	
	public Priority_Queue() {
		heap = new ArrayList<>();
	}
	
	boolean isEmpty() {
		return heap.size() == 0;
	}
	
	public int getMin() throws PriorityQueueException {
		if(isEmpty()) {
			//Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}
	
	void insert(int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex-1)/2;
		
		while(childIndex > 0) {
			
			if(heap.get(childIndex)<heap.get(parentIndex)) {
				int temp = heap.get(parentIndex);
				heap.set(parentIndex, heap.get(childIndex));
				heap.set(childIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex-1) / 2;
			}else {
				return;
			}
		}
	}
	
	int removeMin() throws PriorityQueueException {
        // Complete this function
		// Throw the exception PriorityQueueException if queue is empty
        
		if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
        }
        int ans = heap.get(0);
        
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int index = 0;
        int minI = 0;
        int leftChildI = 1;
        int rightChildI = 2;
        
        while(leftChildI<heap.size()){
                
            if(heap.get(minI)>heap.get(leftChildI)){
            	minI = leftChildI;
            }if(rightChildI<heap.size() && heap.get(rightChildI)<heap.get(minI)){
                minI = rightChildI;
            }
            else if (minI == index){
                return ans;
            }
            int temp = heap.get(index);
            heap.set(index, heap.get(minI));
            heap.set(minI, temp);
            index = minI;
            leftChildI = 2*minI+1;
            rightChildI = 2*minI+2;
        }
        
        return ans;
	}

}
