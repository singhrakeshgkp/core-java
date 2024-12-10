package com.java.dsa.dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeProblemByG {
  public static long makeChange(int[] coins, int money, int index, Map<String,Long> memo){
    //index tells what coin we are considering
    if(money == 0){
      return  1; // how many wasy to make 0 cents is 1
    }

    if(index >= coins.length){
      return 0;
    }
    int amountWithCoin = 0;
    long noOfWays = 0;
    String key = money + "_" + index;
    if (memo.containsKey(key)){
      return memo.get(key);
    }
    while (amountWithCoin <= money){
      int remaining = money - amountWithCoin;
      noOfWays += makeChange(coins,remaining,index+1,memo);
      amountWithCoin += coins[index];
      System.out.println(coins[index]+" , "+amountWithCoin);
    }
    memo.put(key,noOfWays);
    return  noOfWays;
  }

  public static void main(String[] args) {
    Map<String,Long> memo = new HashMap<>();
    int[] coins = {50,25,10,5,1};
    int amount = 79;
    makeChange(coins,amount,0,memo);
  }
}
