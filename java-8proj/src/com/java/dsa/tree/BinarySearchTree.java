package com.java.dsa.tree;



public class BinarySearchTree {
  class Node {

    Node left, right;
    int data;

    public Node(int data) {
      this.data = data;
    }

    public void insert(int value) {
      if (value <= data) {
        if (left == null) {
          left = new Node(value);
        } else {
          left.insert(value);
        }
      } else {
        if (right == null) {
          right = new Node(value);
        } else {
          right.insert(value);
        }
      }
    }

    public boolean contains(int value) {
      if (value == data) {
        return true;
      } else if (value < data) {
        if (left == null) {
          return false;
        } else {
          return left.contains(value);
        }
      } else {
        if (right == null) {
          return false;
        } else {
          return right.contains(value);
        }
      }
    }


    public void printInOrder() {
      if(left != null){
        left.printInOrder();
      }
      System.out.println(data);
      if(right != null){
        right.printInOrder();
      }
    }
  }
  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    BinarySearchTree.Node node = bst.new Node(10);
    node.left = bst.new Node(5);
    node.right = bst.new Node(15);
    /*before insert
                10
                /\
               5  15
    **/
    node.insert(8);
    // after insert
    /*
    *           10
                /\
               5  15
               \
                8
     */
    System.out.println(node.contains(8));
    node.printInOrder();
  }
}
