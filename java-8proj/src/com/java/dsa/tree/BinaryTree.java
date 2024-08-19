package com.java.dsa.tree;

class Node{
    
    int key;
    Node left;
    Node right;
    
    public Node(int key) {
	this.key = key;
	left = right = null;
    }
}
public class BinaryTree {

    Node root;
    BinaryTree(){
	root = null;
    }
    
 public static BinaryTree getTestTree() {
    BinaryTree tree = new BinaryTree();
    Node root = new Node(25);
    tree.root = root;
    
    //left of node 25
    tree.root.left = new Node(15);
    //left right of node 15
    tree.root.left.left = new Node(10);
    tree.root.left.right = new Node(22);
    
    //left right of node 10
    tree.root.left.left.left = new Node(4);
    tree.root.left.left.right = new Node(12);
    
    //left right of node 22
    tree.root.left.right.left = new Node(18);
    tree.root.left.right.right = new Node(24);
    
    //right of node 25
    tree.root.right = new Node(50);
    //left right of 50
    
    tree.root.right.left = new Node(35);
    tree.root.right.right = new Node(70);
    
    //left right of 35
    tree.root.right.left.left = new Node(31);
    tree.root.right.left.right = new Node(44);
    
    //left right of 70
    tree.root.right.right.left = new Node(66);
    tree.root.right.right.right = new Node(90);
    return tree;
 }
}
