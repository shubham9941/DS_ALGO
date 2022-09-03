package pract.dp.pract.medium;

import pract.Reader;

public class OptimalStrategyForAGame {

    static long getMax(int i, int j, int[] arr, long[][] t) {
        if (i > j) {
            return 0;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }

        long first = arr[i] + Long.min(getMax(i + 2, j, arr, t), getMax(i + 1, j - 1, arr, t));
        long second = arr[j] + Long.min(getMax(i, j - 2, arr, t), getMax(i + 1, j - 1, arr, t));

        t[i][j] = Long.max(first, second);
        return t[i][j];
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
            long[][] t = new long[size + 1][size + 1];
            for (int i = 0; i < size + 1; i++) {
                for (int j = 0; j < size + 1; j++) {
                    t[i][j] = -1;
                }
            }
            System.out.println(getMax(0, size - 1, arr, t));
        }
    }
}
