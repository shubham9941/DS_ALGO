package pract.dp.pract.medium;


import pract.Reader;

import java.util.Arrays;

//This is coin change prob (Mostly same as unbounded knapsack)
public class FindMinimumNumberOfCoins {

    //Using recursion
    static int find(int[] coins, int V, int n) {
        if (V == 0) {
            return 0;
        }

        if (n == 0) {
            return Integer.MAX_VALUE - 1;
        }


        if (coins[n - 1] > V) {
            return find(coins, V, n - 1);
        }

        return Integer.min(
                1 + find(coins, V - coins[n - 1], n),
                find(coins, V, n - 1)
        );

    }

    //Using DP

    static int findUsingDP(int[] coins, int V, int n) {
        int[][] t = new int[n + 1][V + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < V + 1; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0) {
                        t[i][j] = Integer.MAX_VALUE - 1;
                    }
                    if (j == 0) {
                        t[i][j] = 0;
                    }
                } else if (coins[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = Integer.min(1 + t[i][j - coins[i - 1]], t[i - 1][j]);
                }
            }
        }
        if (t[n][V] == Integer.MAX_VALUE - 1) {
            return -1;
        }
        return t[n][V];
    }

    //Note: - Here question is done in o(n) space with o(m*n) complexity
    static int getUsingOptimaizedApproach(int[] coins,int V, int n) {
        int[] t = new int[V + 1];
        Arrays.fill(t, Integer.MAX_VALUE);
        t[0] = 0;

        for (int i = 1; i < V + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    t[i] = Integer.min(t[i], 1 + t[i-coins[j]]);
                }
            }
        }
        if(t[V] == Integer.MAX_VALUE){
            return -1;
        }
        return t[V];
    }



    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int V = sc.nextInt();
            int size = sc.nextInt();
            int[] coins = new int[size];
            for (int i = 0; i < size; i++) {
                coins[i] = sc.nextInt();
            }
//            System.out.println(findUsingDP(coins, V, size));
            System.out.println(getUsingOptimaizedApproach(coins, V, size));
        }
    }
}
