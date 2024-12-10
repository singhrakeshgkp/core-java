package com.java.dsa.dp.tabulation;

public class FibTabulationEx {

  private static long getFib(int n) {
    long [] table = new long[n+1];
    table[1] = 1;
    for (int i =0; i< table.length-1; i++){
      table[i+1] += table[i];
      if((i+2) < table.length)
      table[i+2] += table[i];
      System.out.println("");
    }
    return table[n];
  }
  public static void main(String[] args) {
    long fibNumber = getFib(6);
    System.out.println(fibNumber);
  }


}
