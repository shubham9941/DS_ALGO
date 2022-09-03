package pract.dp.lcs;

/**
 * Examples:LongestCommonSubSequence(LCS)
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class FindLongestCommonSubSequence {

    //Using DP

    static int findLongestCommonSubSequenceUsingDP(char[] x, char[] y, int n, int m) {
        int[][] t = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else if (x[i - 1] == y[j - 1]) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Integer.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }
        return t[n][m];
    }

    //Using Recursion

    static int find(char[] x, char[] y, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (x[n - 1] == y[m - 1]) {
            return 1 + find(x, y, n - 1, m - 1);
        } else {
            return Integer.max(find(x, y, n, m - 1), find(x, y, n - 1, m));
        }
    }

    public static void main(String[] args) {
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
        System.out.print(findLongestCommonSubSequenceUsingDP(
                str1.toCharArray(),
                str2.toCharArray(),
                str1.length(),
                str2.length()
        ));
    }
}
