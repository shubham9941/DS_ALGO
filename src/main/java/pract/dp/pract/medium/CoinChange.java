package pract.dp.pract.medium;

// Note:- Number of ways:-

import pract.Reader;

import java.util.Arrays;


//Note:- This is same as subset sum prob
public class CoinChange {

    // Using recursion
    static int get(int sum, int[] coins, int n) {
        if (sum == 0) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }

        if (coins[n - 1] > sum) {
            return get(sum, coins, n - 1);
        }
        return get(sum - coins[n - 1], coins, n) + get(sum, coins, n - 1);
    }


    static int getUsingDP(int sum, int[] coins, int n) {

        int[][] t = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0) {
                        t[i][j] = 0;
                    }
                    if (j == 0) {
                        t[i][j] = 1;
                    }
                } else if (coins[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
                }

            }
        }
        return t[n][sum];
    }


    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int size = sc.nextInt();
            int[] coins = new int[size];
            for (int i = 0; i < size; i++) {
                coins[i] = sc.nextInt();
            }
            int sum = sc.nextInt();
            System.out.println(getUsingDP(sum, coins, size));
        }
    }
}
