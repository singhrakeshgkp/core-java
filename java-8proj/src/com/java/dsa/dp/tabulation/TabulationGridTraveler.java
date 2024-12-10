package com.java.dsa.dp.tabulation;

public class TabulationGridTraveler {
  public static int findNumberOfWays(int row, int column){
    int[][] grid = new int[row+1][column+1];
    grid[1][1] = 1;

    for (int i =0; i<=row; i++){
      for (int j=0; j<=column; j++){
        //copy current position value to its right and down neighbour
       /* [0][0]---Right neighbour  = [0][1]
       *  [0][0]--->Down neighbour = [1][0]... so on
       * */
        if((j+1)<=column) {
          grid[i][j + 1] += grid[i][j];
        }
        if((i+1)<=row) {
          grid[i + 1][j] += grid[i][j];
        }
      }
    }
    System.out.println("grid");
    return grid[row][column];
  }
  public static void main(String[] args) {
    System.out.println(findNumberOfWays(3,3));
  }

}
