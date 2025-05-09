package com.java.dsa.sorting;

import java.util.Arrays;

public class MinHeap {
  private int capacity = 10;
  private  int size = 0;
  int[] items = new int[capacity];

  /*Helper method start*/
  private int getLeftChildIndex(int parentIndex){ return 2 * parentIndex + 1;}
  private int getRightChildIndex(int parentIndex){ return 2 * parentIndex + 2; }
  private int getParentIndex(int childIndex){ return (childIndex - 1) / 2;}

  private boolean hasLeftChild(int index){ return (getLeftChildIndex(index) < size);}
  private boolean hasRightChild(int index){ return (getRightChildIndex(index) < size);}
  private boolean hasParent(int index){ return (getParentIndex(index) >= 0);}

  private int leftChild(int index){ return items[getLeftChildIndex(index)]; }
  private int rightChild(int index){ return items[getRightChildIndex(index)]; }
  private int parent(int index){ return items[getParentIndex(index)]; }

  private void swap(int firstIndex, int secondIndex){
    int tmp = items[firstIndex];
    items[firstIndex] = items[secondIndex];
    items[secondIndex] = tmp;
  }

  private void ensureCapacity(){
    if(size == capacity){
      items = Arrays.copyOf(items,capacity*2);
      capacity *= 2;
    }
  }
/*Helper methods ends*/

  private int peak(){
    if(size == 0) throw new IllegalStateException();
    return items[0];
  }
  //remove min element
  public int poll(){
    if(size == 0) throw  new IllegalStateException();
    int item = items[0];
    items[0] = items[size-1];
    size-- ;
    heapifyDown();
    return  item;
  }

  public void add(int item){
    ensureCapacity();
    items[size] =  item;
    size++;
    heapifyUp();
  }

  public void heapifyUp(){
    int index = size - 1;
    while(hasParent(index) && parent(index) > items[index]){
      swap(getParentIndex(index),index);
      index = getParentIndex(index);
    }
  }

  public void heapifyDown(){
    int index = 0;
    while(hasLeftChild(index)){  // if there is no left child certainly there is no right child
      int smallerChildIndex = getLeftChildIndex(index);
      if(hasRightChild(index) && rightChild(index) < leftChild(index)){
        smallerChildIndex = getRightChildIndex(index);
      }
      if(items[index] < items[smallerChildIndex]){
        break;
      }else{
        swap(index,smallerChildIndex);
      }
      index = smallerChildIndex;
    }
  }

  public static void main(String[] args) {
    MinHeap heap = new MinHeap();
    heap.add(10);
    heap.add(15);
    heap.add(20);
    heap.add(17);
    heap.add(25);
    heap.add(18);
    heap.add(19);
    for(int i : heap.items){
      System.out.println(i);
    }
  }
}
