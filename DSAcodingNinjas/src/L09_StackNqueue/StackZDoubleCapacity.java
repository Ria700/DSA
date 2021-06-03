package L09_StackNqueue;

public class StackZDoubleCapacity {
	private int data[];
	private int top;
	
	public StackZDoubleCapacity() {
		data = new int[10];
		top = -1;
	}
	
	public StackZDoubleCapacity(int capacity) {
		data = new int[capacity];
		top = -1;
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	public int size() {
		return top+1;
	}
	
	public int top() throws Exception {
		if(size()==0) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		return data[top];
	}
	
	public void push(int element) {
		if(size()==data.length) {
			doubleCapacity();	
		}
		data[++top]=element;
	}
	
	private void doubleCapacity() {
		int[] temp = data;
		data = new int[temp.length*2];
		for(int i = 0; i< temp.length; i++) {
			data[i] = temp[i];
		}
	}
	
	public int pop() throws StackEmptyException {
		if(size()==0) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		int temp = data[top];
		top--;
		return temp;
	}
}
