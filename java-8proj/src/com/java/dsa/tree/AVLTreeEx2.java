package com.java.dsa.tree;

public class AVLTreeEx2 extends BinarySearchTreeEx2 {
  @Override
  public Node insert(Node node, int data){
     node = super.insert(node,data);
     updateHeight(node);
     return rebalance(node);
  }

  private Node rebalance(Node node) {
    int balanceFactor = getBalanceFactor(node);

    return null;
  }

  private Node rotateLeft(Node node){
    Node rightChild = node.right;
    //now rotate
    node.right = rightChild.left;
    rightChild.left = node;
    updateHeight(node);
    updateHeight(rightChild);
    return rightChild;
  }

  private Node rotateRight(Node node){
    Node leftChild = node.left;
    //now rotate
    node.left = leftChild.right;
    leftChild.right = node;
    updateHeight(node);
    updateHeight(leftChild);
    return  leftChild;
  }

  private void updateHeight(Node node){
    int lh = height(node.left);
    int rh = height(node.right);
    node.height = Math.max(lh,rh)+1;
  }
  private int height(Node node){
    return node == null ? 0: node.height;
  }
  private int getBalanceFactor(Node node){
    return height(node.left) - height(node.right);
  }
}