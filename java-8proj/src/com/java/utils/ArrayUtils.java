package com.java.utils;

import java.util.Arrays;

public class ArrayUtils {
  public static Integer[] insertLast(Integer[] array,Integer num){
    Integer [] tmpArray = new Integer[array.length+1];
    for (int i =0; i< tmpArray.length; i++){
      if (i == array.length){
        tmpArray[i] = num;
      }else{
        tmpArray[i] = array[i];
      }
    }
    return tmpArray;
  }

  public static String [][] insertLastInEachSubArray(String[][] array,String word) {
    int arrayLength = array == null || array.length == 0 ? 1 : array.length;
    String[][] tmpArray = new String[arrayLength][];
    for (int i = 0; i < tmpArray.length; i++) {
      String[] subArray =
          array == null || array.length == 0 || array[i] == null || array[i].length == 0
              ? new String[1] : new String[array[i].length + 1];
      if (array != null && array.length != 0 && array[i] != null) {
        copyArray(array[i], subArray);
      }
      subArray[subArray.length - 1] = word;
      tmpArray[i] = subArray;
    }
    return tmpArray;
  }

  private static void copyArray(String[] from, String[] to) {
    for (int i=0; i<from.length; i++){
      to[i] = from[i];
    }
  }

  public static String[][] insertFirstInEachSubArray(String element, String[][] array) {

    String[][] tempArray = null;
    if (array.length == 0) {
      tempArray = new String[array.length + 1][];
      tempArray[0] = new String[1];
      tempArray[0][0] = element;
      return tempArray;
    } else {
      tempArray = new String[array.length][];
    }
    for (int i = 0; i < array.length; i++) {
      tempArray[i] = new String[array[i].length + 1];
      for (int j = 0; j <= array[i].length; j++) {
        if (j == 0) {
          tempArray[i][j] = element;
        } else {
          tempArray[i][j] = array[i][j - 1];
        }
      }
    }
    return tempArray;
  }


  public static String[][] mergeJaggedArrays(String[][] array1, String[][] array2) {
    if(array1 == null) return array2;
    if(array2 == null ) return array1;
    int array1RowLength = array1.length;
    int array2RowLength = array2.length;
    String[][] mergedArray = new String[array1RowLength + array2RowLength][];

    /* copy elements from first array*/
    for (int i = 0; i < array1RowLength; i++) {
      int colLength = array1[i].length;
      mergedArray[i] = new String[colLength];
      for (int j = 0; j < colLength; j++) {
        mergedArray[i][j] = array1[i][j];
      }
    }

    // Copy elements from the second array
    for (int i = 0; i < array2RowLength; i++) {
      int colLength = array2[i].length;
      mergedArray[i+array1RowLength] = new String[colLength];
      for (int j = 0; j < colLength; j++) {
        mergedArray[i + array1RowLength][j] = array2[i][j];
      }
    }
    return mergedArray;
  }
}
