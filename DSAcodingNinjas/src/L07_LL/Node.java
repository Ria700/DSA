package L07_LL;

public class Node<T> {
	T data;
	Node<T> next;
	//Node next; this is also possible
	//<T> just insures that the next data type stored is also the same
	
	public Node(T data){
		this.data = data;
		this.next = null;
	}
}


