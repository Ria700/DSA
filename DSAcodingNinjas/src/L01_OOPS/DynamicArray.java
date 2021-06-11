package L01_OOPS;

public class DynamicArray {
	
//	reference
	private int data[];
//  nextIndex
	private int nextIndex;
	
//	Constructor
	public DynamicArray() {
		data = new int[5];
		nextIndex = 0;
	}
	
//	size()
	public int size() {
		return nextIndex;
	}
	
//	add(): Adds to the end
	public void add(int element) {
		if(nextIndex == data.length) {
			restructure();
		}
		data[nextIndex] = element;
		nextIndex++;
	}
	// 	doubleThesize
	//	restructure()
	private void restructure() {
		int temp[] = data;
		data = new int[data.length * 2];
		for(int i = 0; i < temp.length; i++) {
			data[i] = temp[i];
		}
	}
	
//	set()
	public void set(int index, int element) {
		if ( index > nextIndex) {
			return;
		}
		if(index < nextIndex) {
			data[index] = element;
		} else {
			add(element);
		}
	}
	
//	get()
	public int get(int index) {
		if (index >= nextIndex)
			// error out
			return -1;
		return data[index];
		
	}
	
//	isEmpty()
	public boolean isEmpty() {
		if(size()==0) return true;
		return false;
	}
	
//	removeLast()
	public int removeLast() {
		if(size()==0)
			// error out
			return -1;
		int value = data[nextIndex];
		data[nextIndex-1]=0;
		nextIndex--;
		return value;
	}
	
}


