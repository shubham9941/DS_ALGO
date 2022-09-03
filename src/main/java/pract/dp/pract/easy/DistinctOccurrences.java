package pract.dp.pract.easy;

import pract.Reader;

public class DistinctOccurrences {

    static int find(char[] s1, char[] s2, int n1, int n2) {
        if (n2 == 0) {
            return 1;
        }
        if (n1 == 0) {
            return 0;
        }

        if (s1[n1 - 1] == s2[n2 - 1]) {
            return find(s1, s2, n1 - 1, n2 - 1) + find(s1, s2, n1 - 1, n2);
        } else {
            return find(s1, s2, n1 - 1, n2);
        }
    }

    static int findUsingDP(char[] s1, char[] s2, int n1, int n2) {
        int[][] t = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < n1 + 1; i++) {
            for (int j = 0; j < n2 + 1; j++) {
                if (j == 0) {
                    t[i][j] = 1;
                } else if (i == 0) {
                    t[i][j] = 0;
                } else if (s1[i - 1] == s2[j - 1]) {
                    t[i][j] = t[i - 1][j - 1] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n1][n2];
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            String n = sc.readLine();
            String[]strs = n.split(" ");
            System.out.println(findUsingDP(strs[0].toCharArray() , strs[1].toCharArray() , strs[0].length() , strs[1].length()));
        }

    }
}
