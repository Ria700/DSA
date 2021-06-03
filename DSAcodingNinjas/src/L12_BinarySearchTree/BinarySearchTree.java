package L12_BinarySearchTree;

import L11_BinaryTree.BinaryTreeNode;
import java.util.*;

public class BinarySearchTree {
	
	private BinaryTreeNode<Integer> root = null;
    
	public void insert(int data) {
		//Implement the insert() function
        root = insertHelper(root, data);
	}
    
    private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int data){
        if(root==null){
        	BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data);
            return newNode;
        }
        else if(root.data>=data){
            root.left = insertHelper(root.left, data);
        }else{
            root.right = insertHelper(root.right, data);
        }
        return root;
    }
	
	public void remove(int data) {
		//Implement the remove() function
        root = removeHelper(root, data);
        
	}
    
    private BinaryTreeNode<Integer> removeHelper(BinaryTreeNode<Integer> root, int data){
        if(root==null) return null;
        if(root.data==data){
            if(root.left==null && root.right==null) return null;
            else if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            else{
                BinaryTreeNode<Integer> minNode = root.right;
                while(minNode.left!=null){
                    minNode = minNode.left;
                }
                root.data = minNode.data;
                root.right = removeHelper(root.right, minNode.data);
            }
        }else if(data<root.data){
            root.left = removeHelper(root.left, data);
        }else{
            root.right = removeHelper(root.right, data);
        }
        return root;
        
    }
	
	public void printTree() {
		//Implement the printTree() function
        if(root==null) return;
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        
        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front = pendingNodes.remove();
            String toBePrinted = front.data + ":";
            if(front.left!=null){
            	toBePrinted += "L:" + front.left.data + ",";
                pendingNodes.add(front.left);
            }
            if(front.right!=null){
            	toBePrinted += "R:" + front.right.data;
                pendingNodes.add(front.right);
            }
            System.out.println(toBePrinted);
        }
	}
	
	public boolean search(int data) {
		//Implement the search() function
        return searchHelper(root, data);
	}
    
    private boolean searchHelper(BinaryTreeNode<Integer> root, int data) {
			if(root==null) return false;
			
			if(root.data==data) return true;
			else if(root.data<data) 
				return searchHelper(root.left, data);
			else 
				return searchHelper(root.right, data);
	}

}
