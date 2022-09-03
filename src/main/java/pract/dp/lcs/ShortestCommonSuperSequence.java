package pract.dp.lcs;

/**
 * Input:   str1 = "geek",  str2 = "eke"
 * Output: "geeke"
 * <p>
 * Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
 * Output:  "AGXGTXAYB"
 */


// Note if question is like print the length then it will be (st1 + str2) - LCS(st1 , str2)

/**
 * Length of the shortest supersequence  = (Sum of lengths of given two strings) -
 * (Length of LCS of two given strings)
 */

public class ShortestCommonSuperSequence {


    // This function is used to print the ShortestCommonSuperSequence

    static String find(char[] x, char[] y, int n, int m) {
        if (n == 0) {
            String res = "";
            for (int i = m - 1; i >= 0; i--) {
                res += y[i];
            }
            return res;
        }
        if (m == 0) {
            String res = "";
            for (int i = n - 1; i >= 0; i--) {
                res += x[i];
            }
            return res;
        }


        if (x[n - 1] == y[m - 1]) {
            return x[n - 1] + find(x, y, n - 1, m - 1);
        }

        String left = x[n - 1] + find(x, y, n - 1, m);
        String right = y[m - 1] + find(x, y, n, m - 1);
        return (left.length() < right.length()) ? left : right;
    }

    public static void main(String[] args) {

        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        System.out.println(find(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));

    }
}
