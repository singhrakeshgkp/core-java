package com.java.dsa.searching;

public class LinearSearch {

  private static int search(int[] nums,int searchKey) {
    for (int i =0; i< nums.length; i++){
      if (searchKey == nums[i])
        return i;
    }
    return -1;
  }
  public static void main(String[] args) {
    int[] nums = {12,34,11,55,87,56,434,90};
    int key = 500;
    int result = search(nums,key);
    if (result >=0) {
      System.out.println("key "+key+" present at index "+result);
    }else{
      System.out.println("Key "+key+" is not present in array");
    }
  }
}
