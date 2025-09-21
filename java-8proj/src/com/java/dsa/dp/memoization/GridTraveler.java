package com.java.dsa.dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {
//inefficient
 public static int travel(int m, int n){
   if (m == 1 & n == 1) return 1;
   if(m == 0 || n == 0) return 0;
   return travel(m-1,n)+travel(m,n-1);
 }

 // optimized with memoized
  public static long travel(int m, int n, Map<String,Long> memo){
   String k1 = m + "," + n;
   String k2 = n + "," + m;
   if(memo.containsKey(k1)) return memo.get(k1);
   if(memo.containsKey(k2)) return memo.get(k2);
   if (m == 1 & n == 1) return 1;
    if(m == 0 || n == 0) return 0;
    long ways = travel(m-1,n,memo)+travel(m,n-1,memo);
    memo.put(k1,ways);
    memo.put(k2,ways);
    return  ways;
  }
  public static void main(String[] args) {
    //System.out.println(travel(9,9));  // inefficient
   System.out.println("Number of ways: " + travel(3, 3, new HashMap<>()));
   System.out.println("Number of ways: " + travel(5, 4, new HashMap<>()));
   System.out.println("Number of ways: " + travel(4, 5, new HashMap<>()));
  }
}
