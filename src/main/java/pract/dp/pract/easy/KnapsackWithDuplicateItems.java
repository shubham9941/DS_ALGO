package pract.dp.pract.easy;

// This is unbounded knapsack
public class KnapsackWithDuplicateItems {

    static int calculateUsingRec(int[] val, int[] wt, int n, int totalW) {
        if (n == 0 || totalW == 0) {
            return 0;
        }
        if (wt[n - 1] > totalW) {
            return calculateUsingRec(val, wt, n - 1, totalW);
        }

        return Integer.max(
                val[n - 1] + calculateUsingRec(val, wt, n, totalW - wt[n - 1]),
                calculateUsingRec(val, wt, n - 1, totalW)
        );

    }

    //DP approach
    static int calculateUsingDP(int[] val, int[] wt, int n, int totalW) {
        int[][] t = new int[n + 1][totalW + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < totalW + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else if (wt[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = Integer.max(val[i - 1] + t[i][totalW - wt[i - 1]], t[i - 1][j]);
                }
            }
        }
        return t[n][totalW];
    }

    public static void main(String[] args) {

        int[] val = {1, 4, 5, 7};
        int[] wt = {1, 3, 4, 5};

        System.out.println(calculateUsingDP(val, wt, val.length, 8));


    }
}
