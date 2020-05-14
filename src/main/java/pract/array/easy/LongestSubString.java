package pract.array.easy;

import pract.Reader;

public class LongestSubString {
    static int maxLength = 1;
    static int startIndex = 0;
    static int endIndex = 0;

    static void updateLength(int i, int j) {
        if ((j - i + 1) > maxLength) {
            maxLength = (j - i + 1);
            endIndex = j;
            startIndex = i;
        }
    }

    static void checkIfPalindrome(String data, boolean[][] arr, int i, int j) {
        if (j - i == 1) {
            arr[i][j] = data.charAt(i) == data.charAt(j);
            if (arr[i][j])
                updateLength(i, j);
        } else if (data.charAt(i) == data.charAt(j)) {
            arr[i][j] = arr[i + 1][j - 1];
            if (arr[i][j])
                updateLength(i, j);
        } else {
            arr[i][j] = false;
        }
    }

    static void initialize(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = true;
        }
    }

    static void longestPalSubstr(String str, int size) {
        boolean[][] arr = new boolean[size][size];
        endIndex = 0;
        startIndex = 0;
        maxLength = 1;
        int k = 1;
        int i = 0;
        int incr = k;
        initialize(arr);
        while (k <= size - 1) {
            checkIfPalindrome(str, arr, i, incr);
            if (incr == size - 1) {
                i = 0;
                k = k + 1;
                incr = k;
            } else {
                i++;
                incr++;
            }
        }
        System.out.println(str.substring(startIndex, endIndex + 1));

    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            String str = sc.readLine();
            longestPalSubstr(str, str.length());

        }
    }
}
