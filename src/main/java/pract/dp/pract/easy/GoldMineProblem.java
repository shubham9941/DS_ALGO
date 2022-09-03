package pract.dp.pract.easy;

import pract.Reader;

public class GoldMineProblem {

    static int getMaxProfit(int[][] arr, int n, int m, int i, int j, int[][] t) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return 0;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }


        int res1 = getMaxProfit(arr, n, m, i, j + 1, t);
        int res2 = getMaxProfit(arr, n, m, i - 1, j + 1, t);
        int res3 = getMaxProfit(arr, n, m, i + 1, j + 1, t);
        int max = Integer.MIN_VALUE;
        if (res1 > max) {
            max = res1;
        }
        if (res2 > max) {
            max = res2;
        }
        if (res3 > max) {
            max = res3;
        }
        t[i][j] = arr[i][j] + max;
        return arr[i][j] + max;
    }

    static int getMax(int[][] arr, int n, int m) {
        int[][] t = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                t[i][j] = -1;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int res = getMaxProfit(arr, n, m, i, 0, t);
            if (res > max) {
                max = res;
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println(getMax(arr, n, m));
        }

    }
}
