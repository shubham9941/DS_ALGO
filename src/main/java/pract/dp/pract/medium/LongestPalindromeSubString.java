package pract.dp.pract.medium;

import pract.Reader;

public class LongestPalindromeSubString {

    static int count  = 0; // this is for count number of substring palindrome

    static int get(String str, int l) {
        int max = 1;
        boolean[][] t = new boolean[l][l];
        for (int i = 0; i < l; i++) {
            int k = i;
            int p = 0;
            for (; k < l; k++) {
//                System.out.print(" i = " + p + " j = " + k);
                if (p == k) {
                    t[p][k] = true;
                } else if (str.charAt(p) == str.charAt(k)) {

                    if (k - p == 1) {
                        count++;
                        t[p][k] = true;
                        max = ((k - p + 1) > max ? k - p + 1 : max);
                    } else if (t[p + 1][k - 1]) {
                        count++;
                        t[p][k] = true;
                        max = ((k - p + 1) > max ? k - p + 1 : max);
                    } else {
                        t[p][k] = false;
                    }

//                    System.out.println(">>> Hey i m here>> " + (k - p + 1));
                } else {
                    t[p][k] = false;
                }
                p++;

            }
//            System.out.println();
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int size = sc.nextInt();
            String str = sc.readLine();
            count = 0;
            get(str, size);
            System.out.println(count);
        }
    }
}
