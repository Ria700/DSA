package L10_Tree;

import java.util.*;

public class TreeUse {
	
	public static TreeNode<Integer> takeInput(Scanner s){
		System.out.println("Enter the next node data");
		int d = s.nextInt();
		TreeNode<Integer> root = new TreeNode<>(d);
		System.out.println("Enter the number of children of " + root.data);
		int childrenCount = s.nextInt();
		for(int i = 0; i < childrenCount; i++) {
			TreeNode<Integer> child = takeInput(s);
			root.children.add(child);
		}
		return root;
	}
	
	public static void print(TreeNode<Integer> root) {
		System.out.print(root.data+": ");
		String s = "";
		for(int i = 0; i < root.children.size(); i++) {
			s = s + root.children.get(i).data + ", ";
		}
		System.out.println(s);
		for(int i = 0; i < root.children.size(); i++) {
			print(root.children.get(i));
			
		}
	}
	
	public static TreeNode<Integer> takeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootdata = s.nextInt();
		TreeNode<Integer> root = new TreeNode<>(rootdata);
		Queue<TreeNode<Integer>> pendingNode = new LinkedList<>();
		pendingNode.add(root);
		
		while(!pendingNode.isEmpty()) {
			TreeNode<Integer> frontNode = pendingNode.remove();
			System.out.println("Enter the number of children of "+ frontNode.data);
			int numChildren = s.nextInt();
			for(int i = 0; i < numChildren; i++) {
				System.out.println("Enter the " + (i+1) + "th children of "+ frontNode.data);
				int n = s.nextInt();
				TreeNode<Integer> newNode = new TreeNode<>(n);
				frontNode.children.add(newNode);
				pendingNode.add(newNode);
			}
		}
		
		return root;
	}
	
	// Level-order traversal
	public static void printLevelWise(TreeNode<Integer> root){
        if(root==null) return;
        Queue<TreeNode<Integer>> pendingNode = new LinkedList<>();
		pendingNode.add(root);
		System.out.println(root.data);
        int j = 0, k =0;
        int l = root.children.size();
		while(!pendingNode.isEmpty()) {
            TreeNode<Integer> frontNode = pendingNode.remove();
            for(int i = 0; i < frontNode.children.size(); i++) {
                TreeNode<Integer> child = frontNode.children.get(i);
                System.out.print(child.data+" ");
                pendingNode.add(child);
                k+=child.children.size();
                j++;
            }
            if(j==l){
                System.out.println();
                j=0;
                l=k;
                k=0;
            } 
            
		}

	}
	
	public static int numNodes(TreeNode<Integer> root) {
		// NOT A BASE CASE
		if(root==null) return 0;
		
		// Count for root
		int count = 1;
		
		// For loop is self base case
		for(int i = 0; i < root.children.size(); i++) {
			count += numNodes(root.children.get(i));
		}
		return count;
	}
	
	public static int LargestDataNode(TreeNode<Integer> root) {
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		int ans = root.data;
		for(int i = 0; i<root.children.size();i++) {
			int smallAns = LargestDataNode(root.children.get(i));
			if(smallAns>ans) {
				ans = smallAns;
			}
		}
		return ans;
	}
	
	// Depth of a node
	public static void printAtK(TreeNode<Integer> root, int k) {
		if(k<0) {
			return;
		}
		if(k == 0) {
			System.out.println(root.data);
			return;
		}
		for(int i = 0; i < root.children.size(); i++) {
			printAtK(root.children.get(i), k-1);
		}

	}
	
	// First root then its children
	// Left to right
	public static void printPreOrder(TreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data + " ");
		for(int i = 0; i < root.children.size(); i++) {
			printPreOrder(root.children.get(i));
		}
	}
	
	// First children then root
	// Children Left to right
	public static void printPostOrder(TreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		for(int i = 0; i < root.children.size(); i++) {
			printPostOrder(root.children.get(i));
		}
		System.out.print(root.data + " ");
	}
	
	public static void main(String[] args) {
		
		// Self Input
		TreeNode<Integer> root = new TreeNode(4);
		TreeNode<Integer> node1 = new TreeNode(2);
		TreeNode<Integer> node2 = new TreeNode(3);
		TreeNode<Integer> node3 = new TreeNode(5);
		TreeNode<Integer> node4 = new TreeNode(6);
		
		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);
		node2.children.add(node4);
		// Debugger Break Point 
		//System.out.println(root);
		
		
		
		// Taking Input from User
		Scanner s = new Scanner(System.in);
		//TreeNode<Integer> root2 = takeInput(s);
		TreeNode<Integer> root3 = takeInputLevelWise();
		print(root3);
		
		
//		System.out.println(numNodes(root3));
//		System.out.println(LargestDataNode(root3));
//		printAtK(root3, 2);
//		printPreOrder(root3);
		printPostOrder(root3);
		System.out.println();
	}
	
	void prank(long[] a, int n)  
    { 
        // code here
        int k = 0;
        long[] temp = new long[a.length];
        long d = 0;
        for(int i=0; i<a.length; i++){
            if(a[i] == i){
                temp[i] = a[i];
                continue;
            } 
            for(int j=0; j<a.length; j++){
                if(a[j] == i){
                    k = j;
                    break;
                }
            }
            temp[k] = a[i];
        }
        for(int i=0; i<a.length; i++){
           a[i] = temp[i];
        }
    }

}
