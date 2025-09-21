package com.java.dsa.tree;

public class Node {

  Node left, right;
  Node parent; // Used In Red Black Tree
  boolean color; //used in Red Black Tree
  int data;
  int height;  // used in AVL Tree
  public Node(int data) {
    this.data = data;
  }
}
