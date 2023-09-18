package com.java.ds.dp;

public class CoinChangeProblem1 {

    /*1. coinChange-> number of ways exchange can be made
     * 
     */
    public static void main(String[] args) {
	/*1 Number of ways exchange can be made*/
	int amount1 = 10;
	int []coins1 = {2,5,3,6};
	System.out.println(coinChange(coins1,coins1.length,amount1));
    }

    private static int coinChange(int[] coins, int n, int sum) {
	if (sum == 0) {
	    return 1;
	}
	if (sum < 0 || n < 0) {
	    return 0;
	}
	int first = coinChange(coins, n, sum - coins[n]);
	int second = coinChange(coins, n - 1, sum);
	return first + second;
    }
    
}
