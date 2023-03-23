
<details><summary>
  
###  Binary Search Tree
</summary>
  
referred coreman book
##### Binary search tree property
```
Let x be a node in binary search tree. If y is a node in the left substree of x, then y.key<= x.key. 
If y is a node in the right subtree of x, then y.key>= x.key
```

##### Tree Traversal ```BinarySearchTreeTraversal.java```
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
  - PostOrder
</details>

