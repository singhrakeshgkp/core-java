package com.java.dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class AVLT {
  public class Node {
    private Node left, right, parent;
    private int height = 1;
    private int value;

    private Node (int val) {
      this.value = val;
    }
  }
  private int height (Node N) {
    if (N == null)
      return 0;
    return N.height;
  }

  private Node insert(Node node, int value) {
    /* 1.  Perform the normal BST rotation */
    if (node == null) {
      return(new Node(value));
    }

    if (value < node.value)
      node.left  = insert(node.left, value);
    else
      node.right = insert(node.right, value);

    /* 2. Update height of this ancestor node */
    node.height = Math.max(height(node.left), height(node.right)) + 1;

        /* 3. Get the balance factor of this ancestor node to check whether
           this node became unbalanced */
    int balance = getBalance(node);

    // If this node becomes unbalanced, then there are 4 cases

    // Left Left Case
    if (balance > 1 && value < node.left.value)
      return rightRotate(node);

    // Right Right Case
    if (balance < -1 && value > node.right.value)
      return leftRotate(node);

    // Left Right Case
    if (balance > 1 && value > node.left.value)
    {
      node.left =  leftRotate(node.left);
      return rightRotate(node);
    }

    // Right Left Case
    if (balance < -1 && value < node.right.value)
    {
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }

    /* return the (unchanged) node pointer */
    return node;
  }

  private Node rightRotate(Node y) {
    Node x = y.left;
    Node T2 = x.right;

    // Perform rotation
    x.right = y;
    y.left = T2;

    // Update heights
    y.height = Math.max(height(y.left), height(y.right))+1;
    x.height = Math.max(height(x.left), height(x.right))+1;

    // Return new root
    return x;
  }

  private Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;

    // Perform rotation
    y.left = x;
    x.right = T2;

    //  Update heights
    x.height = Math.max(height(x.left), height(x.right))+1;
    y.height = Math.max(height(y.left), height(y.right))+1;

    // Return new root
    return y;
  }

  // Get Balance factor of node N
  private int getBalance(Node N) {
    if (N == null)
      return 0;
    return height(N.left) - height(N.right);
  }

  public void preOrder(Node root) {
    if (root != null) {
      preOrder(root.left);
      System.out.printf("%d ", root.value);
      preOrder(root.right);
    }
  }

  private Node minValueNode(Node node) {
    Node current = node;
    /* loop down to find the leftmost leaf */
    while (current.left != null)
      current = current.left;
    return current;
  }

  private Node deleteNode(Node root, int value) {
    // STEP 1: PERFORM STANDARD BST DELETE

    if (root == null)
      return root;

    // If the value to be deleted is smaller than the root's value,
    // then it lies in left subtree
    if ( value < root.value )
      root.left = deleteNode(root.left, value);

      // If the value to be deleted is greater than the root's value,
      // then it lies in right subtree
    else if( value > root.value )
      root.right = deleteNode(root.right, value);

      // if value is same as root's value, then This is the node
      // to be deleted
    else {
      // node with only one child or no child
      if( (root.left == null) || (root.right == null) ) {

        Node temp;
        if (root.left != null)
          temp = root.left;
        else
          temp = root.right;

        // No child case
        if(temp == null) {
          temp = root;
          root = null;
        }
        else // One child case
          root = temp; // Copy the contents of the non-empty child

        temp = null;
      }
      else {
        // node with two children: Get the inorder successor (smallest
        // in the right subtree)
        Node temp = minValueNode(root.right);

        // Copy the inorder successor's data to this node
        root.value = temp.value;

        // Delete the inorder successor
        root.right = deleteNode(root.right, temp.value);
      }
    }

    // If the tree had only one node then return
    if (root == null)
      return root;

    // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
    root.height = Math.max(height(root.left), height(root.right)) + 1;

    // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
    //  this node became unbalanced)
    int balance = getBalance(root);

    // If this node becomes unbalanced, then there are 4 cases

    // Left Left Case
    if (balance > 1 && getBalance(root.left) >= 0)
      return rightRotate(root);

    // Left Right Case
    if (balance > 1 && getBalance(root.left) < 0) {
      root.left =  leftRotate(root.left);
      return rightRotate(root);
    }

    // Right Right Case
    if (balance < -1 && getBalance(root.right) <= 0)
      return leftRotate(root);

    // Right Left Case
    if (balance < -1 && getBalance(root.right) > 0) {
      root.right = rightRotate(root.right);
      return leftRotate(root);
    }

    return root;
  }



  public static void main(String args[]) {
    AVLT t = new AVLT();
    Node root = null;

    root = t.insert(root,40);
    root = t.insert(root,50);
    root = t.insert(root,60);

  }
}