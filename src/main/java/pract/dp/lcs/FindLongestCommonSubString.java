package pract.dp.lcs;

/**
 Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
 Output : 5
 The longest common substring is “Geeks” and is of length 5.

 Input : X = “abcdxyz”, y = “xyzabcd”
 Output : 4
 The longest common substring is “abcd” and is of length 4.

 Input : X = “zxabcdezy”, y = “yzabcdezx”
 Output : 6
 The longest common substring is “abcdez” and is of length 6.
 */

public class FindLongestCommonSubString {


    //Using DP

    static int findLongestCommonSubSequenceUsingDP(char[] x, char[] y, int n, int m) {
        int[][] t = new int[n + 1][m + 1];
        int res = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else if (x[i - 1] == y[j - 1]) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = 0;
                }

                if (t[i][j] > res) {
                    res = t[i][j];
                }
            }
        }
        return res;
    }


    //Another approach using recursion
    static int result = 0;

    static void find(char[] x, char[] y, int n, int m, int res) {
        if (n == 0 || m == 0) {
            if (res > result) {
                result = res;
            }
        } else if (x[n - 1] == y[m - 1]) {
            find(x, y, n - 1, m - 1, res + 1);
        } else {
            if (res > result) {
                result = res;
            }
            find(x, y, n - 1, m, 0);
            find(x, y, n, m - 1, 0);
        }
    }

    static int find(String x, String y, int n, int m) {
        result = 0;
        find(x.toCharArray(), y.toCharArray(), n, m, 0);
        return result;
    }


    public static void main(String[] args) {
        String x = "GeeksforGeeks";
        String y = "GeeksQuiz";

//        System.out.println(find(x, y, x.length(), y.length()));
        System.out.println(findLongestCommonSubSequenceUsingDP(
                x.toCharArray(), y.toCharArray(), x.length(), y.length()
        ));

    }
}
