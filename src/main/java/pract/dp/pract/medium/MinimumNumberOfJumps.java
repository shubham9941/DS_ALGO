package pract.dp.pract.medium;

import pract.Reader;

public class MinimumNumberOfJumps {

    static boolean flag;

    static long solveUtil(int[] arr, int n, int start, long[] t) {
        if (start >= n - 1) {
            flag = true;
            return 0;
        }

        if (arr[start] == 0) {
            return Integer.MAX_VALUE;
        }

        if (t[start] != -1) {
            return t[start];
        }

        int choices = arr[start];
        long min = Integer.MAX_VALUE;
        for (int i = 1; i <= choices; i++) {
            long res = 1 + solveUtil(arr, n, start + i, t);
            System.out.println("res = " + res);
            if (res < min) {
                min = res;
            }
        }
        t[start] = min;
        return min;
    }

    static long solve(int[] arr, int n) {
        flag = false;
        long[] t = new long[n + 1];
        for (int i = 0; i < n + 1; i++) {
            t[i] = -1;
        }
        long res = solveUtil(arr, n, 0, t);
        return (flag) ? res : -1;
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(solve(arr, size));
        }
    }
}
