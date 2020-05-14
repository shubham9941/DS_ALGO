package pract.array.basic;

// Absolute Difference of 1
/*
Given an array A of size N. Print all the numbers less than K in the array. The numbers should be such that the difference between every adjacent digit should be 1.

Note: Print '-1' if no number if valid.

Input:
The first line consists of an integer T i.e number of test cases. T testcases follow. Each testcase contains two lines of input. The first line consists of two integers N and K separated by a space. The next line consists of N spaced integers.

Output:
For each testcase, print the required output.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= K, A[i] <= 1018

Example:
Input:
2
8 54
7 98 56 43 45 23 12 8
10 1000
87 89 45 235 465 765 123 987 499 655

Output:
43 45 23 12
87 89 45 765 123 987
*/


import pract.Reader;

public class AbsoluteDifference {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int separateByNum(int[] arr, int size, int num) {
        int i = -1;
        for (int j = 0; j < size; j++) {
            if (arr[j] < num) {
                i = i + 1;
                swap(arr, i, j);
            }
        }
        return i;

    }

    static void printWithDiffOne(int[] arr, int start, int end) {
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (; start <= end; start++) {
            String num = String.valueOf(arr[start]);
            char[] numArr = num.toCharArray();
            for (int i = 0; i < numArr.length - 1; i++) {
                int diff = numArr[i] - numArr[i + 1];
                if (!(diff == 1 || diff == -1)) {
                    flag = false;
                    break;
                }
                if (i == numArr.length - 2)
                    flag = true;
            }
            if (flag) {
                sb.append(arr[start] + " ");
                flag = false;
            }

        }
        if (sb.toString().isEmpty())
            System.out.println(-1);
        else
            System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            int num = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            int end = separateByNum(arr, size, num);
            printWithDiffOne(arr, 0, end);
        }

    }
}
