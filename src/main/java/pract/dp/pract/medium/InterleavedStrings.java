package pract.dp.pract.medium;

public class InterleavedStrings {


    //This code successfully submitted at leetcode

    static boolean check(String s1, String s2, String s3, int n1, int n2, int n3, int[][] t) {
        if (n1 == 0 && n2 == 0 && n3 == 0) {
            return true;
        }

        if (n1 == 0) {
            return s3.substring(0, n3).equals(s2.substring(0, n2));
        }
        if (n2 == 0) {

            return s3.substring(0, n3).equals(s1.substring(0, n1));
        }

        if (t[n1][n2] != -1) {
            return (t[n1][n2] == 1);
        }

        boolean res = (s3.charAt(n3 - 1) == s1.charAt(n1 - 1) && check(s1, s2, s3, n1 - 1, n2, n3 - 1, t)) ||
                (s3.charAt(n3 - 1) == s2.charAt(n2 - 1) && check(s1, s2, s3, n1, n2 - 1, n3 - 1, t));

        t[n1][n2] = (res) ? 1 : 0;
        return res;

    }


    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bcd";
        String s3 = "abcbdc";

        int[][] t = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                t[i][j] = -1;
            }
        }
        System.out.println(check(s1, s2, s3, s1.length(), s2.length(), s3.length(), t));
    }
}
