package com.java.ds.dp;

public class CoinChangeProblem2 {

    /*Algorithm
     * Step1-> we will decide on base case first. The base base will be that suppose the size of 
     * the coins array is zero and the amount you have to make is also zero, then we will return 0
     * because to make zero amount zero coins are sufficient else we will return -1
     * 
     * step2-> Now on each coin in coins array we will decide
     *     2.1-> That this coin will be used in making amount and will do amount-coins[start]
     *     2.3-> That this coin will not be used in making amount and  amount will do start+1
     *step3-> Now add 1 in the first recursive call since you decided in that call that you are 
     *        taking that coin and return the minimum of the answer received by recursive calls.
     *        	 
     * Complexity O(2)^n (where n refers to the number of coins) for better time complexity
     * refer {CoinChangeProblem3.java}
     * 
     * 
     * */
    static int counter =0;
    public static int minCoinChange(int[] coins, int start, int amount ) {
	counter++;
	if(counter==68) {
	
	System.out.println(counter);
	}
	//System.out.println("start "+start+", amount "+amount+" , coins length "+coins.length+ " coin start"+ coins[start]);
	// Base Case
	if (start > (coins.length - 1)) {
	    if (amount == 0) {
		return 0;
	    }
	    return -1;
	}

	// If amount is negative
	if (amount < 0) {
	    return -1;
	}

	// Recursive calls
	
	   int result1 = minCoinChange(coins, start, amount - coins[start]);
	   int result2 = minCoinChange(coins, start + 1,  amount);
	
	if (result1 != -1 && result2 != -1) {
	    return Math.min(result1+1, result2);
	}

	// If we cannot achieve that amount through recursive call 1
	if (result1 == -1) {
	    return result2;
	}

	// If we cannot achieve that amount through recursive call 2
	if (result2 == -1) {
	    return (result1 + 1);
	}

	return -1;
    }
    
    
    public static void main(String[] args) {
	
	int amount1 = 5;
	int []coins1 = {1,2,3};
	System.out.println(minCoinChange(coins1,0,amount1));
    }
}
