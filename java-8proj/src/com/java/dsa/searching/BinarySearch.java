package com.java.dsa.searching;

public class BinarySearch {
  public static int recursiveSearch(int[] sortedArray, int value, int low, int high) {

    if (high >= low) {
      int mid = low + (high - low) / 2;
      if (sortedArray[mid] == value) {
        return sortedArray[mid];
      } else if (sortedArray[mid]
          > value) {  //mid is greater than search key value must be present in left subarray
        return recursiveSearch(sortedArray, value, low, mid - 1);
      } else {
        return recursiveSearch(sortedArray, value, mid + 1, high);
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int [] numbers = {30,40,50,55,60,65,70,80,90,95,96,97,98};
    int searchKey = 98;
    int result = recursiveSearch(numbers,searchKey,0,numbers.length-1);
    if(result < 0){
      System.out.println("key not found");
    }else {
      System.out.println("key found "+ result);
    }
  }
}
