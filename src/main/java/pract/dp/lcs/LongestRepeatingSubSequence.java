package pract.dp.lcs;

/**
 * Str  = "AABEBCDD"
 * output = "ABD"
 */

import pract.Reader;

/**
 * Input: str = "abc"
 * Output: 0
 * There is no repeating subsequence
 * <p>
 * Input: str = "aab"
 * Output: 1
 * The two subssequence are 'a'(first) and 'a'(second).
 * Note that 'b' cannot be considered as part of subsequence
 * as it would be at same index in both.
 * <p>
 * Input: str = "aabb"
 * Output: 2
 * <p>
 * Input: str = "axxxy"
 * Output: 2
 */

// Note - code is same except one condition here index of common element should not be same
public class LongestRepeatingSubSequence {

    static int LRS(String str ,int n) {
        char[] str1 = str.toCharArray();
        char[] str2 = str.toCharArray();
        int[][] t = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else if (str1[i - 1] == str2[j - 1] && i != j) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Integer.max(t[i - 1][j], t[i][j - 1]);
                }
            }

        }
        return t[n][n];

    }


    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int l = sc.nextInt();
            String str = sc.readLine();
            System.out.println(LRS(str, l));
        }

    }
}
