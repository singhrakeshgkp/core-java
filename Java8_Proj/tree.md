
<details><summary>
  
###  Binary Search Tree
</summary>
  
referred coreman book
#### Binary search tree property
```
Let x be a node in binary search tree. If y is a node in the left substree of x, then y.key<= x.key. 
If y is a node in the right subtree of x, then y.key>= x.key
```

#### Tree Traversal ```BinarySearchTreeTraversal.java```
  - Inorder (print the key in sorted order)
  ```
    InOrder-Tree-Walk(x)
  1. if(x!=null)
  2.    InOrder-Tree-Walk(x.left)
  3.    print key
  4.    InOrder-Tree-Walk(x.right)
  ```
  - Preorder
   ```
      Preorder-Tree-Walk(x)
    1. if(x!=null)
    2.    print key
    3.    Preorder-Tree-Walk(x.left)
    4.    Preorder-Tree-Walk(x.right)
   ```
  - postorder
  
   ```
   postorder-Tree-Walk(x)
    1. if(x!=null)
    2.   postorder-Tree-Walk(x.left)
    3.   postorder-Tree-Walk(x.right) 
    4.   print key 
   ```
 ###### Complexity
 - Time Complexity O(n) 
 - Space Complexity O(1) if we do not consider function calls else O(h) where h is the height of the tree.
    
#### Searching, Finding Min, Max, Predecessor, and successor
  ##### Searching- recursive
  ```
  tree-search(x,k)
  1. if x == null || k ==x.key
  2.    return x
  3. if k<x.key
  4.    return tree-search(x.left,k)
  5. else return tree-search(x.right,k)
  ```
 ##### Searching- iterative
 ```
  tree-search(x,k)
  1. while x !=null && x.key != k
  2.     if k < x.key
  3.          x = x.left
  4.     else x= x.right
  5. return x
 ```
 
##### Minimum and Maximum
  ```
  Min(x)
  1. while x.left != null
  2.      x = x.left
  3. return x
  
  Max(x)
  1. while x.right != null
  2.      x = x.right
  3. return x
  ```
  
 ##### Successor and Predecessor
  ```
  Successor-> successor of node x is the node 
  ```
  
</details>

