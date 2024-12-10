package com.java.dsa.dp.memoization;

public class CoinChangeProblem4 {
    


    /*Algorithm using DP bottom up approach
     * Step1-> Make a 2D array with N+1 rows and amount+1 column because the amount can also be zero.
     *         Here N is the size of the coin array
     * the coins array is zero and the amount you have to make is also zero, then we will return 0
     * because to make zero amount zero coins are sufficient else we will return -1
     * 
     * step2-> Now on each coin in coins array we will decide
     *     2.1-> That this coin will be used in making amount and will do amount-coins[start]
     *     2.3-> That this coin will not be used in making amount and  amount will do start+1
     *step3-> Now add 1 in the first recursive call since you decided in that call that you are 
     *        taking that coin and return the minimum of the answer received by recursive calls.
     *        	 
     * Time Complexity: O(N * A) where ‘N’ refers to the size of the array and ‘A’ refers to the amount.
     * Here we are visiting a 2-D array of size N * A just once that’s why we are arriving at this time complexity.
     * 
     * 
     * */
    public static int minCoinChange(int[] coins, int start, int amount, int[][]mem ) {
	
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

      //if result of that recursive call already present
	if(mem[start][amount] !=-1) {
	    return mem[start][amount];
	}
	// Recursive calls
	
	   int result1 = minCoinChange(coins, start, amount - coins[start],mem);
	   int result2 = minCoinChange(coins, start + 1,  amount,mem);
	
	if (result1 != -1 && result2 != -1) {
	    mem[start][amount] = Math.min(result1+1, result2);
	    return mem[start][amount];
	}

	// If we cannot achieve that amount through recursive call 1
	if (result1 == -1) {
	    mem[start][amount] =result2;
	    return mem[start][amount];
	}

	// If we cannot achieve that amount through recursive call 2
	if (result2 == -1) {
	    mem[start][amount]= (result1 + 1);
	    return mem[start][amount];
	}

	return -1;
    }
    
    
    public static void main(String[] args) {
	
	int amount1 = 11;
	int []coins1 = {1,2,5};
	int[][] mem = new int[3][amount1];
	for (int i = 0; i < coins1.length; i++) {
	        mem[i] = new int[amount1 + 1];
	        for (int j = 0; j <= amount1; j++) {
	            mem[i][j] = -1;
	        }
	    }
	
	System.out.println(minCoinChange(coins1,0,amount1,mem));
    }


}
