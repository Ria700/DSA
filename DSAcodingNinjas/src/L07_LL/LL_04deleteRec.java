package L07_LL;

public class LL_04deleteRec {

	public static void main(String[] args) {
		Node<Integer> head = LL_01use.takeInput();

        Node<Integer> newHead = deleteRec(head, 2);
        LL_01use.print(newHead);
	}
	
	public static Node<Integer> deleteRec(Node<Integer> head, int pos) {
        if(pos==0){
            return head.next;
        }
     
        if(head.next == null) return head; // IMPORTANT
        
        head.next = deleteRec(head.next, pos-1);
        return head;
	}

}
