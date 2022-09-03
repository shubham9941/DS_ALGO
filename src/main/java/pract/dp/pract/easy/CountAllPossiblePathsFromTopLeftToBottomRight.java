package pract.dp.pract.easy;

import pract.Reader;

public class CountAllPossiblePathsFromTopLeftToBottomRight {

    static int mod = 1000000007;
    static long[][] t ;


    static long count(int i, int j, int n, int m) {
        if (i >= n || i < 0 || j >= m || j < 0) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }

        long forwardMove = count(i, j + 1, n, m);
        long downMove = count(i + 1, j, n, m);
        t[i][j] = (forwardMove + downMove) % mod;
        return t[i][j];
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            t = new long[n+1][m+1];
            for (int i = 0; i < n+1; i++) {
                for (int j = 0; j < m+1; j++) {
                    t[i][j] = -1;
                }
            }
            System.out.println(count(0, 0, n, m));
        }

    }
}
