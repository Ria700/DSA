package L11_BinaryTree;
import java.util.*;

import L10_Tree.TreeNode;
public class BinaryTreeUSe {

	public static BinaryTreeNode<Integer> takeInput(Scanner s){
		System.out.println("Enter root data");
		int rootdata = s.nextInt();
		
		if(rootdata == -1) return null; 
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
		root.left = takeInput(s);
		root.right = takeInput(s);
		return root;
	}
	
	public static void print(BinaryTreeNode<Integer> root) {
		if(root == null) return;
		String printdata = root.data + ": ";
		if(root.left!=null) {
			printdata += "L" + root.left.data +", ";
		}
		if(root.right!=null) {
			printdata += "R" + root.right.data;
		}
		System.out.println(printdata);
		print(root.left);
		print(root.right);
	}
	
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootdata = s.nextInt();
		
		if(rootdata == -1) return null; 
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
		Queue<BinaryTreeNode<Integer>> pendingNode = new LinkedList<>();
		pendingNode.add(root);
		while(!pendingNode.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingNode.remove();
			System.out.println("Enter the left child of " + front.data);
			int leftdata = s.nextInt();
			if(leftdata != -1) {
				BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(leftdata);
				front.left = left;
				pendingNode.add(left);
			}
			System.out.println("Enter the right child of " + front.data);
			int rightdata = s.nextInt();
			if(rightdata != -1) {
				BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(rightdata);
				front.right = right;
				pendingNode.add(right);
			}
		}
		return root;
	}
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		//Your code goes here
        if(root==null) return;
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        
        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front = pendingNodes.remove();
            String toBePrinted = front.data + ":";
            if(front.left!=null){
            	toBePrinted += "L:" + front.left.data + ",";
                pendingNodes.add(front.left);
            }else if(front.left==null)
            	toBePrinted += "L:-1,";
            if(front.right!=null){
            	toBePrinted += "R:" + front.right.data;
                pendingNodes.add(front.right);
            }else if(front.right==null)
            	toBePrinted += "R:-1";
            System.out.println(toBePrinted);
        }
	}
	
	// Time-complexity: O(n*heightOfTree)
	public static int diameter(BinaryTreeNode<Integer> root) {
		if(root==null) return 0;
		int option1 = height(root.left) + height(root.right);
		int option2 = diameter(root.left);
		int option3 = diameter(root.right);
		return Math.max(option1, Math.max(option2, option3));
	}

	public static int height(BinaryTreeNode<Integer> root) {
		if (root==null) return 0;
		int lh = height(root.left);
		int rh = height(root.right);
		return Math.max(lh, rh)+1;
	}
	
	public static Pair<Integer, Integer> heightdiameter(BinaryTreeNode<Integer> root) {
		if(root==null) {
			Pair<Integer, Integer> output = new Pair<>();
			output.first = 0;
			output.second = 0;
			return output;
		}
		Pair<Integer, Integer> lo = heightdiameter(root.left); 
		Pair<Integer, Integer> ro = heightdiameter(root.right);
		int height = 1+Math.max(lo.first, ro.first);
		int option1 = lo.first + ro.first;
		int option2 = lo.second;
		int option3 = ro.second;
		Pair<Integer, Integer> output = new Pair<>();
		output.first = height;
		output.second = Math.max(option1, Math.max(option2, option3));
		return output;
	}
	
	static class Pair<T, V>{
		T first;
		V second;
	}

	public static int countNodes(BinaryTreeNode<Integer> root) {
		if(root==null) return 0;
		int ans = 1;
		ans += countNodes(root.left);
		ans += countNodes(root.right);
		return ans;
	}
	
	//Traversals
	public static void inorder(BinaryTreeNode<Integer> root) {
		if(root==null) return;
		
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	public static void postOrder(BinaryTreeNode<Integer> root) {
		//Your code goes here
        if(root==null) return;
        
        postOrder(root.left);
        postOrder(root.right);
     	System.out.print(root.data + " ");
	}
	
	public static void preOrder(BinaryTreeNode<Integer> root) {
		//Your code goes here
        if(root==null) return;
        
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
	}

	public static ArrayList<Integer> RootToNodePath(BinaryTreeNode<Integer> root, int data) {
		if(root==null) return null;
		
		if(root.data==data) {
			ArrayList<Integer> output = new ArrayList<>();
			output.add(root.data);
			return output;
		}
		
		ArrayList<Integer> leftOutput = RootToNodePath(root.left, data);
		if(leftOutput!=null) {
			leftOutput.add(root.data);
			return leftOutput;
		}
		
		ArrayList<Integer> rightOutput = RootToNodePath(root.right, data);
		if(rightOutput!=null) {
			rightOutput.add(root.data);
			return rightOutput;
		}else {
			return null;
		}
	}
	
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(4);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		//System.out.println(root.left.data);
		
		// User input
		Scanner s = new Scanner(System.in);
		//BinaryTreeNode<Integer> root1 = takeInput(s);
		BinaryTreeNode<Integer> root2 = takeInputLevelWise();
		print(root2);
		
		// Count Nodes
		//System.out.println(countNodes(root2));
		
		// Diameter
//		System.out.println(diameter(root2));
//		Pair<Integer, Integer> output = heightdiameter(root2);
//		System.out.println(output.first);
//		System.out.println(output.second);
		
		//Traversals
		inorder(root2);
		System.out.println();
		ArrayList<Integer> output = RootToNodePath(root2, 6);
		System.out.println(output);
	}

}
