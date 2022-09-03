package pract.dp.unbounded_knapack;

import java.util.Arrays;

/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * For example, if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * <p>
 * <p>
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 * And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
 * <p>
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 3   5   8   9  10  17  17  20
 */

// This is the same problem as FindMaxProfitKnapsack but here we can take one item multiple times
public class RodCuttingProblem {


    static int findMaxCost(int[] rodSize, int[] sizeCost, int n, int totalRodSize) {
        // INITIALIZATION
        int[][] t = new int[n + 1][totalRodSize + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < totalRodSize + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        // After initialization apply knapsack

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < totalRodSize + 1; j++) {
                if (rodSize[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {

                    t[i][j] = Math.max(
                            sizeCost[i - 1] + t[i][j - rodSize[i - 1]], //Notice here did not take i-1 like 0-1 knapsack bcz this is unbounded knapsack
                            t[i - 1][j]
                    );
                }
            }
        }

        // Return last block
        return t[n][totalRodSize];
    }

    // Note optimal sol using O(n) space

    static int find(int[] rodSize , int[] cost, int n , int rl) {
        int[] t = new int[rl + 1];
        t[0] = 0;
        for (int i = 1; i < rl + 1; i++) {
            for (int j = 0; j < n; j++) {
                if(rodSize[j] <= i){
                    t[i] = Integer.max(t[i] , cost[j] + t[i - rodSize[j]]);
                }
            }
        }

        return t[rl];
    }

    public static void main(String[] args) {

        int n = 8;
        int[] rodSize = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};

//        System.out.println(findMaxCost(rodSize, price, price.length, 8));
        System.out.println(find(rodSize, price, price.length, 8));

    }
}
