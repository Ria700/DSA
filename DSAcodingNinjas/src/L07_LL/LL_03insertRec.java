package L07_LL;

public class LL_03insertRec {

	public static void main(String[] args) {
		Node<Integer> head = LL_01use.takeInput();

        Node<Integer> newHead = insertRec(head, 10, 2);
        LL_01use.print(newHead);
	}

	public static Node<Integer> insertRec(Node<Integer> head, int data, int pos) {
		if(pos==0){
			Node<Integer> newNode = new Node<Integer>(data);
			newNode.next = head;
            return newNode;
        }
		
        if(head.next == null) return head; // IMPORTANT
        
        head.next = insertRec(head.next, data, pos-1);
        return head;
	}
}
