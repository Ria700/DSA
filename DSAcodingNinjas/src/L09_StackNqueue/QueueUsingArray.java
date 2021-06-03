package L09_StackNqueue;

public class QueueUsingArray {
	private int[] data;
	private int front;
	private int rear;
	private int size;
	
	public QueueUsingArray() {
		data = new int[10];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	public QueueUsingArray(int capacity) {
		data = new int[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int front() throws QueueEmptyException {
		if(size==0) {
			throw new QueueEmptyException();
		}
		return data[front];
	}
	
//	public int rear() throws QueueEmptyException {
//		if(size==0) {
//			throw new QueueEmptyException();
//		}
//		return data[rear];
//
//	}
	
	public void enqueue(int elem) throws QueueFullException {
		if(size==data.length) throw new QueueFullException();
		if(size==0) front=0;
		rear = (rear+1)%data.length;
//		rear++;
//		if(rear==data.length) {
//			rear = 0;
//		}
		data[rear] = elem;
		size++;
	}
	
	public int dequeue() throws QueueEmptyException {
		if(size==0) throw new QueueEmptyException();
		int temp = data[front];
		front = (front+1)%data.length;
//		front++;
//		if(front==data.length) {
//			front = 0;
//		}
		size--;
		if(size == 0) {
			front = -1;
			rear = -1;
		}
		return temp;
	}
}
