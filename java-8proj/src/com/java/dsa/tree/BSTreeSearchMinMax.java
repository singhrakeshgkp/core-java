package com.java.dsa.tree;

public class BSTreeSearchMinMax {/*

    public static Node search(Node node, int key) {
	if(node == null || node.key == key) {
	    
	    return node;
	}
	if(key<node.key)
	return search(node.left, key);
	else
	  return search(node.right, key);
    }
    
    public static Node min(Node node) {
	while(node.left != null)
	    node = node.left;
	return node;
    }
    
    
    public static Node max(Node node) {
	while(node.right != null)
	    node = node.right;
	return node;
    }
    
    public static Node predecessor(Node node, int key) {
	
	if(node.left.key == key || node.right.key == key)
	    return node;
	
	if(key < node.key)
	    return predecessor(node.left, key);
	else
	 return predecessor(node.right, key);

    }
    public static void main(String[] args) {
	
	//1- searching key in binary search tree
	BinaryTree tree = BinaryTree.getTestTree();
	Node node = search(tree.root, 90);
	if(node != null) {
	    System.out.println("key found "+node.key);
	}else {
	    System.out.println("key is not present in the tree");
	}
	
	//2- finding min and max
	Node minNode = min(tree.root); 
	Node maxNode = max(tree.root);
	System.out.println("Min and Max  are :- "+minNode.key+" , "+maxNode.key);
	
	//3- finding predecessor and successor
	Node predcessorNode = predecessor(tree.root, 25);
	System.out.println("Predcessor of Node  is "+predcessorNode.key);
	
    }*/
}
