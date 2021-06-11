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
		
        if(head == null) return head; // IMPORTANT-to check if pos > length of list, head should != null
        
        head.next = insertRec(head.next, data, pos-1);
        return head;
	}
}

// Important
// For a list: 1->2TTTTTTTTTTTT--ZZ//HH..,,->3, length = 3,
// 0 <= pos <= 3 
