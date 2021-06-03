package L07_LL;

public class LL_02reverseLL {
	
	// Main Function
	public static void main(String[] arg) {
		Node<Integer> head = LL_01use.takeInput();
//		printReverse(head);
//		head = reverse1I(head);
//		head = reverse2I(head);
//		head = reverse3Rec(head);
//		head = reverse5Rec(head);
		
//		DoubleNode d = reverse4Rec(head);
//		LL_01use.print(d.head);
		
		LL_01use.print(head);
	}
	
	
	// Print Recursively
	public static void printReverse(Node<Integer> head) {
		if (head==null) return;
		printReverse(head.next);
		System.out.print(head.data+" ");
	}
	
	
	// 1. Iterative Reverse
	public static Node<Integer> reverse1I(Node<Integer> head){
		if(head == null || head.next == null) return head;
        Node<Integer> temp = head;
        int count = 0;
        while(temp.next != null){
            count++;
            temp = temp.next;
        } 
        Node<Integer> h2 = temp;
        Node<Integer> tail = temp;
        for(int i = count-1; i >= 0; i--){
            temp = head;
            int j = 0;
            while(j < i){
            	temp = temp.next;
            	j++;
            }
            tail.next=temp;
            temp.next = null;
            tail=tail.next;
        }   
		return h2;
	}
	
	
	// 2. Iterative Reverse 
	public static Node<Integer> reverse2I(Node<Integer> head){
		
	        if(head == null || head.next == null ) return head;
	        Node<Integer> prev = null;
	        Node<Integer> curr = head;
	        Node<Integer> temp;
	        while(curr!=null){
	            temp = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = temp;
	        }
	        return prev;
		}
	
	// 3. Reverse Recursively. Time Complexity: O(n2)
	public static Node<Integer> reverse3Rec(Node<Integer> head) {
		//Your code goes here
        if(head == null || head.next == null) return head;
        Node<Integer> h = reverse3Rec(head.next);
        Node<Integer> temp = h;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        head.next = null;
        return h;
	}
	
	// BETTER
	// 4. Reverse Recursively BETTER using Double Node . Time Complexity: O(n)
	static class DoubleNode{
		Node<Integer> head;
		Node<Integer> tail;
	}
	
	public static DoubleNode reverse4Rec(Node<Integer> head) {
		
		//One way of writing
        /*if(head == null || head.next == null) {
        	DoubleNode d = new DoubleNode();
        	d.head = head;
        	d.tail = head;
        	return d;
        }
        
        DoubleNode d = reverse4Rec(head.next);
        d.tail.next = head;
        head.next = null;
        
        return d;*/
		
		if(head == null || head.next == null) {
        	DoubleNode ans = new DoubleNode();
        	ans.head = head;
        	ans.tail = head;
        	return ans;
        }
        
        DoubleNode smallAns = reverse4Rec(head.next);
        smallAns.tail.next = head;
        head.next = null;
        
        DoubleNode ans = new DoubleNode();
    	ans.head = smallAns.head;
    	ans.tail = head;
        return ans;
		
	}
	
	// BEST
	// 5. Reverse Recursively BEST. Time Complexity: O(n)
	public static Node<Integer> reverse5Rec(Node<Integer> head) {
        if(head == null || head.next==null) return head;
        
        Node<Integer> smallHead = reverse5Rec(head.next);
        head.next.next = head;
        head.next = null;
        return smallHead;
	}
}
