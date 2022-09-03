package pract.dp.pract.medium;

// Note:- Order does not matter(This is the problem) ans in one line is (n/2) + 1

import pract.Reader;

//This is doubt full please check code for this using DP
public class CountWaysTONThStair {

    static long get(int[] arr, int n, int sum, long[][] t) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0 || sum < 0) {
            return 0;
        }

        if (t[n][sum] != -1) {
            return t[n][sum];
        }

        if (arr[n - 1] > sum) {
            t[n][sum] = get(arr, n - 1, sum, t);
            return t[n][sum];
        } else {
            t[n][sum] = get(arr, n, sum - arr[n - 1], t) + get(arr, n - 1, sum, t);
            return t[n][sum];
        }
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int sum = sc.nextInt();
            int[] arr = {1, 2};
            long[][] t = new long[arr.length + 1][sum + 1];
            for (int i = 0; i < arr.length + 1; i++) {
                for (int j = 0; j < sum + 1; j++) {
                    t[i][j] = -1;
                }
            }
            System.out.println(get(arr, arr.length, sum, t));
        }
    }
}
