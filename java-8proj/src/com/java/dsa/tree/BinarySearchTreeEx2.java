package com.java.dsa.tree;
public class BinarySearchTreeEx2 {

  protected Node root;

  public Node insert(int value) {
    root = insert(root, value);
    return root;
  }

  public Node insert(Node node, int value) {

    if (node == null) {
      node = new Node(value);
    } else if (value <= node.data) {
      if (node.left == null) {
        node.left = new Node(value);
      } else {
        insert(node.left, value);
      }
    } else {
      if (node.right == null) {
        node.right = new Node(value);
      } else {
        insert(node.right, value);
      }
    }
    return node;
  }

  public boolean contains(Node root, int value) {
    if (value == root.data) {
      return true;
    } else if (value < root.data) {
      if (root.left == null) {
        return false;
      } else {
        return contains(root.left, value);
      }
    } else {
      if (root.right == null) {
        return false;
      } else {
        return contains(root.right, value);
      }
    }
  }


  public void printInOrder(Node root) {
    if (root.left != null) {
      printInOrder(root.left);
    }
    System.out.println(root.data);
    if (root.right != null) {
      printInOrder(root.right);
    }
  }

  public static void main(String[] args) {
    BinarySearchTreeEx2 bst = new BinarySearchTreeEx2();
    Node root = bst.insert(10);
    Node node1 = bst.insert(root,5);
    Node node2 = bst.insert(root,15);
    /*before insert
                10
                /\
               5  15
    **/
    Node node3 = bst.insert(root,8);
    // after insert
    /*
    *           10
                /\
               5  15
               \
                8
     */
    System.out.println(bst.contains(root, 8));
    bst.printInOrder(root);
    System.out.println("after Printing inorder");
    System.out.println("Node1, Node2, and Node3 are "+node1.data + " , "+node2.data+" , "+node3.data);// always returns root
  }
}