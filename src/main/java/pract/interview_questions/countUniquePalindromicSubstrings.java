package pract.interview_questions;

import java.util.Arrays;
import java.util.HashSet;

public class countUniquePalindromicSubstrings {

    static int count(String str, int n) {
        boolean[][] t = new boolean[n][n];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            t[i][i] = true;
        }

        for (int k = 1; k < n; k++) {
            for (int i = 0, j = k; j < n; i++, j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    t[i][j] = Math.abs(i - j) == 1 || t[i + 1][j - 1];

                }
            }
            System.out.println();
        }
        for (boolean[] a : t) {
            System.out.println(Arrays.toString(a));
        }

        for (int i = 0; i < n; i++) {
            String res = "" + str.charAt(i);
            set.add(res);
            for (int j = i + 1; j < n; j++) {
                res = res + str.charAt(j);
                if(t[i][j])
                    set.add(res);
            }
        }
        System.out.println(set);
        return set.size();
    }

    public static void main(String[] args) {
        String s = "aabaaa";
        System.out.println(count(s, s.length()));

    }
}
