package L07_LL;

import java.util.*;

public class LL_01use {

	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		head = insertE(head, 80, 3);
		print(head);
	}
	
	public static <T> void print(Node<T> head) {
		//Node<T> temp = head; No Required
		//print function creates its own head
	 	while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static Node<Integer> takeInput(){
		Node<Integer> head = null;
		Node<Integer> tail = null;
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		
		while(data != -1) {
			Node<Integer> newNode = new Node<Integer>(data);
			if(head==null) {
				head = newNode;
				tail = newNode;
			}else {
//				Node<Integer> temp = head;
//				while(temp.next!=null) {
//					temp = temp.next;
//				}
//				temp.next = newNode;
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}
	
	public static Node<Integer> insertE(Node<Integer> head, int data, int pos){
		Node<Integer> newNode = new Node<>(data);
		if(pos==0) {
			newNode.next = head;
			return newNode;
		}
		
		int i = 0;
		Node<Integer> temp = head;
		while(i<pos-1) {
			temp = temp.next;
			i++;
		}
		newNode.next = temp.next;
		temp.next = newNode; 
		return head;
	}
	
	public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
        if(head == null) return head;
        else if(pos == 0){ 
            head = head.next; 
            return head;
        }
        Node<Integer> temp = head;
        int count = 0;
        while(count < pos-1 && temp.next != null){
            count++;
            temp = temp.next;
        }
        if(temp.next != null)
        temp.next = temp.next.next;
        return head;
	}

}
