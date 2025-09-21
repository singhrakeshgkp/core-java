package com.java.dsa.tree;

public class RedBlackTree {
  Node root;
  static  final boolean RED = false;
  static final boolean BLACK = true;
  private  void rotateRight(Node node){
    Node parent = node.parent;
    Node leftChild = node.left;
    node.left = leftChild.right;
    if (leftChild.right != null){
      leftChild.right.parent = node;
    }
    leftChild.right = node;
    node.parent = leftChild;

    maintainParentChild(parent,node,leftChild);
  }

  private void rotateLeft(Node node){
    Node parent = node.parent;
    Node rightChild = node.right;
    node.right = rightChild.left;
    if (rightChild.left != null){
      rightChild.left.parent = node;
    }
    rightChild.left = node;
    node.parent = rightChild;

  }

  private void maintainParentChild(Node parent, Node oldChild, Node newChild) {
    if (parent == null){
      root = newChild;
    }else if (parent.left == oldChild){
      parent.left = newChild;
    }else if (parent.right == oldChild){
      parent.right = newChild;
    }else {
      throw new IllegalStateException("node isn't child of its parent");
    }
    if (newChild != null){
      newChild.parent = parent;
    }
  }

  /*Operations on red black tree*/
  public Node search(int key) {
    Node node = root;
    while (node != null) {
      if (key == node.data) {
        return node;
      } else if (key > node.data) {
        node = node.right;
      } else {
        node = node.left;
      }
    }
    return null;
  }

  public void insert(int key){
    Node node = root;
    Node parent = null;
    while (node !=null){
      parent = node;
      if (key > node.data){
        node = node.right;
      }else if (key < node.data){
        node = node.left;
      }else{
        throw new IllegalArgumentException("Key u are trying is insert is already exist");
      }
    }

    // insert new node;
    Node nn = new Node(key);
    nn.color = RED;
    if (parent == null){
      root = nn;
    }else if (key > parent.data){
      parent.right = nn;
    }else{
      parent.left = nn;
    }
    nn.parent = parent;
    maintainRedBlackPropertiesPostInsert(nn);
  }

  private void maintainRedBlackPropertiesPostInsert(Node node) {
    Node parent = node.parent;
    /* case 1 if parent is null, we are at the root , end of recursion*/
    if (parent == null){
      node.color = BLACK;
      return ;
    }
    if ( parent.color == BLACK){
      return;
    }
    Node grandParent = parent.parent;
    /*case 2 if grandParent is null that means parent is root*/
    if (grandParent == null){
      parent.color = BLACK;
      return;
    }
    Node uncle = getSibling(parent);
    /*if uncle is null, its color is going to be Black*/
    /*case 3 uncle is red --> redcolor parent, grandparent and uncle*/
    if (uncle != null && uncle.color == RED){
      parent.color = BLACK;
      grandParent.color = RED;
      uncle.color = BLACK;
    }

    //if parent is the left child of grandparent
    else if (parent == grandParent.left){
      //case 4a Uncle is black and node is left->right "inner child" of its grandparent
      if (node == parent.right){
        rotateLeft(parent);
        parent = node;
        //now parent will point to new root node of the rotated subtree
      }
      //case 5a uncle is black and node is left->left "outer child" of its grandparent
      rotateRight(grandParent);
      //recolor original parent and grandparent
      parent.color = BLACK;
      grandParent.color = RED;
    }else{
     //Case 4b: Uncle is black and node is right->left "inner child" of its grandparent
      if (node == parent.left) {
        rotateRight(parent);

        // Let "parent" point to the new root node of the rotated sub-tree.
        parent = node;
      }
      // Case 5b: Uncle is black and node is right->right "outer child" of its grandparent
      rotateLeft(grandParent);
      parent.color = BLACK;
      grandParent.color = RED;
    }

  }

  private Node getSibling(Node node) {
    Node grandParent = node.parent;
    if (grandParent.left == node){
      return grandParent.right;
    }else if (grandParent.right == node){
      return grandParent.left;
    }else{
      throw new IllegalArgumentException("Invalid argument, parent is not child of its grand parent");
    }
  }




  private void fixRedBlackPropertiesAfterInsert(Node node) {
    Node parent = node.parent;

    // Case 1: Parent is null, we've reached the root, the end of the recursion
    if (parent == null) {
      // Uncomment the following line if you want to enforce black roots (rule 2):
      // node.color = BLACK;
      return;
    }

    // Parent is black --> nothing to do
    if (parent.color == BLACK) {
      return;
    }

    // From here on, parent is red
    Node grandparent = parent.parent;

    // Case 2:
    // Not having a grandparent means that parent is the root. If we enforce black roots
    // (rule 2), grandparent will never be null, and the following if-then block can be
    // removed.
    if (grandparent == null) {
      // As this method is only called on red nodes (either on newly inserted ones - or -
      // recursively on red grandparents), all we have to do is to recolor the root black.
      parent.color = BLACK;
      return;
    }

    // Get the uncle (may be null/nil, in which case its color is BLACK)


    // Case 3: Uncle is red -> recolor parent, grandparent and uncle


    // Note on performance:
    // It would be faster to do the uncle color check within the following code. This way
    // we would avoid checking the grandparent-parent direction twice (once in getUncle()
    // and once in the following else-if). But for better understanding of the code,
    // I left the uncle color check as a separate step.

    // Parent is left child of grandparent
    else if (parent == grandparent.left) {
      // Case 4a: Uncle is black and node is left->right "inner child" of its grandparent
      if (node == parent.right) {
        rotateLeft(parent);

        // Let "parent" point to the new root node of the rotated sub-tree.
        // It will be recolored in the next step, which we're going to fall-through to.
        parent = node;
      }

      // Case 5a: Uncle is black and node is left->left "outer child" of its grandparent
      rotateRight(grandparent);

      // Recolor original parent and grandparent
      parent.color = BLACK;
      grandparent.color = RED;
    }

    // Parent is right child of grandparent
    else {
      // Case 4b: Uncle is black and node is right->left "inner child" of its grandparent
      if (node == parent.left) {
        rotateRight(parent);

        // Let "parent" point to the new root node of the rotated sub-tree.
        // It will be recolored in the next step, which we're going to fall-through to.
        parent = node;
      }

      // Case 5b: Uncle is black and node is right->right "outer child" of its grandparent
      rotateLeft(grandparent);

      // Recolor original parent and grandparent
      parent.color = BLACK;
      grandparent.color = RED;
    }
  }

}

