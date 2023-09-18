package com.java.ds.tree;

public class BinarySearchTreeTraversal {

    public static void main(String[] args) {
	
	BinaryTree tree = BinaryTree.getTestTree();
	System.out.println("In Order walk");
	inOrderWalk(tree.root);
	System.out.println();
	System.out.println("Pre Order walk");
	preOrderWalk(tree.root);
	
	System.out.println();
	System.out.println("Post Order walk");
	postOrderWalk(tree.root);
    }
    
    public static void inOrderWalk(Node node) {
	if(node != null) {
	    inOrderWalk(node.left);
	    System.out.print(node.key+" , ");
	    inOrderWalk(node.right);
	}
    }
    
    public static void preOrderWalk(Node node) {
	
	if(node != null) {
	    System.out.print(node.key+" , ");
	    preOrderWalk(node.left);
	    preOrderWalk(node.right);
	}
    }
    
    public static void postOrderWalk(Node node) {
	
	if(node != null) {
	    postOrderWalk(node.left);
	    postOrderWalk(node.right);
	    System.out.print(node.key+" , ");
	}
	
    }
}
