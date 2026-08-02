package com.java.commonproblem;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheExample {
}

class LRUCache <K,V>{
  private final int capacity;
  private final Map<K,Node> map;
  private final DoublyLinkedList dLinkedList;
  public LRUCache(int capacity){
    this.capacity = capacity;
    this.map = new HashMap<>();
    this.dLinkedList = new DoublyLinkedList();
  }

  private class Node{
    K key;
    V value;
    Node prev,next;
    Node(K key, V value){
      this.key = key;
      this.value = value;
    }
  }
  class DoublyLinkedList{
    Node head = new Node(null,null);
    Node tail = new Node(null,null);
    DoublyLinkedList(){
      head.next = tail;
      tail.prev = head;
    }

    void addFirst(Node node){

    }
  }
}
