package pract.dp.lcs;

import java.util.Arrays;

// This is same as LongestCommonSubSequence but here we are printing the subSequence instead of length
public class PrintLCS {

    //Using DP
   public static String getLCS(char[] x, char[] y, int n, int m) {
        String[][] t = new String[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = "";
                } else if (x[i - 1] == y[j - 1]) {
                    t[i][j] = x[i - 1] + t[i - 1][j - 1];
                } else {
                     t[i][j] = ((t[i][j - 1]).length() > (t[i - 1][j]).length()) ? t[i][j - 1] : t[i - 1][j];
                }
            }
        }

        return t[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcdgh";
        String str2 = "abedfha";
        System.out.print(getLCS(
                str1.toCharArray(),
                str2.toCharArray(),
                str1.length(),
                str2.length()
        ));
    }
}
