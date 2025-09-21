package com.java.dsa.tree;

public class AVLTreeEx1 {
  class Node {

    Node left, right;
    int data, height;
    public Node(int data) {
      this.data = data;
      height = 1;
    }

    int getHeight(Node node){
      if ( node == null ){
        return 0;
      }
      return node.height;
    }
    int getBalanceFactor(Node key){
      if ( key == null){
        return 0;
      }

      return ( getHeight(key.left) - getHeight(key.right) );
    }

    public void updateHeight(Node key){
      int l = getHeight(key.left);
      int r = getHeight(key.right);
      key.height = Math.max(l,r)+1;
    }

    public Node rotateLeft(Node x){
      Node y = x.right;
      Node t2 = y.left;

      y.left = x;
      x.right = t2;
      updateHeight(x);
      updateHeight(y);
      return y;
    }

    public Node rotateRight(Node y){
      Node x = y.left;
      Node t2 = x.right;

      x.right = y;
      y.left = t2;
      updateHeight(y);
      updateHeight(x);
      return x;
    }

    Node performRequiredRotations(int value){
      int balance = getBalanceFactor(this);
      // Left heavy
      if (balance > 1 && value < this.left.data) {
        //left-left case
        if (value < this.left.data) {
          return rotateRight(this);
        } else { //left-right case
          rotateLeft(left);
          return rotateRight(this);
        }
      }
      //right heavy
      if (balance < -1) {
        //right-right case
        if (value > this.right.data) {
          return rotateLeft(this);
        } else {// right-left case
          rotateRight(right);
          return rotateLeft(this);
        }
      }
      return this;
    }
    public Node insert(int value) {
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
      updateHeight(this);
      return performRequiredRotations(value);
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
    AVLTreeEx1 tree = new AVLTreeEx1();
    Node root = tree.new Node(40);
    root = root.insert(50);
    root = root.insert(60);
    root.printInOrder();

  }
}
